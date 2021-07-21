package com.ngn.bms.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngn.bms.login.model.ProductModel;


public interface ProductModelRepository extends JpaRepository<ProductModel, Integer> {

	List<ProductModel> findByProductCategoryId(Integer productId);

}
