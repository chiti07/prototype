package com.payu.prototype.backend.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payu.prototype.backend.models.entity.Product;
import com.payu.prototype.backend.models.services.IProductService;

@RestController
@RequestMapping("/stock-api")
public class ProductRestController {

	@Autowired
	private IProductService productService;

	@GetMapping("/products")
	public List<Product> index() {
		return productService.findall();

	}

	@GetMapping("/products/{id}")
	public Product show(@PathVariable Long id) {
		return productService.findById(id);
	}

	@PostMapping("/products")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product producto) {
		return productService.save(producto);
	}
	
	@PutMapping("/products/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		Product currentProduct = productService.findById(id);
		
		currentProduct.setDescription(product.getDescription());
		currentProduct.setName(product.getName());
		currentProduct.setPrice(product.getPrice());
		currentProduct.setAmount(product.getAmount());
		
		return productService.save(currentProduct);
		
	}
	
	@DeleteMapping("/products/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}

}
