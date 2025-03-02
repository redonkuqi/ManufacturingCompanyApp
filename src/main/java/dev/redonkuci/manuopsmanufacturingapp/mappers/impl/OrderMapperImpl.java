package dev.redonkuci.manuopsmanufacturingapp.mappers.impl;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDetailsDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDto;
import dev.redonkuci.manuopsmanufacturingapp.mappers.OrderMapper;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public class OrderMapperImpl implements OrderMapper {


    @Override
    public Order AddDtoToOrderEntity(OrderAddDto dto) {
        Order order = new Order();
        order.setOrderNumber(dto.getOrderNumber());
//        order.setCustomer(dto.getCustomer());
//        order.setItem(dto.getItem());
        order.setProduct(dto.getProduct());
        order.setDescription(dto.getDescription());
        order.setQuantity(dto.getQuantity());
//        order.setPrice(dto.getPrice());
//        order.setTotalPrice(dto.getTotalPrice());
        order.setPackagingInfo(dto.getPackagingInfo());
        order.setItemsPerBox(dto.getItemsPerBox());
//        order.setOrderDate(dto.getOrderDate());
        order.setDeadlineDate(dto.getDeadlineDate());
//        order.setShippingDate(dto.getShippingDate());
        return order;
    }

    @Override
    public OrderViewDto toOrderViewDto(Order order) {
        if (order == null) {
            return null;
        }

        OrderViewDto dto = new OrderViewDto();
        dto.setOrderNumber(order.getOrderNumber());
        dto.setDescription(order.getDescription());
        dto.setProduct(order.getProduct());
        dto.setQuantity(order.getQuantity());
        dto.setPackagingInfo(order.getPackagingInfo());
        dto.setItemsPerBox(order.getItemsPerBox());
        dto.setDeadlineDate(order.getDeadlineDate());

        return dto;
    }

    @Override
    public OrderViewDetailsDto toOrderViewDetailsDto(Order order) {
        if (order == null) {
            return null;
        }

        OrderViewDetailsDto dto = new OrderViewDetailsDto();
        dto.setId(order.getId());
        dto.setOrderNumber(order.getOrderNumber());
        dto.setCustomer(order.getCustomer());
        dto.setItem(order.getItem());
        dto.setProduct(order.getProduct());
        dto.setDescription(order.getDescription());
        dto.setQuantity(order.getQuantity());
        dto.setPrice(order.getPrice());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setPackagingInfo(order.getPackagingInfo());
        dto.setItemsPerBox(order.getItemsPerBox());
        dto.setOrderDate(order.getOrderDate());
        dto.setDeadlineDate(order.getDeadlineDate());
        dto.setShippingDate(order.getShippingDate());
        return dto;
    }

    @Override
    public List<OrderViewDto> toOrderViewDtoList(List<Order> order) {
        return List.of();
    }
}
