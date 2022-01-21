package com.example.aula01.resources;

import com.example.aula01.model.entities.Product;
import com.example.aula01.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prods")
public class ProductResource {
	
	@Autowired
	private ProductService service;

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<Page<Product>> findAll(
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size
	){
		Page<Product> prod;

		if (page == null || size == null) {
			prod = service.findAll();
		} else {
			prod = service.findAll(page, size);
		}

		return ResponseEntity.ok().body(prod);
	}
}
