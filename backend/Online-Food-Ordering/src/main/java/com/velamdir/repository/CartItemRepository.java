package com.velamdir.repository;

import com.velamdir.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem , Long> {

}
