package com.vmware.tanzu.springcloudconfigserver;

import java.util.ArrayList;

import io.kubernetes.client.openapi.models.V1ListMeta;

public class V1SpringCloudConfigServerList {


	private V1ListMeta metadata;

	private java.util.List<V1SpringCloudConfigServer> items = new ArrayList<>();

	public V1SpringCloudConfigServerList(V1ListMeta metadata,
		java.util.List<V1SpringCloudConfigServer> items) {
		this.metadata = metadata;
		this.items = items;
	}

	public V1ListMeta getMetadata() {
		return metadata;
	}

	public void setMetadata(V1ListMeta metadata) {
		this.metadata = metadata;
	}

	public java.util.List<V1SpringCloudConfigServer> getItems() {
		return items;
	}

	public void setItems(java.util.List<V1SpringCloudConfigServer> items) {
		this.items = items;
	}

}
