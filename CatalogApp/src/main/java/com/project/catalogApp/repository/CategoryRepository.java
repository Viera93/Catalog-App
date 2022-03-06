package com.project.catalogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.catalogApp.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
