package com.citoyenaction.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.citoyenaction.domain.ActUpload;


@Repository("actUploadRepository")
public interface ActUploadRepository extends JpaRepository<ActUpload,Long> {
	//ActUpload findByActNonCiviqueIdAndUploadId(ActNonCivique actNonCiviqueId,long uploadId);
	//List<ActUpload> findByActNonCiviqueId(ActNonCivique actNonCiviqueId);

}
