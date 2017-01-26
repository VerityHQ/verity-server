/**
 * VerityReputation
 * This is a simple Verity reputation API. You can find out more about Verity at <a href='http://getcrystal.net'>http://getcrystal.net</a>  For this sample, you can use the api key 'special-key' for tests that need authorization (authorization filters).  Where possible we specify multi-hashes as unique identifiers that can be used by distributed cryptographically secure systems (blockchains) Where possible we specify hyper-media links (e.g. JSON-LD) to describe data that is linked in graph structures by nature (blockchain data, IPFS data, etc.)  Agents, Entity and Activity should map to provenance ontology described in https://www.w3.org/TR/prov-o Transaction is an implementation that maps to TrustAtoms. https://github.com/CoMakery/trust-exchange/blob/master/README.md This is a simple Verity reputation API. You can find out more about Verity at <a href='http://getcrystal.net'>http://getcrystal.net</a>  For this sample, you can use the api key 'special-key' for tests that need authorization (authorization filters).  Where possible we specify multi-hashes as unique identifiers that can be used by distributed cryptographically secure systems (blockchains) Where possible we specify hyper-media links (e.g. JSON-LD) to describe data that is linked in graph structures by nature (blockchain data, IPFS data, etc.)  Agents, Entity and Activity should map to provenance ontology described in https://www.w3.org/TR/prov-o Transaction is an implementation that maps to TrustAtoms. https://github.com/CoMakery/trust-exchange/blob/master/README.md
 *
 * OpenAPI spec version: 1.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package site.verity.client.api;

import site.verity.client.ApiCallback;
import site.verity.client.ApiClient;
import site.verity.client.ApiException;
import site.verity.client.ApiResponse;
import site.verity.client.Configuration;
import site.verity.client.Pair;
import site.verity.client.ProgressRequestBody;
import site.verity.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import site.verity.client.mode.InlineResponse403;
import site.verity.client.mode.InlineResponse404;
import site.verity.client.mode.ValueAction;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueActionApi {
    private ApiClient apiClient;

    public ValueActionApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ValueActionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for archiveValueAction */
    private com.squareup.okhttp.Call archiveValueActionCall(String uuid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'uuid' is set
        if (uuid == null) {
            throw new ApiException("Missing the required parameter 'uuid' when calling archiveValueAction(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/valueaction/{uuid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "uuid" + "\\}", apiClient.escapeString(uuid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * archive ValueAction
     * 
     * @param uuid  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void archiveValueAction(String uuid) throws ApiException {
        archiveValueActionWithHttpInfo(uuid);
    }

    /**
     * archive ValueAction
     * 
     * @param uuid  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> archiveValueActionWithHttpInfo(String uuid) throws ApiException {
        com.squareup.okhttp.Call call = archiveValueActionCall(uuid, null, null);
        return apiClient.execute(call);
    }

    /**
     * archive ValueAction (asynchronously)
     * 
     * @param uuid  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call archiveValueActionAsync(String uuid, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = archiveValueActionCall(uuid, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for createValueAction */
    private com.squareup.okhttp.Call createValueActionCall(ValueAction body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        

        // create path and map variables
        String localVarPath = "/valueaction".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * create ValueAction
     * 
     * @param body  (optional)
     * @return ValueAction
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ValueAction createValueAction(ValueAction body) throws ApiException {
        ApiResponse<ValueAction> resp = createValueActionWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * create ValueAction
     * 
     * @param body  (optional)
     * @return ApiResponse&lt;ValueAction&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ValueAction> createValueActionWithHttpInfo(ValueAction body) throws ApiException {
        com.squareup.okhttp.Call call = createValueActionCall(body, null, null);
        Type localVarReturnType = new TypeToken<ValueAction>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * create ValueAction (asynchronously)
     * 
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createValueActionAsync(ValueAction body, final ApiCallback<ValueAction> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createValueActionCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ValueAction>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getValueAction */
    private com.squareup.okhttp.Call getValueActionCall(String uuid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'uuid' is set
        if (uuid == null) {
            throw new ApiException("Missing the required parameter 'uuid' when calling getValueAction(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/valueaction/{uuid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "uuid" + "\\}", apiClient.escapeString(uuid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * get ValueAction
     * 
     * @param uuid  (required)
     * @return ValueAction
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ValueAction getValueAction(String uuid) throws ApiException {
        ApiResponse<ValueAction> resp = getValueActionWithHttpInfo(uuid);
        return resp.getData();
    }

    /**
     * get ValueAction
     * 
     * @param uuid  (required)
     * @return ApiResponse&lt;ValueAction&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ValueAction> getValueActionWithHttpInfo(String uuid) throws ApiException {
        com.squareup.okhttp.Call call = getValueActionCall(uuid, null, null);
        Type localVarReturnType = new TypeToken<ValueAction>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * get ValueAction (asynchronously)
     * 
     * @param uuid  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getValueActionAsync(String uuid, final ApiCallback<ValueAction> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getValueActionCall(uuid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ValueAction>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for updateValueAction */
    private com.squareup.okhttp.Call updateValueActionCall(ValueAction body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        

        // create path and map variables
        String localVarPath = "/valueaction".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * update ValueAction
     * Updating the value of the ValueAction will cause any calculations in the future to use this new value, changing the rewards retroactivly. If you want to prohibit these types of retroactive changes, set the archived bit to true and create a new ValueAction and use it going forward.
     * @param body  (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateValueAction(ValueAction body) throws ApiException {
        updateValueActionWithHttpInfo(body);
    }

    /**
     * update ValueAction
     * Updating the value of the ValueAction will cause any calculations in the future to use this new value, changing the rewards retroactivly. If you want to prohibit these types of retroactive changes, set the archived bit to true and create a new ValueAction and use it going forward.
     * @param body  (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> updateValueActionWithHttpInfo(ValueAction body) throws ApiException {
        com.squareup.okhttp.Call call = updateValueActionCall(body, null, null);
        return apiClient.execute(call);
    }

    /**
     * update ValueAction (asynchronously)
     * Updating the value of the ValueAction will cause any calculations in the future to use this new value, changing the rewards retroactivly. If you want to prohibit these types of retroactive changes, set the archived bit to true and create a new ValueAction and use it going forward.
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateValueActionAsync(ValueAction body, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateValueActionCall(body, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}