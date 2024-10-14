package com.arquitechthor.hexashop.infrastructure.adapter.out.web;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PriceResponse {
	
    private Long productId;
    private Long brandId;
    private Long priceList;
    private LocalDateTime applicationDate;
    private Double price;
    
}
