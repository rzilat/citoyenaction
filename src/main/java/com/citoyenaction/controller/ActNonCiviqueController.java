package com.citoyenaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citoyenaction.domain.ActNonCivique;

import com.citoyenaction.service.ActNonCiviqueService;


@RestController
@RequestMapping(value= "/citoyenaction")
public class ActNonCiviqueController {
	
	@Autowired
	private ActNonCiviqueService actNonCiviqueService;
	
	@RequestMapping(value= "/actNonCiviques", method= RequestMethod.GET)
	public ResponseEntity <List<ActNonCivique>> getAllActNonCiviques(){
		List<ActNonCivique> actNonCiviques= actNonCiviqueService.findAll();
		return new ResponseEntity <> (actNonCiviques,HttpStatus.OK) ;
		}
	
	@RequestMapping(value= "/actNonCivique", method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addActNonCivique(@RequestBody ActNonCivique actNonCivique) {
		actNonCiviqueService.addActNonCivique(actNonCivique);
	}
	
	@RequestMapping(value= "/actNonCivique/{id}", method= RequestMethod.GET)
	public ResponseEntity <ActNonCivique> getActNonCivique(@PathVariable("id")long actNonCiviqueId){
		
		ActNonCivique actNonCivique= actNonCiviqueService.findActNonCivique(actNonCiviqueId);
		return new ResponseEntity <> (actNonCivique,HttpStatus.OK);
		
	}
	
	@RequestMapping(value= "/actNonCivique/{id}", method= RequestMethod.DELETE)
	public void deleteActNonCivique(@PathVariable("id")long actNonCiviqueId){
		actNonCiviqueService.deleteActNonCivique(actNonCiviqueId);
	}
	
	@RequestMapping(value= "/actNonCivique", method= RequestMethod.PUT)
	public ResponseEntity <ActNonCivique> updateActNonCivique(@RequestBody ActNonCivique actNonCivique) {
		return new ResponseEntity <> (actNonCiviqueService.updateActNonCivique(actNonCivique),HttpStatus.OK);
		
	}
	
	@RequestMapping(value= "/actNonCiviques/findByUserId/{userId}", method=RequestMethod.GET)
	public ResponseEntity<List<ActNonCivique>> getActNonCiviqueByUserId(@PathVariable("userId")long userId)
	
	{
		List<ActNonCivique> actNonCiviqueList= actNonCiviqueService.findActNonCiviquesByUserId(userId);
		return new ResponseEntity<>(actNonCiviqueList,HttpStatus.OK);
	}
	}