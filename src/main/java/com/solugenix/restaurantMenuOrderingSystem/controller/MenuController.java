package com.solugenix.restaurantMenuOrderingSystem.controller;

import com.solugenix.restaurantMenuOrderingSystem.entity.Menu;
import com.solugenix.restaurantMenuOrderingSystem.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    // Queries to fetch a list of all menu items including their attributes.
    @QueryMapping
    public List<Menu> getMenuItems() {
        return menuService.getAllMenuItems();
    }

    // Queries to fetch a specific menu item by its itemId.
    @QueryMapping
    public Menu menuByItemID(@Argument String itemId) {
        return menuService.getById(itemId);
    }

    // Queries to fetch menu items by category.
    @QueryMapping
    public List<Menu> getMenuItemsByCategory(@Argument String itemCategory) {
        return menuService.getMenuItemsByCategory(itemCategory);
    }

}
