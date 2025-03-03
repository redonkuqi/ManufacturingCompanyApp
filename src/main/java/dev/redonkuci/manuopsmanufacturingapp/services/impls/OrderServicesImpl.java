package dev.redonkuci.manuopsmanufacturingapp.services.impls;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDetailsDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDto;
import dev.redonkuci.manuopsmanufacturingapp.mappers.Order.OrderMapper;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Order;
import dev.redonkuci.manuopsmanufacturingapp.repositories.Order.OrderRepository;
import dev.redonkuci.manuopsmanufacturingapp.services.Order.OrderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServicesImpl implements OrderServices {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapperImpl;

    @Override
    public Order addOrder(OrderAddDto orderAddDto) {
        Order order = orderMapperImpl.AddDtoToOrderEntity(orderAddDto);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(OrderAddDto orderAddDto) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public Order getOrder(Long id) {
        return null;
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public List<OrderViewDto> findAllOrdersView() {
        List<Order> orders = orderRepository.findAll();

        if (orders.isEmpty()) {
            return new ArrayList<>();
        }

        return orders.stream()
                .map(orderMapperImpl::toOrderViewDto) // Uses the mapper method
                .collect(Collectors.toList());
    }

    @Override
    public OrderViewDetailsDto getOrderDetails(String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new NoSuchElementException("Order with orderNumber " + orderNumber + " not found"));

        return orderMapperImpl.toOrderViewDetailsDto(order);
    }

}

