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
import io.swagger.model.ActionType;
import io.swagger.model.Agent;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * Community
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-14T11:27:43.869-07:00")

@Entity
@Table(name = "community")
public class Community implements Serializable {

	private static final long serialVersionUID = -3185192700794511303L;

	// @OneToOne(cascade = { CascadeType.ALL, CascadeType.PERSIST,
	// CascadeType.MERGE, CascadeType.REFRESH,
	// CascadeType.DETACH })
	// @JoinColumn(name = "agent_uuid") // was agent_fk

	@Id
	@Column(name="UUID",unique=true, nullable=false )
	@JsonProperty("uuid")
	private String uuid = null;

	@Column(name="COMMUNITY_NAME")
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
	
    //following shows how to use collections of simple types with hibernate
    //The collection will be created as a table of string values with keys back to parent
    //The @LazyCollection attribute is needed. See SO  //http://stackoverflow.com/questions/30465748/jackson-confused-with-bidirectional-one-to-many-relationship-failed-to-lazily
    @Column(name = "ACTION_TYPES")
    @LazyCollection(LazyCollectionOption.FALSE) 
    @ElementCollection(targetClass=String.class)
	@JsonProperty("values")
	private List<ActionType> values = new ArrayList<ActionType>();

	public Community uuid(String uuid) {
		this.uuid = uuid;
		return this;
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
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Community values(List<ActionType> values) {
		this.values = values;
		return this;
	}

	public Community addValuesItem(ActionType valuesItem) {
		this.values.add(valuesItem);
		return this;
	}

	/**
	 * Get values
	 * 
	 * @return values
	 **/
	@ApiModelProperty(value = "")
	public List<ActionType> getValues() {
		return values;
	}

	public void setValues(List<ActionType> values) {
		this.values = values;
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
				&& Objects.equals(this.agent, community.agent) && Objects.equals(this.values, community.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, communityName, subCommunities, agent, values);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Community {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    communityName: ").append(toIndentedString(communityName)).append("\n");
		sb.append("    subCommunities: ").append(toIndentedString(subCommunities)).append("\n");
		sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
		sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
