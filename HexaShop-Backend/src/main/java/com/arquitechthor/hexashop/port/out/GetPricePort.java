package com.arquitechthor.hexashop.port.out;

import com.arquitechthor.hexashop.domain.Price;
import java.time.LocalDateTime;

public interface GetPricePort {
    Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
