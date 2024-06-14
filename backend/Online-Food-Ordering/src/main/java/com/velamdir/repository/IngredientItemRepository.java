package com.velamdir.repository;

import com.velamdir.model.IngrediantItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientItemRepository extends JpaRepository<IngrediantItem, Long> {
    List<IngrediantItem> findByRestaurantId (Long id);
}
