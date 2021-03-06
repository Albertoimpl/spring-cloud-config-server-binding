package com.example.springcloudconfigserverbindingreconciler;

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
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;

public class SpringCloudConfigServerBindingReconcilerApplication {

	private static final String CONTROLLER_NAME = "PodBindingController";

	private static final int WORKER_COUNT = 4;

	public static void main(String[] args) throws IOException {
		ApiClient client = initializeApiClient();
		CoreV1Api coreV1Api = new CoreV1Api(client);
		AppsV1Api appsV1Api = new AppsV1Api(client);
		PatchService patchService = new PatchService(appsV1Api);

		SharedInformerFactory factory = new SharedInformerFactory();
		ControllerManagerBuilder managerBuilder = ControllerBuilder.controllerManagerBuilder(factory);

		SharedIndexInformer<V1Pod> informer = factory.sharedIndexInformerFor(
			callGeneratorParams -> coreV1Api.listPodForAllNamespacesCall(
				null,
				null,
				null,
				null,
				null,
				null,
				callGeneratorParams.resourceVersion,
				callGeneratorParams.timeoutSeconds,
				callGeneratorParams.watch,
				PodListCallback()),
			V1Pod.class,
			V1PodList.class);

		Controller controller = ControllerBuilder.defaultBuilder(factory).watch(
			(workQueue) -> createControllerWatch(workQueue))
			.withReconciler(new SpringCloudConfigServerBindingReconciler(informer, patchService))
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

	private static DefaultControllerWatch<V1Pod> createControllerWatch(WorkQueue<Request> workQueue) {
		return ControllerBuilder.controllerWatchBuilder(V1Pod.class, workQueue)
			.withWorkQueueKeyFunc(
				pod -> new Request("default", pod.getMetadata().getName()))
			.withOnAddFilter(pod -> {
				String namespace = "default";
				String name = pod.getMetadata().getName();

				System.out.println(String.format(
					"[%s] Event: Add Pod '%s/%s'", CONTROLLER_NAME, namespace, name));
				return true;
			})
			.withOnUpdateFilter((oldPod, newPod) -> {
				String namespace = "default";
				String name = newPod.getMetadata().getName();

				System.out.println(String.format(
					"[%s] Event: Update Pod '%s/%s'", CONTROLLER_NAME, namespace, name));

				return true;
			})
			.withOnDeleteFilter((pod, aBoolean) -> {
				String namespace = "default";
				String name = pod.getMetadata().getName();

				System.out.println(String.format(
					"[%s] Event: Delete Pod '%s/%s'", CONTROLLER_NAME, namespace, name));
				return true;
			})
			.build();
	}

	private static ApiCallback<V1PodList> PodListCallback() {
		return new ApiCallback<V1PodList>() {
			@Override
			public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {

			}

			@Override
			public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {

			}

			@Override
			public void onSuccess(V1PodList result, int statusCode, Map responseHeaders) {
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
