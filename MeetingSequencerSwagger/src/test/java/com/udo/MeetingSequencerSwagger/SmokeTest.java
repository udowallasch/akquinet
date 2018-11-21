package com.udo.MeetingSequencerSwagger;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.udo.meetingSequencerSwagger.MeetingSequencerSwaggerApplication;

import io.swagger.api.MeetingApiController;
import io.swagger.api.SpeakrequestApiController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MeetingSequencerSwaggerApplication.class)
public class SmokeTest {

    @Autowired
    private MeetingApiController meetingApiController;
    @Autowired
    private SpeakrequestApiController speakrequestApiController;

    @Test
    public void loadMeetingApiController() throws Exception {
        assertThat(meetingApiController).isNotNull();
     }
    @Test
    public void LoadSpeakrequestApiController() throws Exception {
        assertThat(speakrequestApiController).isNotNull();
    }

 }