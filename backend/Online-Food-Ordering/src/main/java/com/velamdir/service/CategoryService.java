package com.velamdir.service;

import com.velamdir.model.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(String name, Long userId) throws Exception;
    public List <Category> findCategoryRestaurantId(Long id) throws Exception;
    public Category findCategoryById(Long id) throws Exception;

}
