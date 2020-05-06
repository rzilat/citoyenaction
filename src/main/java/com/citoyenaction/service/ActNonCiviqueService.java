package com.citoyenaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citoyenaction.domain.ActNonCivique;

import com.citoyenaction.repository.ActNonCiviqueRepository;

@Service
public class ActNonCiviqueService {
	
	@Autowired
	private ActNonCiviqueRepository actNonCiviqueRepository;
	
	public void addActNonCivique(ActNonCivique actNonCivique) {
		
		actNonCiviqueRepository.save(actNonCivique);
		
	}
	
	public ActNonCivique findActNonCivique(long actNonCiviqueId) {
		return this.actNonCiviqueRepository.getOne(actNonCiviqueId);
		
	}
	
	public List<ActNonCivique> findAll(){
		return this.actNonCiviqueRepository.findAll();
		
	}
	
	public void deleteActNonCivique(long actNonCiviqueId) {
		actNonCiviqueRepository.deleteById(actNonCiviqueId);
	}
	
	public ActNonCivique updateActNonCivique(ActNonCivique actNonCivique) {
		return this.actNonCiviqueRepository.save(actNonCivique);
		
	}
	
	public List<ActNonCivique> findActNonCiviquesByUserId(long userId) {
		return this.actNonCiviqueRepository.findActNonCiviqueByUserId(userId);
	

}

}
