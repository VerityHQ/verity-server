package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;

/**
 * Bot, smart contract, or software that has agency in the reputation ecosystem (can give and receive reputation) and like other agents has a public key that can sign attestations. One such use would be for a crawler that pulls in attestations (ratings) from sites such as IMDB and as an agent of a well known organization, signs the attestations and moves them into the Verity system, vouching for their authenticity.
 **/

/**
 * Bot, smart contract, or software that has agency in the reputation ecosystem
 * (can give and receive reputation) and like other agents has a public key that
 * can sign attestations. One such use would be for a crawler that pulls in
 * attestations (ratings) from sites such as IMDB and as an agent of a well
 * known organization, signs the attestations and moves them into the Verity
 * system, vouching for their authenticity.
 */
@ApiModel(description = "Bot, smart contract, or software that has agency in the reputation ecosystem (can give and receive reputation) and like other agents has a public key that can sign attestations. One such use would be for a crawler that pulls in attestations (ratings) from sites such as IMDB and as an agent of a well known organization, signs the attestations and moves them into the Verity system, vouching for their authenticity.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-30T13:41:55.542-08:00")

@Entity
@Table(name="software_agent")
public class SoftwareAgent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5895593878806837584L;

	@Id
	@Column(name="UUID",unique=true, nullable=false )
	private String id = null;
	@Column(name="API_URL")
	private String apiUrl = null;
	@Column(name="NAME")
	private String name = null;

//	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
//			CascadeType.DETACH })
//	@JoinColumn(name = "owned_by_agent_uuid")
	private Agent ownedBy = null;

	public SoftwareAgent uuid(String uuid) {
		this.id = uuid;
		return this;
	}

	/**
	 * UUID, GUID, HASH, MultiHash or ProxyContract Address that represents this
	 * object
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object")
	public String getUuid() {
		return id;
	}

	public void setUuid(String uuid) {
		this.id = uuid;
	}

	public SoftwareAgent apiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
		return this;
	}

	/**
	 * Get apiUrl
	 * 
	 * @return apiUrl
	 **/
	@ApiModelProperty(required = true, value = "")
	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public SoftwareAgent name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(required = true, value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SoftwareAgent ownedBy(Agent ownedBy) {
		this.ownedBy = ownedBy;
		return this;
	}

	/**
	 * Get ownedBy
	 * 
	 * @return ownedBy
	 **/
	@ApiModelProperty(value = "")
	public Agent getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(Agent ownedBy) {
		this.ownedBy = ownedBy;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SoftwareAgent softwareAgent = (SoftwareAgent) o;
		return Objects.equals(this.id, softwareAgent.id) && Objects.equals(this.apiUrl, softwareAgent.apiUrl)
				&& Objects.equals(this.name, softwareAgent.name) && Objects.equals(this.ownedBy, softwareAgent.ownedBy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, apiUrl, name, ownedBy);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SoftwareAgent {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    apiUrl: ").append(toIndentedString(apiUrl)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    ownedBy: ").append(toIndentedString(ownedBy)).append("\n");
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
