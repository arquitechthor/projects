package com.xcale.shopex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcale.shopex.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
