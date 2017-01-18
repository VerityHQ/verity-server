package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.LocalDate;

/**
 * Activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities.   Maps to https://www.w3.org/TR/prov-o/  prov:Activity
 **/

/**
 * Activity is something that occurs over a period of time and acts upon or with
 * entities; it may include consuming, processing, transforming, modifying,
 * relocating, using, or generating entities. Maps to
 * https://www.w3.org/TR/prov-o/ prov:Activity
 */
@ApiModel(description = "Activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities.   Maps to https://www.w3.org/TR/prov-o/  prov:Activity")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T19:52:26.921-08:00")

@Entity
public class Activity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6797472896832777343L;

	//TODO: added to make hibernate happy. Need to update the API def and regen, adding a UUID filed
	@Id
	private String uuid = null;

	private LocalDate end = null;

	private String name = null;

	private LocalDate start = null;

	public Activity end(LocalDate end) {
		this.end = end;
		return this;
	}

	/**
	 * Could correspond to a block number in the blockchain
	 * 
	 * @return end
	 **/
	@ApiModelProperty(required = true, value = "Could correspond to a block number in the blockchain")
	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public Activity name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(required = true, value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Activity start(LocalDate start) {
		this.start = start;
		return this;
	}

	/**
	 * Could correspond to a block number in the blockchain
	 * 
	 * @return start
	 **/
	@ApiModelProperty(required = true, value = "Could correspond to a block number in the blockchain")
	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Activity activity = (Activity) o;
		return Objects.equals(this.end, activity.end) && Objects.equals(this.name, activity.name)
				&& Objects.equals(this.start, activity.start);
	}

	@Override
	public int hashCode() {
		return Objects.hash(end, name, start);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Activity {\n");

		sb.append("    end: ").append(toIndentedString(end)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    start: ").append(toIndentedString(start)).append("\n");
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
