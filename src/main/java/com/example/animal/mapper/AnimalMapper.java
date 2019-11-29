package com.example.animal.mapper;

import com.example.animal.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalMapper {
    List<Animal> selectAll();

    Object getImgById(int id);

    void deleteById(int id);
}
