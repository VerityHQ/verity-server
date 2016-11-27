package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * represents the type of action performed when giving reputation, e.g. upvote, points, rating
 */
@ApiModel(description = "represents the type of action performed when giving reputation, e.g. upvote, points, rating")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

public class ActionType   {
  @JsonProperty("ActionName")
  private String actionName = null;

  @JsonProperty("CommunityId")
  private String communityId = null;

  @JsonProperty("DefaultPoints")
  private Integer defaultPoints = null;

  @JsonProperty("id")
  private String id = null;

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
  @ApiModelProperty(value = "Community that defined this ActionType. Multi-hash or JSON-LD")
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

  public ActionType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * multi hash id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "multi hash id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
    return Objects.equals(this.actionName, actionType.actionName) &&
        Objects.equals(this.communityId, actionType.communityId) &&
        Objects.equals(this.defaultPoints, actionType.defaultPoints) &&
        Objects.equals(this.id, actionType.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actionName, communityId, defaultPoints, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActionType {\n");
    
    sb.append("    actionName: ").append(toIndentedString(actionName)).append("\n");
    sb.append("    communityId: ").append(toIndentedString(communityId)).append("\n");
    sb.append("    defaultPoints: ").append(toIndentedString(defaultPoints)).append("\n");
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

