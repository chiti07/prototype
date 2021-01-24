package com.payu.prototype.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.payu.prototype.backend.models.entity.Product;

public interface IProductDao extends CrudRepository<Product, Long>{

}
