package com.velamdir.repository;

import com.velamdir.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
     public User findByEmail(String email);
}
