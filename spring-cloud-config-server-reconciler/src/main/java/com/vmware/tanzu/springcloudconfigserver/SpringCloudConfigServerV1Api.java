package com.vmware.tanzu.springcloudconfigserver;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;
import io.kubernetes.client.custom.V1Patch;
import io.kubernetes.client.openapi.ApiCallback;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.ApiResponse;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.Pair;
import io.kubernetes.client.openapi.models.V1APIResourceList;
import io.kubernetes.client.openapi.models.V1DeleteOptions;
import io.kubernetes.client.openapi.models.V1Status;


public class SpringCloudConfigServerV1Api {

	private ApiClient localVarApiClient;

	public SpringCloudConfigServerV1Api() {
		this(Configuration.getDefaultApiClient());
	}

	public SpringCloudConfigServerV1Api(ApiClient apiClient) {
		this.localVarApiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return localVarApiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.localVarApiClient = apiClient;
	}

	/**
	 * Build call for createNamespacedSpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. (optional)
	 * @param _callback Callback for upload/download progress
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
	<tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call createNamespacedSpringCloudConfigServerCall(String namespace, V1SpringCloudConfigServer body, String pretty,
	 String dryRun,
	 String fieldManager, final ApiCallback _callback) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/apis/tanzu.vmware.com/v1/namespaces/{namespace}/springcloudconfigservers"
			.replaceAll("\\{" + "namespace" + "\\}", localVarApiClient.escapeString(namespace.toString()));

		java.util.List<Pair> localVarQueryParams = new ArrayList<Pair>();
		java.util.List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (pretty != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("pretty", pretty));
		}

		if (dryRun != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("dryRun", dryRun));
		}

		if (fieldManager != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("fieldManager", fieldManager));
		}

		java.util.Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		java.util.Map<String, String> localVarCookieParams = new HashMap<String, String>();
		java.util.Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {
			"application/json", "application/yaml", "application/vnd.kubernetes.protobuf"
		};
		final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] { "BearerToken" };
		return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
	}

	@SuppressWarnings("rawtypes")
	private okhttp3.Call createNamespacedSpringCloudConfigServerValidateBeforeCall(String namespace, V1SpringCloudConfigServer body,
	 String pretty,
	 String dryRun, String fieldManager, final ApiCallback _callback) throws ApiException {

		// verify the required parameter 'namespace' is set
		if (namespace == null) {
			throw new ApiException("Missing the required parameter 'namespace' when calling " +
			 "createNamespacedSpringCloudConfigServer" +
			 "(Async)");
		}

		// verify the required parameter 'body' is set
		if (body == null) {
			throw new ApiException("Missing the required parameter 'body' when calling createNamespacedSpringCloudConfigServer" +
			 "(Async)");
		}


		okhttp3.Call localVarCall = createNamespacedSpringCloudConfigServerCall(namespace, body, pretty, dryRun, fieldManager,
 _callback);
		return localVarCall;

	}

	/**
	 *
	 * create a SpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. (optional)
	 * @return V1SpringCloudConfigServer
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
	<tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public V1SpringCloudConfigServer createNamespacedSpringCloudConfigServer(String namespace, V1SpringCloudConfigServer body,
	 String pretty,
	 String dryRun,
	 String fieldManager) throws ApiException {
		ApiResponse<V1SpringCloudConfigServer> localVarResp = createNamespacedSpringCloudConfigServerWithHttpInfo(namespace, body,
		 pretty,
		 dryRun,
		 fieldManager);
		return localVarResp.getData();
	}

	/**
	 *
	 * create a SpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. (optional)
	 * @return ApiResponse&lt;V1SpringCloudConfigServer&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
	<tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public ApiResponse<V1SpringCloudConfigServer> createNamespacedSpringCloudConfigServerWithHttpInfo(String namespace,
	 V1SpringCloudConfigServer body,
	 String pretty, String dryRun, String fieldManager) throws ApiException {
		okhttp3.Call localVarCall = createNamespacedSpringCloudConfigServerValidateBeforeCall(namespace, body, pretty, dryRun,
		 fieldManager,
		 null);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServer>(){}.getType();
		return localVarApiClient.execute(localVarCall, localVarReturnType);
	}

	/**
	 *  (asynchronously)
	 * create a SpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. (optional)
	 * @param _callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
	<tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call createNamespacedSpringCloudConfigServerAsync(String namespace, V1SpringCloudConfigServer body,
		String pretty,
	 String dryRun,
	 String fieldManager, final ApiCallback<V1SpringCloudConfigServer> _callback) throws ApiException {

		okhttp3.Call localVarCall = createNamespacedSpringCloudConfigServerValidateBeforeCall(namespace, body, pretty, dryRun,
fieldManager,
		 _callback);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServer>(){}.getType();
		localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
		return localVarCall;
	}
	/**
	 * Build call for deleteCollectionNamespacedSpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \&quot;orphan\&quot; finalizer will be added to/removed from the object&#39;s finalizers list. Either this field or PropagationPolicy may be set, but not both. (optional)
	 * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: &#39;Orphan&#39; - orphan the dependents; &#39;Background&#39; - allow the garbage collector to delete the dependents in the background; &#39;Foreground&#39; - a cascading policy that deletes all dependents in the foreground. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @param body  (optional)
	 * @param _callback Callback for upload/download progress
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call deleteCollectionNamespacedSpringCloudConfigServerCall(String namespace, String pretty,
	 Boolean allowWatchBookmarks,
	 String _continue, String dryRun, String fieldSelector, Integer gracePeriodSeconds, String labelSelector, Integer limit, Boolean orphanDependents, String propagationPolicy, String resourceVersion, Integer timeoutSeconds, Boolean watch, V1DeleteOptions body, final ApiCallback _callback) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/apis/tanzu.vmware.com/v1/namespaces/{namespace}/springcloudconfigservers"
			.replaceAll("\\{" + "namespace" + "\\}", localVarApiClient.escapeString(namespace.toString()));

		java.util.List<Pair> localVarQueryParams = new ArrayList<Pair>();
		java.util.List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (pretty != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("pretty", pretty));
		}

		if (allowWatchBookmarks != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("allowWatchBookmarks", allowWatchBookmarks));
		}

		if (_continue != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("continue", _continue));
		}

		if (dryRun != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("dryRun", dryRun));
		}

		if (fieldSelector != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("fieldSelector", fieldSelector));
		}

		if (gracePeriodSeconds != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("gracePeriodSeconds", gracePeriodSeconds));
		}

		if (labelSelector != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("labelSelector", labelSelector));
		}

		if (limit != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
		}

		if (orphanDependents != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("orphanDependents", orphanDependents));
		}

		if (propagationPolicy != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("propagationPolicy", propagationPolicy));
		}

		if (resourceVersion != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("resourceVersion", resourceVersion));
		}

		if (timeoutSeconds != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("timeoutSeconds", timeoutSeconds));
		}

		if (watch != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("watch", watch));
		}

		java.util.Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		java.util.Map<String, String> localVarCookieParams = new HashMap<String, String>();
		java.util.Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {
			"application/json", "application/yaml", "application/vnd.kubernetes.protobuf"
		};
		final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] { "BearerToken" };
		return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
	}

	@SuppressWarnings("rawtypes")
	private okhttp3.Call deleteCollectionNamespacedSpringCloudConfigServerValidateBeforeCall(String namespace, String pretty,
		Boolean allowWatchBookmarks, String _continue, String dryRun, String fieldSelector, Integer gracePeriodSeconds, String labelSelector, Integer limit, Boolean orphanDependents, String propagationPolicy, String resourceVersion, Integer timeoutSeconds, Boolean watch, V1DeleteOptions body, final ApiCallback _callback) throws ApiException {

		// verify the required parameter 'namespace' is set
		if (namespace == null) {
			throw new ApiException("Missing the required parameter 'namespace' when calling " +
 "deleteCollectionNamespacedSpringCloudConfigServer" +
			 "(Async)");
		}


		okhttp3.Call localVarCall = deleteCollectionNamespacedSpringCloudConfigServerCall(namespace, pretty, allowWatchBookmarks,
		 _continue,
 dryRun, fieldSelector, gracePeriodSeconds, labelSelector, limit, orphanDependents, propagationPolicy, resourceVersion, timeoutSeconds, watch, body, _callback);
		return localVarCall;

	}

	/**
	 *
	 * delete collection of SpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \&quot;orphan\&quot; finalizer will be added to/removed from the object&#39;s finalizers list. Either this field or PropagationPolicy may be set, but not both. (optional)
	 * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: &#39;Orphan&#39; - orphan the dependents; &#39;Background&#39; - allow the garbage collector to delete the dependents in the background; &#39;Foreground&#39; - a cascading policy that deletes all dependents in the foreground. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @param body  (optional)
	 * @return V1Status
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public V1Status deleteCollectionNamespacedSpringCloudConfigServer(String namespace, String pretty,
	 Boolean allowWatchBookmarks,
	 String _continue, String dryRun, String fieldSelector, Integer gracePeriodSeconds, String labelSelector, Integer limit, Boolean orphanDependents, String propagationPolicy, String resourceVersion, Integer timeoutSeconds, Boolean watch, V1DeleteOptions body) throws ApiException {
		ApiResponse<V1Status> localVarResp = deleteCollectionNamespacedSpringCloudConfigServerWithHttpInfo(namespace, pretty,
		 allowWatchBookmarks, _continue, dryRun, fieldSelector, gracePeriodSeconds, labelSelector, limit, orphanDependents, propagationPolicy, resourceVersion, timeoutSeconds, watch, body);
		return localVarResp.getData();
	}

	/**
	 *
	 * delete collection of SpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \&quot;orphan\&quot; finalizer will be added to/removed from the object&#39;s finalizers list. Either this field or PropagationPolicy may be set, but not both. (optional)
	 * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: &#39;Orphan&#39; - orphan the dependents; &#39;Background&#39; - allow the garbage collector to delete the dependents in the background; &#39;Foreground&#39; - a cascading policy that deletes all dependents in the foreground. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @param body  (optional)
	 * @return ApiResponse&lt;V1Status&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public ApiResponse<V1Status> deleteCollectionNamespacedSpringCloudConfigServerWithHttpInfo(String namespace, String pretty,
	 Boolean allowWatchBookmarks, String _continue, String dryRun, String fieldSelector, Integer gracePeriodSeconds, String labelSelector, Integer limit, Boolean orphanDependents, String propagationPolicy, String resourceVersion, Integer timeoutSeconds, Boolean watch, V1DeleteOptions body) throws ApiException {
		okhttp3.Call localVarCall = deleteCollectionNamespacedSpringCloudConfigServerValidateBeforeCall(namespace, pretty,
		 allowWatchBookmarks,
		 _continue, dryRun, fieldSelector, gracePeriodSeconds, labelSelector, limit, orphanDependents, propagationPolicy, resourceVersion, timeoutSeconds, watch, body, null);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1Status>(){}.getType();
		return localVarApiClient.execute(localVarCall, localVarReturnType);
	}

	/**
	 *  (asynchronously)
	 * delete collection of SpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \&quot;orphan\&quot; finalizer will be added to/removed from the object&#39;s finalizers list. Either this field or PropagationPolicy may be set, but not both. (optional)
	 * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: &#39;Orphan&#39; - orphan the dependents; &#39;Background&#39; - allow the garbage collector to delete the dependents in the background; &#39;Foreground&#39; - a cascading policy that deletes all dependents in the foreground. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @param body  (optional)
	 * @param _callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call deleteCollectionNamespacedSpringCloudConfigServerAsync(String namespace, String pretty,
	 Boolean allowWatchBookmarks,
 String _continue, String dryRun, String fieldSelector, Integer gracePeriodSeconds, String labelSelector, Integer limit, Boolean orphanDependents, String propagationPolicy, String resourceVersion, Integer timeoutSeconds, Boolean watch, V1DeleteOptions body, final ApiCallback<V1Status> _callback) throws ApiException {

		okhttp3.Call localVarCall = deleteCollectionNamespacedSpringCloudConfigServerValidateBeforeCall(namespace, pretty,
		 allowWatchBookmarks,
		 _continue, dryRun, fieldSelector, gracePeriodSeconds, labelSelector, limit, orphanDependents, propagationPolicy, resourceVersion, timeoutSeconds, watch, body, _callback);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1Status>(){}.getType();
		localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
		return localVarCall;
	}
	/**
	 * Build call for deleteNamespacedSpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately. (optional)
	 * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \&quot;orphan\&quot; finalizer will be added to/removed from the object&#39;s finalizers list. Either this field or PropagationPolicy may be set, but not both. (optional)
	 * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: &#39;Orphan&#39; - orphan the dependents; &#39;Background&#39; - allow the garbage collector to delete the dependents in the background; &#39;Foreground&#39; - a cascading policy that deletes all dependents in the foreground. (optional)
	 * @param body  (optional)
	 * @param _callback Callback for upload/download progress
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call deleteNamespacedSpringCloudConfigServerCall(String name, String namespace, String pretty,
	 String dryRun,
	 Integer gracePeriodSeconds, Boolean orphanDependents, String propagationPolicy, V1DeleteOptions body, final ApiCallback _callback) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/apis/tanzu.vmware.com/v1/namespaces/{namespace}/springcloudconfigservers/{name}"
			.replaceAll("\\{" + "name" + "\\}", localVarApiClient.escapeString(name.toString()))
			.replaceAll("\\{" + "namespace" + "\\}", localVarApiClient.escapeString(namespace.toString()));

		java.util.List<Pair> localVarQueryParams = new ArrayList<Pair>();
		java.util.List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (pretty != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("pretty", pretty));
		}

		if (dryRun != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("dryRun", dryRun));
		}

		if (gracePeriodSeconds != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("gracePeriodSeconds", gracePeriodSeconds));
		}

		if (orphanDependents != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("orphanDependents", orphanDependents));
		}

		if (propagationPolicy != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("propagationPolicy", propagationPolicy));
		}

		java.util.Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		java.util.Map<String, String> localVarCookieParams = new HashMap<String, String>();
		java.util.Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {
			"application/json", "application/yaml", "application/vnd.kubernetes.protobuf"
		};
		final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] { "BearerToken" };
		return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
	}

	@SuppressWarnings("rawtypes")
	private okhttp3.Call deleteNamespacedSpringCloudConfigServerValidateBeforeCall(String name, String namespace,
 String pretty,
	 String dryRun, Integer gracePeriodSeconds, Boolean orphanDependents, String propagationPolicy, V1DeleteOptions body, final ApiCallback _callback) throws ApiException {

		// verify the required parameter 'name' is set
		if (name == null) {
			throw new ApiException("Missing the required parameter 'name' when calling deleteNamespacedSpringCloudConfigServer" +
"(Async)");
		}

		// verify the required parameter 'namespace' is set
		if (namespace == null) {
			throw new ApiException("Missing the required parameter 'namespace' when calling " +
			 "deleteNamespacedSpringCloudConfigServer" +
 "(Async)");
		}


		okhttp3.Call localVarCall = deleteNamespacedSpringCloudConfigServerCall(name, namespace, pretty, dryRun,
		 gracePeriodSeconds,
orphanDependents, propagationPolicy, body, _callback);
		return localVarCall;

	}

	/**
	 *
	 * delete a SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately. (optional)
	 * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \&quot;orphan\&quot; finalizer will be added to/removed from the object&#39;s finalizers list. Either this field or PropagationPolicy may be set, but not both. (optional)
	 * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: &#39;Orphan&#39; - orphan the dependents; &#39;Background&#39; - allow the garbage collector to delete the dependents in the background; &#39;Foreground&#39; - a cascading policy that deletes all dependents in the foreground. (optional)
	 * @param body  (optional)
	 * @return V1Status
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public V1Status deleteNamespacedSpringCloudConfigServer(String name, String namespace, String pretty, String dryRun,
	 Integer gracePeriodSeconds, Boolean orphanDependents, String propagationPolicy, V1DeleteOptions body) throws ApiException {
		ApiResponse<V1Status> localVarResp = deleteNamespacedSpringCloudConfigServerWithHttpInfo(name, namespace, pretty, dryRun,
		 gracePeriodSeconds, orphanDependents, propagationPolicy, body);
		return localVarResp.getData();
	}

	/**
	 *
	 * delete a SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately. (optional)
	 * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \&quot;orphan\&quot; finalizer will be added to/removed from the object&#39;s finalizers list. Either this field or PropagationPolicy may be set, but not both. (optional)
	 * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: &#39;Orphan&#39; - orphan the dependents; &#39;Background&#39; - allow the garbage collector to delete the dependents in the background; &#39;Foreground&#39; - a cascading policy that deletes all dependents in the foreground. (optional)
	 * @param body  (optional)
	 * @return ApiResponse&lt;V1Status&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public ApiResponse<V1Status> deleteNamespacedSpringCloudConfigServerWithHttpInfo(String name, String namespace,
	String pretty,
	 String dryRun, Integer gracePeriodSeconds, Boolean orphanDependents, String propagationPolicy, V1DeleteOptions body) throws ApiException {
		okhttp3.Call localVarCall = deleteNamespacedSpringCloudConfigServerValidateBeforeCall(name, namespace, pretty, dryRun,
		 gracePeriodSeconds, orphanDependents, propagationPolicy, body, null);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1Status>(){}.getType();
		return localVarApiClient.execute(localVarCall, localVarReturnType);
	}

	/**
	 *  (asynchronously)
	 * delete a SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately. (optional)
	 * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \&quot;orphan\&quot; finalizer will be added to/removed from the object&#39;s finalizers list. Either this field or PropagationPolicy may be set, but not both. (optional)
	 * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: &#39;Orphan&#39; - orphan the dependents; &#39;Background&#39; - allow the garbage collector to delete the dependents in the background; &#39;Foreground&#39; - a cascading policy that deletes all dependents in the foreground. (optional)
	 * @param body  (optional)
	 * @param _callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call deleteNamespacedSpringCloudConfigServerAsync(String name, String namespace, String pretty,
	 String dryRun,
	 Integer gracePeriodSeconds, Boolean orphanDependents, String propagationPolicy, V1DeleteOptions body, final ApiCallback<V1Status> _callback) throws ApiException {

		okhttp3.Call localVarCall = deleteNamespacedSpringCloudConfigServerValidateBeforeCall(name, namespace, pretty, dryRun,
		 gracePeriodSeconds, orphanDependents, propagationPolicy, body, _callback);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1Status>(){}.getType();
		localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
		return localVarCall;
	}
	/**
	 * Build call for getAPIResources
	 * @param _callback Callback for upload/download progress
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call getAPIResourcesCall(final ApiCallback _callback) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/apis/tanzu.vmware.com/v1/";

		java.util.List<Pair> localVarQueryParams = new ArrayList<Pair>();
		java.util.List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		java.util.Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		java.util.Map<String, String> localVarCookieParams = new HashMap<String, String>();
		java.util.Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {
			"application/json", "application/yaml", "application/vnd.kubernetes.protobuf"
		};
		final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] { "BearerToken" };
		return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
	}

	@SuppressWarnings("rawtypes")
	private okhttp3.Call getAPIResourcesValidateBeforeCall(final ApiCallback _callback) throws ApiException {


		okhttp3.Call localVarCall = getAPIResourcesCall(_callback);
		return localVarCall;

	}

	/**
	 *
	 * get available resources
	 * @return V1APIResourceList
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public V1APIResourceList getAPIResources() throws ApiException {
		ApiResponse<V1APIResourceList> localVarResp = getAPIResourcesWithHttpInfo();
		return localVarResp.getData();
	}

	/**
	 *
	 * get available resources
	 * @return ApiResponse&lt;V1APIResourceList&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public ApiResponse<V1APIResourceList> getAPIResourcesWithHttpInfo() throws ApiException {
		okhttp3.Call localVarCall = getAPIResourcesValidateBeforeCall(null);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1APIResourceList>(){}.getType();
		return localVarApiClient.execute(localVarCall, localVarReturnType);
	}

	/**
	 *  (asynchronously)
	 * get available resources
	 * @param _callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call getAPIResourcesAsync(final ApiCallback<V1APIResourceList> _callback) throws ApiException {

		okhttp3.Call localVarCall = getAPIResourcesValidateBeforeCall(_callback);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1APIResourceList>(){}.getType();
		localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
		return localVarCall;
	}
	/**
	 * Build call for listNamespacedSpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @param _callback Callback for upload/download progress
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call listNamespacedSpringCloudConfigServerCall(String namespace, String pretty, Boolean allowWatchBookmarks,
	 String _continue, String fieldSelector, String labelSelector, Integer limit, String resourceVersion, Integer timeoutSeconds, Boolean watch, final ApiCallback _callback) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/apis/tanzu.vmware.com/v1/namespaces/{namespace}/springcloudconfigservers"
			.replaceAll("\\{" + "namespace" + "\\}", localVarApiClient.escapeString(namespace.toString()));

		java.util.List<Pair> localVarQueryParams = new ArrayList<Pair>();
		java.util.List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (pretty != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("pretty", pretty));
		}

		if (allowWatchBookmarks != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("allowWatchBookmarks", allowWatchBookmarks));
		}

		if (_continue != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("continue", _continue));
		}

		if (fieldSelector != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("fieldSelector", fieldSelector));
		}

		if (labelSelector != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("labelSelector", labelSelector));
		}

		if (limit != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
		}

		if (resourceVersion != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("resourceVersion", resourceVersion));
		}

		if (timeoutSeconds != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("timeoutSeconds", timeoutSeconds));
		}

		if (watch != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("watch", watch));
		}

		java.util.Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		java.util.Map<String, String> localVarCookieParams = new HashMap<String, String>();
		java.util.Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {
			"application/json", "application/yaml", "application/vnd.kubernetes.protobuf", "application/json;stream=watch", "application/vnd.kubernetes.protobuf;stream=watch"
		};
		final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] { "BearerToken" };
		return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
	}

	@SuppressWarnings("rawtypes")
	private okhttp3.Call listNamespacedSpringCloudConfigServerValidateBeforeCall(String namespace, String pretty,
	 Boolean allowWatchBookmarks
	, String _continue, String fieldSelector, String labelSelector, Integer limit, String resourceVersion, Integer timeoutSeconds, Boolean watch, final ApiCallback _callback) throws ApiException {

		// verify the required parameter 'namespace' is set
		if (namespace == null) {
			throw new ApiException("Missing the required parameter 'namespace' when calling " +
			 "listNamespacedSpringCloudConfigServer" +
 "(Async)");
		}


		okhttp3.Call localVarCall = listNamespacedSpringCloudConfigServerCall(namespace, pretty, allowWatchBookmarks, _continue,
 fieldSelector,
		 labelSelector, limit, resourceVersion, timeoutSeconds, watch, _callback);
		return localVarCall;

	}

	/**
	 *
	 * list or watch objects of kind SpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @return V1SpringCloudConfigServerList
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public V1SpringCloudConfigServerList listNamespacedSpringCloudConfigServer(String namespace, String pretty,
	 Boolean allowWatchBookmarks,
	 String _continue, String fieldSelector, String labelSelector, Integer limit, String resourceVersion, Integer timeoutSeconds, Boolean watch) throws ApiException {
		ApiResponse<V1SpringCloudConfigServerList> localVarResp = listNamespacedSpringCloudConfigServerWithHttpInfo(namespace, pretty,
		 allowWatchBookmarks, _continue, fieldSelector, labelSelector, limit, resourceVersion, timeoutSeconds, watch);
		return localVarResp.getData();
	}

	/**
	 *
	 * list or watch objects of kind SpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @return ApiResponse&lt;V1SpringCloudConfigServerList&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public ApiResponse<V1SpringCloudConfigServerList> listNamespacedSpringCloudConfigServerWithHttpInfo(String namespace,
	 String pretty,
	 Boolean allowWatchBookmarks, String _continue, String fieldSelector, String labelSelector, Integer limit, String resourceVersion, Integer timeoutSeconds, Boolean watch) throws ApiException {
		okhttp3.Call localVarCall = listNamespacedSpringCloudConfigServerValidateBeforeCall(namespace, pretty,
		 allowWatchBookmarks,
		 _continue,
		 fieldSelector, labelSelector, limit, resourceVersion, timeoutSeconds, watch, null);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServerList>(){}.getType();
		return localVarApiClient.execute(localVarCall, localVarReturnType);
	}

	/**
	 *  (asynchronously)
	 * list or watch objects of kind SpringCloudConfigServer
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @param _callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call listNamespacedSpringCloudConfigServerAsync(String namespace, String pretty,
	 Boolean allowWatchBookmarks,
	 String _continue, String fieldSelector, String labelSelector, Integer limit, String resourceVersion,
	  Integer timeoutSeconds, Boolean watch, final ApiCallback<V1SpringCloudConfigServerList> _callback) throws ApiException {

		okhttp3.Call localVarCall = listNamespacedSpringCloudConfigServerValidateBeforeCall(namespace, pretty,
		 allowWatchBookmarks,
	 _continue,
		 fieldSelector, labelSelector, limit, resourceVersion, timeoutSeconds, watch, _callback);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServerList>(){}.getType();
		localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
		return localVarCall;
	}
	/**
	 * Build call for listSpringCloudConfigServerForAllNamespaces
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @param _callback Callback for upload/download progress
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call listSpringCloudConfigServerForAllNamespacesCall(Boolean allowWatchBookmarks, String _continue,
	 String fieldSelector,
	 String labelSelector, Integer limit, String pretty, String resourceVersion, Integer timeoutSeconds, Boolean watch, final ApiCallback _callback) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/apis/tanzu.vmware.com/v1/springcloudconfigservers";

		java.util.List<Pair> localVarQueryParams = new ArrayList<Pair>();
		java.util.List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (allowWatchBookmarks != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("allowWatchBookmarks", allowWatchBookmarks));
		}

		if (_continue != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("continue", _continue));
		}

		if (fieldSelector != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("fieldSelector", fieldSelector));
		}

		if (labelSelector != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("labelSelector", labelSelector));
		}

		if (limit != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
		}

		if (pretty != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("pretty", pretty));
		}

		if (resourceVersion != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("resourceVersion", resourceVersion));
		}

		if (timeoutSeconds != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("timeoutSeconds", timeoutSeconds));
		}

		if (watch != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("watch", watch));
		}

		java.util.Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		java.util.Map<String, String> localVarCookieParams = new HashMap<String, String>();
		java.util.Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {
			"application/json", "application/yaml", "application/vnd.kubernetes.protobuf", "application/json;stream=watch", "application/vnd.kubernetes.protobuf;stream=watch"
		};
		final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] { "BearerToken" };
		return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
	}

	@SuppressWarnings("rawtypes")
	private okhttp3.Call listSpringCloudConfigServerForAllNamespacesValidateBeforeCall(Boolean allowWatchBookmarks,
	 String _continue,
			String fieldSelector, String labelSelector, Integer limit, String pretty, String resourceVersion, Integer timeoutSeconds, Boolean watch, final ApiCallback _callback) throws ApiException {


		okhttp3.Call localVarCall = listSpringCloudConfigServerForAllNamespacesCall(allowWatchBookmarks, _continue,
			fieldSelector,
labelSelector, limit, pretty, resourceVersion, timeoutSeconds, watch, _callback);
		return localVarCall;

	}

	/**
	 *
	 * list or watch objects of kind SpringCloudConfigServer
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @return V1SpringCloudConfigServerList
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public V1SpringCloudConfigServerList listSpringCloudConfigServerForAllNamespaces(Boolean allowWatchBookmarks, String _continue,
	 String fieldSelector, String labelSelector, Integer limit, String pretty, String resourceVersion, Integer timeoutSeconds, Boolean watch) throws ApiException {
		ApiResponse<V1SpringCloudConfigServerList> localVarResp =
		 listSpringCloudConfigServerForAllNamespacesWithHttpInfo(allowWatchBookmarks,
		 _continue,
		 fieldSelector, labelSelector, limit, pretty, resourceVersion, timeoutSeconds, watch);
		return localVarResp.getData();
	}

	/**
	 *
	 * list or watch objects of kind SpringCloudConfigServer
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @return ApiResponse&lt;V1SpringCloudConfigServerList&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public ApiResponse<V1SpringCloudConfigServerList> listSpringCloudConfigServerForAllNamespacesWithHttpInfo(Boolean allowWatchBookmarks,
	 String _continue, String fieldSelector, String labelSelector, Integer limit, String pretty, String resourceVersion, Integer timeoutSeconds, Boolean watch) throws ApiException {
		okhttp3.Call localVarCall = listSpringCloudConfigServerForAllNamespacesValidateBeforeCall(allowWatchBookmarks, _continue,
		 fieldSelector
		, labelSelector, limit, pretty, resourceVersion, timeoutSeconds, watch, null);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServerList>(){}.getType();
		return localVarApiClient.execute(localVarCall, localVarReturnType);
	}

	/**
	 *  (asynchronously)
	 * list or watch objects of kind SpringCloudConfigServer
	 * @param allowWatchBookmarks allowWatchBookmarks requests watch events with type \&quot;BOOKMARK\&quot;. Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server&#39;s discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta. (optional)
	 * @param _continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \&quot;next key\&quot;.  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications. (optional)
	 * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything. (optional)
	 * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything. (optional)
	 * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the &#x60;continue&#x60; field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned. (optional)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it&#39;s 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv. (optional)
	 * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity. (optional)
	 * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion. (optional)
	 * @param _callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call listSpringCloudConfigServerForAllNamespacesAsync(Boolean allowWatchBookmarks, String _continue,
	 String fieldSelector,
	 String labelSelector, Integer limit, String pretty, String resourceVersion, Integer timeoutSeconds, Boolean watch,
	  final ApiCallback<V1SpringCloudConfigServerList> _callback) throws ApiException {

		okhttp3.Call localVarCall = listSpringCloudConfigServerForAllNamespacesValidateBeforeCall(allowWatchBookmarks, _continue,
		 fieldSelector
		, labelSelector, limit, pretty, resourceVersion, timeoutSeconds, watch, _callback);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServerList>(){}.getType();
		localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
		return localVarCall;
	}
	/**
	 * Build call for patchNamespacedSpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch). (optional)
	 * @param force Force is going to \&quot;force\&quot; Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests. (optional)
	 * @param _callback Callback for upload/download progress
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call patchNamespacedSpringCloudConfigServerCall(String name, String namespace, V1Patch body, String pretty,
	 String dryRun,
	 String fieldManager, Boolean force, final ApiCallback _callback) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/apis/tanzu.vmware.com/v1/namespaces/{namespace}/springcloudconfigservers/{name}"
			.replaceAll("\\{" + "name" + "\\}", localVarApiClient.escapeString(name.toString()))
			.replaceAll("\\{" + "namespace" + "\\}", localVarApiClient.escapeString(namespace.toString()));

		java.util.List<Pair> localVarQueryParams = new ArrayList<Pair>();
		java.util.List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (pretty != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("pretty", pretty));
		}

		if (dryRun != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("dryRun", dryRun));
		}

		if (fieldManager != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("fieldManager", fieldManager));
		}

		if (force != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("force", force));
		}

		java.util.Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		java.util.Map<String, String> localVarCookieParams = new HashMap<String, String>();
		java.util.Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {
			"application/json", "application/yaml", "application/vnd.kubernetes.protobuf"
		};
		final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		final String[] localVarContentTypes = {
			"application/json-patch+json", "application/merge-patch+json", "application/strategic-merge-patch+json", "application/apply-patch+yaml"
		};
		final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] { "BearerToken" };
		return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
	}

	@SuppressWarnings("rawtypes")
	private okhttp3.Call patchNamespacedSpringCloudConfigServerValidateBeforeCall(String name, String namespace, V1Patch body,
		String pretty,
	 String dryRun, String fieldManager, Boolean force, final ApiCallback _callback) throws ApiException {

		// verify the required parameter 'name' is set
		if (name == null) {
			throw new ApiException("Missing the required parameter 'name' when calling patchNamespacedSpringCloudConfigServer" +
			 "(Async)");
		}

		// verify the required parameter 'namespace' is set
		if (namespace == null) {
			throw new ApiException("Missing the required parameter 'namespace' when calling " +
		"patchNamespacedSpringCloudConfigServer" +
			 "(Async)");
		}

		// verify the required parameter 'body' is set
		if (body == null) {
			throw new ApiException("Missing the required parameter 'body' when calling patchNamespacedSpringCloudConfigServer" +
			 "(Async)");
		}


		okhttp3.Call localVarCall = patchNamespacedSpringCloudConfigServerCall(name, namespace, body, pretty, dryRun,
		fieldManager,
		 force,
		 _callback);
		return localVarCall;

	}

	/**
	 *
	 * partially update the specified SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch). (optional)
	 * @param force Force is going to \&quot;force\&quot; Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests. (optional)
	 * @return V1SpringCloudConfigServer
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public V1SpringCloudConfigServer patchNamespacedSpringCloudConfigServer(String name, String namespace, V1Patch body,
	 String pretty,
	 String dryRun,
	 String fieldManager, Boolean force) throws ApiException {
		ApiResponse<V1SpringCloudConfigServer> localVarResp = patchNamespacedSpringCloudConfigServerWithHttpInfo(name, namespace,
		 body,
		 pretty,
		 dryRun,
		 fieldManager, force);
		return localVarResp.getData();
	}

	/**
	 *
	 * partially update the specified SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch). (optional)
	 * @param force Force is going to \&quot;force\&quot; Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests. (optional)
	 * @return ApiResponse&lt;V1SpringCloudConfigServer&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public ApiResponse<V1SpringCloudConfigServer> patchNamespacedSpringCloudConfigServerWithHttpInfo(String name, String namespace,
	 V1Patch body,
	 String pretty, String dryRun, String fieldManager, Boolean force) throws ApiException {
		okhttp3.Call localVarCall = patchNamespacedSpringCloudConfigServerValidateBeforeCall(name, namespace, body, pretty,
		 dryRun,
		 fieldManager, force, null);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServer>(){}.getType();
		return localVarApiClient.execute(localVarCall, localVarReturnType);
	}

	/**
	 *  (asynchronously)
	 * partially update the specified SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch). (optional)
	 * @param force Force is going to \&quot;force\&quot; Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests. (optional)
	 * @param _callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call patchNamespacedSpringCloudConfigServerAsync(String name, String namespace, V1Patch body, String pretty,
	 String dryRun
	, String fieldManager, Boolean force, final ApiCallback<V1SpringCloudConfigServer> _callback) throws ApiException {

		okhttp3.Call localVarCall = patchNamespacedSpringCloudConfigServerValidateBeforeCall(name, namespace, body, pretty,
		 dryRun,
		 fieldManager, force, _callback);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServer>(){}.getType();
		localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
		return localVarCall;
	}
	/**
	 * Build call for readNamespacedSpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param exact Should the export be exact.  Exact export maintains cluster-specific fields like &#39;Namespace&#39;. Deprecated. Planned for removal in 1.18. (optional)
	 * @param export Should this value be exported.  Export strips fields that a user can not specify. Deprecated. Planned for removal in 1.18. (optional)
	 * @param _callback Callback for upload/download progress
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call readNamespacedSpringCloudConfigServerCall(String name, String namespace, String pretty, Boolean exact,
	 Boolean export
	, final ApiCallback _callback) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/apis/tanzu.vmware.com/v1/namespaces/{namespace}/springcloudconfigservers/{name}"
			.replaceAll("\\{" + "name" + "\\}", localVarApiClient.escapeString(name.toString()))
			.replaceAll("\\{" + "namespace" + "\\}", localVarApiClient.escapeString(namespace.toString()));

		java.util.List<Pair> localVarQueryParams = new ArrayList<Pair>();
		java.util.List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (pretty != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("pretty", pretty));
		}

		if (exact != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("exact", exact));
		}

		if (export != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("export", export));
		}

		java.util.Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		java.util.Map<String, String> localVarCookieParams = new HashMap<String, String>();
		java.util.Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {
			"application/json", "application/yaml", "application/vnd.kubernetes.protobuf"
		};
		final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] { "BearerToken" };
		return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
	}

	@SuppressWarnings("rawtypes")
	private okhttp3.Call readNamespacedSpringCloudConfigServerValidateBeforeCall(String name, String namespace, String pretty,
	 Boolean exact,
	 Boolean export, final ApiCallback _callback) throws ApiException {

		// verify the required parameter 'name' is set
		if (name == null) {
			throw new ApiException("Missing the required parameter 'name' when calling readNamespacedSpringCloudConfigServer" +
			 "(Async)");
		}

		// verify the required parameter 'namespace' is set
		if (namespace == null) {
			throw new ApiException("Missing the required parameter 'namespace' when calling " +
			 "readNamespacedSpringCloudConfigServer" +
		"(Async)");
		}


		okhttp3.Call localVarCall = readNamespacedSpringCloudConfigServerCall(name, namespace, pretty, exact, export, _callback);
		return localVarCall;

	}

	/**
	 *
	 * read the specified SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param exact Should the export be exact.  Exact export maintains cluster-specific fields like &#39;Namespace&#39;. Deprecated. Planned for removal in 1.18. (optional)
	 * @param export Should this value be exported.  Export strips fields that a user can not specify. Deprecated. Planned for removal in 1.18. (optional)
	 * @return V1SpringCloudConfigServer
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public V1SpringCloudConfigServer readNamespacedSpringCloudConfigServer(String name, String namespace, String pretty,
	 Boolean exact,
	 Boolean export) throws ApiException {
		ApiResponse<V1SpringCloudConfigServer> localVarResp = readNamespacedSpringCloudConfigServerWithHttpInfo(name, namespace,
			pretty,
		 exact,
		 export);
		return localVarResp.getData();
	}

	/**
	 *
	 * read the specified SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param exact Should the export be exact.  Exact export maintains cluster-specific fields like &#39;Namespace&#39;. Deprecated. Planned for removal in 1.18. (optional)
	 * @param export Should this value be exported.  Export strips fields that a user can not specify. Deprecated. Planned for removal in 1.18. (optional)
	 * @return ApiResponse&lt;V1SpringCloudConfigServer&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public ApiResponse<V1SpringCloudConfigServer> readNamespacedSpringCloudConfigServerWithHttpInfo(String name, String namespace,
	 String pretty,
	 Boolean exact, Boolean export) throws ApiException {
		okhttp3.Call localVarCall = readNamespacedSpringCloudConfigServerValidateBeforeCall(name, namespace, pretty, exact,
		 export,
		null);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServer>(){}.getType();
		return localVarApiClient.execute(localVarCall, localVarReturnType);
	}

	/**
	 *  (asynchronously)
	 * read the specified SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param exact Should the export be exact.  Exact export maintains cluster-specific fields like &#39;Namespace&#39;. Deprecated. Planned for removal in 1.18. (optional)
	 * @param export Should this value be exported.  Export strips fields that a user can not specify. Deprecated. Planned for removal in 1.18. (optional)
	 * @param _callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call readNamespacedSpringCloudConfigServerAsync(String name, String namespace, String pretty, Boolean exact,
	 Boolean export, final ApiCallback<V1SpringCloudConfigServer> _callback) throws ApiException {

		okhttp3.Call localVarCall = readNamespacedSpringCloudConfigServerValidateBeforeCall(name, namespace, pretty, exact,
		 export,
		 _callback);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServer>(){}.getType();
		localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
		return localVarCall;
	}
	/**
	 * Build call for replaceNamespacedSpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. (optional)
	 * @param _callback Callback for upload/download progress
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call replaceNamespacedSpringCloudConfigServerCall(String name, String namespace, V1SpringCloudConfigServer body,
	 String pretty,
	 String dryRun, String fieldManager, final ApiCallback _callback) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/apis/tanzu.vmware.com/v1/namespaces/{namespace}/springcloudconfigservers/{name}"
			.replaceAll("\\{" + "name" + "\\}", localVarApiClient.escapeString(name.toString()))
			.replaceAll("\\{" + "namespace" + "\\}", localVarApiClient.escapeString(namespace.toString()));

		java.util.List<Pair> localVarQueryParams = new ArrayList<Pair>();
		java.util.List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (pretty != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("pretty", pretty));
		}

		if (dryRun != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("dryRun", dryRun));
		}

		if (fieldManager != null) {
			localVarQueryParams.addAll(localVarApiClient.parameterToPair("fieldManager", fieldManager));
		}

		java.util.Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		java.util.Map<String, String> localVarCookieParams = new HashMap<String, String>();
		java.util.Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {
			"application/json", "application/yaml", "application/vnd.kubernetes.protobuf"
		};
		final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] { "BearerToken" };
		return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
	}

	@SuppressWarnings("rawtypes")
	private okhttp3.Call replaceNamespacedSpringCloudConfigServerValidateBeforeCall(String name, String namespace,
 V1SpringCloudConfigServer body,
	 String pretty, String dryRun, String fieldManager, final ApiCallback _callback) throws ApiException {

		// verify the required parameter 'name' is set
		if (name == null) {
			throw new ApiException("Missing the required parameter 'name' when calling replaceNamespacedSpringCloudConfigServer" +
"(Async)");
		}

		// verify the required parameter 'namespace' is set
		if (namespace == null) {
			throw new ApiException("Missing the required parameter 'namespace' when calling " +
"replaceNamespacedSpringCloudConfigServer" +
			 "(Async)");
		}

		// verify the required parameter 'body' is set
		if (body == null) {
			throw new ApiException("Missing the required parameter 'body' when calling replaceNamespacedSpringCloudConfigServer" +
			 "(Async)");
		}


		okhttp3.Call localVarCall = replaceNamespacedSpringCloudConfigServerCall(name, namespace, body, pretty, dryRun,
		 fieldManager,
 _callback);
		return localVarCall;

	}

	/**
	 *
	 * replace the specified SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. (optional)
	 * @return V1SpringCloudConfigServer
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public V1SpringCloudConfigServer replaceNamespacedSpringCloudConfigServer(String name, String namespace,
 V1SpringCloudConfigServer body,
	 String pretty,
	 String dryRun, String fieldManager) throws ApiException {
		ApiResponse<V1SpringCloudConfigServer> localVarResp = replaceNamespacedSpringCloudConfigServerWithHttpInfo(name, namespace,
		 body,
		 pretty,
		 dryRun,
 fieldManager);
		return localVarResp.getData();
	}

	/**
	 *
	 * replace the specified SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. (optional)
	 * @return ApiResponse&lt;V1SpringCloudConfigServer&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public ApiResponse<V1SpringCloudConfigServer> replaceNamespacedSpringCloudConfigServerWithHttpInfo(String name,
		String namespace,
	 V1SpringCloudConfigServer body, String pretty, String dryRun, String fieldManager) throws ApiException {
		okhttp3.Call localVarCall = replaceNamespacedSpringCloudConfigServerValidateBeforeCall(name, namespace, body, pretty,
		 dryRun,
		 fieldManager, null);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServer>(){}.getType();
		return localVarApiClient.execute(localVarCall, localVarReturnType);
	}

	/**
	 *  (asynchronously)
	 * replace the specified SpringCloudConfigServer
	 * @param name name of the SpringCloudConfigServer (required)
	 * @param namespace object name and auth scope, such as for teams and projects (required)
	 * @param body  (required)
	 * @param pretty If &#39;true&#39;, then the output is pretty printed. (optional)
	 * @param dryRun When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed (optional)
	 * @param fieldManager fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. (optional)
	 * @param _callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 * @http.response.details
	<table summary="Response Details" border="1">
	<tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
	<tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
	<tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
	<tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
	</table>
	 */
	public okhttp3.Call replaceNamespacedSpringCloudConfigServerAsync(String name, String namespace, V1SpringCloudConfigServer body,
String pretty,
	 String dryRun, String fieldManager, final ApiCallback<V1SpringCloudConfigServer> _callback) throws ApiException {

		okhttp3.Call localVarCall = replaceNamespacedSpringCloudConfigServerValidateBeforeCall(name, namespace, body, pretty,
		 dryRun,
		 fieldManager, _callback);
		java.lang.reflect.Type localVarReturnType = new TypeToken<V1SpringCloudConfigServer>(){}.getType();
		localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
		return localVarCall;
	}
}
