package com.example.aula01.services;

import com.example.aula01.model.entities.Order;
import com.example.aula01.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public Order findById(Integer id) {
		Optional<Order> order = orderRepo.findById(id);
		return order.get();
	}

    public Page<Order> findAll(int page, int size) {
		PageRequest pag = PageRequest.of(page, size);

		return orderRepo.findAll(pag);
    }

	public Page<Order> findAll() {
		PageRequest pag = PageRequest.of(0, 100);

		return orderRepo.findAll(pag);
	}

//	public Page<Order> findAllPag(Pageable pageable) {
//
//		return orderRepo.findAll(pageable);
//	}

}
