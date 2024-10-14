package com.xcale.shopex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcale.shopex.model.Product;
import com.xcale.shopex.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/product")
@Tag(name = "Product Controller")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping(produces= {"application/json"})
	public ResponseEntity<Iterable<Product>> findAll() {
		Iterable<Product> towns = service.get();
		return ResponseEntity.ok(towns);
	}
	

	@GetMapping(value = "/{id}", produces= {"application/json"})
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		
		Product product = service.findById(id);
		if(product == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} 
		else {

			return ResponseEntity.ok(product);
		}
		
	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		
		if(product == null) {
			return ResponseEntity.badRequest().build();
		}
		product = service.save(product);
		
		return ResponseEntity.ok(product);
	}
	
	@PutMapping(produces = "application/json")
	public ResponseEntity<Product> update(@RequestBody Product product) {
		
		if(product == null) {
			return ResponseEntity.badRequest().build();
		}
		
		product = service.update(product);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping(value = "/{id}", produces= {"application/json"})
	public boolean delete(@PathVariable Long id) {
		
		return service.deleteById(id);
	  }
}
