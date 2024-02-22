package com.solugenix.restaurantMenuOrderingSystem.repository;

import com.solugenix.restaurantMenuOrderingSystem.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(value = "SELECT * FROM menu WHERE item_id IN :itemIds", nativeQuery = true)
    List<Menu> findAllByIdIn(@Param("itemIds") List<String> itemIds);

    @Query(value = "SELECT * FROM menu WHERE ITEM_CATEGORY=?1", nativeQuery = true)
    List<Menu> findMenuByCategory(String itemCategory);

}
