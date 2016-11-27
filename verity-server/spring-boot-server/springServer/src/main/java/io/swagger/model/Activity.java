package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.LocalDate;

/**
 * Activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities.   Maps to https://www.w3.org/TR/prov-o/  prov:Activity
 */
@ApiModel(description = "Activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities.   Maps to https://www.w3.org/TR/prov-o/  prov:Activity")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

public class Activity   {
  @JsonProperty("end")
  private LocalDate end = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("start")
  private LocalDate start = null;

  public Activity end(LocalDate end) {
    this.end = end;
    return this;
  }

   /**
   * Could correspond to a block number in the blockchain
   * @return end
  **/
  @ApiModelProperty(required = true, value = "Could correspond to a block number in the blockchain")
  public LocalDate getEnd() {
    return end;
  }

  public void setEnd(LocalDate end) {
    this.end = end;
  }

  public Activity name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Activity start(LocalDate start) {
    this.start = start;
    return this;
  }

   /**
   * Could correspond to a block number in the blockchain
   * @return start
  **/
  @ApiModelProperty(required = true, value = "Could correspond to a block number in the blockchain")
  public LocalDate getStart() {
    return start;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Activity activity = (Activity) o;
    return Objects.equals(this.end, activity.end) &&
        Objects.equals(this.name, activity.name) &&
        Objects.equals(this.start, activity.start);
  }

  @Override
  public int hashCode() {
    return Objects.hash(end, name, start);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Activity {\n");
    
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
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

