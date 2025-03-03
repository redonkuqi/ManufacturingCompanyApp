package dev.redonkuci.manuopsmanufacturingapp.controllers.Order;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDetailsDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDto;
import dev.redonkuci.manuopsmanufacturingapp.services.impls.OrderServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServicesImpl orderServicesImpl;

    @GetMapping
    public String getOrders(Model model) {

        List<OrderViewDto> orders = orderServicesImpl.findAllOrdersView();
        model.addAttribute("orders", orders);

        model.addAttribute("orderAddDto", new OrderAddDto());
        return "orders-view";
    }

    // View the details of an order
    @GetMapping("/details/{orderNumber}")
    public String getOrderDetails(@PathVariable String orderNumber, Model model) {
        OrderViewDetailsDto orderDetails = orderServicesImpl.getOrderDetails(orderNumber);
        model.addAttribute("orderDetails", orderDetails);
        return "order-details-modal"; // Return only modal content
    }

    @GetMapping("/add")
    public String getAddOrderForm(Model model) {
        model.addAttribute("orderAddDto", new OrderAddDto());
        return "orders-add";
    }

    @PostMapping
    public String addOrder(@Valid @ModelAttribute("orderAddDto") OrderAddDto orderAddDto,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {

            List<OrderViewDto> orders = orderServicesImpl.findAllOrdersView();
            model.addAttribute("orders", orders);
            return "orders-view";
        }

        orderServicesImpl.addOrder(orderAddDto);

        return "redirect:/orders";
    }
}
