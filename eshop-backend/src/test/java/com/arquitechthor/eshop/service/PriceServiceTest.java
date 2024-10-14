package com.arquitechthor.eshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.arquitechthor.eshop.entity.Brand;
import com.arquitechthor.eshop.entity.Price;
import com.arquitechthor.eshop.entity.Product;
import com.arquitechthor.eshop.repository.PriceRepository;
import com.arquitechthor.eshop.request.PriceRequest;
import com.arquitechthor.eshop.response.PriceResponse;
import com.arquitechthor.eshop.service.impl.PriceServiceImpl;

public class PriceServiceTest {
	
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    @InjectMocks
    private PriceServiceImpl priceService;
    
    @Mock
    private PriceRepository priceRepository;
    
    private LocalDateTime applicationDate = LocalDateTime.now();
    private Price price;
    
    @BeforeEach
    public void setup() {
        price = new Price();
        int UNO = 1;
            price.setId(Long.valueOf(UNO));
            price.setPriority(UNO);
            price.setPriceList(Long.valueOf(UNO));
            price.setPrice(Double.valueOf(UNO));
            price.setProduct(new Product(35455L,"CHANNEL"));
            price.setBrand(new Brand(1L, "ZARA"));
    }
    
    @Test
    public void getPricebyDateProductAndBrand_test() {
        
        doReturn(Optional.of(price)).when(priceRepository).findFirstbyBrandProductAndDate(applicationDate, 35455L,1L);
        
        PriceRequest priceRequest = PriceRequest.builder().applicationDate(applicationDate).productId(35455L).brandId(1L).build();
        
        PriceResponse priceResponse = priceService.getPricebyDateProductAndBrand(priceRequest);
        
        assertEquals(1L, priceResponse.getBrandId());
        assertEquals(1L, priceResponse.getPrice());
        assertEquals(applicationDate, priceResponse.getApplicationDate());
        assertEquals(1L, priceResponse.getPriceList());
        assertEquals(35455L, priceResponse.getProductId());
    }

}
