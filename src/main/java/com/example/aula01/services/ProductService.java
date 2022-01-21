package com.example.aula01.services;

import com.example.aula01.model.entities.Product;
import com.example.aula01.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public Product findById(Integer id) {
		Optional<Product> cat = productRepo.findById(id);
		return cat.get();
	}
	
	public Page<Product> findAll(){
		PageRequest pag = PageRequest.of(0, 100);

		return productRepo.findAll(pag);
	}

	public Page<Product> findAll(int page, int size){
		PageRequest pag = PageRequest.of(page, size);

		return productRepo.findAll(pag);
	}
}
