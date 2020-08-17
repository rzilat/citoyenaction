package com.citoyenaction.service;

import java.util.List;

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
	
	public List<ActUpload> findAll(){
		return this.actUploadRepository.findAll();
		
	}
	
	

}
