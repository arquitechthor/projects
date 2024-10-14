package com.arquitechthor.hexashop.infrastructure.adapter.in.command;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetPriceCommand {

    private Long brandId;
    private Long productId;
    private LocalDateTime applicationDate;
    
}
