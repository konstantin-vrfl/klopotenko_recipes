package com.example.entity.dto;

import com.example.entity.db.IngredientDB;

public class IngredientDTO {
    private Integer id;

    private String name;

    private boolean vegetarian;

    private int measureId;

    public IngredientDTO() {
    }

    public IngredientDTO(IngredientDB ingredientDB) {
        if (ingredientDB == null) {
            return;
        }

        this.id = ingredientDB.getId();
        this.name = ingredientDB.getName();
        this.vegetarian = ingredientDB.isVegetarian();
        this.measureId = ingredientDB.getMeasure().getId();
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

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean is_vegetarian) {
        this.vegetarian = is_vegetarian;
    }

    public int getMeasureId() {
        return measureId;
    }

    public void setMeasureId(int measureId) {
        this.measureId = measureId;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", measureId=" + measureId +
                '}';
    }
}
