package com.arquitechthor.eshop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRICES")
public class Price {
    
    @Id
    @Column(name = "PRICE_ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brand brand;
    
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    
    @Column(name = "PRICE_LIST")
    private Long priceList;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;
    
    @Column(name = "PRIORITY")
    private Integer priority;
    
    @Column(name = "PRICE")
    private Double price;
    
    @Column(name = "CURR")
    private String currency;

}
