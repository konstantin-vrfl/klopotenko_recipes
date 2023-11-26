package com.example.dao;

import com.example.entity.db.MeasureDB;

import java.util.List;

public interface MeasureDAO {

    List<MeasureDB> getAllMeasures();

    MeasureDB getMeasure(Integer id);

    void saveMeasure(MeasureDB measureDB);

    void deleteMeasure(Integer id);
}
