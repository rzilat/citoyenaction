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
import com.citoyenaction.domain.User;
import com.citoyenaction.service.ActNonCiviqueService;


@RestController
@RequestMapping(value= "/citoyenaction")
public class ActNonCiviqueController {
	
	@Autowired
	private ActNonCiviqueService actNonCiviqueService;
	
	@RequestMapping(value= "/actnonciviques", method= RequestMethod.GET)
	public ResponseEntity <List<ActNonCivique>> getAllActNonCiviques(){
		List<ActNonCivique> actNonCiviques= actNonCiviqueService.findAll();
		return new ResponseEntity <> (actNonCiviques,HttpStatus.OK) ;
		}
	
	@RequestMapping(value= "/actnoncivique", method= RequestMethod.POST)
	public ResponseEntity <ActNonCivique> addActNonCivique(@RequestBody ActNonCivique actNonCivique) {
		return new ResponseEntity<> (actNonCiviqueService.addActNonCivique(actNonCivique),HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value= "/actnoncivique/{actNonCiviqueId}", method= RequestMethod.GET)
	public ResponseEntity <ActNonCivique> getActNonCivique(@PathVariable("actNonCiviqueId")long actNonCiviqueId){
		
		ActNonCivique actNonCivique= actNonCiviqueService.findActNonCivique(actNonCiviqueId);
		return new ResponseEntity <> (actNonCivique,HttpStatus.OK);
		
	}
	
	@RequestMapping(value= "/actnoncivique/{actNonCiviqueId}", method= RequestMethod.DELETE)
	public void deleteActNonCivique(@PathVariable("actNonCiviqueId")long actNonCiviqueId){
		actNonCiviqueService.deleteActNonCivique(actNonCiviqueId);
	}
	
	@RequestMapping(value= "/actnoncivique", method= RequestMethod.PUT)
	public ResponseEntity <ActNonCivique> updateActNonCivique(@RequestBody ActNonCivique actNonCivique) {
		return new ResponseEntity <> (actNonCiviqueService.updateActNonCivique(actNonCivique),HttpStatus.OK);
		
	}
	
	@RequestMapping(value= "/actnonciviques/findbyuserid/{userId}", method=RequestMethod.GET)
	public ResponseEntity<List<ActNonCivique>> getActNonCiviqueByUserId(@PathVariable("userId")long userId)
	
	{
		List<ActNonCivique> actNonCiviqueList= actNonCiviqueService.findActNonCiviquesByUserId(userId);
		return new ResponseEntity<>(actNonCiviqueList,HttpStatus.OK);
	}
	}