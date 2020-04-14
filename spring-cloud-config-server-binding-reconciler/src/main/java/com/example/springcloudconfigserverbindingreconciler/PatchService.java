package com.example.springcloudconfigserverbindingreconciler;

import java.util.List;
import java.util.Map;

import io.kubernetes.client.custom.V1Patch;
import io.kubernetes.client.openapi.ApiCallback;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1Container;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.openapi.models.V1DeploymentList;
import io.kubernetes.client.openapi.models.V1EnvVar;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodSpec;
import io.kubernetes.client.util.PatchUtils;

class PatchService {

	private AppsV1Api api;

	public PatchService(AppsV1Api api) {
		this.api = api;
	}

	public void update(V1PodSpec podSpec) throws ApiException {
		System.out.println("Updating deployment");
		V1DeploymentList list =
			api.listNamespacedDeployment("default",
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			);

		System.out.println("Found DeploymentList");
		V1Deployment deployment = list
			.getItems()
			.stream()
			.filter(v1Deployment -> v1Deployment.getMetadata().getName().startsWith("my-client-app"))
			.findFirst()
			.orElseThrow(RuntimeException::new);
		System.out.println("Found deployment");

		List<V1Container> containers =
			deployment.getSpec().getTemplate().getSpec().getContainers();

		for (V1Container container : containers) {
			List<V1EnvVar> environment = container.getEnv();
			if (environment == null) {
				break;
			}
			for (V1EnvVar env : container.getEnv()) {
				if (env.getName().equals("spring.cloud.bootstrap.location")) {
					System.out.println("Already patched");
					return;
				}
			}
		}

		String name = deployment.getMetadata().getName();
		System.out.println("Patching " + name);
		String parsedPatch =
			"[{\n" +
				"\t\t\"op\": \"add\",\n" +
				"\t\t\"path\": \"/spec/template/spec/containers/0/env\",\n" +
				"\t\t\"value\": [{\n" +
				"\t\t\t\"name\": \"spring.cloud.bootstrap.location\",\n" +
				"\t\t\t\"value\": \"/etc/config/bootstrap.properties\"\n" +
				"\t\t}]\n" +
				"\t},\n" +
				"\n" +
				"\t{\n" +
				"\t\t\"op\": \"add\",\n" +
				"\t\t\"path\": \"/spec/template/spec/containers/0/volumeMounts\",\n" +
				"\t\t\"value\": [{\n" +
				"\t\t\t\"mountPath\": \"/etc/config\",\n" +
				"\t\t\t\"name\": \"my-config-server-configuration\"\n" +
				"\t\t}]\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"op\": \"add\",\n" +
				"\t\t\"path\": \"/spec/template/spec/volumes\",\n" +
				"\t\t\"value\": [{\n" +
				"\t\t\t\"configMap\": {\n" +
				"\t\t\t\t\"items\": [{\n" +
				"\t\t\t\t\t\"key\": \"bootstrap.properties\",\n" +
				"\t\t\t\t\t\"path\": \"bootstrap.properties\"\n" +
				"\t\t\t\t}],\n" +
				"\t\t\t\t\"name\": \"my-config-server-configuration\"\n" +
				"\t\t\t},\n" +
				"\t\t\t\"name\": \"my-config-server-configuration\"\n" +
				"\t\t}]\n" +
				"\t}\n" +
				"]";
		V1Patch v1Patch = new V1Patch(parsedPatch);
		PatchUtils.patch(
			V1Pod.class,
			() ->
				api.patchNamespacedDeploymentCall(
					name,
					"default",
					v1Patch,
					null,
					null,
					null,
					null,
					new ApiCallback<Object>() {

						@Override
						public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
							System.out.println("onFailure!");
							System.out.println(statusCode);
							e.printStackTrace();
							System.out.println(e.getResponseBody());
						}

						@Override
						public void onSuccess(Object result, int statusCode, Map<String, List<String>> responseHeaders) {
							System.out.println("success!");
							System.out.println(statusCode);
							System.out.println(result);
						}

						@Override
						public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
							System.out.println("onUploadProgress");
						}

						@Override
						public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
							System.out.println("onDownloadProgress");
						}
					}),
			V1Patch.PATCH_FORMAT_JSON_PATCH,
			api.getApiClient());
	}

}
