package com.example.dao;

import com.example.entity.db.IngredientDB;

import java.util.List;

public interface IngredientDAO {
    List<IngredientDB> getAllIngredients();

    IngredientDB getIngredient(Integer id);

    void saveIngredient(IngredientDB ingredientDB);

    void deleteIngredient(Integer id);
}
