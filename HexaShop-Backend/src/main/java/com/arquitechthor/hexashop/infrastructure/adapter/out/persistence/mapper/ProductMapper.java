package com.arquitechthor.hexashop.infrastructure.adapter.out.persistence.mapper;

import com.arquitechthor.hexashop.infrastructure.adapter.out.persistence.entity.ProductEntity;
import com.arquitechthor.hexashop.domain.Product;

public class ProductMapper {
    public static Product entityToDomain(ProductEntity productEntity) {

            return Product.builder()
                    .id(productEntity.getId())
                    .name(productEntity.getName())
                    .build();
    }

    public static ProductEntity domainToEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }
}
