package com.udo.meetingSequencerSwagger.model;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "MeetingData")
public class MeetingData {
	@Id
	@GeneratedValue
	private Long id = null;
	
	@Column(name = "name")
	private String name = null;

	@Column(name = "description")
	private String description = null;
	
	@OneToMany(mappedBy = "meeting")
	private List<SpeakRequestData> speakRequests;

	public MeetingData() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<SpeakRequestData> getSpeakRequests(){
		return speakRequests;
	}

}

