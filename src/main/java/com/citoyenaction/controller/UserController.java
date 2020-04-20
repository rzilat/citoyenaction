package com.citoyenaction.controller;

import java.util.List;

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
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
		
	}
	
	@RequestMapping(value= "/user/{id}", method= RequestMethod.GET)
	public ResponseEntity <User> getUser(@PathVariable("id")long id){
		
		User user= userService.findUser(id);
		return new ResponseEntity <> (user,HttpStatus.OK);
		
	}
	@RequestMapping(value= "/user/{id}", method= RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id")long id){
		userService.deleteUser(id);
	}
	
	@RequestMapping(value= "/user", method= RequestMethod.PUT)
	public ResponseEntity <User> updateUser(@RequestBody User user) {
		return new ResponseEntity <> (userService.updateUser(user),HttpStatus.OK);
		
	}
	
}