package com.example.aula01.resources;

import com.example.aula01.model.entities.Category;
import com.example.aula01.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<Page<Category>> findAllPag(
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size){

		Page<Category> cat ;

		if(page == null || size == null){
			cat = service.findAll();
		}
		else{
			cat = service.findAll(page, size);
		}

		return ResponseEntity.ok().body(cat);
	}
}
