package com.solugenix.restaurantMenuOrderingSystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDER_ENTITY")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Menu> items;

    private Float totalPrice;

    private LocalDateTime orderDate;

    @Override
    public String toString() {
        // Returning attributes of organisation
        return "Order [orderId="
                + orderId
                + ", items=" + items
                + ", totalPrice=" + totalPrice + "+ orderDate" + orderDate + "]";
    }
}
