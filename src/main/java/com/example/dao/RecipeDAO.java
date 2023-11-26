package com.example.dao;

import com.example.entity.db.*;
import com.example.entity.dto.*;

import java.util.List;

public interface RecipeDAO {
    List<RecipeDTO> getAllRecipes();

    RecipeDB getRecipe(Integer id);

    void saveRecipe(RecipeDB recipe);

    void deleteRecipe(Integer id);
}
