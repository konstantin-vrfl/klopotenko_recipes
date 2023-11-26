package com.example.service;

import com.example.dao.IngredientDAO;
import com.example.dao.MeasureDAO;
import com.example.entity.db.IngredientDB;
import com.example.entity.db.MeasureDB;
import com.example.entity.dto.IngredientDTO;
import com.example.entity.dto.IngredientExtendedDTO;
import com.example.entity.dto.MeasureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientDAO ingredientDAO;
    @Autowired
    private MeasureDAO measureDAO;

    @Override
    @Transactional
    public List<IngredientExtendedDTO> getAllIngredients() {
        return ingredientDAO.getAllIngredients()
                .stream()
                .map(IngredientExtendedDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public IngredientExtendedDTO getIngredient(Integer id) {
        IngredientDB ingredientDB = ingredientDAO.getIngredient(id);

        return new IngredientExtendedDTO(ingredientDB);
    }

    @Override
    @Transactional
    public IngredientExtendedDTO saveIngredient(IngredientDTO ingredientDTO) {
        MeasureDB measureDB = measureDAO.getMeasure(ingredientDTO.getMeasureId());

        IngredientDB ingredientDB = new IngredientDB(ingredientDTO);
        ingredientDB.setMeasure(measureDB);

        ingredientDAO.saveIngredient(ingredientDB);

//        IngredientExtendedDTO ingredientExtendedDTO = new IngredientExtendedDTO(ingredientDB);
//        ingredientExtendedDTO.setMeasure(new MeasureDTO(measureDB));

        return new IngredientExtendedDTO(ingredientDB);
    }

    @Override
    @Transactional
    public void deleteIngredient(Integer id) {
        ingredientDAO.deleteIngredient(id);
    }
}
