package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CandidatureRepository;
import com.example.demo.entity.Candidatures;

@Transactional
@Service
public class CandidatureService {
	
	@Autowired
	private CandidatureRepository candidatureRepository;

	public List<Candidatures> findAll() {
		return candidatureRepository.findAll();
	}

	public Candidatures findById(Long theId) {
		Optional<Candidatures> result = candidatureRepository.findById(theId);

		Candidatures theCandidature = null;

		if (result.isPresent()) {
			theCandidature = result.get();
		} else {

			throw new RuntimeException("Did not find Candidature id - " + theId);
		}

		return theCandidature;
	}

	public Candidatures saveCandidature(Candidatures theCandidature) {
		candidatureRepository.save(theCandidature);
		return theCandidature;
	}

	public void deleteById(Long theId) {
		candidatureRepository.deleteById(theId);
	}

	public Long getCandidatureIdBymail(String mail) {
		Long idcandidature = candidatureRepository.findCandidatureByemail(mail);
		return idcandidature;
	}
	
	public String findCandidatureMailByIdService(Long id) {
		return candidatureRepository.findCandidatureMailById(id);		
	}

}
