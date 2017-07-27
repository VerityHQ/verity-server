
# Transaction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object | 
**valueActionId** | **String** | link that describes the way this score was derived, or the community feature that affects the way the value will be interpreted. Could be a link or content addressable graph pointing to a richer source of description or information. | 
**sourceAgentId** | **String** |  | 
**targetAgentId** | **String** |  | 
**timeStamp** | [**DateTime**](DateTime.md) | timestamp or block height of blockchain at time of creation. Should be self-describing as to format and meaning. |  [optional]
**value** | **Integer** | value (points) awarded at the time of the transaction. Immutable. Use ValueActionId to lookup the &#39;current&#39; value if you want to calculate points based on the latest value as apposed to the value at time transaction was created. This allows for &#39;retroactive&#39; adjustment of points. |  [optional]



