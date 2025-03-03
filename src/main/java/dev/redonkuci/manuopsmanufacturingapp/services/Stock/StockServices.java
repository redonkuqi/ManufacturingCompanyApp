package dev.redonkuci.manuopsmanufacturingapp.services.Stock;


import dev.redonkuci.manuopsmanufacturingapp.dtos.Stock.StockAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Stock.StockViewDto;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Stock;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StockServices {

    List<StockViewDto> findAllStocks();
    Stock addStock(StockAddDto dto);
}
