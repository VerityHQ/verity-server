package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Award type with associated award amount (points) . Amount can be changed to allow for &#39;re-distribution&#39; of points after the transaction has been recorded.
 **/

/**
 * Award type with associated award amount (points) . Amount can be changed to
 * allow for &#39;re-distribution&#39; of points after the transaction has been
 * recorded.
 */
@ApiModel(description = "Award type with associated award amount (points) . Amount can be changed to allow for 're-distribution' of points after the transaction has been recorded.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-04-02T18:25:03.524-07:00")

@Entity
@Table(name = "value_action")
public class ValueAction implements Serializable {

	private static final long serialVersionUID = -3904227431741460230L;

	@Column(name = "DESCRIPTION")
	private String description = null;

	@Column(name = "AMOUNT")
	private Integer amount = null;

	@Column(name = "ACTION_TYPE_ID")
	private String actionTypeId = null;

	@Column(name = "ARCHIVED")
	private Boolean archived = false;

	@Column(name = "COMMUNITY_ID")
	private String communityId = null;

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	private String uuid = null;

	public ValueAction uuid(String uuid) {
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

	public ValueAction description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Describes this action or community value. Formatted as JSON or JSON:LD.
	 * Should include a short 'tag' and optionally a longer description or link
	 * to more content.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(required = true, value = "Describes this action or community value. Formatted as JSON or JSON:LD. Should include a short 'tag' and optionally a longer description or link to more content.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ValueAction amount(Integer amount) {
		this.amount = amount;
		return this;
	}

	/**
	 * The amount to be awarded. When creating a transaction the default amount
	 * can be used or overridden. If the defalut changes at a later date, new
	 * awards can be retroactivly computed based on the new default amount,
	 * however the original transaction will remain fixed in value.
	 * 
	 * @return amount
	 **/
	@ApiModelProperty(value = "The amount to be awarded. When creating a transaction the default amount can be used or overridden. If the defalut changes at a later date, new awards can be retroactivly computed based on the new default amount, however the original transaction will remain fixed in value.")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public ValueAction actionTypeId(String actionTypeId) {
		this.actionTypeId = actionTypeId;
		return this;
	}

	/**
	 * the UUID of the actionType
	 * 
	 * @return actionTypeId
	 **/
	@ApiModelProperty(required = true, value = "the  UUID of the actionType")
	public String getActionTypeId() {
		return actionTypeId;
	}

	public void setActionTypeId(String actionTypeId) {
		this.actionTypeId = actionTypeId;
	}

	public ValueAction archived(Boolean archived) {
		this.archived = archived;
		return this;
	}

	/**
	 * indicates this ValueAction is frozen and read-only. No further changes to
	 * 'amount' or any other fields can be made.
	 * 
	 * @return archived
	 **/
	@ApiModelProperty(required = true, value = "indicates this ValueAction is frozen and read-only. No further changes to 'amount' or any other fields can be made.")
	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	public ValueAction communityId(String communityId) {
		this.communityId = communityId;
		return this;
	}

	/**
	 * Get communityId
	 * 
	 * @return communityId
	 **/
	@ApiModelProperty(value = "")
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
		ValueAction valueAction = (ValueAction) o;
		return Objects.equals(this.uuid, valueAction.uuid) && Objects.equals(this.description, valueAction.description)
				&& Objects.equals(this.amount, valueAction.amount)
				&& Objects.equals(this.actionTypeId, valueAction.actionTypeId)
				&& Objects.equals(this.archived, valueAction.archived)
				&& Objects.equals(this.communityId, valueAction.communityId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, description, amount, actionTypeId, archived, communityId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ValueAction {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
		sb.append("    actionTypeId: ").append(toIndentedString(actionTypeId)).append("\n");
		sb.append("    archived: ").append(toIndentedString(archived)).append("\n");
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
