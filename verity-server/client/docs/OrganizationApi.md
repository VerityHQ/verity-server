# OrganizationApi

All URIs are relative to *http://springserver.cfapps.io/verity/core*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createOrganization**](OrganizationApi.md#createOrganization) | **POST** /organization | create an Organization
[**getOrganization**](OrganizationApi.md#getOrganization) | **GET** /organization/{uuid} | get organization
[**updateOrganization**](OrganizationApi.md#updateOrganization) | **PUT** /organization | update Organization


<a name="createOrganization"></a>
# **createOrganization**
> Organization createOrganization(body)

create an Organization

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.OrganizationApi;


OrganizationApi apiInstance = new OrganizationApi();
Organization body = new Organization(); // Organization | 
try {
    Organization result = apiInstance.createOrganization(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganizationApi#createOrganization");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Organization**](Organization.md)|  | [optional]

### Return type

[**Organization**](Organization.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getOrganization"></a>
# **getOrganization**
> Organization getOrganization(uuid)

get organization

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.OrganizationApi;


OrganizationApi apiInstance = new OrganizationApi();
String uuid = "uuid_example"; // String | 
try {
    Organization result = apiInstance.getOrganization(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganizationApi#getOrganization");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**|  |

### Return type

[**Organization**](Organization.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateOrganization"></a>
# **updateOrganization**
> updateOrganization(body)

update Organization

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.OrganizationApi;


OrganizationApi apiInstance = new OrganizationApi();
Organization body = new Organization(); // Organization | 
try {
    apiInstance.updateOrganization(body);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganizationApi#updateOrganization");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Organization**](Organization.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

