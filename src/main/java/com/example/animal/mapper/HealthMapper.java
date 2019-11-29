package com.example.animal.mapper;

import com.example.animal.model.Health;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthMapper {
    List<Health> selectAll();

    void deleteById(int id);

    void update(int old_id, int id, int a_id, int u_id, String health_info, String date, String remarks);

    void insert(int id, int a_id, int u_id, String health_info, String date, String remarks);
}
