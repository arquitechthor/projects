package com.arquitechthor.hexashop.infrastructure.adapter.out.persistence.mapper;

import com.arquitechthor.hexashop.infrastructure.adapter.out.persistence.entity.PriceEntity;
import com.arquitechthor.hexashop.domain.Price;

public class PriceMapper {

    public static Price entityToDomain(PriceEntity priceEntity) {
        Price price = Price.builder()
                .id(priceEntity.getId())
                .brand(BrandMapper.entityToDomain(priceEntity.getBrandEntity()))
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .priceList(priceEntity.getPriceList())
                .product(ProductMapper.entityToDomain(priceEntity.getProductEntity()))
                .priority(priceEntity.getPriority())
                .price(priceEntity.getPrice())
                .currency(priceEntity.getCurrency())
                .build();

        return price;

    }

    public static PriceEntity domainToEntity(Price price) {
        PriceEntity priceEntity = PriceEntity.builder()
                .id(price.getId())
                .brandEntity(BrandMapper.domainToEntity(price.getBrand()))
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .priceList(price.getPriceList())
                .productEntity(ProductMapper.domainToEntity(price.getProduct()))
                .priority(price.getPriority())
                .price(price.getPrice())
                .currency(price.getCurrency())
                .build();

        return priceEntity;
    }
}
