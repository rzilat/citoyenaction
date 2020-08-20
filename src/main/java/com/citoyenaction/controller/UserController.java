package com.citoyenaction.controller;

import java.util.List;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citoyenaction.domain.User;
import com.citoyenaction.service.UserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


@RestController
@RequestMapping(value= "/citoyenaction")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= "/users", method= RequestMethod.GET)
	public ResponseEntity <List<User>> getAllUsers(){
		
		List<User> users= userService.findAll();
		return new ResponseEntity <> (users,HttpStatus.OK);
		
	}
	
	@RequestMapping(value= "/user", method= RequestMethod.POST)
	public ResponseEntity <User> addUser(@RequestBody User user) {
		return new ResponseEntity<> (userService.addUser(user),HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value= "/user/{userId}", method= RequestMethod.GET)
	public ResponseEntity <User> getUser(@PathVariable("userId")long userId){
		
		User user= userService.findUser(userId);
		return new ResponseEntity <> (user,HttpStatus.OK);
	}
	
	@RequestMapping(value= "/user/{userId}", method= RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId")long userId){
		userService.deleteUser(userId);
	}
	
	@RequestMapping(value= "/user", method= RequestMethod.PUT)
	public ResponseEntity <User> updateUser(@RequestBody User user) {
		return new ResponseEntity <> (userService.updateUser(user),HttpStatus.OK);
	}
	
	@RequestMapping(value= "/loginuser/{email}/{password}", method= RequestMethod.GET)
	public ResponseEntity <User> loginUser(@PathVariable("email")String email,@PathVariable("password")String password){
		
		User user= userService.loginUser(email, password);
		if(user != null) {
			return new ResponseEntity<> (user,HttpStatus.OK);
		}else {
			return new ResponseEntity <> (null,HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}