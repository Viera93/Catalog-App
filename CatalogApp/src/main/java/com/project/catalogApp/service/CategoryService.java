package com.project.catalogApp.service;

import java.util.List;

import com.project.catalogApp.model.Category;

public interface CategoryService {
	
	List<Category> getAllCategories();
	Category saveCategory(Category category);
	Category findCategoryById(Integer id);
	void deleteCategoryById(Integer id);

}
