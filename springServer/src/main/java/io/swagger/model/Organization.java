package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;
import io.swagger.model.Community;
import io.swagger.model.Content;

/**
 * Organization
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-30T13:26:20.711-08:00")

@Entity
public class Organization implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1616396014713721397L;

	@Id
	private String uuid = null;

	private String orgName = null;
	
	@OneToOne(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH })
	@JoinColumn(name = "agent_uuid", unique = true) // was agent_fk
	private Agent agent = null;

	private Content content = null;

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
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Organization content(Content content) {
		this.content = content;
		return this;
	}

	/**
	 * Get content
	 * 
	 * @return content
	 **/
	@ApiModelProperty(value = "")
	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
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
	@ApiModelProperty(value = "")
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
				&& Objects.equals(this.agent, organization.agent) && Objects.equals(this.content, organization.content)
				&& Objects.equals(this.community, organization.community);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, orgName, agent, content, community);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Organization {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    orgName: ").append(toIndentedString(orgName)).append("\n");
		sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
		sb.append("    content: ").append(toIndentedString(content)).append("\n");
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
