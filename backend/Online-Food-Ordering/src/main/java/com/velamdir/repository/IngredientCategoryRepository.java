package com.velamdir.repository;

import com.velamdir.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientCategoryRepository extends JpaRepository <IngredientCategory, Long> {
}
