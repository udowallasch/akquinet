package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.JsonMeetingData;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JsonMeetingsData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-19T15:51:46.420Z")

public class JsonMeetingsData   {
  @JsonProperty("meetings")
  @Valid
  private List<JsonMeetingData> meetings = null;

  public JsonMeetingsData meetings(List<JsonMeetingData> meetings) {
    this.meetings = meetings;
    return this;
  }

  public JsonMeetingsData addMeetingsItem(JsonMeetingData meetingsItem) {
    if (this.meetings == null) {
      this.meetings = new ArrayList<JsonMeetingData>();
    }
    this.meetings.add(meetingsItem);
    return this;
  }

  /**
   * Get meetings
   * @return meetings
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<JsonMeetingData> getMeetings() {
    return meetings;
  }

  public void setMeetings(List<JsonMeetingData> meetings) {
    this.meetings = meetings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonMeetingsData jsonMeetingsData = (JsonMeetingsData) o;
    return Objects.equals(this.meetings, jsonMeetingsData.meetings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meetings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonMeetingsData {\n");
    
    sb.append("    meetings: ").append(toIndentedString(meetings)).append("\n");
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

