package dev.redonkuci.manuopsmanufacturingapp.dtos.Order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderViewDetailsDto extends OrderViewDto {

    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Customer is required")
    @Size(max = 100, message = "Customer name must not exceed 100 characters")
    private String customer = "N/A";

    @NotNull(message = "Item count is required")
    @Min(value = 1, message = "Item count must be at least 1")
    private int item = 1;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price cannot be negative")
    private double price = 0.0;

    @NotNull(message = "Total price is required")
    @Min(value = 0, message = "Total price cannot be negative")
    private double totalPrice = 0.0;

    @NotNull(message = "Order date is required")
    private LocalDate orderDate = LocalDate.now();

    private LocalDate shippingDate = LocalDate.now();
}
