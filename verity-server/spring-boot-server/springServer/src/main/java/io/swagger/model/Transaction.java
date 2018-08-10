package io.swagger.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * A fundamental unit of reputation value transfer, attestation or verifiable claim.
 * Represents a singular event that transfers or bestows a reputation claim to the
 * target/recipient. The sender/source can be a person, software agent,
 * organization or the like. Intended to be independent of database or
 * blockchain. Therefore all IDs should be globally identifiable hashes in multi-hash
 * format pointing to the canonical representation or permanent public store.
 * Similar to and should map to TrustAtom
 * https://github.com/CoMakery/trust-exchange/blob/master/README.md
 */
@ApiModel(description = "A fundamental unit of reputation value transfer, attestation or claim. Represents a singular event that transfers or bestows reputation to the target/recipient. The sender/source can be a person, software agent, organization or the like. Intended to be independent of database or blockchain so all IDs should be globally identifiable hashes in multi-hash format pointing to the canonical representation or permanent public store.  Similar to and should map to TrustAtom https://github.com/CoMakery/trust-exchange/blob/master/README.md")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-14T11:27:43.869-07:00")

@Entity
@Table(name="transaction")
public class Transaction implements Serializable {

	/**
	 * Indicates which side of the transaction
	 * we are interested.
	 * Either the agent is the source or the target
	 * of the transaction.
	 */
	static public enum Direction {
		SOURCE("source"), 
		TARGET("target");
		//valueOf() method is case sensitive and doesn't tolerate extraneous whitespace
		private String value;
		 
		private Direction(String value) {
			this.value = value;
		}
	}
	
	private static final long serialVersionUID = 524431549164105537L;
	
	@Id
	@Column(name="UUID", unique=true, nullable=false )
	//TODO: the TransactionApiController will validate via @Valid annotation
	// any javax validation that are applied to the private fields
	//TODO: determine the min/max for UUIDs. 
	// Maybe there are none, assuming IPFS links or Universial 
	//@Size(min = 20, max = 50) 
	@JsonProperty("uuid")
	private String uuid = null;

	@Column(name="VALUE_ACTION_UUID")
	@JsonProperty("valueActionId")
	private String valueActionId = null;

	@Column(name="SOURCE_AGENT_UUID")
	@JsonProperty("sourceAgentId")
	private String sourceAgentId = null;

	@Column(name="TARGET_AGENT_UUID")
	@JsonProperty("targetAgentId")
	private String targetAgentId = null;
	
	@Column(name="TIME_STAMP")
	//@Temporal(TemporalType.TIMESTAMP) //otherwise will generate just date column without room for time
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonProperty("timeStamp")
	private String timeStamp = Long.toString(Instant.now().toEpochMilli()); //may be a block height number

	@Column(name="VALUE")
	@JsonProperty("value")
	private Integer value = null;

	public Transaction uuid(String uuid) {
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
	@NotNull
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Transaction valueActionId(String valueActionId) {
		this.valueActionId = valueActionId;
		return this;
	}

	/**
	 * Hash link to description of how the score will be derived, or the
	 * community feature that affects the way the value will be interpreted.
	 * Could be a globally unique link or content addressable graph pointing to
	 * a richer source of description or information.
	 * 
	 * @return valueActionId
	 **/
	@ApiModelProperty(required = true, value = "Hash link to description of how the score will be derived, or the community feature that affects the way the value will be interpreted. Could be a globally unique link or content addressable graph pointing to a richer source of description or information.")
	@NotNull
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
	@NotNull
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
	@NotNull
	public String getTargetAgentId() {
		return targetAgentId;
	}

	public void setTargetAgentId(String targetAgentId) {
		this.targetAgentId = targetAgentId;
	}

	public Transaction timeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}

	/**
	 * timestamp or block height of blockchain at time of creation. Should be
	 * self-describing as to format and meaning.
	 * 
	 * @return timeStamp
	 **/
	@ApiModelProperty(required = true, value = "timestamp or block height of blockchain at time of creation. Should be self-describing as to format and meaning.")
	@NotNull
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Transaction value(Integer value) {
		this.value = value;
		return this;
	}

	/**
	 * value (points) awarded at the time of the transaction. Immutable. Use
	 * ValueActionId to lookup the 'current' value if you want to calculate
	 * points based on the latest default value as apposed to the value awarded
	 * at time of the transaction. This allows for 'retroactive' adjustment of
	 * points.
	 * 
	 * @return value
	 **/
	@ApiModelProperty(value = "value (points) awarded at the time of the transaction. Immutable. Use ValueActionId to lookup the 'current' value if you want to calculate points based on the latest default value as apposed to the value awarded at time of the transaction. This allows for 'retroactive' adjustment of points.")
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
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
		return Objects.equals(this.uuid, transaction.uuid)
				&& Objects.equals(this.valueActionId, transaction.valueActionId)
				&& Objects.equals(this.sourceAgentId, transaction.sourceAgentId)
				&& Objects.equals(this.targetAgentId, transaction.targetAgentId)
				&& Objects.equals(this.timeStamp, transaction.timeStamp)
				&& Objects.equals(this.value, transaction.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, valueActionId, sourceAgentId, targetAgentId, timeStamp, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Transaction {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    valueActionId: ").append(toIndentedString(valueActionId)).append("\n");
		sb.append("    sourceAgentId: ").append(toIndentedString(sourceAgentId)).append("\n");
		sb.append("    targetAgentId: ").append(toIndentedString(targetAgentId)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
