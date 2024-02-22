package com.solugenix.restaurantMenuOrderingSystem.controller;

import com.solugenix.restaurantMenuOrderingSystem.entity.Order;
import com.solugenix.restaurantMenuOrderingSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    // Mutations to place an order with attributes including itemIds and quantities.
    @MutationMapping
    Order placeOrder(@Argument List<String> itemIds, @Argument List<Integer> quantities) {
        return orderService.placeOrder(itemIds, quantities);
    }

}

