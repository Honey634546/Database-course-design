package com.example.animal.controller;

import com.example.animal.model.Animal;
import com.example.animal.model.Health;
import com.example.animal.model.User;
import com.example.animal.model.Vaccine;
import com.example.animal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Honey
 * @date 2019/11/16 2:49
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService = new UserService();

    @Autowired
    private AnimalService animalService = new AnimalService();

    @Autowired
    private HealthService healthService=new HealthService();

    @Autowired
    private VaccineService vaccineService=new VaccineService();

    @RequestMapping(value = "")
    public String to_login() {
        return "index";
    }

    @RequestMapping(value = "/user")
    public String login(HttpServletRequest request,Model model) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String pwd = userService.getPassword(name);

        List<Health> healths=healthService.selectAll();
        List<Vaccine> vaccines=vaccineService.selectAll();
        List<Animal> animals=animalService.selectAll();
        model.addAttribute("healths",healths);
        model.addAttribute("vaccines",vaccines);
        model.addAttribute("animals",animals);
        if (pwd.equals(password)) {
            return "tableuser";
        } else {
            return "forward:";
        }
    }

    @RequestMapping(value = "signup")
    public String signup(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        try {
            userService.signUp(name, password, email, phone);
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:";
        }
        return "forward:";
    }

    @RequestMapping(value = "/user/edit")
    public String edit(Model model) {
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "editUser";
    }

    @RequestMapping(value = "/user/delete")
    public String delete(int id){
        userService.deleteById(id);
        return "redirect:/user/edit";
    }

    @RequestMapping(value = "/user/insert2")
    public String insertPage(){
        return "insertUser";
    }

    @RequestMapping(value = "/user/insert")
    public String insert(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String h_id=request.getParameter("h_id");
        userService.insert(name,password,email,phone,h_id);
        return "redirect:/user/edit";
    }



}
