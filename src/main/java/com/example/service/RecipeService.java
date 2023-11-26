package com.example.service;

import com.example.entity.db.RecipeDB;
import com.example.entity.dto.RecipeDTO;
import com.example.entity.dto.RecipeExtendedDTO;

import java.util.List;

public interface RecipeService {

    List<RecipeDTO> getAllRecipes();

    RecipeDTO getRecipe(Integer id);

    RecipeExtendedDTO getRecipeWithIngredients(Integer id);

    RecipeDB saveRecipe(RecipeDB recipe);

    void deleteRecipe(Integer id);
}
