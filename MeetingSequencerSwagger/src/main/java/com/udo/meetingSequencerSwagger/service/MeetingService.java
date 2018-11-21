package com.udo.meetingSequencerSwagger.service;


import java.util.List;

import com.udo.meetingSequencerSwagger.model.MeetingData;
import com.udo.meetingSequencerSwagger.model.SpeakRequestData;

public interface MeetingService {
    public MeetingData  createMeeting(MeetingData meeting) ;

	public List<MeetingData> getAllMeetings() ;

	public MeetingData getMeetingById(Long meetingId);

	public SpeakRequestData  createSpeakRequest(SpeakRequestData speakrequest) ;

	public List<SpeakRequestData> getSpeakRequestForMeeting(Long meetingId);


}
