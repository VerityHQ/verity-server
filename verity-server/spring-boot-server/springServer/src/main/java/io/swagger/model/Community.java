package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Community
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-27T15:39:32.532-07:00")

@Entity
@Table(name = "community")
public class Community implements Serializable {

	private static final long serialVersionUID = -3185192700794511303L;

	// @OneToOne(cascade = { CascadeType.ALL, CascadeType.PERSIST,
	// CascadeType.MERGE, CascadeType.REFRESH,
	// CascadeType.DETACH })
	// @JoinColumn(name = "agent_uuid") // was agent_fk

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@JsonProperty("uuid")
	private String uuid = null;
	
	@Column(name = "PARENT_COMMUNITY_ID", nullable = true)
	@JsonProperty("parentCommunityId")
	private String parentCommunityId = null;

	@Column(name = "COMMUNITY_NAME", unique = true, nullable = false)
	@JsonProperty("communityName")
	private String communityName = null;

	@Column(name = "SUB_COMMUNITIES")
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection(targetClass = String.class)
	@JsonProperty("subCommunities")
	private List<String> subCommunities = new ArrayList<String>();

	@OneToOne
	@JoinColumn(name = "AGENT_UUID")
	@JsonProperty("agent")
	private Agent agent = null;

	// following shows how to use collections of simple types with hibernate
	// The collection will be created as a table of string values with keys back to
	// parent
	// The @LazyCollection attribute is needed. See SO
	// //http://stackoverflow.com/questions/30465748/jackson-confused-with-bidirectional-one-to-many-relationship-failed-to-lazily
//	@Column(name = "ACTION_TYPES", unique = true)
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@ElementCollection(targetClass = ActionType.class)
//	@JsonProperty("values")
//	private List<ActionType> values = new ArrayList<ActionType>();


	@Column(name="ETHICS")
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection(targetClass = String.class)
	@JsonProperty("ethics")
	private List<String> ethics = null;

	@Column(name="VALUE_ACTIONS")
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection(targetClass = String.class)
	@JsonProperty("valueActions")
	private List<String> valueActions = null;
	
	@Column(name = "MEMBERS")
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection(targetClass = String.class)
	@JsonProperty("members")
	private List<String> members = new ArrayList<String>();

	public Community uuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public List<String> getMembers() {
		return members;
	}
	
	public void setMembers(List<String> members) {
		this.members = members;
	}
	
	/**
	 * UUID, GUID, HASH, MultiHash or ProxyContract Address that represents this
	 * object
	 * 
	 * @return uuid
	 **/
	@ApiModelProperty(value = "UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getParentCommunityId() {
		return parentCommunityId;
	}
	
	public void setParentCommunityId(String parentCommunityId) {
		this.parentCommunityId = parentCommunityId;
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
	@NotNull
	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public Community subCommunities(List<String> subCommunities) {
		this.subCommunities = subCommunities;
		return this;
	}

	public Community addSubCommunitiesItem(String subCommunitiesItem) {
		if (this.subCommunities == null) {
			this.subCommunities = new ArrayList<String>();
		}
		this.subCommunities.add(subCommunitiesItem);
		return this;
	}

	/**
	 * child community ids
	 * 
	 * @return subCommunities
	 **/
	@ApiModelProperty(value = "child community ids")
	public List<String> getSubCommunities() {
		return subCommunities;
	}

	public void setSubCommunities(List<String> subCommunities) {
		this.subCommunities = subCommunities;
	}

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
	@NotNull
	@Valid
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Community ethics(List<String> ethics) {
		this.ethics = ethics;
		return this;
	}

	public Community addEthicsItem(String ethicsItem) {
		if (this.ethics == null) {
			this.ethics = new ArrayList<String>();
		}
		this.ethics.add(ethicsItem);
		return this;
	}

	/**
	 * Get ethics
	 * 
	 * @return list of ethics ids for this community
	 **/
	@ApiModelProperty(value = "")
	public List<String> getEthics() {
		return ethics;
	}

	public void setEthics(List<String> ethics) {
		this.ethics = ethics;
	}

	public Community valueActions(List<String> valueActions) {
		this.valueActions = valueActions;
		return this;
	}

	public Community addValueActionsItem(String valueActionsItem) {
		if (this.valueActions == null) {
			this.valueActions = new ArrayList<String>();
		}
		this.valueActions.add(valueActionsItem);
		return this;
	}

	/**
	 * Get valueActions
	 * 
	 * @return valueActions
	 **/
	@ApiModelProperty(value = "")
	public List<String> getValueActions() {
		return valueActions;
	}

	public void setValueActions(List<String> valueActions) {
		this.valueActions = valueActions;
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
		return Objects.equals(this.uuid, community.uuid) && Objects.equals(this.communityName, community.communityName)
				&& Objects.equals(this.subCommunities, community.subCommunities)
				&& Objects.equals(this.agent, community.agent) && Objects.equals(this.ethics, community.ethics)
				&& Objects.equals(this.valueActions, community.valueActions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, communityName, subCommunities, agent, ethics, valueActions);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Community {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    communityName: ").append(toIndentedString(communityName)).append("\n");
		sb.append("    subCommunities: ").append(toIndentedString(subCommunities)).append("\n");
		sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
		sb.append("    ethics: ").append(toIndentedString(ethics)).append("\n");
		sb.append("    valueActions: ").append(toIndentedString(valueActions)).append("\n");
		sb.append("    members: ").append(toIndentedString(members)).append("\n");
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
