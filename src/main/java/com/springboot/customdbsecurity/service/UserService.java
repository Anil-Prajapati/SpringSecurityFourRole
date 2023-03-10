package com.springboot.customdbsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.customdbsecurity.Repository.UsersRepository;
import com.springboot.customdbsecurity.model.Users;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	//this is the getting all data into the data bases
	public Iterable<Users> getAll(){
		
		return usersRepository.findAll();
	}
	
	//this is the getting single data into the data bases
	public Users getSingle(Integer id) {
		
		return usersRepository.findById(id).orElse(new Users());
	}
	
	
	

}
