package com.arquitechthor.hexashop.infrastructure.adapter.out.persistence.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.arquitechthor.hexashop.infrastructure.adapter.out.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpringPriceRepository extends JpaRepository<PriceEntity, Long> {
	
    @Query("""
            SELECT p
            FROM PriceEntity p
            	JOIN p.brandEntity b
            	JOIN p.productEntity pro
            WHERE b.id = ?3 
            	AND pro.id = ?2 
            	AND (?1 BETWEEN p.startDate AND p.endDate)
            ORDER BY p.priority DESC
            LIMIT 1
            """)
   Optional<PriceEntity> findFirstByBrandProductAndDate(LocalDateTime applicationDate, Long productId, Long brandId);

}
