package com.vmware.tanzu.springcloudconfigserver;

import java.util.Collections;

import io.kubernetes.client.custom.IntOrString;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1Service;
import io.kubernetes.client.openapi.models.V1ServiceList;
import io.kubernetes.client.openapi.models.V1ServicePort;
import io.kubernetes.client.openapi.models.V1ServiceSpec;
import io.kubernetes.client.openapi.models.V1Status;

class ServiceService {

	private CoreV1Api coreV1Api;

	public ServiceService(CoreV1Api coreV1Api) {
		this.coreV1Api = coreV1Api;
	}

	V1ServiceList list() throws ApiException {
		System.out.println("Listing services");
		V1ServiceList serviceList =
			coreV1Api.listNamespacedService(
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
		System.out.println("Listed services");
		System.out.println(serviceList.getItems().size());
		return serviceList;
	}

	void create() throws ApiException {
		System.out.println("Creating service");

		V1Service service = new V1Service();
		service.setApiVersion("v1");
		service.setKind("Service");

		V1ObjectMeta metadata = new V1ObjectMeta();
		metadata.setName("my-config-server");
		service.setMetadata(metadata);

		V1ServiceSpec serviceSpec = new V1ServiceSpec();

		serviceSpec.setSelector(Collections.singletonMap("app", "spring-cloud-config-server"));

		V1ServicePort servicePort = new V1ServicePort();
		servicePort.setPort(8080);
		servicePort.setProtocol("TCP");
		servicePort.setTargetPort(new IntOrString(8080));
		serviceSpec.setPorts(Collections.singletonList(servicePort));

		service.setSpec(serviceSpec);

		coreV1Api.createNamespacedService(
			"default",
			service,
			null,
			null,
			null
		);

		System.out.println("Created service");
	}

	void delete() throws ApiException {
		System.out.println("Deleting service");
		V1Status status = coreV1Api.deleteNamespacedService(
			"my-config-server",
			"default",
			null,
			null,
			null,
			null,
			null,
			null
		);
		System.out.println("Deleted service");
		System.out.println(status);
	}

}
