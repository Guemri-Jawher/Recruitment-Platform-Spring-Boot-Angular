package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Candidatures;
import com.example.demo.entity.Jobs_Candidatures;
import com.example.demo.service.Jobs_CandidaturesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class Jobs_CandidaturesControler {
	
	@Autowired
	private Jobs_CandidaturesService service;
	
	@PostMapping("/save")
	 public String register(@RequestBody Jobs_Candidatures cand ) {
		service.saveJobs_Candidatures(cand);
		 return "succes ";
	 }
	
	@GetMapping("/getAllCandidate/{jobsId}")
	 public List<Candidatures> findAllCandidate(@PathVariable Long jobsId) {
		return service.findcandforjob(jobsId);
	 }

}
