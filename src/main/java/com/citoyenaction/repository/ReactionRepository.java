package com.citoyenaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citoyenaction.domain.Reaction;



@Repository("reactionRepository")
public interface ReactionRepository extends JpaRepository<Reaction,Long> {
	
	@Query("select r from Reaction r where r.actNonCivique.actNonCiviqueId=?1")
	List<Reaction> findReactionsByActNonCiviqueId(long actNonCiviqueId);
	

}
