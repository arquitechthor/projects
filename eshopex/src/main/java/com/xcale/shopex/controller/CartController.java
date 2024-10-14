package com.xcale.shopex.controller;

import java.util.HashSet;
import java.util.Set;

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

import com.xcale.shopex.model.Cart;
import com.xcale.shopex.model.CartItem;
import com.xcale.shopex.request.CartItemRequest;
import com.xcale.shopex.request.CartRequest;
import com.xcale.shopex.service.CartService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/cart")
@Tag(name = "Cart Controller")
public class CartController {

	@Autowired
	CartService service;

	@GetMapping(produces= {"application/json"})
	public ResponseEntity<Iterable<Cart>> findAll() {
		Iterable<Cart> carts = service.get();
		return ResponseEntity.ok(carts);
	}
	

	@GetMapping(value = "/{id}", produces= {"application/json"})
	public ResponseEntity<Cart> findById(@PathVariable Long id) {
		
		Cart cart = service.findById(id);
		if(cart == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} 
		else {

			return ResponseEntity.ok(cart);
		}
		
	}
	
//	@GetMapping(path = "/dummy", produces= {"application/json"})
//	public ResponseEntity<Cart> getDummyCart() {
//		
//		Cart cart = new Cart();
//		CartItem cartItem = new CartItem();
//		Set<CartItem> items = new HashSet<>();
//		
//		cartItem.setId(1L);
//		cartItem.setProductId(2L);
//		cartItem.setQuantity(4);
//		
//		items.add(cartItem);
//		
//		cartItem.setId(2L);
//		cartItem.setProductId(1L);
//		cartItem.setQuantity(19);
//		
//		items.add(cartItem);
//		
//		cart.setId(1L);
//		cart.setCartItem(items);
//		
//		
//
//		return ResponseEntity.ok(cart);
//		
//		
//	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<Cart> save(@RequestBody CartRequest cartRQ) {
		
		if(cartRQ == null) {
			return ResponseEntity.badRequest().build();
		}
		
		Cart cart = new Cart();
		Set <CartItem> cartItems = new HashSet<>();
		
		for (CartItemRequest currentCartItemRequest : cartRQ.getCartItem()) {
			CartItem cartItem = new CartItem();
			cartItem.setProductId(currentCartItemRequest.getProductId());
			cartItem.setQuantity(currentCartItemRequest.getQuantity());
			cartItems.add(cartItem);
		}
		
		cart.setCartItem(cartItems);
		
		cart = service.save(cart);
		
		return ResponseEntity.ok(cart);
	}
	
	@PutMapping(produces = "application/json")
	public ResponseEntity<Cart> update(@RequestBody Cart cart) {
		
		if(cart == null) {
			return ResponseEntity.badRequest().build();
		}
		
		cart = service.update(cart);
		if (cart == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(cart);
	}
	
	@DeleteMapping(value = "/{id}", produces= {"application/json"})
	public boolean delete(@PathVariable Long id) {
		
		return service.deleteById(id);
	  }
}
