package com.udo.meetingSequencerSwagger.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udo.meetingSequencerSwagger.model.MeetingData;


@Repository
public interface MeetingRepository extends JpaRepository<MeetingData, Long> {
}
