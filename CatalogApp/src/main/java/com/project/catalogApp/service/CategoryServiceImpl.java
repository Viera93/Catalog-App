package com.project.catalogApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.catalogApp.model.Category;
import com.project.catalogApp.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category findCategoryById(Integer id) {
		return categoryRepo.findById(id).get();
	}

	@Override
	public void deleteCategoryById(Integer id) {
		categoryRepo.deleteById(id);
		
	}

}
