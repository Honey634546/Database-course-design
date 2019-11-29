package com.example.animal.controller;

import com.example.animal.model.Health;
import com.example.animal.model.Hospice;
import com.example.animal.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Honey
 * @date 2019/11/20 14:39
 */
@Controller
@RequestMapping(value = "/health")
public class HealthController {
    @Autowired
    private HealthService healthService;

    @RequestMapping(value = "/edit")
    public String edit(Model model) {
        List<Health> healths = healthService.selectAll();
        model.addAttribute("healths",healths);
        return "editHealth";
    }

    @RequestMapping(value = "/delete")
    public String delete(int id){
        healthService.deleteById(id);
        return "redirect:/health/edit";
    }

    @RequestMapping(value ="/update")
    public String update(HttpServletRequest request){
        int old_id = Integer.parseInt(request.getParameter("old_id"));
        int id = Integer.parseInt(request.getParameter("id"));
        int a_id = Integer.parseInt(request.getParameter("a_id"));
        int u_id = Integer.parseInt(request.getParameter("u_id"));
        String health_info = request.getParameter("health_info");
        String date = request.getParameter("date");
        String remarks = request.getParameter("remarks");
        healthService.update(old_id,id,a_id,u_id,health_info,date,remarks);
        return "redirect:/health/edit";
    }

    @RequestMapping(value = "/insert2")
    public String insertPage(){
        return "insertHealth";
    }

    @RequestMapping(value = "/insert")
    public String insert(HttpServletRequest request)
    {
        int id = Integer.parseInt(request.getParameter("id"));
        int a_id = Integer.parseInt(request.getParameter("a_id"));
        int u_id = Integer.parseInt(request.getParameter("u_id"));
        String health_info = request.getParameter("health_info");
        String date = request.getParameter("date");
        System.out.println(date);
        String remarks = request.getParameter("remarks");
        healthService.insert(id,a_id,u_id,health_info,date,remarks);
        return "redirect:/health/edit";
    }
}
