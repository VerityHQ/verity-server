# ActionTypeApi

All URIs are relative to *http://springserver.cfapps.io/verity/core*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createActiontype**](ActionTypeApi.md#createActiontype) | **POST** /actiontype | create ActionType
[**getActiontype**](ActionTypeApi.md#getActiontype) | **GET** /actiontype/{uuid} | get ActionType
[**updateActiontype**](ActionTypeApi.md#updateActiontype) | **PUT** /actiontype | update ActionType


<a name="createActiontype"></a>
# **createActiontype**
> ActionType createActiontype(body)

create ActionType

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.ActionTypeApi;


ActionTypeApi apiInstance = new ActionTypeApi();
ActionType body = new ActionType(); // ActionType | 
try {
    ActionType result = apiInstance.createActiontype(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionTypeApi#createActiontype");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ActionType**](ActionType.md)|  | [optional]

### Return type

[**ActionType**](ActionType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getActiontype"></a>
# **getActiontype**
> ActionType getActiontype(uuid)

get ActionType

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.ActionTypeApi;


ActionTypeApi apiInstance = new ActionTypeApi();
String uuid = "uuid_example"; // String | 
try {
    ActionType result = apiInstance.getActiontype(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionTypeApi#getActiontype");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**|  |

### Return type

[**ActionType**](ActionType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateActiontype"></a>
# **updateActiontype**
> updateActiontype(body)

update ActionType

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.ActionTypeApi;


ActionTypeApi apiInstance = new ActionTypeApi();
ActionType body = new ActionType(); // ActionType | 
try {
    apiInstance.updateActiontype(body);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionTypeApi#updateActiontype");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ActionType**](ActionType.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

