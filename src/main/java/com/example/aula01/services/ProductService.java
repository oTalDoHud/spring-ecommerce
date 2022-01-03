package com.example.aula01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula01.model.entities.Product;
import com.example.aula01.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public Product findById(Integer id) {
		Optional<Product> cat = productRepo.findById(id);
		return cat.get();
	}
	
	public List<Product> findAll(){
		return productRepo.findAll();
	}

}
