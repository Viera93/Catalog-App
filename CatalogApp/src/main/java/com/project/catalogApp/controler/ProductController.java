package com.project.catalogApp.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.catalogApp.model.Category;
import com.project.catalogApp.model.Product;
import com.project.catalogApp.service.CategoryServiceImpl;
import com.project.catalogApp.service.ProductServiceImpl;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private CategoryServiceImpl categoryService;	
	
	@GetMapping()
	public String getAllProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/new")
	public String showProductForm(Model model) {
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("product", new Product());
		model.addAttribute("categories",categories);
		return "product_form";
	}
	
	@PostMapping("/save")
	public String saveProduct(Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model model) {
		Product product = productService.findProductById(id);
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories",categories);
		model.addAttribute("product", product);
		return "product_form";
	}
	
	@GetMapping("delete/{id}")
		public String deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProductById(id);
			return "redirect:/products";
	}
	

}
