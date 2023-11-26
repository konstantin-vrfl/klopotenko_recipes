package com.example.entity.dto;

import com.example.entity.db.MeasureDB;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeasureDTO {
    private Integer id;

    private String name;

    public MeasureDTO() {
    }

    public MeasureDTO(MeasureDB measureDB) {
        if (measureDB == null) {
            return; //TODO Rewrite to converter
        }

        this.id = measureDB.getId();
        this.name = measureDB.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MeasureDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
