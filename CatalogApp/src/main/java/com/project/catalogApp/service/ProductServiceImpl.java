package com.project.catalogApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.catalogApp.model.Product;
import com.project.catalogApp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		 return productRepo.save(product);
	}

	@Override
	public Product findProductById(Integer id) {
		return productRepo.findById(id).get();
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepo.deleteById(id);
		
	}

	 
	

	 

}
