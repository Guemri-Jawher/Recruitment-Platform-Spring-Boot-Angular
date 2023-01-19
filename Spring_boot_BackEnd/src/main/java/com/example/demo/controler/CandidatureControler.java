package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Candidatures;
import com.example.demo.service.CandidatureService;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
//@RequestMapping()
public class CandidatureControler {
	
	@Autowired
	private CandidatureService candidatureService;

	@GetMapping("/getAllCandidature")
	public List<Candidatures> findAll() {
		return candidatureService.findAll();
	}

	@GetMapping("/{id}")
	public Candidatures getCandidature(@PathVariable Long id) {

		return candidatureService.findById(id);
	}
	
	@GetMapping("/findCandidat/{mail}")
	public Long getCandidatureIdBymail(@PathVariable String mail) {
			Long id = (long) 0 ;
		id= candidatureService.getCandidatureIdBymail(mail);
		return id ;
	}
	
	@GetMapping("/findCandidatM/{id}")
	public String findCandidatureMailById(@PathVariable Long id) {
		return candidatureService.findCandidatureMailByIdService(id); 
	}

	@PostMapping("/apply")
	public Candidatures addCandidature(@RequestBody Candidatures theCandidature) {

		candidatureService.saveCandidature(theCandidature);
		return theCandidature ;

	}

	@PutMapping("/Candidatures")
	public Candidatures updateCandidature(@RequestBody Candidatures theCandidature) {
		candidatureService.saveCandidature(theCandidature);
		return theCandidature;
	}

	@DeleteMapping("/Candidatures/{CandidatureId}")
	public List<Candidatures> deleteCandidature(@PathVariable Long CandidatureId) {

		/*Candidatures tempCandidature = candidatureService.findById(CandidatureId);

		if (tempCandidature == null) {
			throw new RuntimeException("Candidature id not found - " + CandidatureId);
		}*/

		candidatureService.deleteById(CandidatureId);

		return candidatureService.findAll();
	}


}
