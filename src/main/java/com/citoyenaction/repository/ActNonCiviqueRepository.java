package com.citoyenaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citoyenaction.domain.ActNonCivique;





@Repository("actNonCiviqueRepository")
public interface ActNonCiviqueRepository extends JpaRepository<ActNonCivique,Long> {
	
	@Query("select a from ActNonCivique a where a.user.userId=?1")
	List<ActNonCivique> findActNonCiviqueByUserId(long userId);
	
	@Query("select a from ActNonCivique a where a.statut=?1")
	List<ActNonCivique> findActNonCiviqueByStatut(String statut);
	
	

}
