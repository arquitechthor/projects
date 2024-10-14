package com.arquitechthor.hexashop.adapter.in;

import com.arquitechthor.hexashop.infrastructure.adapter.in.command.GetPriceCommand;
import com.arquitechthor.hexashop.infrastructure.adapter.in.web.PriceController;
import com.arquitechthor.hexashop.infrastructure.adapter.out.web.PriceResponse;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;

@SpringBootTest
@RequiredArgsConstructor
public class PriceControllerTest {

	@Autowired
	private PriceController priceController;

	@Test
	void getPrice_test1() {

		// Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)

		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

		GetPriceCommand priceRequest = GetPriceCommand.builder().brandId(1L).productId(35455L).applicationDate(applicationDate).build();
		ResponseEntity<PriceResponse> priceResponse = priceController.getPrice(priceRequest);
		
		if (priceResponse.getStatusCode() == HttpStatus.OK) {
			print(1, priceResponse.getBody());
			
			PriceResponse price = priceResponse.getBody();
			if (price != null) {
				assertEquals(price.getBrandId(), 1L); // Brand ID
				assertEquals(price.getProductId(), 35455L); // Product ID
				assertEquals(price.getApplicationDate(), applicationDate);
				assertEquals(price.getPriceList(), 1L); // Final Price
				assertEquals(price.getPrice(), 35.5); // Price List
			}
		} else {
			System.err.println(priceResponse.getStatusCode());
		}
	}

	@Test
	void getPrice_test2() {
		
        //  	Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	    
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);

		GetPriceCommand priceRequest = GetPriceCommand.builder().brandId(1L).productId(35455L).applicationDate(applicationDate).build();
		ResponseEntity<PriceResponse> priceResponse = priceController.getPrice(priceRequest);
		
		if (priceResponse.getStatusCode() == HttpStatus.OK) {
			print(1, priceResponse.getBody());
			
			PriceResponse price = priceResponse.getBody();
			if (price != null) {
				assertEquals(price.getBrandId(), 1L); // Brand ID
				assertEquals(price.getProductId(), 35455L); // Product ID
				assertEquals(price.getApplicationDate(), applicationDate);
				assertEquals(price.getPriceList(), 2L); // Final Price
				assertEquals(price.getPrice(), 25.45); // Price List
			}
		} else {
			System.err.println(priceResponse.getStatusCode());
		}
	}
	
	@Test
	void getPrice_test3() {
		
        //  	Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	    
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);

		GetPriceCommand priceRequest = GetPriceCommand.builder().brandId(1L).productId(35455L).applicationDate(applicationDate).build();
		ResponseEntity<PriceResponse> priceResponse = priceController.getPrice(priceRequest);
		
		if (priceResponse.getStatusCode() == HttpStatus.OK) {
			print(1, priceResponse.getBody());
			
			PriceResponse price = priceResponse.getBody();
			if (price != null) {
				assertEquals(price.getBrandId(), 1L); // Brand ID
				assertEquals(price.getProductId(), 35455L); // Product ID
				assertEquals(price.getApplicationDate(), applicationDate);
				assertEquals(price.getPriceList(), 1L); // Final Price
				assertEquals(price.getPrice(), 35.5); // Price List
			}
		} else {
			System.err.println(priceResponse.getStatusCode());
		}
	}
	
	@Test
	void getPrice_test4() {
		
        //  	Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
	    
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);

		GetPriceCommand priceRequest = GetPriceCommand.builder().brandId(1L).productId(35455L).applicationDate(applicationDate).build();
		ResponseEntity<PriceResponse> priceResponse = priceController.getPrice(priceRequest);
		
		if (priceResponse.getStatusCode() == HttpStatus.OK) {
			print(1, priceResponse.getBody());
			
			PriceResponse price = priceResponse.getBody();
			if (price != null) {
				assertEquals(price.getBrandId(), 1L); // Brand ID
				assertEquals(price.getProductId(), 35455L); // Product ID
				assertEquals(price.getApplicationDate(), applicationDate);
				assertEquals(price.getPriceList(), 3L); // Final Price
				assertEquals(price.getPrice(), 30.5); // Price List
			}
		} else {
			System.err.println(priceResponse.getStatusCode());
		}
	}
	
	@Test
	void getPrice_test5() {
		
        //  	Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
	    
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);

		GetPriceCommand priceRequest = GetPriceCommand.builder().brandId(1L).productId(35455L).applicationDate(applicationDate).build();
		ResponseEntity<PriceResponse> priceResponse = priceController.getPrice(priceRequest);
		
		if (priceResponse.getStatusCode() == HttpStatus.OK) {
			print(1, priceResponse.getBody());
			
			PriceResponse price = priceResponse.getBody();
			if (price != null) {
				assertEquals(price.getBrandId(), 1L); // Brand ID
				assertEquals(price.getProductId(), 35455L); // Product ID
				assertEquals(price.getApplicationDate(), applicationDate);
				assertEquals(price.getPriceList(), 4L); // Final Price
				assertEquals(price.getPrice(), 38.95); // Price List
			}
		} else {
			System.err.println(priceResponse.getStatusCode());
		}
	}

	private void print(int testNumber, PriceResponse priceResponse) {
		System.out.println(
				"Test "+ testNumber+":"+
				"petición a las "+priceResponse.getApplicationDate().getHour()+":"+priceResponse.getApplicationDate().getMinute()+
				" del dia "+priceResponse.getApplicationDate().getDayOfMonth()+
				" del producto "+priceResponse.getProductId()+
				" para la brand "+priceResponse.getBrandId());
		
	}
}
