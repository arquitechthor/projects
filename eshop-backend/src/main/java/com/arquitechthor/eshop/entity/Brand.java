package com.arquitechthor.eshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BRANDS")
public class Brand {

    @Id
    @Column(name = "BRAND_ID")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
}
