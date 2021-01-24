package com.payu.prototype.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payu.prototype.backend.models.dao.IProductDao;
import com.payu.prototype.backend.models.entity.Product;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findall() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	@Transactional
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return productDao.findById(id).orElse(null);
	}

}
