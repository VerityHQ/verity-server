package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;
import io.swagger.model.Community;
import javax.validation.constraints.*;

/**
 * Organization is at the top level of the ecosystem. An organization has one
 * community that is the root of the community ecosystem (tree). A community can
 * have sub communities so the hirearchy is Organization-&gt;Community-&gt;Sub
 * Communities
 */
@ApiModel(description = "Organization is at the top level of the ecosystem. An organization has one community that is the root of the community ecosystem (tree). A community can have sub communities so the hirearchy is Organization->Community->Sub Communities")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-14T11:27:43.869-07:00")
@Entity
@Table(name = "organization")
public class Organization implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1616396014713721397L;

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@JsonProperty("uuid")
	private String uuid = null;

	@Column(name="NAME")
	@JsonProperty("orgName")
	private String orgName = null;
	
	@OneToOne   //(mappedBy="id") //the table (Agent class)
	@JoinColumn(name = "AGENT_UUID")
	@JsonProperty("agent")
	private Agent agent = null;

	//the root community for the organization
	@OneToOne
	@JoinColumn(name = "COMMUNITY_UUID")
	@JsonProperty("community")
	private Community community = null;

	public Organization uuid(String uuid) {
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

	public Organization orgName(String orgName) {
		this.orgName = orgName;
		return this;
	}

	/**
	 * Get orgName
	 * 
	 * @return orgName
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Organization agent(Agent agent) {
		this.agent = agent;
		return this;
	}

	/**
	 * Get agent
	 * 
	 * @return agent
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Organization community(Community community) {
		this.community = community;
		return this;
	}

	/**
	 * Get community
	 * 
	 * @return community
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Organization organization = (Organization) o;
		return Objects.equals(this.uuid, organization.uuid) && Objects.equals(this.orgName, organization.orgName)
				&& Objects.equals(this.agent, organization.agent)
				&& Objects.equals(this.community, organization.community);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, orgName, agent, community);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Organization {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    orgName: ").append(toIndentedString(orgName)).append("\n");
		sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
		sb.append("    community: ").append(toIndentedString(community)).append("\n");
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
