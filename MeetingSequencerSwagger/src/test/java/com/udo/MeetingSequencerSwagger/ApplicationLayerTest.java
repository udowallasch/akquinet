package com.udo.MeetingSequencerSwagger;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.udo.meetingSequencerSwagger.MeetingSequencerSwaggerApplication;
import com.udo.meetingSequencerSwagger.service.MeetingServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { MeetingSequencerSwaggerApplication.class })
public class ApplicationLayerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private MeetingServiceImpl service;

	
	
	@Before
	public void setup() throws Exception{
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/meeting")
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
				.characterEncoding("UTF-8").content(getMeetingJson2());
		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
		MockHttpServletRequestBuilder builder1 = MockMvcRequestBuilders.post("/meeting")
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
				.characterEncoding("UTF-8").content(getMeetingJson3());
		mockMvc.perform(builder1).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	public void testCreateMeeting() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/meeting")
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
				.characterEncoding("UTF-8").content(getMeetingJson());
		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
		MockHttpServletRequestBuilder builder1 = MockMvcRequestBuilders.post("/meeting")
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
				.characterEncoding("UTF-8").content(getMeetingJson1());
		mockMvc.perform(builder1).andExpect(MockMvcResultMatchers.status().isOk());

	}
	@Test
	public void testMeetingById() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/meeting/1")
				.accept(MediaType.APPLICATION_JSON_UTF8);
		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(content().string(containsString("smoke meeting")));

	}
	@Test
	public void testGetAllMeetings() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/meeting")
				.accept(MediaType.APPLICATION_JSON_UTF8);
		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(content().string(containsString("smoke meeting")))
		.andExpect(content().string(containsString("smoke meeting1")));

	}

	private String getMeetingJson() {
		return "{ \"description\": \"smoke meeting\", \"id\": \"to be ignored\", \"name\": \"smokeTest\" }";
	}	
	private String getMeetingJson1() {
		return "{ \"description\": \"smoke meeting1\", \"id\": \"to be ignored\", \"name\": \"smokeTest1\" }";
	}	private String getMeetingJson2() {
		return "{ \"description\": \"smoke meeting2\", \"id\": \"to be ignored\", \"name\": \"smokeTest\" }";
	}	
	private String getMeetingJson3() {
		return "{ \"description\": \"smoke meeting3\", \"id\": \"to be ignored\", \"name\": \"smokeTest1\" }";
	}
}