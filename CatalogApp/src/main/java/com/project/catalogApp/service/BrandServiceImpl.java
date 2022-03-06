package com.project.catalogApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.catalogApp.model.Brand;
import com.project.catalogApp.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandRepository brandRepo;

	@Override
	public List<Brand> getAllBrands() {
		return brandRepo.findAll();
	}

	@Override
	public Brand saveBrand(Brand brand) {
		return brandRepo.save(brand);
	}

	@Override
	public Brand findBrandById(Integer id) {
		return brandRepo.findById(id).get();
	}

	@Override
	public void deleteBrandById(Integer id) {
		brandRepo.deleteById(id);

	}

}
