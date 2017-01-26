
# Agent

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object | 
**publicKey** | **String** |  | 
**attestationUrls** | **List&lt;String&gt;** | zero or more attestation URLs (twitter, FB, blog) links to proof of account ownership, a post with public key id of owner. Signing the attribute with the Verity signing key creates a claim that the Verity system has created this attestation.   Examples at:  https://keybase.io/ https://keybase.io/docs/kbfs/understanding_kbfs  How to use Oracalize to create attestations: http://docs.oraclize.it/#datasources-url. Alignment with W3C Verifiable Claims spec is encouraged. https://opencreds.github.io/vc-data-model/ |  [optional]



