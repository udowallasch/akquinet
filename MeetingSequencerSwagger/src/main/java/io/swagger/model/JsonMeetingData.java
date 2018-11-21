package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JsonMeetingData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-19T15:51:46.420Z")

public class JsonMeetingData   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  public JsonMeetingData id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of a meeting
   * @return id
  **/
  @ApiModelProperty(required = true, value = "ID of a meeting")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public JsonMeetingData name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the meeting
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the meeting")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public JsonMeetingData description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the meeting
   * @return description
  **/
  @ApiModelProperty(value = "The description of the meeting")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
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
    JsonMeetingData jsonMeetingData = (JsonMeetingData) o;
    return Objects.equals(this.id, jsonMeetingData.id) &&
        Objects.equals(this.name, jsonMeetingData.name) &&
        Objects.equals(this.description, jsonMeetingData.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonMeetingData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

