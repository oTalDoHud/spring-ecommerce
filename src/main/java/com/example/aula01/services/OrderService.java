package com.example.aula01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula01.model.entities.Order;
import com.example.aula01.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public Order findById(Integer id) {
		Optional<Order> order = orderRepo.findById(id);
		return order.get();
	}
	
	public List<Order> findAll() {
		List<Order> listOrder = orderRepo.findAll();
		return listOrder;
	}
}
