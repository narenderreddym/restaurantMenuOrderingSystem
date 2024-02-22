package com.solugenix.restaurantMenuOrderingSystem;

import com.solugenix.restaurantMenuOrderingSystem.entity.Menu;
import com.solugenix.restaurantMenuOrderingSystem.repository.MenuRepository;
import com.solugenix.restaurantMenuOrderingSystem.service.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MenuServiceTest {

    @InjectMocks
    private MenuService menuService;

    @Mock
    private MenuRepository menuRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMenuItems() {
        // Mock data
        List<Menu> mockMenus = Arrays.asList(
                new Menu(1l, "1", "Item1", "Category1", "Description1", 10.0f),
                new Menu(2l, "2", "Item2", "Category2", "Description2", 15.0f)
        );

        // Mock behavior of the repository
        when(menuRepository.findAll()).thenReturn(mockMenus);

        // Test the service method
        List<Menu> result = menuService.getAllMenuItems();

        // Assertions
        assertEquals(2, result.size());
        verify(menuRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Mock data
        String itemId = "1";
        Menu mockMenu = new Menu(1l, itemId, "Item1", "Category1", "Description1", 10.0f);

        // Mock behavior of the repository
        when(menuRepository.findById(any())).thenReturn(Optional.of(mockMenu));

        // Test the service method
        Menu result = menuService.getById(itemId);

        // Assertions
        assertEquals(itemId, result.getItemId());
        verify(menuRepository, times(1)).findById(any());
    }

    @Test
    void testGetAllMenuByItemIDs() {
        // Mock data
        List<String> itemIds = Arrays.asList("1", "2");
        List<Menu> mockMenus = Arrays.asList(
                new Menu(1L, "1", "Item1", "Category1", "Description1", 10.0F),
                new Menu(2L, "2", "Item2", "Category2", "Description2", 15.0F)
        );

        // Mock behavior of the repository
        when(menuRepository.findAllByIdIn(itemIds)).thenReturn(mockMenus);

        // Test the service method
        List<Menu> result = menuService.getAllMenuByItemIDs(itemIds);

        // Assertions
        assertEquals(2, result.size());
        verify(menuRepository, times(1)).findAllByIdIn(itemIds);
    }

    @Test
    void testGetMenuItemsByCategory() {
        // Mock data
        String itemCategory = "Category1";
        List<Menu> mockMenus = Arrays.asList(
                new Menu(1L, "1", "Item1", itemCategory, "Description1", 10.0F),
                new Menu(2L, "2", "Item2", itemCategory, "Description2", 15.0F)
        );

        // Mock behavior of the repository
        when(menuRepository.findMenuByCategory(itemCategory)).thenReturn(mockMenus);

        // Test the service method
        List<Menu> result = menuService.getMenuItemsByCategory(itemCategory);

        // Assertions
        assertEquals(2, result.size());
        verify(menuRepository, times(1)).findMenuByCategory(itemCategory);
    }
}

