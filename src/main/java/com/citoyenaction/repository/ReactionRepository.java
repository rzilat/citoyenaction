package com.citoyenaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citoyenaction.domain.Reaction;

@Repository("reactionRepository")
public interface ReactionRepository extends JpaRepository<Reaction,Long> {
	

}
