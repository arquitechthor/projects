package com.arquitechthor.hexashop.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCTS")
public class ProductEntity {

	@Id
    @Column(name = "PRODUCT_ID")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
}
