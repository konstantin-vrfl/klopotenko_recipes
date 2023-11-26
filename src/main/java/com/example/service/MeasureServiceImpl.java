package com.example.service;

import com.example.dao.MeasureDAO;
import com.example.entity.db.MeasureDB;
import com.example.entity.dto.MeasureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasureServiceImpl implements MeasureService {
    @Autowired
    private MeasureDAO measureDAO;

    @Override
    @Transactional
    public List<MeasureDTO> getAllMeasures() {
        return measureDAO.getAllMeasures()
                .stream()
                .map(MeasureDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MeasureDTO getMeasure(Integer id) {
        MeasureDB measureDB = measureDAO.getMeasure(id);
        return new MeasureDTO(measureDB);
    }

    @Override
    @Transactional
    public MeasureDTO saveMeasure(MeasureDTO measureDTO) {
        MeasureDB measureDB = new MeasureDB(measureDTO);
        measureDAO.saveMeasure(measureDB);

        return new MeasureDTO(measureDB);
    }

    @Override
    @Transactional
    public void deleteMeasure(Integer id) {
        measureDAO.deleteMeasure(id);
    }
}
