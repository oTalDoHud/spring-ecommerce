package com.example.aula01.resources;

import com.example.aula01.model.entities.Category;
import com.example.aula01.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<Page<Category>> findAll(){

		Page<Category> cat = service.findAll();
		
		return ResponseEntity.ok().body(cat);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping(path = "/pag/{pag}/size/{size}")
	public ResponseEntity<Page<Category>> findAllPag(
			@PathVariable int pag,
			@PathVariable int size){

		Page<Category> cat = service.findAllPag(pag, size);

		return ResponseEntity.ok().body(cat);
	}
}
