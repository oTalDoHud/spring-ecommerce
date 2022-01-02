package com.example.aula01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}

}
