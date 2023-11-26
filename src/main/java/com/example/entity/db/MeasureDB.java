package com.example.entity.db;

import com.example.entity.dto.MeasureDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "measures")
public class MeasureDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public MeasureDB() {
    }

    @Deprecated
    public MeasureDB(String name) {
        this.name = name;
    }

    public MeasureDB(MeasureDTO measureDTO) {
        if (measureDTO == null) {
            return;
        }

        this.id = measureDTO.getId();
        this.name = measureDTO.getName();
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
        return "Measure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
