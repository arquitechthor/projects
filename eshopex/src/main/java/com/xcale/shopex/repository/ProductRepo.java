package com.xcale.shopex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcale.shopex.model.Product;

public interface ProductRepo extends JpaRepository <Product, Long>{
	
}
