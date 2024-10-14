package com.arquitechthor.hexashop.infrastructure.adapter.in.web;

import com.arquitechthor.hexashop.infrastructure.adapter.in.command.GetPriceCommand;
import com.arquitechthor.hexashop.infrastructure.adapter.out.web.PriceResponse;
import com.arquitechthor.hexashop.port.in.PricePort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PriceController {
	
	private final PricePort pricePort;

    @PostMapping("/get-price")
    public ResponseEntity<PriceResponse> getPrice(@RequestBody GetPriceCommand getPriceCommand) {
        PriceResponse response = pricePort.getPriceByDateProductAndBrand(getPriceCommand);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
