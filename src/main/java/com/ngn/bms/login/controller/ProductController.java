package com.ngn.bms.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngn.bms.login.model.ProductCategory;
import com.ngn.bms.login.model.ProductModel;
import com.ngn.bms.login.model.ProductOem;
import com.ngn.bms.login.model.ProductType;
import com.ngn.bms.login.repository.ProductCategoryRepo;
import com.ngn.bms.login.repository.ProductModelRepository;
import com.ngn.bms.login.repository.ProductOemRepo;
import com.ngn.bms.login.repository.ProductTypeRopository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102"})
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductOemRepo productOemRepo;
	
	@Autowired
	private ProductCategoryRepo productCategoryRepo;
	
	@Autowired
	private ProductModelRepository productModelRepository;
	
	@Autowired
	private ProductTypeRopository productTypeRepository;
	
	@GetMapping("/oem")
	public List<ProductOem> getAllOem(){
		return productOemRepo.findAll();
	}
	
	@GetMapping("/oem/{id}")
	public ProductOem getOemById(@PathVariable Integer id){
		return productOemRepo.findById(id).orElse(null);
	}
	@PostMapping("oem")
	public ProductOem addProductOem(@RequestBody ProductOem entity) {
		return productOemRepo.save(entity);
	}
	
	@GetMapping("/category")
	public List<ProductCategory> getProductCategory(){
		return productCategoryRepo.findAll();
	}
	
	@GetMapping("/category/{id}")
	public ProductCategory getProductCategoryById(@PathVariable Integer id){
		return productCategoryRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/categoryByOemId/{oemId}")
	public List<ProductCategory> getProductCategoryByUseId(@PathVariable Integer oemId){
		return productCategoryRepo.findByOemId(oemId);
	}
	
	@PostMapping("category")
	public ProductCategory addProductCategory(@RequestBody ProductCategory entity) {
		return productCategoryRepo.save(entity);
	}
	
	@GetMapping("/model")
	public List<ProductModel> getAllMOdel(){
		return productModelRepository.findAll();
	}
	
	@GetMapping("/product_type")//newly added KuengaPalden
	public List<ProductType> getAllProductType(){
		return productTypeRepository.findAll();
	}
	
	@GetMapping("/model/{id}")
	public ProductModel getModelById(@PathVariable Integer id){
		return productModelRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/modelByProductId/{productId}")
	public List<ProductModel> getModelByproductId(@PathVariable Integer productId){
		return productModelRepository.findByProductCategoryId(productId);
	}
	
	@PostMapping("model")
	public ProductModel addProductModel(@RequestBody ProductModel entity) {
		return productModelRepository.save(entity);
	}
}
