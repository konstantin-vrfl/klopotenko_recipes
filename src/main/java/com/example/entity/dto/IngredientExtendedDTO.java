package com.example.entity.dto;

import com.example.entity.db.IngredientDB;
import com.example.entity.db.MeasureDB;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonInclude(Include.NON_NULL)
public class IngredientExtendedDTO {
    private Integer id;

    private String name;

    private boolean vegetarian;

//    @JsonInclude(Include.NON_NULL)
    private MeasureDTO measure;

    public IngredientExtendedDTO() {
    }

    public IngredientExtendedDTO(IngredientDB ingredientDB) {
        if (ingredientDB == null) {
            return;
        }

        this.id = ingredientDB.getId();
        this.name = ingredientDB.getName();
        this.vegetarian = ingredientDB.isVegetarian();
        this.measure = ingredientDB.getMeasure() != null ? new MeasureDTO(ingredientDB.getMeasure()) : null;
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

    public MeasureDTO getMeasure() {
        return measure;
    }

    public void setMeasure(MeasureDTO measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", measure=" + measure +
                '}';
    }
}
