package dev.redonkuci.manuopsmanufacturingapp.repositories;

import dev.redonkuci.manuopsmanufacturingapp.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByOrderNumber(String orderNumber);
    Optional<Order> findByCustomer(String customer);
    Optional<Order> findByProduct(String product);
    Optional<Order> findByDescription(String description);
    Optional<Order> findByPackagingInfo(String packagingInfo);
    Optional<Order> findByDeadlineDate(LocalDate deadlineDate);

}
