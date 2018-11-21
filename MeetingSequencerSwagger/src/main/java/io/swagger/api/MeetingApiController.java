package io.swagger.api;

import io.swagger.model.JsonMeetingData;
import io.swagger.model.JsonMeetingsData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udo.meetingSequencerSwagger.model.MeetingData;
import com.udo.meetingSequencerSwagger.service.MeetingServiceImpl;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-19T15:51:46.420Z")

@Controller
public class MeetingApiController implements MeetingApi {

	private static final Logger log = LoggerFactory.getLogger(MeetingApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	private MeetingServiceImpl meetingService;

	@org.springframework.beans.factory.annotation.Autowired
	public MeetingApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> createMeeting(
		@ApiParam(value = "the meeting to be created") @Valid @RequestBody JsonMeetingData meeting) {
		String accept = request.getHeader("Accept");
		MeetingData mtg = new MeetingData();
		mtg.setName(meeting.getName());
		mtg.setDescription(meeting.getDescription());
		MeetingData ret = meetingService.createMeeting(mtg);
		if (meetingService.createMeeting(mtg) != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<JsonMeetingsData> getAllMeetings() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			// try {
			List<MeetingData> meetings = meetingService.getAllMeetings();
			if (meetings == null || meetings.isEmpty()) {
				return new ResponseEntity<JsonMeetingsData>(HttpStatus.NOT_FOUND);
			}
			List<JsonMeetingData> jmeetings = new ArrayList<JsonMeetingData>();

			for (MeetingData m : meetings) {
				JsonMeetingData j = new JsonMeetingData();
				j.setId(m.getId().toString());
				j.setName(m.getName());
				j.setDescription(m.getDescription());
				jmeetings.add(j);

			}
			JsonMeetingsData jmeetingsData = new JsonMeetingsData();
			jmeetingsData.meetings(jmeetings);
			return new ResponseEntity<JsonMeetingsData>(jmeetingsData, HttpStatus.OK);
		}

		return new ResponseEntity<JsonMeetingsData>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<JsonMeetingData> getMeetingById(
			@ApiParam(value = "", required = true) @PathVariable("meetingId") Integer meetingId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<JsonMeetingsData>(objectMapper.readValue("{  \"meetings\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  } ]}", JsonMeetingsData.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<JsonMeetingsData>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
			MeetingData meeting;
			try {
				meeting = meetingService.getMeetingById(meetingId.longValue());
			} catch (NoSuchElementException e) {
				return new ResponseEntity<JsonMeetingData>(HttpStatus.NOT_FOUND);
			}
			if (meeting == null ) {
				return new ResponseEntity<JsonMeetingData>(HttpStatus.NOT_FOUND);
			}
			
			JsonMeetingData j = new JsonMeetingData();
			j.setId(meeting.getId().toString());
			j.setName(meeting.getName());
			j.setDescription(meeting.getDescription());

			return new ResponseEntity<JsonMeetingData>(j, HttpStatus.OK);

		}

		return new ResponseEntity<JsonMeetingData>(HttpStatus.NOT_IMPLEMENTED);
	}

}
