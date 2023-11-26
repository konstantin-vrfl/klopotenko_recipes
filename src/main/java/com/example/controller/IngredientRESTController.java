package com.example.controller;

import com.example.entity.dto.IngredientDTO;
import com.example.entity.db.IngredientDB;
import com.example.entity.dto.IngredientExtendedDTO;
import com.example.service.IngredientService;
import com.example.service.MeasureService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class IngredientRESTController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/ingredients")
    public List<IngredientExtendedDTO> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/ingredients/{id}")
    public IngredientExtendedDTO getIngredient(@PathVariable int id) throws JsonProcessingException {
        IngredientExtendedDTO ingredient = ingredientService.getIngredient(id);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(ingredient));

        return ingredient;
    }

    @PostMapping("/ingredients")
    public IngredientExtendedDTO addNewIngredient(@RequestBody IngredientDTO ingredient) {
        return ingredientService.saveIngredient(ingredient);
    }

    @PutMapping("/ingredients")
    public IngredientExtendedDTO updateIngredient(@RequestBody IngredientDTO ingredient) {
        return ingredientService.saveIngredient(ingredient); //TODO - не работает
    }

    @DeleteMapping("/ingredients/{id}")
    public String deleteIngredient(@PathVariable Integer id) {
        IngredientExtendedDTO ingredientExtendedDTO = ingredientService.getIngredient(id);

        if (ingredientExtendedDTO == null) {
            return "There is no ingredient with ID = " + id + " in database";
        }

        ingredientService.deleteIngredient(id);
        return "Ingredient with ID = " + id + " was deleted";
    }


}
