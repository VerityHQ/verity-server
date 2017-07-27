package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * Self describing content (document object model, JSON-LD) A physical, digital,
 * conceptual, or other kind of thing with some fixed aspects; entities may be
 * real or imaginary. Maps to https://www.w3.org/TR/prov-o/ prov:Entity
 */
@ApiModel(description = "Self describing content (document object model, JSON-LD) A physical, digital, conceptual, or other kind of thing with some fixed aspects; entities may be real or imaginary.  Maps to https://www.w3.org/TR/prov-o/  prov:Entity")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-14T11:27:43.869-07:00")

@Entity
@Table(name = "content")
public class Content implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7851449562084883370L;

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@JsonProperty("uuid")
	private String uuid = null;

	@Column(name="NAME")
	@JsonProperty("name")
	private String name = null;

	@Lob  //larger than varchar(max)
	@Column(name="BODY")
	@JsonProperty("body")
	private String body = null;

	@Column(name="NODES")
	@JsonProperty("nodes")
    @LazyCollection(LazyCollectionOption.FALSE) 
    @ElementCollection(targetClass=String.class)
	private List<String> nodes = new ArrayList<String>();

	@Column(name="AUTHORS")
	@JsonProperty("authors")
    @LazyCollection(LazyCollectionOption.FALSE) 
    @ElementCollection(targetClass=String.class)
	private List<String> authors = new ArrayList<String>();

	@Column(name="COMMUNITY")
	@JsonProperty("communityId")
	private String communityId = null;

	public Content uuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	/**
	 * UUID, GUID, HASH or MultiHash that represents this object. For example a
	 * GitHub commit hash or IPFS address.
	 * 
	 * @return uuid
	 **/
	@ApiModelProperty(required = true, value = "UUID, GUID, HASH or MultiHash that represents this object. For example a GitHub commit hash or IPFS address.")
	@NotNull
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Content name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * name or tag
	 * 
	 * @return name
	 **/
	@ApiModelProperty(required = true, value = "name or tag")
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Content body(String body) {
		this.body = body;
		return this;
	}

	/**
	 * content as text or JSON
	 * 
	 * @return body
	 **/
	@ApiModelProperty(required = true, value = "content as text or JSON")
	@NotNull
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Content nodes(List<String> nodes) {
		this.nodes = nodes;
		return this;
	}

	public Content addNodesItem(String nodesItem) {
		this.nodes.add(nodesItem);
		return this;
	}

	/**
	 * child node ids
	 * 
	 * @return nodes
	 **/
	@ApiModelProperty(value = "child node ids")
	public List<String> getNodes() {
		return nodes;
	}

	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}

	public Content authors(List<String> authors) {
		this.authors = authors;
		return this;
	}

	public Content addAuthorsItem(String authorsItem) {
		this.authors.add(authorsItem);
		return this;
	}

	/**
	 * one or more uuids of the creating agent(s)
	 * 
	 * @return authors
	 **/
	@ApiModelProperty(value = "one or more uuids of the creating agent(s)")
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public Content communityId(String communityId) {
		this.communityId = communityId;
		return this;
	}

	/**
	 * The community from which the content originated.
	 * 
	 * @return communityId
	 **/
	@ApiModelProperty(value = "The community from which the content originated.")
	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Content content = (Content) o;
		return Objects.equals(this.uuid, content.uuid) && Objects.equals(this.name, content.name)
				&& Objects.equals(this.body, content.body) && Objects.equals(this.nodes, content.nodes)
				&& Objects.equals(this.authors, content.authors)
				&& Objects.equals(this.communityId, content.communityId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, name, body, nodes, authors, communityId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Content {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    body: ").append(toIndentedString(body)).append("\n");
		sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
		sb.append("    authors: ").append(toIndentedString(authors)).append("\n");
		sb.append("    communityId: ").append(toIndentedString(communityId)).append("\n");
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
