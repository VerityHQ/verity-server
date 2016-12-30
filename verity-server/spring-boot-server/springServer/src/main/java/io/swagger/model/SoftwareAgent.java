package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;



/**
 * Bot, smart contract, or software that has agency in the reputation ecosystem (can give and receive reputation)
 **/

/**
 * Bot, smart contract, or software that has agency in the reputation ecosystem (can give and receive reputation)
 */
@ApiModel(description = "Bot, smart contract, or software that has agency in the reputation ecosystem (can give and receive reputation)")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T19:52:26.921-08:00")

public class SoftwareAgent   implements Serializable  {
  /**
	 * 
	 */
	private static final long serialVersionUID = -2547880021996915305L;

private String apiUrl = null;

  private String name = null;

  private Agent ownedBy = null;

  public SoftwareAgent apiUrl(String apiUrl) {
    this.apiUrl = apiUrl;
    return this;
  }

   /**
   * Get apiUrl
   * @return apiUrl
  **/
  @ApiModelProperty(required = true, value = "")
  public String getApiUrl() {
    return apiUrl;
  }

  public void setApiUrl(String apiUrl) {
    this.apiUrl = apiUrl;
  }

  public SoftwareAgent name(String name) {
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

  public SoftwareAgent ownedBy(Agent ownedBy) {
    this.ownedBy = ownedBy;
    return this;
  }

   /**
   * Get ownedBy
   * @return ownedBy
  **/
  @ApiModelProperty(value = "")
  public Agent getOwnedBy() {
    return ownedBy;
  }

  public void setOwnedBy(Agent ownedBy) {
    this.ownedBy = ownedBy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SoftwareAgent softwareAgent = (SoftwareAgent) o;
    return Objects.equals(this.apiUrl, softwareAgent.apiUrl) &&
        Objects.equals(this.name, softwareAgent.name) &&
        Objects.equals(this.ownedBy, softwareAgent.ownedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiUrl, name, ownedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SoftwareAgent {\n");
    
    sb.append("    apiUrl: ").append(toIndentedString(apiUrl)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownedBy: ").append(toIndentedString(ownedBy)).append("\n");
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

