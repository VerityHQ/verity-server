package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.Entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Agent;

/**
 * Person
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

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
	private String id = null;
	
	@Column(name = "FIRST_NAME")
	private String firstName = null;
	
	@Column(name = "LAST_NAME")
	private String lastName = null;
	
	@Column(name = "NICK_NAME")

	@NotNull
	@Size(min=2, max=50)
	private String nickName = null;
	
	@Column(name = "ORGANIZATION_ID")
	private String organizationId = null;

	// @OneToOne(cascade = { CascadeType.ALL, CascadeType.PERSIST,
	// CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	// @JoinColumn(name = "agent_uuid") //was agent_fk
	@OneToOne
	@JoinColumn(name = "AGENT_UUID")
	private Agent agent = null;

	public Person uuid(String uuid) {
		this.id = uuid;
		return this;
	}

	/**
	 * UUID, GUID, HASH, MultiHash or ProxyContract Address that represents this
	 * object
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "UUID, GUID, HASH,  MultiHash or ProxyContract Address that represents this object")
	public String getUuid() {
		return id;
	}

	public void setUuid(String uuid) {
		this.id = uuid;
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
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
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
		return Objects.equals(this.id, person.id) && Objects.equals(this.firstName, person.firstName)
				&& Objects.equals(this.lastName, person.lastName) && Objects.equals(this.nickName, person.nickName)
				&& Objects.equals(this.organizationId, person.organizationId)
				&& Objects.equals(this.agent, person.agent);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, nickName, organizationId, agent);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Person {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
		sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
		sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
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
