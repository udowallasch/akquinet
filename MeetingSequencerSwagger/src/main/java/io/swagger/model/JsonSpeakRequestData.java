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
 * JsonSpeakRequestData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-19T15:51:46.420Z")

public class JsonSpeakRequestData   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("topic")
  private String topic = null;

  @JsonProperty("attendee")
  private String attendee = null;

  @JsonProperty("meetingId")
  private Integer meetingId = null;

  @JsonProperty("timestamp")
  private String timestamp = null;

  public JsonSpeakRequestData id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of a the requestToSpeak
   * @return id
  **/
  @ApiModelProperty(required = true, value = "ID of a the requestToSpeak")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public JsonSpeakRequestData topic(String topic) {
    this.topic = topic;
    return this;
  }

  /**
   * The topic of the desired speakrequest
   * @return topic
  **/
  @ApiModelProperty(required = true, value = "The topic of the desired speakrequest")
  @NotNull


  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public JsonSpeakRequestData attendee(String attendee) {
    this.attendee = attendee;
    return this;
  }

  /**
   * Name of the meetings attendee who wants to speak
   * @return attendee
  **/
  @ApiModelProperty(required = true, value = "Name of the meetings attendee who wants to speak")
  @NotNull


  public String getAttendee() {
    return attendee;
  }

  public void setAttendee(String attendee) {
    this.attendee = attendee;
  }

  public JsonSpeakRequestData meetingId(Integer meetingId) {
    this.meetingId = meetingId;
    return this;
  }

  /**
   * The Id of the corresponding meeting
   * @return meetingId
  **/
  @ApiModelProperty(required = true, value = "The Id of the corresponding meeting")
  @NotNull


  public Integer getMeetingId() {
    return meetingId;
  }

  public void setMeetingId(Integer meetingId) {
    this.meetingId = meetingId;
  }

  public JsonSpeakRequestData timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The time when the speakrequest was created
   * @return timestamp
  **/
  @ApiModelProperty(value = "The time when the speakrequest was created")


  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonSpeakRequestData jsonSpeakRequestData = (JsonSpeakRequestData) o;
    return Objects.equals(this.id, jsonSpeakRequestData.id) &&
        Objects.equals(this.topic, jsonSpeakRequestData.topic) &&
        Objects.equals(this.attendee, jsonSpeakRequestData.attendee) &&
        Objects.equals(this.meetingId, jsonSpeakRequestData.meetingId) &&
        Objects.equals(this.timestamp, jsonSpeakRequestData.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, topic, attendee, meetingId, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonSpeakRequestData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    attendee: ").append(toIndentedString(attendee)).append("\n");
    sb.append("    meetingId: ").append(toIndentedString(meetingId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

