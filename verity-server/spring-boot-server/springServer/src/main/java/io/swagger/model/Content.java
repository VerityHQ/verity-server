package io.swagger.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Self describing content (document object model, JSON-LD) A physical, digital,
 * conceptual, or other kind of thing with some fixed aspects; entities may be
 * real or imaginary. Maps to https://www.w3.org/TR/prov-o/ prov:Entity
 */
@ApiModel(description = "Self describing content (document object model, JSON-LD) A physical, digital, conceptual, or other kind of thing with some fixed aspects; entities may be real or imaginary.  Maps to https://www.w3.org/TR/prov-o/  prov:Entity")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T19:52:26.921-08:00")

@Entity
@Table(name="content")
public class Content implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7851449562084883370L;

	@Id
	@Column(name="UUID",unique=true, nullable=false )
	private String id = null;
	
	@Column(name="NAME")
	private String name = null;

	@Column(name="BODY")
	private String body = null;
	
    @Column(name = "PARENT_UUID")
    private String parentUuid;
     
    //mappedBy must not define database mappings like @JoinTable or @JoinColumn
    //Mapped by means that Hibernate should look/track the other side of the relation
    @OneToMany(mappedBy="parent_node")
    private List<Content> child_nodes;
    
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="PARENT_NODE_UUID", insertable = false, updatable = false)
    private Content parent_node;
    

	//====================
    
    
    public List<Content> getChildContent() {
        return child_nodes;
    }
    public void setChildContent(List<Content> children) {
        this.child_nodes = children;
    }
     
     
    public Content getParentNode() {
        return parent_node;
    }
    public void setParentNode(Content content) {
        this.parent_node = content;
    }

	public Content uuid(String uuid) {
		this.id = uuid;
		return this;
	}

	/**
	 * UUID, GUID, HASH or MultiHash that represents this object
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "UUID, GUID, HASH or MultiHash that represents this object")
	public String getUuid() {
		return id;
	}

	public void setUuid(String uuid) {
		this.id = uuid;
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

//	public Content nodes(List<Content> nodes) {
//		this.nodes = nodes;
//		return this;
//	}
//
//	public Content addNodesItem(Content nodesItem) {
//		this.nodes.add(nodesItem);
//		return this;
//	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Content content = (Content) o;
		return Objects.equals(this.id, content.id) && Objects.equals(this.name, content.name)
				&& Objects.equals(this.body, content.body) && Objects.equals(this.child_nodes, content.child_nodes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, body, child_nodes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Content {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    body: ").append(toIndentedString(body)).append("\n");
		sb.append("    nodes: ").append(toIndentedString(child_nodes)).append("\n");
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
