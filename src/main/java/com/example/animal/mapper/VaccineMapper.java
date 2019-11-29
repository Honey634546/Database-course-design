package com.example.animal.mapper;

import com.example.animal.model.Vaccine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineMapper {
    List<Vaccine> selectAll();

    void deleteById(int id);

    void update(int old_id, int id, int a_id, int u_id, String vaccine, String date, String remarks);

    void insert(int id, int a_id, int u_id, String vaccine, String date, String remarks);
}
