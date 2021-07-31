package com.dojo.greatideas.controllers;

import java.util.HashMap;
import com.dojo.greatideas.models.LoginUser;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.greatideas.models.User;
import com.dojo.greatideas.service.UserServiceImpl;



@RestController
public class UserController {
	@Autowired
	private UserServiceImpl service;
	@PostMapping(path="/register",consumes="application/json",produces="application/json")
	public ResponseEntity<String> RegisterUsers(@Valid @RequestBody User user){
		service.registerUser(user);
		return new ResponseEntity("user created successfully",HttpStatus.OK);
		
	}
	@GetMapping(path = "/user/new")
    public String displayUserCreatePage(Model model) {
       model.addAttribute("name","ernest");
		return "user"; 
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	   });
	   return errors;
	}
	@PostMapping(path="/login",consumes="application/json",produces="application/json")
	public ResponseEntity<String> LoginUser(@Valid @RequestBody LoginUser loginuser){
		String name = service.loginUser(loginuser);
		return new ResponseEntity(name,HttpStatus.OK);
		
	}
}


   
