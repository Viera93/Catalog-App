package com.project.catalogApp.service;

import java.util.List;

import com.project.catalogApp.model.Brand;

public interface BrandService {
	
	List<Brand>getAllBrands();
	Brand saveBrand(Brand brand);
	Brand findBrandById(Integer id);
	void deleteBrandById(Integer id);

}
