package com.udo.MeetingSequencerSwagger;


import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.udo.meetingSequencerSwagger.MeetingSequencerSwaggerApplication;
import com.udo.meetingSequencerSwagger.model.MeetingData;
import com.udo.meetingSequencerSwagger.model.SpeakRequestData;
import com.udo.meetingSequencerSwagger.service.MeetingServiceImpl;

import io.swagger.api.SpeakrequestApiController;

@RunWith(SpringRunner.class)
@WebMvcTest(SpeakrequestApiController.class)
@ContextConfiguration(classes = {MeetingSequencerSwaggerApplication.class})
public class WebLayerSpeakRequestTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MeetingServiceImpl service;

	@Test
	public void testCreateSpeakRequest() throws Exception {
		MeetingData value = new MeetingData();
		value.setDescription("bla");
		value.setId(4711L);
		value.setName("name");

		SpeakRequestData spk = new SpeakRequestData();
		spk.setAttendee("attendee1");
		spk.setTimestamp("1.1.1958");
		spk.setTopic("mxTopic");
		spk.setMeeting(value);
		when(service.getMeetingById(4711L)).thenReturn(value);	

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/speakrequest")
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
				.characterEncoding("UTF-8").content(getSpeakRequestJson());
		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());

	}
	@Test
	public void getSpeakrequestByMeetingId() throws Exception {
		MeetingData value = new MeetingData();
		value.setDescription("bla");
		value.setId(4711L);
		value.setName("name");

		SpeakRequestData spk = new SpeakRequestData();
		spk.setId(1L);
		spk.setAttendee("attendee1");
		spk.setTimestamp("1.1.1958");
		spk.setTopic("mxTopic");
		spk.setMeeting(value);
		List<SpeakRequestData> spks = new ArrayList<SpeakRequestData>();
		spks.add(spk);
		when (service.getMeetingById(4711L)).thenReturn(value);
		when (service.getSpeakRequestForMeeting(4711L)).thenReturn(spks);
		
		
//		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/speakRequest/1")
//				.contentType(MediaType.APPLICATION_JSON_UTF8);
//		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
		
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/speakrequest?meetingId=4711")
				.accept(MediaType.APPLICATION_JSON_UTF8);
		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());

		

	}
	private String getSpeakRequestJson() {
		return "{  \"attendee\": \"string\", \"id\": \"string\", \"meetingId\": 4711, \"timestamp\": \"string\",  \"topic\": \"string\" }";
	}

}
