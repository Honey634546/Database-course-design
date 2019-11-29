package com.example.animal.controller;

import com.example.animal.model.Animal;
import com.example.animal.model.User;
import com.example.animal.service.AnimalService;
import com.example.animal.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Honey
 * @date 2019/11/20 1:58
 */
@Controller
@RequestMapping(value = "/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService = new AnimalService();

//    @RequestMapping(value = "/image")
//    public void image(int id, HttpServletResponse response) {
//        System.out.println(id);
//        Object img = animalService.getImgById(3);
//        System.out.println(img);
//        try {
//            OutputStream out = response.getOutputStream();
//            out.write((byte[]) img);
//            out.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @RequestMapping(value = "/edit")
    public String edit(Model model) {
        List<Animal> animals = animalService.selectAll();
        model.addAttribute("animals", animals);
        return "editAnimal";
    }

    @RequestMapping(value = "/delete")
    public String delete(int id) {
        animalService.deleteById(id);
        return "redirect:/animal/edit";
    }

    @RequestMapping(value = "/update")
    public String update(HttpServletRequest request) {
        String old_id = request.getParameter("old_id");
        String id = request.getParameter("id");
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String species = request.getParameter("species");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String image = request.getParameter("image");
        String h_id = request.getParameter("h_id");
//        animalService.update(old_id, id, number, name, species, sex, age, image, h_id);
        return "redirect:/animal/edit";
    }

    @RequestMapping(value = "/insert2")
    public String insertPage(){
        return "insertAnimal";
    }

}
