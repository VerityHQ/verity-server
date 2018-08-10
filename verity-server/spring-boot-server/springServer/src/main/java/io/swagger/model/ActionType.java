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
import javax.validation.constraints.*;

/**
 * Type of action that results in a transaction. Seen from the POV of the giver
 * - use a verb to describe act of giving or rating, e.g. upvote, give points,
 * tagged, rate.
 */
@ApiModel(description = "Type of action that results in a transaction. Seen from the POV of the giver - use a verb to describe act of giving or rating, e.g. upvote, give points, tagged, rate.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-27T15:39:32.532-07:00")

@Entity
@Table(name = "action_type")
public class ActionType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6932039472963754277L;

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@JsonProperty("uuid")
	private String uuid = null;

	// readonly - no public setter
	@Column(name = "ACTION_NAME")
	@JsonProperty("actionName")
	protected String actionName = null;

	@Column(name = "COMMUNITY_ID")
	@JsonProperty("communityId")
	private String communityId = null;

	@Column(name = "DESCRIPTION")
	@JsonProperty("description")
	private String description = null;

	public ActionType uuid(String uuid) {
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

	public ActionType actionName(String actionName) {
		this.actionName = actionName;
		return this;
	}

	/**
	 * Represents action taken that triggers a transaction of reputation. Use verb
	 * to describe act of giving or rating, e.g. upvote, give points, tagged, rate.
	 * 
	 * @return actionName
	 **/
	@ApiModelProperty(required = true, value = "Represents action taken that triggers a transaction of reputation. Use verb to describe act of giving or rating, e.g. upvote, give points, tagged, rate.")
	@NotNull

	public String getActionName() {
		return actionName;
	}

//	private void setActionName(String actionName) {
//		this.actionName = actionName;
//	}

	public ActionType description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Describes this action in detail. Formatted as JSON or JSON:LD. Should include
	 * the ActionName along with a longer description or link to more content.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Describes this action in detail. Formatted as JSON or JSON:LD. Should include the ActionName along with a longer description or link to more content.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ActionType communityId(String communityId) {
		this.communityId = communityId;
		return this;
	}

	/**
	 * Community that defined this ActionType. Multi-hash or JSON-LD
	 * 
	 * @return communityId
	 **/
	@ApiModelProperty(required = true, value = "Community that defined this ActionType. Multi-hash or JSON-LD")
	@NotNull

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ActionType actionType = (ActionType) o;
		return Objects.equals(this.uuid, actionType.uuid) && Objects.equals(this.actionName, actionType.actionName)
				&& Objects.equals(this.description, actionType.description)
				&& Objects.equals(this.communityId, actionType.communityId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, actionName, description, communityId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ActionType {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    actionName: ").append(toIndentedString(actionName)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    communityId: ").append(toIndentedString(communityId)).append("\n");
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
