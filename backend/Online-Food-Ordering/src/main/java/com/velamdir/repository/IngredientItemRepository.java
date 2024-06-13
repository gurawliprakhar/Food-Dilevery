package com.velamdir.repository;

import com.velamdir.model.IngrediantItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientItemRepository extends JpaRepository<IngrediantItem, Long> {
}
