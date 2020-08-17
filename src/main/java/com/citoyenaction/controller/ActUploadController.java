package com.citoyenaction.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.citoyenaction.domain.ActUpload;
import com.citoyenaction.service.ActUploadService;


@RestController
public class ActUploadController {
	
	@Autowired
	private ActUploadService actUploadService;
	
	@RequestMapping(value= "/actupload", method= RequestMethod.POST,headers = "content-type=multipart/*")
	public ResponseEntity <ActUpload> saveActUpload(HttpServletRequest request, @RequestPart(required = true) MultipartFile file ) throws IOException {
		String fileName = file.getOriginalFilename();
		byte[] fileData = file.getBytes();
		ActUpload actUpload = new ActUpload();
		actUpload.setFileName(fileName);
		actUpload.setFileData(fileData);
		actUpload = actUploadService.saveActUpload(actUpload);
		//actUpload.toString();
		return new ResponseEntity<> (actUpload,HttpStatus.OK);
		
	}

}
