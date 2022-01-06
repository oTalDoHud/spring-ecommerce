package com.example.aula01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula01.model.entities.User;
import com.example.aula01.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User findById(Integer id) {
		Optional<User> user =  userRepo.findById(id);
		return user.get();
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User insertUser(User user) {
		return userRepo.save(user);
	}
	
	public User deleteById(Integer id) {
		Optional<User> user = userRepo.findById(id);
		
		userRepo.deleteById(id);
		
		return user.get();
	}
	
	public User updateUser(Integer id, User user) {
		Optional<User> entity = userRepo.findById(id);
		updateEntity(entity.get(), user);
		return userRepo.save(entity.get());
	}

	private void updateEntity(User entity, User user) {
		entity.setName(user.getEmail());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
}
