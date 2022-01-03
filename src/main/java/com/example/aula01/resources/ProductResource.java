package com.example.aula01.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula01.model.entities.Product;
import com.example.aula01.services.ProductService;

@RestController
@RequestMapping(value = "prod")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> cat = service.findAll();
		
		return ResponseEntity.ok().body(cat);
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.findById(id));
	}
}
