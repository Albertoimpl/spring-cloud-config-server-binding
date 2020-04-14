package com.example.springcloudconfigserverbindingreconciler;

import java.util.Map;
import java.util.Objects;

import io.kubernetes.client.extended.controller.reconciler.Reconciler;
import io.kubernetes.client.extended.controller.reconciler.Request;
import io.kubernetes.client.extended.controller.reconciler.Result;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.kubernetes.client.informer.cache.Lister;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1Pod;

public class SpringCloudConfigServerBindingReconciler implements Reconciler {

	private Lister<V1Pod> lister;

	private PatchService patchService;

	public SpringCloudConfigServerBindingReconciler(
		SharedIndexInformer<V1Pod> informer, PatchService patchService) {
		this.lister = new Lister<>(informer.getIndexer());
		this.patchService = patchService;
	}

	@Override
	public Result reconcile(Request request) {
		String namespace = request.getNamespace();
		if (!"default".equals(namespace)) {
			return new Result(false);
		}

		String name = request.getName();
		V1Pod resource = lister.namespace(namespace).get(name);

		if (resource == null) {
			// TODO remove volumes
			return new Result(false);
		}
		System.out.println("******* Pod");
		Map<String, String> labels = Objects.requireNonNull(resource.getMetadata()).getLabels();
		System.out.println(labels);
		if (Objects.requireNonNull(labels).containsKey("binds-to")) {
			try {
				patchService.update(resource.getSpec());
			}
			catch (ApiException e) {
				e.printStackTrace();
			}

		}

		return new Result(false);
	}

}
