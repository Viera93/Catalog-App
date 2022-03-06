package com.project.catalogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.catalogApp.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
