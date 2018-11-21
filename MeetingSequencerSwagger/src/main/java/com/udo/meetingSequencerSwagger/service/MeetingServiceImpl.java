package com.udo.meetingSequencerSwagger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udo.meetingSequencerSwagger.model.MeetingData;
import com.udo.meetingSequencerSwagger.model.SpeakRequestData;
import com.udo.meetingSequencerSwagger.repository.MeetingRepository;
import com.udo.meetingSequencerSwagger.repository.SpeakRequestRepository;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	MeetingRepository meetingRepository;

	@Autowired
	SpeakRequestRepository speakRequestRepository;

	@Override
	public MeetingData createMeeting(MeetingData meeting) {

		return meetingRepository.save(meeting);
	}

	@Override
	public List<MeetingData> getAllMeetings() {
		List<MeetingData> meetings = meetingRepository.findAll();
		return meetings;
	}

	@Override
	public MeetingData getMeetingById(Long meetingId) {
		Optional<MeetingData> optMtg = meetingRepository.findById(meetingId);
		return optMtg.get();
	}

	@Override
	public SpeakRequestData createSpeakRequest(SpeakRequestData speakrequest) {
		return speakRequestRepository.save(speakrequest);
	}

	@Override
	public List<SpeakRequestData> getSpeakRequestForMeeting(Long meetingId) {
		Optional<MeetingData> optMtg = meetingRepository.findById(meetingId);

		return optMtg.get().getSpeakRequests();

	}
	public String test() {
		return ("teststring");
	}

}