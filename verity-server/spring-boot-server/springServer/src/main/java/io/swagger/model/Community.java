package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;
import io.swagger.model.Organization;
import java.util.ArrayList;
import java.util.List;

/**
 * Community
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

public class Community   {
  @JsonProperty("agents")
  private List<Agent> agents = new ArrayList<Agent>();

  @JsonProperty("communityName")
  private String communityName = null;

  @JsonProperty("hashId")
  private String hashId = null;

  @JsonProperty("oganization")
  private Organization oganization = null;

  public Community agents(List<Agent> agents) {
    this.agents = agents;
    return this;
  }

  public Community addAgentsItem(Agent agentsItem) {
    this.agents.add(agentsItem);
    return this;
  }

   /**
   * Community agents. List of agents that may operate on behalf of the community.
   * @return agents
  **/
  @ApiModelProperty(value = "Community agents. List of agents that may operate on behalf of the community.")
  public List<Agent> getAgents() {
    return agents;
  }

  public void setAgents(List<Agent> agents) {
    this.agents = agents;
  }

  public Community communityName(String communityName) {
    this.communityName = communityName;
    return this;
  }

   /**
   * Get communityName
   * @return communityName
  **/
  @ApiModelProperty(value = "")
  public String getCommunityName() {
    return communityName;
  }

  public void setCommunityName(String communityName) {
    this.communityName = communityName;
  }

  public Community hashId(String hashId) {
    this.hashId = hashId;
    return this;
  }

   /**
   * unique id of the community (could be a blockchain contract address)
   * @return hashId
  **/
  @ApiModelProperty(value = "unique id of the community (could be a blockchain contract address)")
  public String getHashId() {
    return hashId;
  }

  public void setHashId(String hashId) {
    this.hashId = hashId;
  }

  public Community oganization(Organization oganization) {
    this.oganization = oganization;
    return this;
  }

   /**
   * The organization-agent that runs / owns the community.
   * @return oganization
  **/
  @ApiModelProperty(value = "The organization-agent that runs / owns the community.")
  public Organization getOganization() {
    return oganization;
  }

  public void setOganization(Organization oganization) {
    this.oganization = oganization;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Community community = (Community) o;
    return Objects.equals(this.agents, community.agents) &&
        Objects.equals(this.communityName, community.communityName) &&
        Objects.equals(this.hashId, community.hashId) &&
        Objects.equals(this.oganization, community.oganization);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agents, communityName, hashId, oganization);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Community {\n");
    
    sb.append("    agents: ").append(toIndentedString(agents)).append("\n");
    sb.append("    communityName: ").append(toIndentedString(communityName)).append("\n");
    sb.append("    hashId: ").append(toIndentedString(hashId)).append("\n");
    sb.append("    oganization: ").append(toIndentedString(oganization)).append("\n");
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

