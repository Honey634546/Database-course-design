package com.example.animal.service;

import com.example.animal.mapper.AdminMapper;
import com.example.animal.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Honey
 * @date 2019/11/15 20:30
 */
@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public String getPassword(String name) {
        return adminMapper.getPassword(name);
    }

    public List<Admin> selectAll()
    {
        return adminMapper.selectAll();
    }

}
