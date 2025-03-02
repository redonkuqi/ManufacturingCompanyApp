package dev.redonkuci.manuopsmanufacturingapp.controllers;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderAddDto;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderViewDto;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Order;
import dev.redonkuci.manuopsmanufacturingapp.repositories.OrderRepository;
import dev.redonkuci.manuopsmanufacturingapp.services.impls.OrderServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServicesImpl orderServicesImpl;
    private final OrderRepository orderRepository;

    @GetMapping
    public String getOrders(Model model) {
        // Get the list of orders as OrderViewDto objects for display.
        List<OrderViewDto> orders = orderServicesImpl.findAllOrdersView();
        model.addAttribute("orders", orders);
        // Prepare the DTO for the add order form.
        model.addAttribute("orderAddDto", new OrderAddDto());
        return "orders-view"; // Thymeleaf will render orders-view.html
    }

    @GetMapping("/add")
    public String getAddOrderForm(Model model) {
        model.addAttribute("orderAddDto", new OrderAddDto());
        return "orders-add"; // Thymeleaf template for adding an order
    }

    @PostMapping
    public String addOrder(@Valid @ModelAttribute("orderAddDto") OrderAddDto orderAddDto,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            // In case of validation errors, reload the orders view with errors.
            List<OrderViewDto> orders = orderServicesImpl.findAllOrdersView();
            model.addAttribute("orders", orders);
            return "orders-view";
        }

        orderServicesImpl.addOrder(orderAddDto);

        return "redirect:/orders";
    }

    @GetMapping("/details/{orderNumber}")
    public String getOrderDetails(@ModelAttribute("orderNumber") String orderNumber, Model model) {
        return "orders-details";
    }
}
