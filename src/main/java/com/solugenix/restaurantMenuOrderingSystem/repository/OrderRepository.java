package com.solugenix.restaurantMenuOrderingSystem.repository;

import com.solugenix.restaurantMenuOrderingSystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
