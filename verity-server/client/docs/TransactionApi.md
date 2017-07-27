# TransactionApi

All URIs are relative to *http://springserver.cfapps.io/verity/core*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTransaction**](TransactionApi.md#createTransaction) | **POST** /transaction | create transaction
[**getTransactionByTargetAgentId**](TransactionApi.md#getTransactionByTargetAgentId) | **GET** /transaction/{targetAgentId} | get Transactions by targetAgentId
[**getTransactionByTargetAgentIdByValueActionId**](TransactionApi.md#getTransactionByTargetAgentIdByValueActionId) | **GET** /transaction/{targetAgentId}/{valueActionId} | get transactions by targetAgent and valueAction
[**getTransactionsByDates**](TransactionApi.md#getTransactionsByDates) | **GET** /transaction/{targetAgentId}/{fromdate}/{todate} | get Transactions by Dates


<a name="createTransaction"></a>
# **createTransaction**
> Transaction createTransaction(body)

create transaction

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.TransactionApi;


TransactionApi apiInstance = new TransactionApi();
Transaction body = new Transaction(); // Transaction | 
try {
    Transaction result = apiInstance.createTransaction(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionApi#createTransaction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Transaction**](Transaction.md)|  | [optional]

### Return type

[**Transaction**](Transaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTransactionByTargetAgentId"></a>
# **getTransactionByTargetAgentId**
> List&lt;Transaction&gt; getTransactionByTargetAgentId(targetAgentId)

get Transactions by targetAgentId

TODO:consider paginating results in similar way to reddit API https://www.reddit.com/dev/api/

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.TransactionApi;


TransactionApi apiInstance = new TransactionApi();
String targetAgentId = "targetAgentId_example"; // String | 
try {
    List<Transaction> result = apiInstance.getTransactionByTargetAgentId(targetAgentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionApi#getTransactionByTargetAgentId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **targetAgentId** | **String**|  |

### Return type

[**List&lt;Transaction&gt;**](Transaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionByTargetAgentIdByValueActionId"></a>
# **getTransactionByTargetAgentIdByValueActionId**
> getTransactionByTargetAgentIdByValueActionId(targetAgentId, valueActionId)

get transactions by targetAgent and valueAction

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.TransactionApi;


TransactionApi apiInstance = new TransactionApi();
String targetAgentId = "targetAgentId_example"; // String | 
String valueActionId = "valueActionId_example"; // String | 
try {
    apiInstance.getTransactionByTargetAgentIdByValueActionId(targetAgentId, valueActionId);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionApi#getTransactionByTargetAgentIdByValueActionId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **targetAgentId** | **String**|  |
 **valueActionId** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionsByDates"></a>
# **getTransactionsByDates**
> List&lt;Transaction&gt; getTransactionsByDates(targetAgentId, fromdate, todate)

get Transactions by Dates

### Example
```java
// Import classes:
//import site.verity.client.ApiException;
//import site.verity.client.api.TransactionApi;


TransactionApi apiInstance = new TransactionApi();
String targetAgentId = "targetAgentId_example"; // String | 
String fromdate = "fromdate_example"; // String | 
String todate = "todate_example"; // String | 
try {
    List<Transaction> result = apiInstance.getTransactionsByDates(targetAgentId, fromdate, todate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionApi#getTransactionsByDates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **targetAgentId** | **String**|  |
 **fromdate** | **String**|  |
 **todate** | **String**|  |

### Return type

[**List&lt;Transaction&gt;**](Transaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

