package com.xcale.shopex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcale.shopex.model.Product;
import com.xcale.shopex.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo repo;
	
	public List<Product> get() {
		ArrayList<Product> r =  new ArrayList<>();
		CollectionUtils.addAll(r, repo.findAll());
		return r;
	}
	
	public Product save(Product product) {
		return repo.save(product);
	}
	
	public Product findById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public boolean deleteById(Long id) {
		try {
			Optional<Product> result = repo.findById(id);
			if(result.isPresent()) {
				repo.delete(result.get());
				return true;
			}
			else {
				return false;
			}
		} 
		catch (Exception e) {
			return false;
		}
	}

	public Product update(Product product) {
		
		Product foundProduct = repo.findById(product.getId()).orElse(null);
		
		if (foundProduct != null){
			foundProduct.setName(product.getName());
			foundProduct.setPrice(product.getPrice());
			return repo.save(foundProduct);
		}
		
		return null;
	}
}
