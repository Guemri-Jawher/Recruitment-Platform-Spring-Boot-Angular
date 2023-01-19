package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Jobs_Candidatures")
public class Jobs_Candidatures {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, length = 45)
    private Long jobsId;
     
    @Column(nullable = false, length = 64)
    private Long candidaturesId ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobsId() {
		return jobsId;
	}

	public void setJobsId(Long jobsId) {
		this.jobsId = jobsId;
	}

	public Long getCandidaturesId() {
		return candidaturesId;
	}

	public void setCandidaturesId(Long candidaturesId) {
		this.candidaturesId = candidaturesId;
	}

}
