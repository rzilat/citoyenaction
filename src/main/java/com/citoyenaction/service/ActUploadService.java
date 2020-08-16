package com.citoyenaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.citoyenaction.domain.ActUpload;

import com.citoyenaction.repository.ActUploadRepository;


@Service
public class ActUploadService {
	
	@Autowired
	private ActUploadRepository actUploadRepository;
	
	public ActUpload saveActUpload(ActUpload actUpload) {
		return actUploadRepository.save(actUpload) ;
		
	}
	
	

}
