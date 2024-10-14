package com.xcale.shopex.request;

import java.util.Set;

import lombok.Data;

@Data
public class CartRequest {
	private Set<CartItemRequest> cartItem;
}
