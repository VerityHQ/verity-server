
# ActionType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object | 
**actionName** | **String** | Can represent any type of reputation as a verb. Use verb to describe act of giving or rating, e.g. upvote, give points, tagged, rate. | 
**communityId** | **String** | Community that defined this ActionType. Multi-hash or JSON-LD | 
**defaultPoints** | **Integer** | points to award in default case |  [optional]
**content** | **String** | Describes this action in detail. Formatted as JSON or JSON:LD. Should include the ActionName along with a longer description or link to more content. |  [optional]



