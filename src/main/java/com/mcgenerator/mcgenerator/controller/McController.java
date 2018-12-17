package com.mcgenerator.mcgenerator.controller;

import com.mcgenerator.mcgenerator.service.McService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class McController {

	@Autowired
	private McService mcService;

	@GetMapping("mc")
	public ResponseEntity<String> test(){
		mcService.attempt();
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}

}
