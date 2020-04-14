package com.vmware.tanzu.springcloudconfigserver;

import io.kubernetes.client.openapi.models.V1ObjectMeta;

public class V1SpringCloudConfigServer {

	private V1ObjectMeta metadata;

	public V1SpringCloudConfigServer(V1ObjectMeta metadata) {
		this.metadata = metadata;
	}

	public V1ObjectMeta getMetadata() {
		return metadata;
	}

	public void setMetadata(V1ObjectMeta metadata) {
		this.metadata = metadata;
	}

}
