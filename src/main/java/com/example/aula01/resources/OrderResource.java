package com.example.aula01.resources;

import com.example.aula01.model.entities.Order;
import com.example.aula01.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<Page<Order>> findAllPag(
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size
			){

		Page<Order> order;

		if (page == null || size == null) {
			order = service.findAll();
		} else {
			order = service.findAll(page, size);
		}

		return ResponseEntity.ok().body(order);
	}

// Solução Lucas
//	@GetMapping
//	public ResponseEntity<Page<Order>> findAllPag(Pageable pageable){
//
//		Page<Order> cat = service.findAllPag(pageable);
//
//		return ResponseEntity.ok().body(cat);
//	}
}
