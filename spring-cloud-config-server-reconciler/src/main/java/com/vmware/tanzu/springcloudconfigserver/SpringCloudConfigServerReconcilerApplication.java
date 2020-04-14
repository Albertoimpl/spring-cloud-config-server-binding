package com.vmware.tanzu.springcloudconfigserver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import io.kubernetes.client.extended.controller.Controller;
import io.kubernetes.client.extended.controller.DefaultControllerWatch;
import io.kubernetes.client.extended.controller.builder.ControllerBuilder;
import io.kubernetes.client.extended.controller.builder.ControllerManagerBuilder;
import io.kubernetes.client.extended.controller.reconciler.Request;
import io.kubernetes.client.extended.workqueue.WorkQueue;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.kubernetes.client.informer.SharedInformerFactory;
import io.kubernetes.client.openapi.ApiCallback;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;

public class SpringCloudConfigServerReconcilerApplication {

	private static final String CONTROLLER_NAME = "SpringCloudConfigServerController";

	private static final int WORKER_COUNT = 4;

	public static void main(String[] args) throws IOException {
		ApiClient client = initializeApiClient();
		SpringCloudConfigServerV1Api springCloudConfigServerApi = new SpringCloudConfigServerV1Api(client);

		AppsV1Api appsV1Api = new AppsV1Api(client);
		DeploymentService deploymentService = new DeploymentService(appsV1Api);
		CoreV1Api coreV1Api = new CoreV1Api(client);
		ServiceService serviceService = new ServiceService(coreV1Api);
		ConfigMapService configMapService = new ConfigMapService(coreV1Api);

		SharedInformerFactory factory = new SharedInformerFactory();
		ControllerManagerBuilder managerBuilder = ControllerBuilder.controllerManagerBuilder(factory);

		SharedIndexInformer<V1SpringCloudConfigServer> informer = factory.sharedIndexInformerFor(
			callGeneratorParams -> springCloudConfigServerApi.listSpringCloudConfigServerForAllNamespacesCall(
				null,
				null,
				null,
				null,
				null,
				null,
				callGeneratorParams.resourceVersion,
				callGeneratorParams.timeoutSeconds,
				callGeneratorParams.watch,
				SpringCloudConfigServerListCallback()),
			V1SpringCloudConfigServer.class,
			V1SpringCloudConfigServerList.class);

		Controller controller = ControllerBuilder.defaultBuilder(factory).watch(
			(workQueue) -> createControllerWatch(workQueue))
			.withReconciler(new SpringCloudConfigServerReconciler(informer, deploymentService, serviceService,
				configMapService))
			.withName(CONTROLLER_NAME)
			.withWorkerCount(WORKER_COUNT)
			.build();

		managerBuilder.addController(controller).build().run();
	}

	private static ApiClient initializeApiClient() throws IOException {
		String home = System.getProperty("user.home");
		String kubeConfigPath = home + "/.kube/config";

		// In a cluster we should be able to read the KUBECONFIG variable as path
		String kubeconfig = System.getProperty("KUBECONFIG");
		if (kubeconfig != null && !kubeconfig.isEmpty()) {
			kubeConfigPath = kubeconfig;
		}

		ApiClient client =
			ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath)))
				.build();
		Configuration.setDefaultApiClient(client);

		return client;
	}

	private static DefaultControllerWatch<V1SpringCloudConfigServer> createControllerWatch(WorkQueue<Request> workQueue) {
		return ControllerBuilder.controllerWatchBuilder(V1SpringCloudConfigServer.class, workQueue)
			.withWorkQueueKeyFunc(
				pod -> new Request("default", "my-config-server"))
			.withOnAddFilter(pod -> {
				String namespace = "default";
				String name = "my-config-server";

				System.out.println(String.format(
					"[%s] Event: Add SpringCloudConfigServer '%s/%s'", CONTROLLER_NAME, namespace, name));
				return true;
			})
			.withOnUpdateFilter((oldSpringCloudConfigServer, newSpringCloudConfigServer) -> {
				String namespace = "default";
				String name = "my-config-server";

				System.out.println(String.format(
					"[%s] Event: Update SpringCloudConfigServer '%s/%s'", CONTROLLER_NAME, namespace, name));

				return true;
			})
			.withOnDeleteFilter((pod, aBoolean) -> {
				String namespace = "default";
				String name = "my-config-server";

				System.out.println(String.format(
					"[%s] Event: Delete SpringCloudConfigServer '%s/%s'", CONTROLLER_NAME, namespace, name));
				return true;
			})
			.build();
	}

	private static ApiCallback<V1SpringCloudConfigServerList> SpringCloudConfigServerListCallback() {
		return new ApiCallback<V1SpringCloudConfigServerList>() {
			@Override
			public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {

			}

			@Override
			public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {

			}

			@Override
			public void onSuccess(V1SpringCloudConfigServerList result, int statusCode, Map responseHeaders) {
				System.out.println("onSuccess SharedIndexInformer");
				System.out.println(statusCode);
			}

			@Override
			public void onFailure(ApiException e, int statusCode, Map responseHeaders) {
				System.out.println("onFailure SharedIndexInformer");
				System.out.println(statusCode);
				e.printStackTrace();
			}
		};
	}

}
