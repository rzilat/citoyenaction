package com.citoyenaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citoyenaction.domain.Reaction;
import com.citoyenaction.repository.ReactionRepository;

@Service
public class ReactionService {
	
	@Autowired
	private ReactionRepository reactionRepository;
	
	public void addReaction(Reaction reaction) {
		
		reactionRepository.save(reaction);
		
	}
	
	public Reaction findReaction(long reactionId){
		return this.reactionRepository.getOne(reactionId);
		
	}
	
	public List<Reaction> findAll(){
		return this.reactionRepository.findAll();
		
	}
	
	public void deleteReaction(long reactionId) {
		reactionRepository.deleteById(reactionId);
	}
	
	public Reaction updateReaction(Reaction reaction) {
		return this.reactionRepository.save(reaction);
		
	}
	

}
