package com.arquitechthor.eshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitechthor.eshop.request.PriceRequest;
import com.arquitechthor.eshop.response.PriceResponse;
import com.arquitechthor.eshop.service.PriceService;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PriceController {
	
	private final PriceService priceService;

    @PostMapping("/price")
    public ResponseEntity<PriceResponse> getPrice(@RequestBody PriceRequest priceRequest) {
        
    	return new ResponseEntity<>(priceService.getPricebyDateProductAndBrand(priceRequest),HttpStatus.OK);

    }

}
