package com.example.aula01.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula01.model.entities.Category;
import com.example.aula01.services.CategoryService;

@RestController
@RequestMapping(value = "cat")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> cat = service.findAll();
		
		return ResponseEntity.ok().body(cat);
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.findById(id));
	}
}
