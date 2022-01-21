package com.example.aula01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.aula01.model.entities.Category;
import com.example.aula01.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Category findById(Integer id) {
		Optional<Category> cat = categoryRepo.findById(id);
		return cat.get();
	}
	
	public Page<Category> findAll(){
		PageRequest pag = PageRequest.of(0, 100);

		return categoryRepo.findAll(pag);
	}

	public Page<Category> findAll(int pag, int size) {
		PageRequest page = PageRequest.of(pag, size);

		return categoryRepo.findAll(page);
	}
}
