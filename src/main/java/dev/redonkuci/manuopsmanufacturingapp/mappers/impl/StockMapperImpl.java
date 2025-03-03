package dev.redonkuci.manuopsmanufacturingapp.mappers.impl;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Stock.StockAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Stock.StockViewDto;
import dev.redonkuci.manuopsmanufacturingapp.mappers.Stock.StockMapper;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Stock;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
@Component
public class StockMapperImpl implements StockMapper {

    @Override
    public StockViewDto toStockViewDto(Stock stock) {
        StockViewDto dto = new StockViewDto();

        dto.setProductNumber(stock.getProductNumber());
        dto.setItemName(stock.getItemName());
        dto.setCategory(stock.getCategory());
        dto.setQuantity(stock.getQuantity());
        dto.setUnit(stock.getUnit());
        dto.setReorderLevel(stock.getReorderLevel());
        dto.setSupplier(stock.getSupplier());
        dto.setStorageLocation(stock.getStorageLocation());
        dto.setExpiryDate(stock.getExpiryDate());
        dto.setAddedDate(stock.getAddedDate());

        return dto;
    }

    @Override
    public Stock addDtoToStock(StockAddDto dto) {

        Stock stock = new Stock();

        stock.setProductNumber(dto.getProductNumber());
        stock.setItemName(dto.getItemName());
        stock.setCategory(dto.getCategory());
        stock.setQuantity(dto.getQuantity());
        stock.setUnit(dto.getUnit());
        stock.setReorderLevel(dto.getReorderLevel()); // Optional
        stock.setSupplier(dto.getSupplier()); // Optional
        stock.setStorageLocation(dto.getStorageLocation());
        stock.setExpiryDate(dto.getExpiryDate()); // Optional
        stock.setAddedDate(dto.getAddedDate() != null ? dto.getAddedDate() : LocalDate.now());

        return stock;

    }
}
