package com.arquitechthor.eshop.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arquitechthor.eshop.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {
	
    @Query("""
            SELECT p
            FROM Price p
            	JOIN p.brand b
            	JOIN p.product pro
            WHERE b.id = ?3 
            	AND pro.id = ?2 
            	AND (?1 BETWEEN p.startDate AND p.endDate)
            ORDER BY p.priority DESC
            LIMIT 1
            """)
   Optional<Price> findFirstbyBrandProductAndDate(LocalDateTime applicationDate, Long productId, Long brandId);

}
