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
import com.udo.meetingSequencerSwagger.service.MeetingServiceImpl;

import io.swagger.api.MeetingApiController;

@RunWith(SpringRunner.class)
@WebMvcTest(MeetingApiController.class)
@ContextConfiguration(classes = {MeetingSequencerSwaggerApplication.class})
public class WebLayerMeetingTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MeetingServiceImpl service;

	@Test
	public void testGetMeetingById() throws Exception {
		MeetingData value = new MeetingData();
		value.setDescription("bla");
		value.setId(4711L);
		value.setName("name");

		when (service.getMeetingById(1L)).thenReturn(value);
		 
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/meeting/1")
				.accept(MediaType.APPLICATION_JSON_UTF8);
				
		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(content().string(containsString("4711")));

	}
	@Test
	public void testGetAllMeetings() throws Exception {
		MeetingData value = new MeetingData();
		value.setDescription("bla");
		value.setId(4711L);
		value.setName("name");
		MeetingData value1 = new MeetingData();
		value1.setDescription("blabla");
		value1.setId(4712L);
		value1.setName("name1");
		
		List<MeetingData> meetings = new ArrayList<MeetingData>();
		meetings.add(value);
		meetings.add(value1);

		when (service.getAllMeetings()).thenReturn(meetings);
		 
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/meeting")
				.accept(MediaType.APPLICATION_JSON_UTF8);
				
		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(content().string(containsString("4711")));

	}
	private String getMeetingJson() {
		return "{ \"description\": \"smoke meeting\", \"id\": \"to be ignored\", \"name\": \"smokeTest\" }";
	}
	@Test
	public void testCreateMeeting() throws Exception {
		MeetingData value = new MeetingData();
		value.setDescription("bla");
		value.setId(4711L);
		value.setName("name");
	
		Mockito.when (service.createMeeting(new MeetingData())).thenReturn(value);
		 
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/meeting")
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
				.characterEncoding("UTF-8").content(getMeetingJson());
		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isInternalServerError());

	}

}
