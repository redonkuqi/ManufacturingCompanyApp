package dev.redonkuci.manuopsmanufacturingapp.dtos.Order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
// etc.


import java.time.LocalDate;

@Getter
@Setter
public class OrderViewDto {

    @NotBlank(message = "Order number is required")
    @Size(max = 50, message = "Order number must not exceed 50 characters")
    private String orderNumber;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotBlank(message = "Product is required")
    @Size(max = 100, message = "Product must not exceed 100 characters")
    private String product;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @Size(max = 255, message = "Packaging info must not exceed 255 characters")
    private String packagingInfo;

    @NotNull(message = "Items per box is required")
    @Min(value = 1, message = "There must be at least 1 item per box")
    private Integer itemsPerBox;

    @NotNull(message = "Deadline date is required")
    private LocalDate deadlineDate;
}