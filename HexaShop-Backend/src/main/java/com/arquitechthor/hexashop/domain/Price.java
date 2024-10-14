package com.arquitechthor.hexashop.domain;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class Price {

    private Long id;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Product product;
    private Integer priority;
    private Double price;
    private String currency;

}
