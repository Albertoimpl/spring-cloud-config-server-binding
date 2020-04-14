package com.vmware.tanzu.springcloudconfigserver;

import java.util.Collections;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1Container;
import io.kubernetes.client.openapi.models.V1ContainerPort;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.openapi.models.V1DeploymentList;
import io.kubernetes.client.openapi.models.V1DeploymentSpec;
import io.kubernetes.client.openapi.models.V1LabelSelector;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1PodSpec;
import io.kubernetes.client.openapi.models.V1PodTemplateSpec;
import io.kubernetes.client.openapi.models.V1Status;

class DeploymentService {

	private AppsV1Api appsV1Api;

	public DeploymentService(AppsV1Api appsV1Api) {
		this.appsV1Api = appsV1Api;
	}

	V1DeploymentList list() throws ApiException {
		System.out.println("Listing deployments");
		V1DeploymentList deploymentList =
			appsV1Api.listNamespacedDeployment(
				"default",
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null);
		System.out.println("Listed deployments");
		System.out.println(deploymentList.getItems().size());
		return deploymentList;
	}


	void create() throws ApiException {
		System.out.println("Creating deployment");

		V1Deployment deployment = new V1Deployment();
		deployment.setApiVersion("apps/v1");
		deployment.setKind("Deployment");

		V1ObjectMeta metadata = new V1ObjectMeta();
		metadata.setName("my-config-server");
		deployment.setMetadata(metadata);

		V1DeploymentSpec deploymentSpec = new V1DeploymentSpec();

		V1LabelSelector selector = new V1LabelSelector();
		selector.setMatchLabels(Collections.singletonMap("app", "spring-cloud-config-server"));
		deploymentSpec.setSelector(selector);

		V1PodTemplateSpec template = new V1PodTemplateSpec();

		V1PodSpec podSpec = new V1PodSpec();
		V1Container v1Container = new V1Container();
		v1Container.setName("config-server");
		v1Container.setImage("albertoimpl/spring-cloud-config-server");
		V1ContainerPort containerPort = new V1ContainerPort();
		containerPort.setContainerPort(8080);
		v1Container.setPorts(Collections.singletonList(containerPort));
		podSpec.setContainers(Collections.singletonList(v1Container));
		template.setSpec(podSpec);

		V1ObjectMeta podMetadata = new V1ObjectMeta();
		podMetadata.setLabels(Collections.singletonMap("app", "spring-cloud-config-server"));
		template.setMetadata(podMetadata);

		deploymentSpec.setTemplate(template);

		deployment.setSpec(deploymentSpec);

		appsV1Api.createNamespacedDeployment(
			"default",
			deployment,
			null,
			null,
			null
		);

		System.out.println("Created deployment");
	}

	void delete() throws ApiException {
		System.out.println("Deleting deployment");
		V1Status status = appsV1Api.deleteNamespacedDeployment(
			"my-config-server",
			"default",
			null,
			null,
			null,
			null,
			null,
			null
		);
		System.out.println("Deleted deployment");
		System.out.println(status);
	}

}
