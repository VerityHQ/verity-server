/*
 * VerityReputation
 * You can find out more about Verity at <a href='http://verity.site'>http://verity.site</a>  For this sample, you can use the api key 'special-key' for tests that need authorization (authorization filters).  The collaboration layer in Verity is built on the notion of agents, content and communities. Agents are any users, groups, or autonomous actors that can perform actions within the system. A community in Verity is a group of agents that share a common purpose, vision, or goal. Content is anything in the Verity protocol that can be rated or acted upon, but which cannot itself act.  The purpose of the Verity collaboration layer is to ensure that communities organize talent, resources, and actions around their shared economic and social interest. There are two specific goals: to preserve community intent over time, thus preserving the identity of the community, and to incentivize actions in alignment with that intent.  Where possible we specify multi-hashes as unique identifiers that can be used by distributed cryptographically secure systems (blockchains) Where possible we specify hyper-media links (e.g. JSON-LD) to describe data that is linked in graph structures by nature (blockchain data, IPFS data, etc.)  Agents, Entity and Activity should map to provenance ontology described in https://www.w3.org/TR/prov-o  Transaction is an implementation that maps to TrustAtoms. https://github.com/CoMakery/trust-exchange/blob/master/README.md This is a simple Verity reputation API. You can find out more about Verity at <a href='http://getcrystal.net'>http://getcrystal.net</a>  For this sample, you can use the api key 'special-key' for tests that need authorization (authorization filters).  Where possible we specify multi-hashes as unique identifiers that can be used by distributed cryptographically secure systems (blockchains) Where possible we specify hyper-media links (e.g. JSON-LD) to describe data that is linked in graph structures by nature (blockchain data, IPFS data, etc.)  Agents, Entity and Activity should map to provenance ontology described in https://www.w3.org/TR/prov-o Transaction is an implementation that maps to TrustAtoms. https://github.com/CoMakery/trust-exchange/blob/master/README.md
 *
 * OpenAPI spec version: 1.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package site.verity.client.auth;

import site.verity.client.Pair;

import java.util.Map;
import java.util.List;

public interface Authentication {
    /**
     * Apply authentication settings to header and query params.
     *
     * @param queryParams List of query parameters
     * @param headerParams Map of header parameters
     */
    void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}
