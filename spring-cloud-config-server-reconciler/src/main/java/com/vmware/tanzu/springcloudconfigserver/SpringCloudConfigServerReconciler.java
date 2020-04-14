package com.vmware.tanzu.springcloudconfigserver;

import io.kubernetes.client.extended.controller.reconciler.Reconciler;
import io.kubernetes.client.extended.controller.reconciler.Request;
import io.kubernetes.client.extended.controller.reconciler.Result;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.kubernetes.client.informer.cache.Lister;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1ConfigMapList;
import io.kubernetes.client.openapi.models.V1DeploymentList;
import io.kubernetes.client.openapi.models.V1ServiceList;

public class SpringCloudConfigServerReconciler implements Reconciler {

	private Lister<V1SpringCloudConfigServer> lister;

	private DeploymentService deploymentService;

	private ServiceService serviceService;

	private ConfigMapService configMapService;

	public SpringCloudConfigServerReconciler(
		SharedIndexInformer<V1SpringCloudConfigServer> informer,
		DeploymentService deploymentService, ServiceService serviceService,
		ConfigMapService configMapService) {
		this.lister = new Lister<>(informer.getIndexer());
		this.deploymentService = deploymentService;
		this.serviceService = serviceService;
		this.configMapService = configMapService;
	}

	@Override
	public Result reconcile(Request request) {
		try {
			String namespace = request.getNamespace();
			if (!"default".equals(namespace)) {
				return new Result(false);
			}

			String name = request.getName();
			V1SpringCloudConfigServer resource = lister.namespace(namespace).get(name);

			if (resource == null) {
				System.out.println("******* Deployments");
				V1DeploymentList deploymentList = deploymentService.list();
				System.out.println(deploymentList.getItems().size());
				if (!deploymentList.getItems().isEmpty()) {
					deploymentService.delete();
				}
				System.out.println("******* Service");
				V1ServiceList serviceList = serviceService.list();
				System.out.println(serviceList.getItems().size());
				if (!serviceList.getItems().isEmpty()) {
					serviceService.delete();
				}
				System.out.println("******* ConfigMaps");
				V1ConfigMapList configMapList = configMapService.list();
				System.out.println(configMapList.getItems().size());
				if (!configMapList.getItems().isEmpty()) {
					configMapService.delete();
				}

				return new Result(false);
			}
			System.out.println("******* ConfigServer");
			System.out.println(resource.getMetadata().getLabels());

			System.out.println("******* Deployments");
			V1DeploymentList deploymentList = deploymentService.list();
			System.out.println(deploymentList.getItems().size());

			if (deploymentList.getItems().isEmpty()) {
				deploymentService.create();
			}
			System.out.println("******* Service");
			V1ServiceList serviceList = serviceService.list();
			System.out.println(serviceList.getItems().size());
			boolean containsConfigServerService =
				serviceList.getItems()
				.stream()
				.anyMatch(service -> service.getMetadata().getName().startsWith("my-config-server"));

			if (serviceList.getItems().isEmpty() || !containsConfigServerService) {
				serviceService.create();
			}
			System.out.println("******* ConfigMaps");
			V1ConfigMapList configMapList = configMapService.list();
			System.out.println(configMapList.getItems().size());
			if (configMapList.getItems().isEmpty()) {
				configMapService.create();
			}

		}
		catch (ApiException e) {
			e.printStackTrace();
			return new Result(false);
		}
		return new Result(false);
	}

}
