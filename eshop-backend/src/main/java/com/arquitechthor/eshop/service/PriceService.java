package com.arquitechthor.eshop.service;

import com.arquitechthor.eshop.request.PriceRequest;
import com.arquitechthor.eshop.response.PriceResponse;

public interface PriceService {

	PriceResponse getPricebyDateProductAndBrand(PriceRequest priceRequest);

}
