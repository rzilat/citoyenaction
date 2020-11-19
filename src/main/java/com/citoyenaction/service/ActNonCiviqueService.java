package com.citoyenaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citoyenaction.domain.ActNonCivique;
import com.citoyenaction.domain.Statut;
import com.citoyenaction.domain.User;
import com.citoyenaction.repository.ActNonCiviqueRepository;

@Service
public class ActNonCiviqueService {
	
	@Autowired
	private ActNonCiviqueRepository actNonCiviqueRepository;
	
	public ActNonCivique addActNonCivique(ActNonCivique actNonCivique) {
		actNonCivique.setStatut(Statut.PENDING.toString());
		return this.actNonCiviqueRepository.save(actNonCivique);
		
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
	
	public List<ActNonCivique> findActNonCiviquesByStatut(String statut) {
		return this.actNonCiviqueRepository.findActNonCiviqueByStatut(statut);
	

	}

	public void aprouvedActNonCivique(long actNonCiviqueId) {
		ActNonCivique actNonCivique = actNonCiviqueRepository.getOne(actNonCiviqueId);
		actNonCivique.setStatut(Statut.APROUVED.toString());
		this.actNonCiviqueRepository.save(actNonCivique);
	}

}
