package com.vmware.tanzu.springcloudconfigserver;

import java.util.Collections;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.openapi.models.V1ConfigMapList;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1Status;

class ConfigMapService {

	private CoreV1Api coreV1Api;

	public ConfigMapService(CoreV1Api coreV1Api) {
		this.coreV1Api = coreV1Api;
	}

	V1ConfigMapList list() throws ApiException {
		System.out.println("Listing configMaps");
		V1ConfigMapList configMapList =
			coreV1Api.listNamespacedConfigMap(
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
		System.out.println("Listed configMaps");
		System.out.println(configMapList.getItems().size());
		return configMapList;
	}

	void create() throws ApiException {
		System.out.println("Creating configMap");

		V1ConfigMap configMap = new V1ConfigMap();
		configMap.setApiVersion("v1");
		configMap.setKind("ConfigMap");

		V1ObjectMeta metadata = new V1ObjectMeta();
		metadata.setName("my-config-server-configuration");
		configMap.setMetadata(metadata);

		configMap.setData(Collections.singletonMap("bootstrap.properties", "spring.cloud.config" +
			".uri=http://my-config-server:8080"));

		coreV1Api.createNamespacedConfigMap(
			"default",
			configMap,
			null,
			null,
			null
		);

		System.out.println("Created configMap");
	}

	void delete() throws ApiException {
		System.out.println("Deleting configMap");
		V1Status status = coreV1Api.deleteNamespacedConfigMap(
			"my-config-server-configuration",
			"default",
			null,
			null,
			null,
			null,
			null,
			null
		);
		System.out.println("Deleted configMap");
		System.out.println(status);
	}

}
