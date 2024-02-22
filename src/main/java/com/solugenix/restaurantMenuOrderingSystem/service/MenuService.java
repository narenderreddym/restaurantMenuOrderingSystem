package com.solugenix.restaurantMenuOrderingSystem.service;

import com.solugenix.restaurantMenuOrderingSystem.entity.Menu;
import com.solugenix.restaurantMenuOrderingSystem.repository.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MenuService {
    Logger logger = LoggerFactory.getLogger(MenuService.class);
    @Autowired
    MenuRepository menuRepository;

    public List<Menu> getAllMenuItems() {
        List<Menu> listOfMenus;
        try {
            listOfMenus = menuRepository.findAll();
        } catch (Exception ex) {
            logger.error("An error occurred while fetching the all menuItems: {} App is running at={}, operation ={}", ex.getMessage(), LocalDateTime.now(), "getAllMenuItems()");
            throw ex;
        }
        return listOfMenus;
    }

    public Menu getById(String itemId) {
        try {
            return menuRepository.findById(Long.valueOf(itemId)).get();
        } catch (Exception ex) {
            logger.error("An error occurred while fetching menu items by ID:{}, itemId = {}, App is running at={}, operation ={}", ex.getMessage(), itemId, LocalDateTime.now(), "getById()");
            throw ex;
        }
    }

    public List<Menu> getAllMenuByItemIDs(List<String> itemIds) {
        try {
            return menuRepository.findAllByIdIn(itemIds);
        } catch (Exception ex) {
            logger.error("An error occurred while fetching get AllMenuByItemIDs :{}, itemCategory = {}, App is running at={}, operation ={}", ex.getMessage(), itemIds, LocalDateTime.now(), "getMenuItemsByCategory");
            throw ex;
        }

    }

    public List<Menu> getMenuItemsByCategory(String itemCategory) {
        try {
            return menuRepository.findMenuByCategory(itemCategory);
        } catch (Exception ex) {
            logger.error("An error occurred while fetching menuItemsByCategory :{}, itemCategory = {}, App is running at={}, operation ={}", ex.getMessage(), itemCategory, LocalDateTime.now(), "getMenuItemsByCategory");
            throw ex;
        }
    }

}
