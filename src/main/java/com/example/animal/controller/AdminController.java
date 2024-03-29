package com.example.animal.controller;

import com.example.animal.model.*;
import com.example.animal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Honey
 * @date 2019/11/15 17:16
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService=new AdminService();

    @Autowired
    private AnimalService animalService=new AnimalService();

    @Autowired
    private UserService userService=new UserService();

    @Autowired
    private HospiceService hospiceService=new HospiceService();




    @RequestMapping(value = "")
    public String admin() {
        return "adminlogin";
    }

    @RequestMapping(value = "/login")
    public String login(String name, String password, Model model) {
        String pwd = adminService.getPassword(name);

        model.addAttribute("name", name);

        if (password.equals(pwd)) {
            return "table";
        } else {
            return "adminlogin";
        }
    }

    @RequestMapping(value = "/table")
    public String table(Model model) {
        List<User> users=userService.selectAll();
        List<Animal> animals=animalService.selectAll();
        List<Hospice> hospices=hospiceService.selectAll();
        model.addAttribute("users",users);
        model.addAttribute("animals",animals);
        model.addAttribute("hospices",hospices);
        return "table";
    }

}
