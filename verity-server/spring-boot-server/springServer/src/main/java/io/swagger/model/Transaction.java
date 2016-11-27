package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;

/**
 * A fundamental unit of reputation transfer. Represents a singular event that transfers or bestows reputation to the target/recipient. The sender/source can be a person, software agent, organization or the like. Intended to be independent of database or blockchain so all IDs should be globally identifiable hashes in multi-hash format pointing to the canonical representation or permanent public store.  Similar to and should map to TrustAtom https://github.com/CoMakery/trust-exchange/blob/master/README.md  TODO: determine how Ethereum UINT value can map to multiple datatypes. One model comes from Augur -  Yes or no (binary)   no: 2**64   yes: 2*2**64   indeterminate: 3*2**63   exactly in the middle but not indeterminate: 2**63 + 1  Multiple choice (categorical)   min: 1    max: 2**64   indeterminate: 2**63 exactly in the middle but not indeterminate: 2**63 + 1  Numerical (scalar)   min: 1   max: 2**64   indeterminate: 2**63   exactly in the middle but not indeterminate: 2**63 + 1
 */
@ApiModel(description = "A fundamental unit of reputation transfer. Represents a singular event that transfers or bestows reputation to the target/recipient. The sender/source can be a person, software agent, organization or the like. Intended to be independent of database or blockchain so all IDs should be globally identifiable hashes in multi-hash format pointing to the canonical representation or permanent public store.  Similar to and should map to TrustAtom https://github.com/CoMakery/trust-exchange/blob/master/README.md  TODO: determine how Ethereum UINT value can map to multiple datatypes. One model comes from Augur -  Yes or no (binary)   no: 2**64   yes: 2*2**64   indeterminate: 3*2**63   exactly in the middle but not indeterminate: 2**63 + 1  Multiple choice (categorical)   min: 1    max: 2**64   indeterminate: 2**63 exactly in the middle but not indeterminate: 2**63 + 1  Numerical (scalar)   min: 1   max: 2**64   indeterminate: 2**63   exactly in the middle but not indeterminate: 2**63 + 1")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

public class Transaction   {
  @JsonProperty("content")
  private String content = null;

  @JsonProperty("context")
  private String context = null;

  @JsonProperty("source")
  private Agent source = null;

  @JsonProperty("target")
  private Agent target = null;

  @JsonProperty("timeStamp")
  private String timeStamp = null;

  @JsonProperty("value")
  private Integer value = null;

  public Transaction content(String content) {
    this.content = content;
    return this;
  }

   /**
   * Describes or defines the type of reputation being given (points, karma, score) or the action performed (ActionType) during rating, e.g. upvote, like. Could be a link or content addressable graph pointing to a richer source of description such as a set of tags.
   * @return content
  **/
  @ApiModelProperty(value = "Describes or defines the type of reputation being given (points, karma, score) or the action performed (ActionType) during rating, e.g. upvote, like. Could be a link or content addressable graph pointing to a richer source of description such as a set of tags.")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Transaction context(String context) {
    this.context = context;
    return this;
  }

   /**
   * metadata that describes the way this score was derived, or the community feature that affects the way the value will be interpreted. Could be a link or content addressable graph pointing to a richer source of description or information.
   * @return context
  **/
  @ApiModelProperty(value = "metadata that describes the way this score was derived, or the community feature that affects the way the value will be interpreted. Could be a link or content addressable graph pointing to a richer source of description or information.")
  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public Transaction source(Agent source) {
    this.source = source;
    return this;
  }

   /**
   * source / sender / giver of reputation value. Multi-hash agent key. Required.
   * @return source
  **/
  @ApiModelProperty(required = true, value = "source / sender / giver of reputation value. Multi-hash agent key. Required.")
  public Agent getSource() {
    return source;
  }

  public void setSource(Agent source) {
    this.source = source;
  }

  public Transaction target(Agent target) {
    this.target = target;
    return this;
  }

   /**
   * target / recipient / receiver of reputation value. Multi-hash agent key. Required.
   * @return target
  **/
  @ApiModelProperty(required = true, value = "target / recipient / receiver of reputation value. Multi-hash agent key. Required.")
  public Agent getTarget() {
    return target;
  }

  public void setTarget(Agent target) {
    this.target = target;
  }

  public Transaction timeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

   /**
   * timestamp or block height of blockchain at time of creation. Should be self-describing as to format and meaning.
   * @return timeStamp
  **/
  @ApiModelProperty(value = "timestamp or block height of blockchain at time of creation. Should be self-describing as to format and meaning.")
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
   * Reputation value or amount. optional. If empty the value of the transaction can be inferred by the content or context, e.g. it's a value tag.
   * @return value
  **/
  @ApiModelProperty(value = "Reputation value or amount. optional. If empty the value of the transaction can be inferred by the content or context, e.g. it's a value tag.")
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
    return Objects.equals(this.content, transaction.content) &&
        Objects.equals(this.context, transaction.context) &&
        Objects.equals(this.source, transaction.source) &&
        Objects.equals(this.target, transaction.target) &&
        Objects.equals(this.timeStamp, transaction.timeStamp) &&
        Objects.equals(this.value, transaction.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, context, source, target, timeStamp, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
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

