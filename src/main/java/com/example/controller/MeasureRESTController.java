package com.example.controller;

import com.example.entity.dto.MeasureDTO;
import com.example.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MeasureRESTController {
    @Autowired
    private MeasureService measureService;

    @GetMapping("/measures")
    public List<MeasureDTO> getAllMeasures() {
        return measureService.getAllMeasures();
    }

    @GetMapping("/measures/{id}")
    public MeasureDTO getMeasure(@PathVariable int id) {
        return measureService.getMeasure(id);
    }

    @PostMapping("/measures")
    public MeasureDTO addNewMeasure(@RequestBody MeasureDTO measureDTO) {
        return measureService.saveMeasure(measureDTO);
    }

    @DeleteMapping("/measures/{id}")
    public String deleteMeasure(@PathVariable Integer id) {
        MeasureDTO measureDTO = measureService.getMeasure(id);

        if (measureDTO == null) {
            return "There is no measure with ID = " + id + " in database";
        }

        measureService.deleteMeasure(id);
        return "Measure with ID = " + id + " was deleted";
    }
}
