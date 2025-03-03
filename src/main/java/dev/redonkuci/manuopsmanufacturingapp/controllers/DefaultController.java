package dev.redonkuci.manuopsmanufacturingapp.controllers;

import dev.redonkuci.manuopsmanufacturingapp.repositories.Order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DefaultController {
    private final OrderRepository orderRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
