package com.velamdir.request;

import com.velamdir.model.Category;
import com.velamdir.model.IngrediantItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {
   public String getDescription;
   private String name;
   private String description;
   private Long price;
   private Category category;
   private List<String> images;
   private Long restaurantId;
   private boolean vegetarian;
   private boolean sessional;
   private List<IngrediantItem> ingredients;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Long getPrice() {
      return price;
   }

   public void setPrice(Long price) {
      this.price = price;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public List<String> getImages() {
      return images;
   }

   public void setImages(List<String> images) {
      this.images = images;
   }

   public Long getRestaurantId() {
      return restaurantId;
   }

   public void setRestaurantId(Long restaurantId) {
      this.restaurantId = restaurantId;
   }

   public boolean isVegetarian() {
      return vegetarian;
   }

   public void setVegetarian(boolean vegetarian) {
      this.vegetarian = vegetarian;
   }

   public boolean isSessional() {
      return sessional;
   }

   public void setSessional(boolean sessional) {
      this.sessional = sessional;
   }

   public List<IngrediantItem> getIngredients() {
      return ingredients;
   }

   public void setIngredients(List<IngrediantItem> ingredients) {
      this.ingredients = ingredients;
   }
}
