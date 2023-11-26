package com.example.controller;

import com.example.entity.dto.*;
import com.example.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeRESTController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/recipes/{id}")
    public RecipeExtendedDTO getRecipeWithIngredients(@PathVariable int id) {
        return recipeService.getRecipeWithIngredients(id);
    }

    @PostMapping("/recipes")
    public RecipeExtendedDTO addNewRecipe(RecipeExtendedDTO recipeExtendedDTO) {
        return null; //TODO
    }

    @PutMapping("/recipes")
    public RecipeExtendedDTO updateRecipe(@RequestBody RecipeExtendedDTO recipeExtendedDTO) {
        return null; //TODO
    }

    @DeleteMapping("/recipes/{id}")
    public String deleteMeasure(@PathVariable Integer id) { //TODO check
        RecipeDTO recipeDTO = recipeService.getRecipe(id);

        if (recipeDTO == null) {
            return "There is no recipe with ID = " + id + " in database";
        }

        recipeService.deleteRecipe(id); //TODO удалить или проверить, что удалились записи из таблицы recipe_ingredient
        return "Recipe with ID = " + id + " was deleted";
    }
}
