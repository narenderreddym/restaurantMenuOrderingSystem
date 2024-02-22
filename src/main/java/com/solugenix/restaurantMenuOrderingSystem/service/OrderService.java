package com.solugenix.restaurantMenuOrderingSystem.service;

import com.solugenix.restaurantMenuOrderingSystem.entity.Menu;
import com.solugenix.restaurantMenuOrderingSystem.entity.Order;
import com.solugenix.restaurantMenuOrderingSystem.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private MenuService menuItemService;

    public Order placeOrder(List<String> itemIds, List<Integer> quantities) {
        // Fetch menu items based on itemIds
        List<Menu> orderedItems = getMenuItemsByIds(itemIds);
        logger.info(" order items {}", orderedItems);

        // Calculate total price
        Float totalPrice = calculateTotalPrice(orderedItems, quantities);

        // Create the order
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setItems(orderedItems);
        order.setTotalPrice(totalPrice);
        order.setOrderDate(LocalDateTime.now());
        try {
            return orderRepository.save(order);
        } catch (Exception ex) {
            logger.error("An error occurred while placing the order: {} App is running at={}, operation ={}, order={}", ex.getMessage(), LocalDateTime.now(), "placeOrder()", order.toString());
            throw ex;
        }

    }


    private List<Menu> getMenuItemsByIds(List<String> itemIds) {
        return menuItemService.getAllMenuByItemIDs(itemIds);
    }

    private Float calculateTotalPrice(List<Menu> orderedItems, List<Integer> quantities) {
        Float totalPrice = 0.0f;
        for (int i = 0; i < orderedItems.size(); i++) {
            totalPrice += orderedItems.get(i).getPrice() * quantities.get(i);
        }
        return totalPrice;
    }
}

