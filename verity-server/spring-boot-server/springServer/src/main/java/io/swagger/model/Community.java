package io.swagger.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;
import io.swagger.model.Community;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Community
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T19:52:26.921-08:00")

@Entity
@Table(name="community")
public class Community implements Serializable {

	private static final long serialVersionUID = -3185192700794511303L;

//	@OneToOne(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
//			CascadeType.DETACH })
//	@JoinColumn(name = "agent_uuid") // was agent_fk
	
	@OneToOne
	@JoinColumn(name = "AGENT_UUID")
	private Agent agent = null;

	private String communityName = null;

	@Id
	@Column(name="UUID",unique=true, nullable=false )
	private String id = null;

	@Column(name = "SUB_COMMUNITY")
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection(targetClass = Community.class)
	private List<Community> subCommunities = new ArrayList<Community>();

	
	
	public Community agent(Agent agent) {
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

	public Community communityName(String communityName) {
		this.communityName = communityName;
		return this;
	}

	/**
	 * Get communityName
	 * 
	 * @return communityName
	 **/
	@ApiModelProperty(required = true, value = "")
	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public Community uuid(String uuid) {
		this.id = uuid;
		return this;
	}

	/**
	 * UUID, GUID, HASH or MultiHash that represents this object.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "UUID, GUID, HASH or MultiHash that represents this object.")
	public String getUuid() {
		return id;
	}

	public void setUuid(String uuid) {
		this.id = uuid;
	}

	public Community subCommunities(List<Community> subCommunities) {
		this.subCommunities = subCommunities;
		return this;
	}

	public Community addSubCommunitiesItem(Community subCommunitiesItem) {
		this.subCommunities.add(subCommunitiesItem);
		return this;
	}

	/**
	 * Get subCommunities
	 * 
	 * @return subCommunities
	 **/
	@ApiModelProperty(value = "")
	public List<Community> getSubCommunities() {
		return subCommunities;
	}

	public void setSubCommunities(List<Community> subCommunities) {
		this.subCommunities = subCommunities;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Community community = (Community) o;
		return Objects.equals(this.id, community.id) && Objects.equals(this.communityName, community.communityName)
				&& Objects.equals(this.subCommunities, community.subCommunities)
				&& Objects.equals(this.agent, community.agent);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, communityName, subCommunities, agent);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Community {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    communityName: ").append(toIndentedString(communityName)).append("\n");
		sb.append("    subCommunities: ").append(toIndentedString(subCommunities)).append("\n");
		sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
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