package com.arquitechthor.hexashop.application;

import com.arquitechthor.hexashop.infrastructure.adapter.in.command.GetPriceCommand;
import com.arquitechthor.hexashop.infrastructure.adapter.out.web.PriceResponse;
import com.arquitechthor.hexashop.port.in.PricePort;
import com.arquitechthor.hexashop.port.out.GetPricePort;
import com.arquitechthor.hexashop.infrastructure.annotation.UseCase;
import com.arquitechthor.hexashop.domain.Price;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PriceService implements PricePort {
	
	private final GetPricePort getPricePort;
	
	@Override
	@Transactional
	public PriceResponse getPriceByDateProductAndBrand(GetPriceCommand priceRequest) {
		
		Price price = getPricePort.getPrice(
				priceRequest.getApplicationDate(), 
				priceRequest.getProductId(),
				priceRequest.getBrandId());

		PriceResponse priceResponse = PriceResponse.builder()
            		.price(price.getPrice())
            		.priceList(price.getPriceList())
            		.applicationDate(priceRequest.getApplicationDate())
            		.brandId(priceRequest.getBrandId())
            		.productId(priceRequest.getProductId())
            		.build();

        return priceResponse;
		
	}
}
