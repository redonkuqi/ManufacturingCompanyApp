package dev.redonkuci.manuopsmanufacturingapp.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productNumber;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String unit;

    @Column
    private Integer reorderLevel;

    @Column
    private String supplier;

    @Column(nullable = false)
    private String storageLocation;

    @Column
    private LocalDate expiryDate;

    @Column
    private LocalDate addedDate = LocalDate.now();
}
