package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;
import javax.validation.constraints.*;

/**
 * Bot, smart contract, or software that has agency in the reputation ecosystem
 * (can give and receive reputation) and like other agents has a public key that
 * can sign attestations. One such use would be for a crawler that pulls in
 * attestations (ratings) from sites such as IMDB and as an agent of a well
 * known organization, signs the attestations and moves them into the Verity
 * system, vouching for their authenticity.
 */
@ApiModel(description = "Bot, smart contract, or software that has agency in the reputation ecosystem (can give and receive reputation) and like other agents has a public key that can sign attestations. One such use would be for a crawler that pulls in attestations (ratings) from sites such as IMDB and as an agent of a well known organization, signs the attestations and moves them into the Verity system, vouching for their authenticity.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-14T11:27:43.869-07:00")

@Entity
@Table(name="software_agent")
public class SoftwareAgent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5895593878806837584L;

	@Id
	@Column(name="UUID",unique=true, nullable=false )
	@JsonProperty("uuid")
	private String uuid = null;

	@JsonProperty("apiUrl")
	@Column(name="API_URL")
	private String apiUrl = null;

	@JsonProperty("name")
	@Column(name="NAME")
	private String name = null;

	//TODO: how should this be represented in DB?
	@JsonProperty("ownedBy")
	private Agent ownedBy = null;

	public SoftwareAgent uuid(String uuid) {
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
	@NotNull
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
	@NotNull
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
		return Objects.equals(this.uuid, softwareAgent.uuid) && Objects.equals(this.apiUrl, softwareAgent.apiUrl)
				&& Objects.equals(this.name, softwareAgent.name) && Objects.equals(this.ownedBy, softwareAgent.ownedBy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, apiUrl, name, ownedBy);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SoftwareAgent {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
