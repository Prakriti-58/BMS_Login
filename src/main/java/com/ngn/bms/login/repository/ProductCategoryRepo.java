package com.ngn.bms.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngn.bms.login.model.ProductCategory;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer>{

	List<ProductCategory> findByOemId(Integer oemId);

}
