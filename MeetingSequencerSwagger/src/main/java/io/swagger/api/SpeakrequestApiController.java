package io.swagger.api;

import io.swagger.model.JsonMeetingData;
import io.swagger.model.JsonSpeakRequestData;
import io.swagger.model.JsonSpeakRequestsData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udo.meetingSequencerSwagger.model.MeetingData;
import com.udo.meetingSequencerSwagger.model.SpeakRequestData;
import com.udo.meetingSequencerSwagger.service.MeetingServiceImpl;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-19T15:51:46.420Z")

@Controller
public class SpeakrequestApiController implements SpeakrequestApi {

	private static final Logger log = LoggerFactory.getLogger(SpeakrequestApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	private MeetingServiceImpl meetingService;

	@org.springframework.beans.factory.annotation.Autowired
	public SpeakrequestApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> createSpeakRequest(
			@ApiParam(value = "the speakrequest to be created") @Valid @RequestBody JsonSpeakRequestData meeting) {
		String accept = request.getHeader("Accept");

		MeetingData mtg;
		try {
			mtg = meetingService.getMeetingById(meeting.getMeetingId().longValue());
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		if (mtg == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		SpeakRequestData spk = new SpeakRequestData();
		spk.setAttendee(meeting.getAttendee());
		spk.setTimestamp(meeting.getTimestamp());
		spk.setTopic(meeting.getTopic());
		spk.setMeeting(mtg);

		meetingService.createSpeakRequest(spk);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<JsonSpeakRequestsData> getSpeakrequestByMeetingId(
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "meetingId", required = true) String meetingId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Long mId;
			try {
				mId = Long.valueOf(meetingId);
			} catch (NumberFormatException e1) {
				return new ResponseEntity<JsonSpeakRequestsData>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			List<SpeakRequestData> speakRequest = meetingService.getSpeakRequestForMeeting(mId);

			if (speakRequest == null || speakRequest.isEmpty()) {
				return new ResponseEntity<JsonSpeakRequestsData>(HttpStatus.NOT_FOUND);
			}

			List<JsonSpeakRequestData> jspeakRequest = new ArrayList<JsonSpeakRequestData>();

			for (SpeakRequestData s : speakRequest) {
				JsonSpeakRequestData j = new JsonSpeakRequestData();
				j.setId(s.getId().toString());
				j.setAttendee(s.getAttendee());
				j.setMeetingId(Integer.valueOf(meetingId));
				j.setTimestamp(s.getTimestamp());
				j.setTopic(s.getTopic());
				jspeakRequest.add(j);

			}
			JsonSpeakRequestsData jSpeakRequests = new JsonSpeakRequestsData();
			jSpeakRequests.setMeetings(jspeakRequest);
			return new ResponseEntity<JsonSpeakRequestsData>(jSpeakRequests, HttpStatus.OK);

		}
		return new ResponseEntity<JsonSpeakRequestsData>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
