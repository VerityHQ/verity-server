package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Self describing content (document object model, JSON-LD) A physical, digital, conceptual, or other kind of thing with some fixed aspects; entities may be real or imaginary.  Maps to https://www.w3.org/TR/prov-o/  prov:Entity
 */
@ApiModel(description = "Self describing content (document object model, JSON-LD) A physical, digital, conceptual, or other kind of thing with some fixed aspects; entities may be real or imaginary.  Maps to https://www.w3.org/TR/prov-o/  prov:Entity")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-22T21:40:22.727Z")


public class Entity  implements Serializable  {
  /**
	 * 
	 */
	private static final long serialVersionUID = -4210735979713304201L;

@JsonProperty("hashId")
  private String hashId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("nodes")
  private List<Entity> nodes = new ArrayList<Entity>();

  public Entity hashId(String hashId) {
    this.hashId = hashId;
    return this;
  }

   /**
   * multihash
   * @return hashId
  **/
  @ApiModelProperty(value = "multihash")
  public String getHashId() {
    return hashId;
  }

  public void setHashId(String hashId) {
    this.hashId = hashId;
  }

  public Entity name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name of the thing
   * @return name
  **/
  @ApiModelProperty(value = "name of the thing")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Entity nodes(List<Entity> nodes) {
    this.nodes = nodes;
    return this;
  }

  public Entity addNodesItem(Entity nodesItem) {
    this.nodes.add(nodesItem);
    return this;
  }

   /**
   * next level of the tree
   * @return nodes
  **/
  @ApiModelProperty(value = "next level of the tree")
  public List<Entity> getNodes() {
    return nodes;
  }

  public void setNodes(List<Entity> nodes) {
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
    Entity entity = (Entity) o;
    return Objects.equals(this.hashId, entity.hashId) &&
        Objects.equals(this.name, entity.name) &&
        Objects.equals(this.nodes, entity.nodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashId, name, nodes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Entity {\n");
    
    sb.append("    hashId: ").append(toIndentedString(hashId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

