package io.swagger.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Agent is something that bears some form of responsibility for an activity taking place, for the existence of an entity, or for another agent&#39;s activity. An Agent could be software, person, organization, device.  Maps to  https://www.w3.org/TR/prov-o/#Agent  prov:Agent
 **/

/**
 * Agent is something that bears some form of responsibility for an activity
 * taking place, for the existence of an entity, or for another agent&#39;s
 * activity. An Agent could be software, person, organization, device. Maps to
 * https://www.w3.org/TR/prov-o/#Agent prov:Agent
 */
@ApiModel(description = "Agent is something that bears some form of responsibility for an activity taking place, for the existence of an entity, or for another agent's activity. An Agent could be software, person, organization, device.  Maps to  https://www.w3.org/TR/prov-o/#Agent  prov:Agent")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T19:52:26.921-08:00")

@Entity
public class Agent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5193173655266389886L;
	
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    //private long id;

	//we expect the UUID to come from the caller, allready generated on chain by the 
	//agent account
    @Id
    @Column(name = "uuid")
	private String uuid = null;
    
//    @Id
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
//    @Column(name = "uuid2", unique = true)
//    private String uuid2;
    
/*
 * Persisting or merging a transient entity from a controller:

session.persist(new UUID2Identifier());
session.flush();
session.merge(new UUID2Identifier());
session.flush();

 */
    
    
    @Column(name = "public_key")
	private String publicKey = null;

    //following shows how to use collections with hibernate
    //The collection will be created as a table of string values with keys back to parent
    //The @LazyCollection attribute is needed. See SO  //http://stackoverflow.com/questions/30465748/jackson-confused-with-bidirectional-one-to-many-relationship-failed-to-lazily
    @Column(name = "attestation_urls")
    @LazyCollection(LazyCollectionOption.FALSE) 
    @ElementCollection(targetClass=String.class)
	private List<String> attestationUrls = new ArrayList<String>();
	

	public Agent uuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public Agent publicKey(String publicKey) {
		this.publicKey = publicKey;
		return this;
	}
	
	public Agent attestationUrls(List<String> attestationUrls) {
		this.attestationUrls = attestationUrls;
		return this;
	}

	public Agent addAttestationUrlsItem(String attestationUrlsItem) {
		this.attestationUrls.add(attestationUrlsItem);
		return this;
	}
	
	/**
	 * UUID, GUID, HASH, MultiHash or ProxyContract Address that represents this
	 * object
	 * 
	 * @return uuid
	 **/
	@ApiModelProperty(required = true, value = "UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Get publicKey
	 * 
	 * @return publicKey
	 **/
	@ApiModelProperty(required = true, value = "")
	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}


	/**
	 * zero or more attestation URLs (twitter, FB, blog) links to proof of
	 * account ownership, a post with public key id of owner. Signing the
	 * attribute with the Verity signing key creates a claim that the Verity
	 * identity controls the account. Examples at: https://keybase.io/ How to
	 * use Oracalize to create attestations:
	 * http://docs.oraclize.it/#datasources-url
	 * 
	 * @return attestationUrls
	 **/
	@ApiModelProperty(value = "zero or more attestation URLs (twitter, FB, blog) links to proof of account ownership, a post with public key id of owner.  Signing the attribute with the Verity signing key creates a claim that the Verity identity controls the account. Examples at: https://keybase.io/ How to use Oracalize to create attestations: http://docs.oraclize.it/#datasources-url")
	public List<String> getAttestationUrls() {
		return attestationUrls;
	}

	public void setAttestationUrls(List<String> attestationUrls) {
		this.attestationUrls = attestationUrls;
	}

	
	
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Agent agent = (Agent) o;
		return Objects.equals(this.uuid, agent.uuid) && Objects.equals(this.publicKey, agent.publicKey)
				&& Objects.equals(this.attestationUrls, agent.attestationUrls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, publicKey, attestationUrls);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Agent {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
		sb.append("    attestationUrls: ").append(toIndentedString(attestationUrls)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
