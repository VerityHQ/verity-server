package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * Award with associated award amount (points) . Amount can be changed to allow
 * for &#39;re-distribution&#39; of points after the transaction has been
 * recorded.
 */
@ApiModel(description = "Award with associated award amount (points) . Amount can be changed to allow for 're-distribution' of points after the transaction has been recorded.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-27T04:32:12.007-07:00")

@Entity
@Table(name = "value_action")
public class ValueAction implements Serializable {

	private static final long serialVersionUID = -3904227431741460230L;

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@JsonProperty("uuid")
	private String uuid = null;

	@Column(name = "DESCRIPTION", unique = true)
	@JsonProperty("description")
	private String description = null;

	@Column(name = "AMOUNT")
	@JsonProperty("amount")
	private Integer amount = null;

	@Column(name = "ACTION_TYPE_ID")
	@JsonProperty("actionTypeId")
	private String actionTypeId = null;

	@Column(name = "ARCHIVED")
	@JsonProperty("archived")
	private Boolean archived = false;

	@Column(name = "COMMUNITY_ID")
	@JsonProperty("communityId")
	private String communityId = null;

	@Column(name = "NAME")
	@JsonProperty("name")
	private String name = null;
	
	@Column(name = "ETHIC_ID")
	@JsonProperty("ethicId")
	private String ethicId = null;

	@Column(name = "AWARD_MIN")
	@JsonProperty("awardMin")
	private Integer awardMin = null;

	@Column(name = "AWARD_MAX")
	@JsonProperty("awardMax")
	private Integer awardMax = null;

	@Column(name = "AWARD_SCALE")
	@JsonProperty("awardScale")
	private AwardScaleEnum awardScale = AwardScaleEnum.INT;

	public enum AwardScaleEnum {
		INT("int"),
		DECIMAL("decimal"),
		BOOL("bool");

		private String value;

		AwardScaleEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static AwardScaleEnum fromValue(String text) {
			for (AwardScaleEnum b : AwardScaleEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
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

	public ValueAction name(String name) {
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

	public ValueAction description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Describes this action or community value. Formatted as JSON or JSON:LD.
	 * Should include a short 'tag' and optionally a longer description or link to
	 * more content.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(required = true, value = "Describes this action or community value. Formatted as JSON or JSON:LD. Should include a short 'tag' and optionally a longer description or link to more content.")
	@NotNull

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
	 * Default amount to be awarded. When creating a transaction the default amount
	 * can be used or overridden. If the defalut changes at a later date, new awards
	 * can be retroactivly computed based on the new default amount, however the
	 * original transaction will remain fixed in value.
	 * 
	 * @return amount
	 **/
	@ApiModelProperty(value = "Default amount to be awarded. When creating a transaction the default amount can be used or overridden. If the defalut changes at a later date, new awards can be retroactivly computed based on the new default amount, however the original transaction will remain fixed in value.")

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
	@NotNull

	public String getActionTypeId() {
		return actionTypeId;
	}

	public void setActionTypeId(String actionTypeId) {
		this.actionTypeId = actionTypeId;
	}

	public ValueAction ethicId(String ethicId) {
		this.ethicId = ethicId;
		return this;
	}

	/**
	 * Get ethicId
	 * 
	 * @return ethicId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getEthicId() {
		return ethicId;
	}

	public void setEthicId(String ethicId) {
		this.ethicId = ethicId;
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

	public ValueAction awardMin(Integer awardMin) {
		this.awardMin = awardMin;
		return this;
	}

	/**
	 * Get awardMin
	 * 
	 * @return awardMin
	 **/
	@ApiModelProperty(value = "")

	public Integer getAwardMin() {
		return awardMin;
	}

	public void setAwardMin(Integer awardMin) {
		this.awardMin = awardMin;
	}

	public ValueAction awardMax(Integer awardMax) {
		this.awardMax = awardMax;
		return this;
	}

	/**
	 * Get awardMax
	 * 
	 * @return awardMax
	 **/
	@ApiModelProperty(value = "")

	public Integer getAwardMax() {
		return awardMax;
	}

	public void setAwardMax(Integer awardMax) {
		this.awardMax = awardMax;
	}

	public ValueAction awardScale(AwardScaleEnum awardScale) {
		this.awardScale = awardScale;
		return this;
	}

	/**
	 * 
	 * @return awardScale
	 **/
	@ApiModelProperty(value = "")

	public AwardScaleEnum getAwardScale() {
		return awardScale;
	}

	public void setAwardScale(AwardScaleEnum awardScale) {
		this.awardScale = awardScale;
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
	@NotNull

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
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
		return Objects.equals(this.uuid, valueAction.uuid) && Objects.equals(this.name, valueAction.name)
				&& Objects.equals(this.description, valueAction.description)
				&& Objects.equals(this.amount, valueAction.amount)
				&& Objects.equals(this.actionTypeId, valueAction.actionTypeId)
				&& Objects.equals(this.ethicId, valueAction.ethicId)
				&& Objects.equals(this.communityId, valueAction.communityId)
				&& Objects.equals(this.awardMin, valueAction.awardMin)
				&& Objects.equals(this.awardMax, valueAction.awardMax)
				&& Objects.equals(this.awardScale, valueAction.awardScale)
				&& Objects.equals(this.archived, valueAction.archived);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, name, description, amount, actionTypeId, ethicId, communityId, awardMin, awardMax,
				awardScale, archived);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ValueAction {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
		sb.append("    actionTypeId: ").append(toIndentedString(actionTypeId)).append("\n");
		sb.append("    ethicId: ").append(toIndentedString(ethicId)).append("\n");
		sb.append("    communityId: ").append(toIndentedString(communityId)).append("\n");
		sb.append("    awardMin: ").append(toIndentedString(awardMin)).append("\n");
		sb.append("    awardMax: ").append(toIndentedString(awardMax)).append("\n");
		sb.append("    awardScale: ").append(toIndentedString(awardScale)).append("\n");
		sb.append("    archived: ").append(toIndentedString(archived)).append("\n");
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
