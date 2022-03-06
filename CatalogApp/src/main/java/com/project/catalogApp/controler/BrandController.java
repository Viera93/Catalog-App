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
@RequestMapping("/brands")
public class BrandController {

	@Autowired
	private BrandServiceImpl brandService;
	
	@Autowired
	private CategoryServiceImpl categoryService;

	@GetMapping
	public String getAllBrands(Model model) {
		List<Brand> brands = brandService.getAllBrands();
		model.addAttribute("brands", brands);
		return "brands";
	}

	@GetMapping("/new")
	public String showBrandForm(Model model) {
		List<Category>categories = categoryService.getAllCategories();
		model.addAttribute("brand", new Brand());
		model.addAttribute("categories", categories);
		return "brand_form";
	}

	@PostMapping("/save")
	public String saveBrand(Brand brand) {
		brandService.saveBrand(brand);
		return "redirect:/brands";
	}

	@GetMapping("/edit/{id}")
	public String editBrand(@PathVariable("id") Integer id, Model model) {
		Brand brand = brandService.findBrandById(id);
		model.addAttribute("brand", brand);
		
		List<Category>categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		return "brand_form";
	}

	@GetMapping("/delete/{id}")
	public String deleteBrand(@PathVariable("id") Integer id) {
		brandService.deleteBrandById(id);
		return "redirect:/brands";
	}

}
