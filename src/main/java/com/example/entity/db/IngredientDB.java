package com.example.entity.db;

import com.example.entity.dto.IngredientDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "ingredients")
public class IngredientDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_vegetarian")
    private boolean vegetarian;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
               fetch = FetchType.EAGER)
    @JoinColumn(name = "measure_id")
    private MeasureDB measure;

    @JsonIgnore
    @OneToMany(mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<RecipeIngredientDB> recipeIngredients;

    public IngredientDB() {
    }

    @Deprecated
    public IngredientDB(String name, boolean vegetarian) {
        this.name = name;
        this.vegetarian = vegetarian;
    }

    @Deprecated
    public IngredientDB(String name, boolean vegetarian, MeasureDB measure) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.measure = measure;
    }

    public IngredientDB(IngredientDTO ingredientDTO) {
        if (ingredientDTO == null) {
            return;
        }

        this.id = ingredientDTO.getId();
        this.name = ingredientDTO.getName();
        this.vegetarian = ingredientDTO.isVegetarian();
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

    public MeasureDB getMeasure() {
        return measure;
    }

    public void setMeasure(MeasureDB measure) {
        this.measure = measure;
    }

    public Set<RecipeIngredientDB> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredientDB> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
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
