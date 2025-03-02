package dev.redonkuci.manuopsmanufacturingapp.controllers;

import dev.redonkuci.manuopsmanufacturingapp.dtos.Order.OrderAddDto;
import dev.redonkuci.manuopsmanufacturingapp.models.entities.Order;
import dev.redonkuci.manuopsmanufacturingapp.repositories.OrderRepository;
import dev.redonkuci.manuopsmanufacturingapp.services.OrderServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DefaultController {
    private final OrderRepository orderRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
