package com.velamdir.repository;

import com.velamdir.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    @Query("SELECT r FROM Restaurant WHERE lower(r.name) LIKE lower(concat('%'))" +
            "OR lower(r.cusineType) LIKE lower(concat('%', :query, '%')")
    List <Restaurant> findBySearchQuery(String query);
    Restaurant findByOwnerId(Long userId);

}
