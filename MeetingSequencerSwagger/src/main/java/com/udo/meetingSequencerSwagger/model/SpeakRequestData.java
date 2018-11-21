package com.udo.meetingSequencerSwagger.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SpeakRequestData")
public class SpeakRequestData {
	
	@Id
	@GeneratedValue
	private Long id = null;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MEETING_ID")
	private MeetingData meeting = null;

	@Column(name = "timestamp")
	private String timestamp = null;	
	
	@Column(name = "topic")
	private String topic = null;

	@Column(name = "attendee")
	private String attendee = null;

	public SpeakRequestData() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getAttendee() {
		return attendee;
	}

	public void setAttendee(String attendee) {
		this.attendee = attendee;
	}
	
	public void setMeeting(MeetingData meeting) {
		this.meeting = meeting;
	}

}
