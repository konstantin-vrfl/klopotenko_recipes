package com.example.service;

import com.example.entity.db.MeasureDB;
import com.example.entity.dto.MeasureDTO;

import java.util.List;

public interface MeasureService {

    List<MeasureDTO> getAllMeasures();

    MeasureDTO getMeasure(Integer id);

    MeasureDTO saveMeasure(MeasureDTO measureDTO);

    void deleteMeasure(Integer id);
}
