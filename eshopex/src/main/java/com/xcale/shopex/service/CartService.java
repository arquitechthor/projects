package com.xcale.shopex.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.CollectionUtils;

import com.xcale.shopex.model.Cart;
import com.xcale.shopex.repository.CartRepo;

@Service
public class CartService{
	
	@Autowired
	CartRepo repo;
	
	@Value("${xcale.cart.ttl}")
	private long TTL;
	
	public List<Cart> get() {
		ArrayList<Cart> r =  new ArrayList<>();
		CollectionUtils.addAll(r, repo.findAll());
		return r;
	}
	
	public Cart save(Cart cart) {
		
        cart.setExpiryDate(LocalDateTime.ofInstant
        		(Instant.ofEpochMilli(System.currentTimeMillis() + 
        				(TTL * 60000)), ZoneId.systemDefault()));

		return repo.save(cart);
	}
	
	public Cart findById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public boolean deleteById(Long id) {
		try {
			Optional<Cart> result = repo.findById(id);
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

	public Cart update(Cart cart) {
		Cart foundCart = repo.findById(cart.getId()).orElse(null);
		
		if (foundCart != null){
			foundCart.setCartItem(cart.getCartItem());
			return repo.save(foundCart);
		}
		
		return null;
	}
}
