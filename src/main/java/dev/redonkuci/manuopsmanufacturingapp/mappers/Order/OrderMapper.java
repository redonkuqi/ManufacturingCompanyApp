package dev.redonkuci.manuopsmanufacturingapp.mappers.Order;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDetailsDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDto;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Order;

import java.util.List;

public interface OrderMapper {

    Order AddDtoToOrderEntity(OrderAddDto orderAddDto);
    OrderViewDto toOrderViewDto(Order order);
    OrderViewDetailsDto toOrderViewDetailsDto(Order order);
    List<OrderViewDto> toOrderViewDtoList(List<Order> order);

}