# PersonApi

All URIs are relative to *http://springserver.cfapps.io/verity/core*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPerson**](PersonApi.md#createPerson) | **POST** /person | create person
[**getPerson**](PersonApi.md#getPerson) | **GET** /person/{uuid} | get Person
[**updatePerson**](PersonApi.md#updatePerson) | **PUT** /person | update person


<a name="createPerson"></a>
# **createPerson**
> Person createPerson(body)

create person

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.PersonApi;


PersonApi apiInstance = new PersonApi();
Person body = new Person(); // Person | 
try {
    Person result = apiInstance.createPerson(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PersonApi#createPerson");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Person**](Person.md)|  | [optional]

### Return type

[**Person**](Person.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPerson"></a>
# **getPerson**
> Person getPerson(uuid)

get Person

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.PersonApi;


PersonApi apiInstance = new PersonApi();
String uuid = "uuid_example"; // String | multi-hash id of person record on the blockchain
try {
    Person result = apiInstance.getPerson(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PersonApi#getPerson");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| multi-hash id of person record on the blockchain |

### Return type

[**Person**](Person.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updatePerson"></a>
# **updatePerson**
> updatePerson(body)

update person

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.PersonApi;


PersonApi apiInstance = new PersonApi();
Person body = new Person(); // Person | 
try {
    apiInstance.updatePerson(body);
} catch (ApiException e) {
    System.err.println("Exception when calling PersonApi#updatePerson");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Person**](Person.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

