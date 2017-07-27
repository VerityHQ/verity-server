# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import site.verity.client.*;
import site.verity.client.auth.*;
import site.verity.client.model.*;
import site.verity.client.api.ActionTypeApi;

import java.io.File;
import java.util.*;

public class ActionTypeApiExample {

    public static void main(String[] args) {
        
        ActionTypeApi apiInstance = new ActionTypeApi();
        ActionType body = new ActionType(); // ActionType | 
        try {
            ActionType result = apiInstance.createActiontype(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActionTypeApi#createActiontype");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://springserver.cfapps.io/verity/core*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ActionTypeApi* | [**createActiontype**](docs/ActionTypeApi.md#createActiontype) | **POST** /actiontype | create ActionType
*ActionTypeApi* | [**getActiontype**](docs/ActionTypeApi.md#getActiontype) | **GET** /actiontype/{uuid} | get ActionType
*ActionTypeApi* | [**updateActiontype**](docs/ActionTypeApi.md#updateActiontype) | **PUT** /actiontype | update ActionType
*CommunityApi* | [**createCommunity**](docs/CommunityApi.md#createCommunity) | **POST** /community | create a Community
*CommunityApi* | [**getCommunity**](docs/CommunityApi.md#getCommunity) | **GET** /community/{uuid} | get community
*CommunityApi* | [**updateCommunity**](docs/CommunityApi.md#updateCommunity) | **PUT** /community | update a community
*OrganizationApi* | [**createOrganization**](docs/OrganizationApi.md#createOrganization) | **POST** /organization | create an Organization
*OrganizationApi* | [**getOrganization**](docs/OrganizationApi.md#getOrganization) | **GET** /organization/{uuid} | get organization
*OrganizationApi* | [**updateOrganization**](docs/OrganizationApi.md#updateOrganization) | **PUT** /organization | update Organization
*PersonApi* | [**createPerson**](docs/PersonApi.md#createPerson) | **POST** /person | create person
*PersonApi* | [**getPerson**](docs/PersonApi.md#getPerson) | **GET** /person/{uuid} | get Person
*PersonApi* | [**updatePerson**](docs/PersonApi.md#updatePerson) | **PUT** /person | update person
*TransactionApi* | [**createTransaction**](docs/TransactionApi.md#createTransaction) | **POST** /transaction | create transaction
*TransactionApi* | [**getTransactionByTargetAgentId**](docs/TransactionApi.md#getTransactionByTargetAgentId) | **GET** /transaction/{targetAgentId} | get Transactions by targetAgentId
*TransactionApi* | [**getTransactionByTargetAgentIdByValueActionId**](docs/TransactionApi.md#getTransactionByTargetAgentIdByValueActionId) | **GET** /transaction/{targetAgentId}/{valueActionId} | get transactions by targetAgent and valueAction
*TransactionApi* | [**getTransactionsByDates**](docs/TransactionApi.md#getTransactionsByDates) | **GET** /transaction/{targetAgentId}/{fromdate}/{todate} | get Transactions by Dates
*ValueActionApi* | [**archiveValueAction**](docs/ValueActionApi.md#archiveValueAction) | **DELETE** /valueaction/{uuid} | archive ValueAction
*ValueActionApi* | [**createValueAction**](docs/ValueActionApi.md#createValueAction) | **POST** /valueaction | create ValueAction
*ValueActionApi* | [**getValueAction**](docs/ValueActionApi.md#getValueAction) | **GET** /valueaction/{uuid} | get ValueAction
*ValueActionApi* | [**updateValueAction**](docs/ValueActionApi.md#updateValueAction) | **PUT** /valueaction | update ValueAction


## Documentation for Models

 - [ActionType](docs/ActionType.md)
 - [Activity](docs/Activity.md)
 - [Agent](docs/Agent.md)
 - [Community](docs/Community.md)
 - [Content](docs/Content.md)
 - [InlineResponse403](docs/InlineResponse403.md)
 - [InlineResponse404](docs/InlineResponse404.md)
 - [Organization](docs/Organization.md)
 - [Person](docs/Person.md)
 - [SoftwareAgent](docs/SoftwareAgent.md)
 - [Transaction](docs/Transaction.md)
 - [Uuid](docs/Uuid.md)
 - [ValueAction](docs/ValueAction.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### verity_auth_token

- **Type**: API key
- **API key parameter name**: verity_auth_token
- **Location**: URL query string

### Basic Auth

- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



