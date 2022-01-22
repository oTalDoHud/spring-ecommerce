package com.example.aula01.resources;

import com.example.aula01.model.entities.User;
import com.example.aula01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<Page<User>> findAll(
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size){
		
		Page<User> users;

		if(page != null || size != null){
			users = service.findAll(page, size);
		}
		else{
			users = service.findAll();
		}

		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<User> postInsert (@RequestBody User user){
		user = service.insertUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(user);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<User> deleteById(@PathVariable Integer id){
		User user = service.deleteById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
		user = service.updateUser(id, user);
		return ResponseEntity.ok().body(user);
	}
}