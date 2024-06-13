package com.velamdir.controller;

import com.velamdir.model.Category;
import com.velamdir.model.User;
import com.velamdir.service.CategoryService;
import com.velamdir.service.CategoryServiceImp;
import com.velamdir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @PostMapping("/admin/category")
    public ResponseEntity <Category> categoryResponseEntity (@RequestBody Category category,
                                                             @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        Category createdCategory = categoryService.createCategory(category.getName(), user.getId());

        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/category/restaurant")
    public ResponseEntity <List<Category>> getRestaurantCategory (
                                                             @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        List<Category> categories = categoryService.findCategoryRestaurantId(user.getId());

        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }
}
