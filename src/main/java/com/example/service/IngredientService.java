package com.example.service;

import com.example.entity.db.IngredientDB;
import com.example.entity.dto.IngredientDTO;
import com.example.entity.dto.IngredientExtendedDTO;

import java.util.List;

public interface IngredientService {
    List<IngredientExtendedDTO> getAllIngredients();

    IngredientExtendedDTO getIngredient(Integer id);

    IngredientExtendedDTO saveIngredient(IngredientDTO ingredientDTO);

    void deleteIngredient(Integer id);
}
