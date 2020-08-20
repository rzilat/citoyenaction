package com.citoyenaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citoyenaction.domain.Reaction;
import com.citoyenaction.service.ReactionService;




@RestController
@RequestMapping(value= "/citoyenaction")
public class ReactionController {
	
	@Autowired
	private ReactionService reactionService;
	
	@RequestMapping(value= "/reactions", method= RequestMethod.GET)
	public ResponseEntity <List<Reaction>>getAllReactions(){
		List<Reaction> reactions= reactionService.findAll();
		return new ResponseEntity <>(reactions,HttpStatus.OK);
		
	}
	
	@RequestMapping(value= "/reaction", method= RequestMethod.POST)
	public ResponseEntity <Reaction> addReaction(@RequestBody Reaction reaction) {
		return new ResponseEntity<> (reactionService.addReaction(reaction),HttpStatus.CREATED);
		
	}
	@RequestMapping(value= "/reaction/{reactionId}", method= RequestMethod.GET)
	public ResponseEntity <Reaction> getReaction(@PathVariable("reactionId")long reactionId){
		
		Reaction reaction= reactionService.findReaction(reactionId);
		return new ResponseEntity <> (reaction,HttpStatus.OK);
		
	}
	
	@RequestMapping(value= "/reaction/{reactionId}", method= RequestMethod.DELETE)
	public void deleteReaction(@PathVariable("reactionId")long reactionId){
		reactionService.deleteReaction(reactionId);
	}
	
	@RequestMapping(value= "/reaction", method= RequestMethod.PUT)
	public ResponseEntity <Reaction> updateReaction(@RequestBody Reaction reaction) {
		return new ResponseEntity <> (reactionService.updateReaction(reaction),HttpStatus.OK);
		
	}
	
	@RequestMapping(value= "/reactions/findbyactnonciviqueId/{actNonCiviqueId}", method=RequestMethod.GET)
	public ResponseEntity<List<Reaction>> getReactionsByActNonCiviqueId(@PathVariable("actNonCiviqueId")long actNonCiviqueId)
	
	{
		List<Reaction> reactionList= reactionService.findReactionsByActNonCiviqueId(actNonCiviqueId);
		return new ResponseEntity<>(reactionList,HttpStatus.OK);
	}
	}