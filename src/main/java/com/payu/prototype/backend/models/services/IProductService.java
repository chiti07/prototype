package com.payu.prototype.backend.models.services;

import java.util.List;

import com.payu.prototype.backend.models.entity.Product;

public interface IProductService {

	public List<Product> findall();
	
	public Product save(Product product);
	
	public void delete(Long id);
	
	public Product findById(Long id);
	
}
