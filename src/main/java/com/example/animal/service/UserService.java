package com.example.animal.service;

import com.example.animal.mapper.UserMapper;
import com.example.animal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2019/11/16 23:31
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    public String getPassword(String name) {
        return userMapper.getPassword(name);
    }

    public void signUp(String name, String password, String email, String phone) {
        userMapper.signUp(name,password,email,phone);
    }

    public void deleteById(int id) {
        userMapper.deleteById(id);
    }

    public void insert(String name, String password, String email, String phone, String h_id) {
        userMapper.insert(name,password,email,phone,h_id);
    }
}
