package com.solugenix.restaurantMenuOrderingSystem;

import com.solugenix.restaurantMenuOrderingSystem.entity.Menu;
import com.solugenix.restaurantMenuOrderingSystem.entity.Order;
import com.solugenix.restaurantMenuOrderingSystem.repository.MenuRepository;
import com.solugenix.restaurantMenuOrderingSystem.repository.OrderRepository;
import com.solugenix.restaurantMenuOrderingSystem.service.MenuService;
import com.solugenix.restaurantMenuOrderingSystem.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private MenuRepository menuRepository;
    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void testPlaceOrder() {
        // Mock data
        List<Menu> menuList = new ArrayList<>();
        Menu menu = new Menu();
        menu.setPrice(99.2f);
        menu.setDescription("description");
        menu.setItemId("1");
        menu.setItemCategory("Appetizer");
        List<String> itemIds = Arrays.asList("itemId1", "itemId2");
        List<Integer> quantities = Arrays.asList(2, 1);

        // Mock behavior of the repository
        when(menuRepository.findAllByIdIn(Mockito.anyList())).thenReturn(menuList);
        when(orderRepository.save(Mockito.any(Order.class))).thenReturn(new Order());

        // Test the service method
        Order order = orderService.placeOrder(itemIds, quantities);
        // Assertions
        assertNotNull(order);
        // Add more assertions based on the expected behavior
    }

}
