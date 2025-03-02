package dev.redonkuci.manuopsmanufacturingapp.services;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDto;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Order;

import java.util.List;

public interface OrderServices {

    Order addOrder(OrderAddDto orderAddDto);
    Order updateOrder(OrderAddDto orderAddDto);
    void deleteOrder(Long id);
    Order getOrder(Long id);
    List<Order> findAllOrders();
    List<OrderViewDto> findAllOrdersView();
    OrderViewDto getOrderDetails(String orderNumber);
}
