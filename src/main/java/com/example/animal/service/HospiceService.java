package com.example.animal.service;

import com.example.animal.mapper.HospiceMapper;
import com.example.animal.model.Hospice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Honey
 * @date 2019/11/18 23:45
 */
@Service
public class HospiceService {
    @Autowired
    private HospiceMapper hospiceMapper;

    public List<Hospice> selectAll() {
        return hospiceMapper.selectAll();
    }

    public void deleteById(int id) {
        hospiceMapper.deleteById(id);
    }

    public void update(int old_id, int id, String name, String address, String postcode, int total_room_number, int spare_room_number, String remarks) {
        hospiceMapper.update(old_id,id,name,address,postcode,total_room_number,spare_room_number,remarks);
    }

    public void insert(int id, String name, String address, String postcode, int total_room_number, int spare_room_number, String remarks) {
        hospiceMapper.insert(id,name,address,postcode,total_room_number,spare_room_number,remarks);
    }
}
