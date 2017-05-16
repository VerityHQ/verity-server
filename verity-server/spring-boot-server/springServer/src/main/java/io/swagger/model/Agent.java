package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


/**
 * Agent is something that bears some form of responsibility for changing state
 * in the Verity system. An Agent could be a smart contract, person,
 * organization, device, or anything the owns the Private Key half of the
 * publicKey of the Agent and controlls the accounts used for attestationURLs.
 * Maps to https://www.w3.org/TR/prov-o/#Agent prov:Agent
 */
@ApiModel(description = "Agent is something that bears some form of responsibility for changing state in the Verity system. An Agent could be a smart contract, person, organization, device, or anything the owns the Private Key half of the publicKey of the Agent and controlls the accounts used for attestationURLs.  Maps to  https://www.w3.org/TR/prov-o/#Agent  prov:Agent")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-14T11:27:43.869-07:00")

@Entity
@Table(name = "agent")
public class Agent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5193173655266389886L;
	
	@JsonProperty("uuid")	
	@Id
	@Column(name="UUID", unique=true, nullable=false )
	private String uuid = null;
	
	//there is also a generator for system-guid which is more like an blockchain address
//  @Id
//  @GeneratedValue(generator="system-uuid")
//  @GenericGenerator(name="system-uuid", strategy = "uuid")
//  @Column(name = "uuid", unique = true)
//  private String uuid;

	@Lob //varchar(max)
	@Column(name = "PUBLIC_KEY")
	@JsonProperty("publicKey")
	private String publicKey = null;
	
    //following shows how to use collections of simple types with hibernate
    //The collection will be created as a table of string values with keys back to parent
    //The @LazyCollection attribute is needed. See SO  //http://stackoverflow.com/questions/30465748/jackson-confused-with-bidirectional-one-to-many-relationship-failed-to-lazily
    @Column(name = "ATTESTATION_URLS")
    @LazyCollection(LazyCollectionOption.FALSE) 
    @ElementCollection(targetClass=String.class)
	@JsonProperty("attestationUrls")
	private List<String> attestationUrls = new ArrayList<String>();

	public Agent uuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	/**
	 * UUID, GUID, HASH, MultiHash or ProxyContract Address that represents this
	 * object
	 * 
	 * @return uuid
	 **/
	@ApiModelProperty(required = true, value = "UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object")
	@NotNull
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Agent publicKey(String publicKey) {
		this.publicKey = publicKey;
		return this;
	}

	/**
	 * Get publicKey
	 * 
	 * @return publicKey
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
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
	 * zero or more attestation URLs (twitter, FB, blog) links to proof of
	 * account ownership, a post with public key id of owner. Signing the
	 * attribute with the Verity signing key creates a claim that the Verity
	 * system has created this attestation. Examples at: https://keybase.io/
	 * https://keybase.io/docs/kbfs/understanding_kbfs How to use Oracalize to
	 * create attestations: http://docs.oraclize.it/#datasources-url. Alignment
	 * with W3C Verifiable Claims spec is encouraged.
	 * https://opencreds.github.io/vc-data-model/
	 * 
	 * @return attestationUrls
	 **/
	@ApiModelProperty(value = "zero or more attestation URLs (twitter, FB, blog) links to proof of account ownership, a post with public key id of owner. Signing the attribute with the Verity signing key creates a claim that the Verity system has created this attestation.   Examples at:  https://keybase.io/ https://keybase.io/docs/kbfs/understanding_kbfs  How to use Oracalize to create attestations: http://docs.oraclize.it/#datasources-url. Alignment with W3C Verifiable Claims spec is encouraged. https://opencreds.github.io/vc-data-model/")
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
