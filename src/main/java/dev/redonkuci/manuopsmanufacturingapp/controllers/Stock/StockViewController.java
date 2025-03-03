package dev.redonkuci.manuopsmanufacturingapp.controllers.Stock;

import dev.redonkuci.manuopsmanufacturingapp.services.Stock.StockServices;
import dev.redonkuci.manuopsmanufacturingapp.services.impls.StockServicesImpl;
import org.springframework.ui.Model;
import dev.redonkuci.manuopsmanufacturingapp.dtos.Stock.StockViewDto;
import dev.redonkuci.manuopsmanufacturingapp.mappers.Stock.StockMapper;
import dev.redonkuci.manuopsmanufacturingapp.repositories.Stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockViewController {

    private final StockMapper stockMapper;
    private final StockRepository stockRepository;
    private final StockServices stockServices;

    @GetMapping
    public String viewStock(Model model) {

        List<StockViewDto> stock = stockServices.findAllStocks();
        model.addAttribute("stock", stock);

        return "stock-view";
    }
}
