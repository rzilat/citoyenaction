package com.citoyenaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citoyenaction.domain.User;
import com.citoyenaction.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		
		return this.userRepository.save(user);
		
	}
	
	public User findUser(long userId) {
		
	return this.userRepository.getOne(userId) ;
		
	}
	
	public List<User> findAll(){
		return this.userRepository.findAll();
		
	}
	
	public void deleteUser(long userId) {
		 userRepository.deleteById(userId);
		
	}
	
	public User updateUser(User user) {
		return this.userRepository.save(user);
		
	}

	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
		return this.userRepository.findUserByEmailAndPassword(email,password) ;
	}
}
