package com.velamdir.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<IngrediantItem> ingredients = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<IngrediantItem> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngrediantItem> ingredients) {
        this.ingredients = ingredients;
    }
}
