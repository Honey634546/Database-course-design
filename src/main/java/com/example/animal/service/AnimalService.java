package com.example.animal.service;

import com.example.animal.mapper.AnimalMapper;
import com.example.animal.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Honey
 * @date 2019/11/17 21:51
 */
@Service
public class AnimalService {
    @Autowired
    private AnimalMapper animalMapper;


    public List<Animal> selectAll() {
        return  animalMapper.selectAll();
    }

    public Object getImgById(int id) {
        return animalMapper.getImgById(id);
    }

    public void deleteById(int id) {
        animalMapper.deleteById(id);
    }
}
