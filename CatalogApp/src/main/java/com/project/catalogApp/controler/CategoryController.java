package com.project.catalogApp.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.catalogApp.model.Brand;
import com.project.catalogApp.model.Category;
import com.project.catalogApp.service.BrandServiceImpl;
import com.project.catalogApp.service.CategoryServiceImpl;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired BrandServiceImpl brandService;

	@GetMapping()
	public String getAllCategories(Model model) {
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		return "categories";
	}
	
	@GetMapping("/new")
	public String showCategoryForm(Model model) {
		List<Brand>brands = brandService.getAllBrands();
		model.addAttribute("category", new Category());
		model.addAttribute("brands", brands);
		return "category_form";
	}
	
	@PostMapping("/save")
	public String saveCategory(Category category) {
		categoryService.saveCategory(category);
		return "redirect:/categories";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") Integer id, Model model) {
		Category category = categoryService.findCategoryById(id);
		model.addAttribute("category", category);
		List<Brand>brands = brandService.getAllBrands();
		model.addAttribute("brands", brands);
		return "category_form";
	}
	
	@GetMapping("delete/{id}")
		public String deleteCategory(@PathVariable("id") Integer id) {
		categoryService.deleteCategoryById(id);
			return "redirect:/categories";
	}

}
