package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Candidatures;

public interface CandidatureRepository extends JpaRepository<Candidatures, Long> {

	@Query("SELECT j.id FROM Candidatures j WHERE j.email = :email ")
	Long findCandidatureByemail (@Param("email") String email);
	
	@Query("SELECT j.email FROM Candidatures j WHERE j.id = :id ")
	String findCandidatureMailById (@Param("id") Long id);
	
	@Query("SELECT j FROM Candidatures j WHERE j.id = :id ")
	Candidatures findCandidatureByid (@Param("id") Long id);
}
