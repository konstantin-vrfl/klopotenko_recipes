package com.example.entity.dto;

import com.example.entity.db.RecipeDB;

public class RecipeDTO {

    private Integer id;

    private String name;

    private String url;

    private String description;

    private boolean hot_dish;

    private boolean vegetarian_dish;

    private Integer cooking_time;

    public RecipeDTO() {
    }

    public RecipeDTO(RecipeDB recipeDB) {
        if (recipeDB == null) {
            return;
        }

        this.id = recipeDB.getId();
        this.name = recipeDB.getName();
        this.url = recipeDB.getUrl();
        this.description = recipeDB.getDescription();
        this.hot_dish = recipeDB.isHot_dish();
        this.vegetarian_dish = recipeDB.isVegetarian_dish();
        this.cooking_time = recipeDB.getCooking_time();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHot_dish() {
        return hot_dish;
    }

    public void setHot_dish(boolean hot_dish) {
        this.hot_dish = hot_dish;
    }

    public boolean isVegetarian_dish() {
        return vegetarian_dish;
    }

    public void setVegetarian_dish(boolean vegetarian_dish) {
        this.vegetarian_dish = vegetarian_dish;
    }

    public Integer getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(Integer cooking_time) {
        this.cooking_time = cooking_time;
    }

    @Override
    public String toString() {
        return "Recipe{\n\r" +
                "id=" + id +
                ", name='" + name + "'\n\r" +
                ", url='" + url + "'\n\r" +
                ", description='" + description + "'\n\r" +
                ", hot_dish=" + hot_dish + "\n\r" +
                ", vegetarian_dish=" + vegetarian_dish + "\n\r" +
                ", cooking_time=" + cooking_time + "\n\r" +
                '}';
    }
}
