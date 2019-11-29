package com.example.animal.mapper;

import com.example.animal.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectAll();

    String getPassword(String name);

    void signUp(String name, String password, String email, String phone);

    void deleteById(int id);

    void insert(String name, String password, String email, String phone, String h_id);
}
