package com.arquitechthor.hexashop.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;
import java.util.Optional;

import com.arquitechthor.hexashop.application.PriceService;
import com.arquitechthor.hexashop.domain.Brand;
import com.arquitechthor.hexashop.domain.Price;
import com.arquitechthor.hexashop.domain.Product;
import com.arquitechthor.hexashop.infrastructure.adapter.in.command.GetPriceCommand;
import com.arquitechthor.hexashop.infrastructure.adapter.out.web.PriceResponse;
import com.arquitechthor.hexashop.port.out.GetPricePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class PriceServiceTest {
	
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    @InjectMocks
    private PriceService priceService;
    
    @Mock
    private GetPricePort getPricePort;
    
    private LocalDateTime applicationDate = LocalDateTime.now();
    private Price price;
    
    @BeforeEach
    public void setup() {
        price = Price.builder()
                .id(1L)
                .brand(new Brand(1L, "ZARA"))
                .product(new Product(35455L,"CHANNEL"))
                .priority(1)
                .priceList(1L)
                .price(1d)
                .build();
    }
    
    @Test
    public void getPriceByDateProductAndBrand_test() {
        
        doReturn(price).when(getPricePort).getPrice(applicationDate, 35455L,1L);

        GetPriceCommand priceRequest = GetPriceCommand.builder().applicationDate(applicationDate).productId(35455L).brandId(1L).build();

        PriceResponse priceResponse = priceService.getPriceByDateProductAndBrand(priceRequest);
        
        assertEquals(1L, priceResponse.getBrandId());
        assertEquals(1L, priceResponse.getPrice());
        assertEquals(applicationDate, priceResponse.getApplicationDate());
        assertEquals(1L, priceResponse.getPriceList());
        assertEquals(35455L, priceResponse.getProductId());
    }

}
