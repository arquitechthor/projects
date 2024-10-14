package com.arquitechthor.hexashop.port.in;

import com.arquitechthor.hexashop.infrastructure.adapter.in.command.GetPriceCommand;
import com.arquitechthor.hexashop.infrastructure.adapter.out.web.PriceResponse;

public interface PricePort {
	PriceResponse getPriceByDateProductAndBrand(GetPriceCommand command);

}
