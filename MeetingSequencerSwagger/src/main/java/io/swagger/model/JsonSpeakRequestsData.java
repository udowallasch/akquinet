package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * JsonMeetingsData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-19T15:51:46.420Z")

public class JsonSpeakRequestsData   {
  @JsonProperty("speakRequests")
  @Valid
  private List<JsonSpeakRequestData> speakRequests = null;

  public JsonSpeakRequestsData speakRequests(List<JsonSpeakRequestData> speakRequests) {
    this.speakRequests = speakRequests;
    return this;
  }

  public JsonSpeakRequestsData addMeetingsItem(JsonSpeakRequestData speakRequestItem) {
    if (this.speakRequests == null) {
      this.speakRequests = new ArrayList<JsonSpeakRequestData>();
    }
    this.speakRequests.add(speakRequestItem);
    return this;
  }

  /**
   * Get meetings
   * @return meetings
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<JsonSpeakRequestData> getSpeakRequests() {
    return speakRequests;
  }

  public void setMeetings(List<JsonSpeakRequestData> speakRequests) {
    this.speakRequests = speakRequests;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonSpeakRequestsData jsonSpeakRequestsData = (JsonSpeakRequestsData) o;
    return Objects.equals(this.speakRequests, jsonSpeakRequestsData.speakRequests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(speakRequests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonMeetingsData {\n");
    
    sb.append("    meetings: ").append(toIndentedString(speakRequests)).append("\n");
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

