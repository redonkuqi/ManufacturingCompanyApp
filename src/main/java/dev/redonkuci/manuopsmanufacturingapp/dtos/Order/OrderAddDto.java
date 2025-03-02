package dev.redonkuci.manuopsmanufacturingapp.dtos.Order;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderAddDto {

    @NotBlank
    @Size(max = 50)
    private String orderNumber;

//    @NotBlank
//    @Size(max = 100)
//    private String customer;

//    @Min(1)
//    private int item;

    @NotBlank
    @Size(max = 100)
    private String product;

    @Size(max = 500)
    private String description;

    @Min(1)
    private int quantity;

//    @DecimalMin("0.01")
//    private double price;
//
//    @DecimalMin("0")
//    private double totalPrice;

    @Size(max = 255)
    private String packagingInfo;

    @Min(1)
    private int itemsPerBox;

//    @NotNull
//    private LocalDate orderDate;

    private LocalDate deadlineDate;
//    private LocalDate shippingDate;
}