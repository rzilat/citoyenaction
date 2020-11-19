package com.citoyenaction.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.citoyenaction.domain.ActNonCivique;
import com.citoyenaction.domain.ActUpload;
import com.citoyenaction.service.ActNonCiviqueService;
import com.citoyenaction.service.ActUploadService;


@RestController
@RequestMapping(value= "/citoyenaction")
public class ActUploadController {
	
	@Autowired
	private ActUploadService actUploadService;
	
	@Autowired
	private ActNonCiviqueService actNonCiviqueService;
	
	
	@RequestMapping(value= "/actupload", method= RequestMethod.POST)
	public ResponseEntity <String> saveActUpload(@RequestParam long actNonCiviqueId, @RequestParam String description, @RequestParam MultipartFile file ) throws IOException {
		String fileName = file.getOriginalFilename();
		byte[] fileData = file.getBytes();
		ActUpload actUpload = new ActUpload();
		ActNonCivique actNonCivique = actNonCiviqueService.findActNonCivique(actNonCiviqueId);
		actUpload.setActNonCivique(actNonCivique);
		actUpload.setFileName(fileName);
		actUpload.setFileData(fileData);
		actUpload = actUploadService.saveActUpload(actUpload);
		return new ResponseEntity<> ("file uploaded",HttpStatus.OK);
	}
	
	
	@RequestMapping(value= "/actuploads", method= RequestMethod.GET)
	public ResponseEntity <List<ActUpload>> getAllActUploads(){
		List<ActUpload> actUploads= actUploadService.findAll();
		return new ResponseEntity <> (actUploads,HttpStatus.OK) ;
		}

}
