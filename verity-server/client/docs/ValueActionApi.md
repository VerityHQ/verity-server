# ValueActionApi

All URIs are relative to *http://springserver.cfapps.io/verity/core*

Method | HTTP request | Description
------------- | ------------- | -------------
[**archiveValueAction**](ValueActionApi.md#archiveValueAction) | **DELETE** /valueaction/{uuid} | archive ValueAction
[**createValueAction**](ValueActionApi.md#createValueAction) | **POST** /valueaction | create ValueAction
[**getValueAction**](ValueActionApi.md#getValueAction) | **GET** /valueaction/{uuid} | get ValueAction
[**updateValueAction**](ValueActionApi.md#updateValueAction) | **PUT** /valueaction | update ValueAction


<a name="archiveValueAction"></a>
# **archiveValueAction**
> archiveValueAction(uuid)

archive ValueAction

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.ValueActionApi;


ValueActionApi apiInstance = new ValueActionApi();
String uuid = "uuid_example"; // String | 
try {
    apiInstance.archiveValueAction(uuid);
} catch (ApiException e) {
    System.err.println("Exception when calling ValueActionApi#archiveValueAction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createValueAction"></a>
# **createValueAction**
> ValueAction createValueAction(body)

create ValueAction

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.ValueActionApi;


ValueActionApi apiInstance = new ValueActionApi();
ValueAction body = new ValueAction(); // ValueAction | 
try {
    ValueAction result = apiInstance.createValueAction(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ValueActionApi#createValueAction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ValueAction**](ValueAction.md)|  | [optional]

### Return type

[**ValueAction**](ValueAction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getValueAction"></a>
# **getValueAction**
> ValueAction getValueAction(uuid)

get ValueAction

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.ValueActionApi;


ValueActionApi apiInstance = new ValueActionApi();
String uuid = "uuid_example"; // String | 
try {
    ValueAction result = apiInstance.getValueAction(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ValueActionApi#getValueAction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**|  |

### Return type

[**ValueAction**](ValueAction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateValueAction"></a>
# **updateValueAction**
> updateValueAction(body)

update ValueAction

Updating the value of the ValueAction will cause any calculations in the future to use this new value, changing the rewards retroactivly. If you want to prohibit these types of retroactive changes, set the archived bit to true and create a new ValueAction and use it going forward.

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.ValueActionApi;


ValueActionApi apiInstance = new ValueActionApi();
ValueAction body = new ValueAction(); // ValueAction | 
try {
    apiInstance.updateValueAction(body);
} catch (ApiException e) {
    System.err.println("Exception when calling ValueActionApi#updateValueAction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ValueAction**](ValueAction.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

