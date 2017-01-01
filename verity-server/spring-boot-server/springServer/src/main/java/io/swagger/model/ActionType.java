package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * represents the type of action performed when giving reputation, e.g. upvote, points, rating
 **/

/**
 * represents the type of action performed when giving reputation, e.g. upvote, points, rating
 */
@ApiModel(description = "represents the type of action performed when giving reputation, e.g. upvote, points, rating")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T19:52:26.921-08:00")

@Entity
public class ActionType  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 6932039472963754277L;

	@Id
	private String uuid = null;

  private String actionName = null;

  private String communityId = null;

  private Integer defaultPoints = null;

  private String content = null;

  
  public ActionType uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * UUID, GUID, HASH or MultiHash that represents this object
   * @return uuid
  **/
  @ApiModelProperty(value = "UUID, GUID, HASH or MultiHash that represents this object")
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
   * Can represent any type of reputation as a verb. Use verb to describe act of giving or rating, e.g. upvote, give points, tagged, rate.
   * @return actionName
  **/
  @ApiModelProperty(required = true, value = "Can represent any type of reputation as a verb. Use verb to describe act of giving or rating, e.g. upvote, give points, tagged, rate.")
  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public ActionType communityId(String communityId) {
    this.communityId = communityId;
    return this;
  }

   /**
   * Community that defined this ActionType. Multi-hash or JSON-LD
   * @return communityId
  **/
  @ApiModelProperty(required = true, value = "Community that defined this ActionType. Multi-hash or JSON-LD")
  public String getCommunityId() {
    return communityId;
  }

  public void setCommunityId(String communityId) {
    this.communityId = communityId;
  }

  public ActionType defaultPoints(Integer defaultPoints) {
    this.defaultPoints = defaultPoints;
    return this;
  }

   /**
   * points to award in default case
   * @return defaultPoints
  **/
  @ApiModelProperty(value = "points to award in default case")
  public Integer getDefaultPoints() {
    return defaultPoints;
  }

  public void setDefaultPoints(Integer defaultPoints) {
    this.defaultPoints = defaultPoints;
  }

  public ActionType content(String content) {
    this.content = content;
    return this;
  }

   /**
   * Describes this action in detail. Formatted as JSON or JSON:LD. Should include the ActionName along with a longer description or link to more content.
   * @return content
  **/
  @ApiModelProperty(value = "Describes this action in detail. Formatted as JSON or JSON:LD. Should include the ActionName along with a longer description or link to more content.")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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
    return Objects.equals(this.uuid, actionType.uuid) &&
        Objects.equals(this.actionName, actionType.actionName) &&
        Objects.equals(this.communityId, actionType.communityId) &&
        Objects.equals(this.defaultPoints, actionType.defaultPoints) &&
        Objects.equals(this.content, actionType.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, actionName, communityId, defaultPoints, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActionType {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    actionName: ").append(toIndentedString(actionName)).append("\n");
    sb.append("    communityId: ").append(toIndentedString(communityId)).append("\n");
    sb.append("    defaultPoints: ").append(toIndentedString(defaultPoints)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

