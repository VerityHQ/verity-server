package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * A fundamental unit of reputation transfer. Represents a singular event that transfers or bestows reputation to the target/recipient. The sender/source can be a person, software agent, organization or the like. Intended to be independent of database or blockchain so all IDs should be globally identifiable hashes in multi-hash format pointing to the canonical representation or permanent public store.  Similar to and should map to TrustAtom https://github.com/CoMakery/trust-exchange/blob/master/README.md
 **/

/**
 * A fundamental unit of reputation transfer. Represents a singular event that
 * transfers or bestows reputation to the target/recipient. The sender/source
 * can be a person, software agent, organization or the like. Intended to be
 * independent of database or blockchain so all IDs should be globally
 * identifiable hashes in multi-hash format pointing to the canonical
 * representation or permanent public store. Similar to and should map to
 * TrustAtom https://github.com/CoMakery/trust-exchange/blob/master/README.md
 */
@ApiModel(description = "A fundamental unit of reputation transfer. Represents a singular event that transfers or bestows reputation to the target/recipient. The sender/source can be a person, software agent, organization or the like. Intended to be independent of database or blockchain so all IDs should be globally identifiable hashes in multi-hash format pointing to the canonical representation or permanent public store.  Similar to and should map to TrustAtom https://github.com/CoMakery/trust-exchange/blob/master/README.md")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T19:52:26.921-08:00")

@Entity
@Table(name="transaction")
public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 524431549164105537L;
	@Column(name="VALUE_ACTION_UUID")
	private String valueActionId = null;
	
	@Column(name="SOURCE_AGENT_UUID")
	private String sourceAgentId = null;
	
	@Column(name="TARGET_AGENT_UUID")
	private String targetAgentId = null;
	
	@Column(name="TIME_STAMP")
	//@Temporal(TemporalType.TIMESTAMP) //otherwise will generate just date column without room for time
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime timeStamp = null;
	
	@Column(name="VALUE")
	private Integer value = null;

	@Id
	@Column(name="UUID",unique=true, nullable=false )
	private String id = null;

	public Transaction valueActionId(String valueActionId) {
		this.valueActionId = valueActionId;
		return this;
	}

	/**
	 * link that describes the way this score was derived, or the community
	 * feature that affects the way the value will be interpreted. Could be a
	 * link or content addressable graph pointing to a richer source of
	 * description or information.
	 * 
	 * @return valueActionId
	 **/
	@ApiModelProperty(required = true, value = "link that describes the way this score was derived, or the community feature that affects the way the value will be interpreted. Could be a link or content addressable graph pointing to a richer source of description or information.")
	public String getValueActionId() {
		return valueActionId;
	}

	public void setValueActionId(String valueActionId) {
		this.valueActionId = valueActionId;
	}

	public Transaction sourceAgentId(String sourceAgentId) {
		this.sourceAgentId = sourceAgentId;
		return this;
	}

	/**
	 * Get sourceAgentId
	 * 
	 * @return sourceAgentId
	 **/
	@ApiModelProperty(required = true, value = "")
	public String getSourceAgentId() {
		return sourceAgentId;
	}

	public void setSourceAgentId(String sourceAgentId) {
		this.sourceAgentId = sourceAgentId;
	}

	public Transaction targetAgentId(String targetAgentId) {
		this.targetAgentId = targetAgentId;
		return this;
	}

	/**
	 * Get targetAgentId
	 * 
	 * @return targetAgentId
	 **/
	@ApiModelProperty(required = true, value = "")
	public String getTargetAgentId() {
		return targetAgentId;
	}

	public void setTargetAgentId(String targetAgentId) {
		this.targetAgentId = targetAgentId;
	}

	public Transaction timeStamp(DateTime timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}

	/**
	 * timestamp or block height of blockchain at time of creation. Should be
	 * self-describing as to format and meaning.
	 * 
	 * @return timeStamp
	 **/
	@ApiModelProperty(value = "timestamp or block height of blockchain at time of creation. Should be self-describing as to format and meaning.")
	public DateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(DateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Transaction value(Integer value) {
		this.value = value;
		return this;
	}

	/**
	 * value (points) awarded at the time of the transaction. Immutable. Use
	 * ValueActionId to lookup the 'current' value if you want to calculate
	 * points based on the latest value as apposed to the value at time
	 * transaction was created. This allows for 'retroactive' adjustment of
	 * points.
	 * 
	 * @return value
	 **/
	@ApiModelProperty(value = "value (points) awarded at the time of the transaction. Immutable. Use ValueActionId to lookup the 'current' value if you want to calculate points based on the latest value as apposed to the value at time transaction was created. This allows for 'retroactive' adjustment of points.")
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Transaction uuid(String uuid) {
		this.id = uuid;
		return this;
	}

	/**
	 * UUID, GUID, HASH or MultiHash that represents this object
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "UUID, GUID, HASH or MultiHash that represents this object")
	public String getUuid() {
		return id;
	}

	public void setUuid(String uuid) {
		this.id = uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Transaction transaction = (Transaction) o;
		return Objects.equals(this.valueActionId, transaction.valueActionId)
				&& Objects.equals(this.sourceAgentId, transaction.sourceAgentId)
				&& Objects.equals(this.targetAgentId, transaction.targetAgentId)
				&& Objects.equals(this.timeStamp, transaction.timeStamp)
				&& Objects.equals(this.value, transaction.value) && Objects.equals(this.id, transaction.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(valueActionId, sourceAgentId, targetAgentId, timeStamp, value, id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Transaction {\n");

		sb.append("    valueActionId: ").append(toIndentedString(valueActionId)).append("\n");
		sb.append("    sourceAgentId: ").append(toIndentedString(sourceAgentId)).append("\n");
		sb.append("    targetAgentId: ").append(toIndentedString(targetAgentId)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
