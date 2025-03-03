package dev.redonkuci.manuopsmanufacturingapp.mappers.Stock;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Stock.StockAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Stock.StockViewDto;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Stock;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface StockMapper {

    StockViewDto toStockViewDto(Stock stock);
    Stock addDtoToStock(StockAddDto dto);
}
