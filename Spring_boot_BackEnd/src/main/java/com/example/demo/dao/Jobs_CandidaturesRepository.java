package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Jobs_Candidatures;

public interface Jobs_CandidaturesRepository extends JpaRepository<Jobs_Candidatures, Long> {
	
	@Query("SELECT u.candidaturesId FROM Jobs_Candidatures u WHERE u.jobsId = :jobsId ")
	List<Long> findJobs_CandidaturesR(@Param("jobsId") Long jobsId);

}
