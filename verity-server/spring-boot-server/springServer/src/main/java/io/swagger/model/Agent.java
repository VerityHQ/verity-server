package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Agent is something that bears some form of responsibility for an activity
 * taking place, for the existence of an entity, or for another agent&#39;s
 * activity. An Agent could be software, person, organization, device. Maps to
 * https://www.w3.org/TR/prov-o/#Agent prov:Agent
 */
@ApiModel(description = "Agent is something that bears some form of responsibility for an activity taking place, for the existence of an entity, or for another agent's activity. An Agent could be software, person, organization, device.  Maps to  https://www.w3.org/TR/prov-o/#Agent  prov:Agent")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

public class Agent implements Serializable {

	private static final long serialVersionUID = 3139214304397971110L;

	@JsonProperty("hashId")
	private String hashId = null;

	@JsonProperty("key")
	private String key = null;

	@JsonProperty("url")
	private String url = null;

	public Agent hashId(String hashId) {
		this.hashId = hashId;
		return this;
	}

	/**
	 * hash or blockchain address
	 * 
	 * @return hashId
	 **/
	@ApiModelProperty(required = true, value = "hash or blockchain address")
	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public Agent key(String key) {
		this.key = key;
		return this;
	}

	/**
	 * Get key
	 * 
	 * @return key
	 **/
	@ApiModelProperty(value = "")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Agent url(String url) {
		this.url = url;
		return this;
	}

	/**
	 * URL
	 * 
	 * @return url
	 **/
	@ApiModelProperty(value = "URL")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Agent agent = (Agent) o;
		return Objects.equals(this.hashId, agent.hashId) && Objects.equals(this.key, agent.key)
				&& Objects.equals(this.url, agent.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(hashId, key, url);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Agent {\n");

		sb.append("    hashId: ").append(toIndentedString(hashId)).append("\n");
		sb.append("    key: ").append(toIndentedString(key)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
