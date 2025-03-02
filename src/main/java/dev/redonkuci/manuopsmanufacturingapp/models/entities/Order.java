package dev.redonkuci.manuopsmanufacturingapp.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String orderNumber;

    @Column(nullable = false, length = 100)
    private String customer = "N/A";

    @Column(nullable = false)
    private int item = 1;

    @Column(nullable = false, length = 100)
    private String product;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price = 0.0;

    @Column(nullable = false)
    private double totalPrice = 0.0;

    @Column(length = 255)
    private String packagingInfo;

    @Column(nullable = false)
    private int itemsPerBox;

    @Column(nullable = false)
    private LocalDate orderDate = LocalDate.now();

    @Column
    private LocalDate deadlineDate;

    @Column
    private LocalDate shippingDate = LocalDate.now();

}
