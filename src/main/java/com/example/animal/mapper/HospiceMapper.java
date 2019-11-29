package com.example.animal.mapper;

import com.example.animal.model.Hospice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospiceMapper {
    List<Hospice> selectAll();

    void deleteById(int id);

    void update(int old_id, int id, String name, String address, String postcode, int total_room_number, int spare_room_number, String remarks);

    void insert(int id, String name, String address, String postcode, int total_room_number, int spare_room_number, String remarks);
}
