# CommunityApi

All URIs are relative to *http://springserver.cfapps.io/verity/core*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCommunity**](CommunityApi.md#createCommunity) | **POST** /community | create a Community
[**getCommunity**](CommunityApi.md#getCommunity) | **GET** /community/{uuid} | get community
[**updateCommunity**](CommunityApi.md#updateCommunity) | **PUT** /community | update a community


<a name="createCommunity"></a>
# **createCommunity**
> Community createCommunity(body)

create a Community

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.CommunityApi;


CommunityApi apiInstance = new CommunityApi();
Community body = new Community(); // Community | 
try {
    Community result = apiInstance.createCommunity(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommunityApi#createCommunity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Community**](Community.md)|  | [optional]

### Return type

[**Community**](Community.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCommunity"></a>
# **getCommunity**
> Community getCommunity(uuid)

get community

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.CommunityApi;


CommunityApi apiInstance = new CommunityApi();
String uuid = "uuid_example"; // String | 
try {
    Community result = apiInstance.getCommunity(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommunityApi#getCommunity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**|  |

### Return type

[**Community**](Community.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCommunity"></a>
# **updateCommunity**
> updateCommunity(body)

update a community

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.CommunityApi;


CommunityApi apiInstance = new CommunityApi();
Community body = new Community(); // Community | 
try {
    apiInstance.updateCommunity(body);
} catch (ApiException e) {
    System.err.println("Exception when calling CommunityApi#updateCommunity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Community**](Community.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

