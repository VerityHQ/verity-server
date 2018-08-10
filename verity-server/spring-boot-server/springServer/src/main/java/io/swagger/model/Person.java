package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;
import io.swagger.model.Content;
import javax.validation.constraints.*;

/**
 * Person
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-14T11:27:43.869-07:00")

@Entity
@Table(name = "person")
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7126747806967910530L;

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@NotNull
	@JsonProperty("uuid")
	private String uuid = null;
	
	// @OneToOne(cascade = { CascadeType.ALL, CascadeType.PERSIST,
	// CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	// @JoinColumn(name = "agent_uuid") //was agent_fk
	@OneToOne
	@JoinColumn(name = "AGENT_UUID",  unique = true)
	@JsonProperty("agent")
	private Agent agent = null;

	@Column(name = "FIRST_NAME")
	@JsonProperty("firstName")
	private String firstName = null;

	@Column(name = "LAST_NAME")
	@JsonProperty("lastName")
	private String lastName = null;

	//TODO: currently this is globally unique in the db. Needs to be org.nickname unique.
	// ORGS will be responsible for curating identity
	@Column(name = "NICK_NAME",  unique = true)
	@NotNull
	@Size(min=2, max=50)
	@JsonProperty("nickName")
	private String nickName = null;

	@Column(name = "ORGANIZATION_ID")
	@JsonProperty("organizationId")
	private String organizationId = null;

	@JsonProperty("description")
	private Content description = null;

	public Person agent(Agent agent) {
		this.agent = agent;
		return this;
	}

	/**
	 * Get agent
	 * 
	 * @return agent
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Person uuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	/**
	 * UUID, GUID, HASH, MultiHash or ProxyContract Address that represents this
	 * object
	 * 
	 * @return uuid
	 **/
	@ApiModelProperty(required = true, value = "UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object")
	@NotNull
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Person firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/
	@ApiModelProperty(value = "")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Person lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(value = "")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person nickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	/**
	 * Get nickName
	 * 
	 * @return nickName
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Person organizationId(String organizationId) {
		this.organizationId = organizationId;
		return this;
	}

	/**
	 * Get organizationId
	 * 
	 * @return organizationId
	 **/
	@ApiModelProperty(value = "")
	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public Person description(Content description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "")
	public Content getDescription() {
		return description;
	}

	public void setDescription(Content description) {
		this.description = description;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Person person = (Person) o;
		return Objects.equals(this.agent, person.agent) && Objects.equals(this.uuid, person.uuid)
				&& Objects.equals(this.firstName, person.firstName) && Objects.equals(this.lastName, person.lastName)
				&& Objects.equals(this.nickName, person.nickName)
				&& Objects.equals(this.organizationId, person.organizationId)
				&& Objects.equals(this.description, person.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(agent, uuid, firstName, lastName, nickName, organizationId, description);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Person {\n");

		sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
		sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
