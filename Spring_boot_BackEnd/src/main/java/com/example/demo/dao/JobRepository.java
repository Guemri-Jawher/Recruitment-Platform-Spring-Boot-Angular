package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Jobs;

public interface JobRepository extends JpaRepository<Jobs, Long> {
	@Query("SELECT j FROM Jobs j WHERE j.id = :id ")
	Jobs findJobById (@Param("id") Long id);
	
	@Query("SELECT j FROM Jobs j WHERE j.job_title = :job_title ")
	List<Jobs> findJobByJob_title (@Param("job_title") String job_title);
	
	@Query("SELECT j FROM Jobs j WHERE j.location = :location ")
	List<Jobs> findJobByLocation (@Param("location") String location);
	
	@Query("SELECT j FROM Jobs j WHERE j.job_title = :job_title and j.location = :location ")
	List<Jobs> findJobByJob_titleAndLocation(@Param("job_title") String job_title ,@Param("location") String location);
	
	@Modifying
	@Query(value = "UPDATE Jobs u set u.job_title = :job_title where u.id = :id", nativeQuery = true)
	void changeJobTitle(@Param("job_title") String job_title, @Param("id") Long id);
	
	@Modifying
	@Query(value = "UPDATE Jobs u set u.email = :mail where u.id = :id", nativeQuery = true)
	void changeJobEmail(@Param("mail") String mail, @Param("id") Long id);
	
	@Modifying
	@Query(value = "UPDATE Jobs u set u.job_type = :job_type where u.id = :id", nativeQuery = true)
	void changeJobType(@Param("job_type") String job_type, @Param("id") Long id);
}
