package com.project.catalogApp.service;

import java.util.List;

import com.project.catalogApp.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	Product saveProduct(Product product);
	Product findProductById(Integer id);
	void deleteProductById(Integer id);

}
