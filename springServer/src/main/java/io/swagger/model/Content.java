package io.swagger.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Self describing content (document object model, JSON-LD) A physical, digital, conceptual, or other kind of thing with some fixed aspects; entities may be real or imaginary.  Maps to https://www.w3.org/TR/prov-o/  prov:Entity
 **/

/**
 * Self describing content (document object model, JSON-LD) A physical, digital,
 * conceptual, or other kind of thing with some fixed aspects; entities may be
 * real or imaginary. Maps to https://www.w3.org/TR/prov-o/ prov:Entity
 */
@ApiModel(description = "Self describing content (document object model, JSON-LD) A physical, digital, conceptual, or other kind of thing with some fixed aspects; entities may be real or imaginary.  Maps to https://www.w3.org/TR/prov-o/  prov:Entity")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T19:52:26.921-08:00")

@Entity
public class Content implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -7851449562084883370L;

	@Id
	@Column(name="uuid")
	private String uuid = null;

	private String name = null;

	private String body = null;

	@OneToMany
	@JoinColumn(name="parent_uuid")
	private List<Content> nodes = new ArrayList<Content>();

	public Content uuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	/**
	 * UUID, GUID, HASH or MultiHash that represents this object
	 *
	 * @return uuid
	 **/
	@ApiModelProperty(required = true, value = "UUID, GUID, HASH or MultiHash that represents this object")
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
	@ApiModelProperty(value = "content as text or JSON")
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Content nodes(List<Content> nodes) {
		this.nodes = nodes;
		return this;
	}

	public Content addNodesItem(Content nodesItem) {
		this.nodes.add(nodesItem);
		return this;
	}

	/**
	 * child nodes
	 *
	 * @return nodes
	 **/
	@ApiModelProperty(value = "child nodes")
	public List<Content> getNodes() {
		return nodes;
	}

	public void setNodes(List<Content> nodes) {
		this.nodes = nodes;
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
				&& Objects.equals(this.body, content.body) && Objects.equals(this.nodes, content.nodes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, name, body, nodes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Content {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    body: ").append(toIndentedString(body)).append("\n");
		sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
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
