package com.example.entity.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredientDB {
    @Id
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "recipe_id") //referencedColumnName = "id"
    private RecipeDB recipe;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ingredient_id") //, referencedColumnName = "id"
    private IngredientDB ingredient;

    @Column(name = "amount")
    private double amount;

    public RecipeIngredientDB() {
    }

    @Deprecated
    public RecipeIngredientDB(IngredientDB ingredient, double amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public RecipeDB getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDB recipe) {
        this.recipe = recipe;
    }

    public IngredientDB getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDB ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RecipeIngredientDB{" +
                "recipe=" + recipe +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                '}';
    }
}
