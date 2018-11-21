package com.udo.meetingSequencerSwagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udo.meetingSequencerSwagger.model.SpeakRequestData;

@Repository
public interface SpeakRequestRepository extends JpaRepository<SpeakRequestData, Long> {
}
