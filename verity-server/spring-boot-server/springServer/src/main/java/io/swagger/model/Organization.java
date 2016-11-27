package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;

/**
 * Organization
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

public class Organization implements Serializable {

	private static final long serialVersionUID = 9193613119909916944L;

	@JsonProperty("agent")
	private Agent agent = null;

	@JsonProperty("orgName")
	private String orgName = null;

	public Organization agent(Agent agent) {
		this.agent = agent;
		return this;
	}

	/**
	 * Get agent
	 * 
	 * @return agent
	 **/
	@ApiModelProperty(required = true, value = "")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Organization orgName(String orgName) {
		this.orgName = orgName;
		return this;
	}

	/**
	 * Get orgName
	 * 
	 * @return orgName
	 **/
	@ApiModelProperty(required = true, value = "")
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Organization organization = (Organization) o;
		return Objects.equals(this.agent, organization.agent) && Objects.equals(this.orgName, organization.orgName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(agent, orgName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Organization {\n");

		sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
		sb.append("    orgName: ").append(toIndentedString(orgName)).append("\n");
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
