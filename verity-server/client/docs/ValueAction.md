
# ValueAction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object | 
**description** | **String** | Describes this action. Formatted as JSON or JSON:LD. Should include a short &#39;tag&#39; and optionally a longer description or link to more content. | 
**value** | **Integer** | the value awarded. Can be changed at any time. Changes to value will affect all transactions to date that have been created with this ValueAction. |  [optional]
**actionTypeId** | **String** | the  UUID of the actionType | 
**archived** | **Boolean** | indicates this ValueAction is frozen and read-only. No further changes to &#39;value&#39; or any other fields can be made. | 



