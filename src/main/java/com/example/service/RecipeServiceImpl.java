package com.example.service;

import com.example.dao.RecipeDAO;
import com.example.entity.db.*;
import com.example.entity.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeDAO recipeDAO;

    @Override
    @Transactional
    public List<RecipeDTO> getAllRecipes() {
        return recipeDAO.getAllRecipes();
    }

    @Override
    @Transactional
    public RecipeDTO getRecipe(Integer id) {
        RecipeDB recipeDB = recipeDAO.getRecipe(id);
        return new RecipeDTO(recipeDB);
    }

    @Override
    @Transactional
    public RecipeExtendedDTO getRecipeWithIngredients(Integer id) {
        RecipeDB recipeDB = recipeDAO.getRecipe(id);

        List<IngredientExtendedDTO> ingredientsExtendedDTO = recipeDB.getRecipeIngredients().stream()
                .map(RecipeIngredientDB::getIngredient)
                .map(IngredientExtendedDTO::new)
                .toList();

        RecipeExtendedDTO recipe = new RecipeExtendedDTO(recipeDB);
        recipe.setIngredients(ingredientsExtendedDTO);

        return recipe;
    }

    @Override
    @Transactional
    public RecipeDB saveRecipe(RecipeDB recipe) {
        recipeDAO.saveRecipe(recipe);

        return recipe;
    }

    @Override
    @Transactional
    public void deleteRecipe(Integer id) {
        recipeDAO.deleteRecipe(id);
    }
}
