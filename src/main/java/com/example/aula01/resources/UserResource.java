package com.example.aula01.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula01.model.entities.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@GetMapping()
	public ResponseEntity<User> findAll(){
		User user = new User(1, "Hudson", "Hudson@gmail.com"
				, "11932165703", "HudsonLucas2000");
		return ResponseEntity.ok().body(user);
	}
}
