package dev.redonkuci.manuopsmanufacturingapp.repositories.Stock;

import dev.redonkuci.manuopsmanufacturingapp.models.entities.Stock;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForOffsetTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository <Stock, Long> {

    Optional<Stock> findByProductNumber(String productNumber);
    Optional<Stock> findByItemName(String itemName);
    Optional<Stock> findByCategory(String category);

}
