package com.example.aula01.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula01.model.entities.Order;
import com.example.aula01.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderResource {
	
	@Autowired
	private OrderService service;

	@GetMapping(path = "/all")
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> users = service.findAll();
		
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.findById(id));
	}
}
