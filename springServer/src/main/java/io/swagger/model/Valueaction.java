package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * ValueAction describes the action taken and the associated value (points) awarded. Value can be retroactivly changed to adjust point distribution after the transaction has been recorded.
 **/

/**
 * ValueAction describes the action taken and the associated value (points) awarded. Value can be retroactivly changed to adjust point distribution after the transaction has been recorded.
 */
@ApiModel(description = "ValueAction describes the action taken and the associated value (points) awarded. Value can be retroactivly changed to adjust point distribution after the transaction has been recorded.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T19:52:26.921-08:00")

@Entity
public class Valueaction  implements Serializable   {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6806102713677972879L;
	
	@Id
	@Column(name="uuid",unique=true, nullable=false )
private String uuid = null;

  private String description = null;

  private Integer value = null;

  private String actionTypeId = null;

  private Boolean archived = false;
  
  public Valueaction uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * UUID, GUID, HASH or MultiHash that represents this object
   * @return uuid
  **/
  @ApiModelProperty(required = true, value = "UUID, GUID, HASH or MultiHash that represents this object")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public Valueaction description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Describes this action. Formatted as JSON or JSON:LD. Should include a short 'tag' and optionally a longer description or link to more content.
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Describes this action. Formatted as JSON or JSON:LD. Should include a short 'tag' and optionally a longer description or link to more content.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Valueaction value(Integer value) {
    this.value = value;
    return this;
  }

   /**
   * the value awarded. Can be changed at any time. Changes to value will affect all transactions to date that have been created with this ValueAction.
   * @return value
  **/
  @ApiModelProperty(value = "the value awarded. Can be changed at any time. Changes to value will affect all transactions to date that have been created with this ValueAction.")
  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Valueaction actionTypeId(String actionTypeId) {
    this.actionTypeId = actionTypeId;
    return this;
  }

   /**
   * the  UUID of the actionType
   * @return actionTypeId
  **/
  @ApiModelProperty(value = "the  UUID of the actionType")
  public String getActionTypeId() {
    return actionTypeId;
  }

  public void setActionTypeId(String actionTypeId) {
    this.actionTypeId = actionTypeId;
  }

  public Valueaction archived(Boolean archived) {
    this.archived = archived;
    return this;
  }

   /**
   * Get archived
   * @return archived
  **/
  @ApiModelProperty(required = true, value = "")
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
    Valueaction valueaction = (Valueaction) o;
    return Objects.equals(this.uuid, valueaction.uuid) &&
        Objects.equals(this.description, valueaction.description) &&
        Objects.equals(this.value, valueaction.value) &&
        Objects.equals(this.actionTypeId, valueaction.actionTypeId) &&
        Objects.equals(this.archived, valueaction.archived);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, description, value, actionTypeId, archived);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Valueaction {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    actionTypeId: ").append(toIndentedString(actionTypeId)).append("\n");
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

