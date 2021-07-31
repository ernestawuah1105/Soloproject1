package com.dojo.greatideas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.greatideas.models.Idea;
import com.dojo.greatideas.models.User;
import com.dojo.greatideas.service.IdeaServiceImpl;



@RestController
public class IdeaController {
	@Autowired
private IdeaServiceImpl service;
	@PostMapping(path="/idea",consumes="application/json",produces="application/json")
	public ResponseEntity<String> createNewIdea(@Valid @RequestBody  Idea idea){
		service.registerIdea(idea);
		return new ResponseEntity("..",HttpStatus.OK);
		
	}	
	@GetMapping(path = "/ideas")
    public ResponseEntity<List<Idea>>getIdeas() {
      List<Idea> ideas = service.getAllIdeas();
		return new ResponseEntity(ideas,HttpStatus.OK);
        
	}
}

	
