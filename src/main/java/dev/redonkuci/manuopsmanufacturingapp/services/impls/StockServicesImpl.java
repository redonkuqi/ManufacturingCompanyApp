package dev.redonkuci.manuopsmanufacturingapp.services.impls;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Stock.StockAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Stock.StockViewDto;
import dev.redonkuci.manuopsmanufacturingapp.mappers.impl.StockMapperImpl;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Stock;
import dev.redonkuci.manuopsmanufacturingapp.repositories.Stock.StockRepository;
import dev.redonkuci.manuopsmanufacturingapp.services.Stock.StockServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServicesImpl implements StockServices {

    private final StockRepository stockRepository;
    private final StockMapperImpl stockMapperImpl;

    @Override
    public List<StockViewDto> findAllStocks() {
        List<Stock> stocks = stockRepository.findAll();

        if (stocks.isEmpty()) {
            return new ArrayList<>();
        }

        return stocks.stream()
                .map(stockMapperImpl::toStockViewDto)
                .collect(Collectors.toList());// Uses the mapper method

    }

    @Override
    public Stock addStock(StockAddDto dto) {
        Stock stock = stockMapperImpl.addDtoToStock(dto);
        return stockRepository.save(stock);
    }
}
