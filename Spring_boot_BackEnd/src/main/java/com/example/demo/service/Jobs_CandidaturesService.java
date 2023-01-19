package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CandidatureRepository;
import com.example.demo.dao.Jobs_CandidaturesRepository;
import com.example.demo.entity.Candidatures;
import com.example.demo.entity.Jobs_Candidatures;

@Transactional
@Service
public class Jobs_CandidaturesService {
	
	@Autowired
    private Jobs_CandidaturesRepository repository ;
	
	@Autowired
    private CandidatureRepository repositoryCandidat ;
	
	public void saveJobs_Candidatures (Jobs_Candidatures cand) {
		repository.save(cand) ;
	}
	
	// les id des candidat ici
	public List<Long> findJobs_Candidatures (Long jobsId) {
		return repository.findJobs_CandidaturesR(jobsId);
	}
	
	public List<Candidatures> findcandforjob(Long jobsId){
		List<Candidatures> L = new ArrayList<>(); 
		for (Long e : findJobs_Candidatures (jobsId) ) {
			if (!L.contains(repositoryCandidat.findCandidatureByid(e))) {
				L.add(repositoryCandidat.findCandidatureByid(e));
			}
		}
		return L;
	}

}
