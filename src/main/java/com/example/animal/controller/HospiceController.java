package com.example.animal.controller;

import com.example.animal.model.Animal;
import com.example.animal.model.Hospice;
import com.example.animal.service.HospiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Honey
 * @date 2019/11/20 14:26
 */
@Controller
@RequestMapping(value = "/hospice")
public class HospiceController {
    @Autowired
    private HospiceService hospiceService;

    @RequestMapping(value = "/edit")
    public String edit(Model model) {
        List<Hospice> hospices = hospiceService.selectAll();
        model.addAttribute("hospices",hospices);
        return "editHospice";
    }

    @RequestMapping(value = "/delete")
    public String delete(int id){
        hospiceService.deleteById(id);
        return "redirect:/hospice/edit";
    }

    @RequestMapping(value = "/update")
    public String update(HttpServletRequest request){
        int old_id= Integer.parseInt(request.getParameter("old_id"));
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        String postcode=request.getParameter("postcode");
        int total_room_number= Integer.parseInt(request.getParameter("postcode"));
        int spare_room_number= Integer.parseInt(request.getParameter("spare_room_number"));
        String remarks=request.getParameter("request");
        hospiceService.update(old_id,id,name,address,postcode,total_room_number,spare_room_number,remarks);
        return "redirect:/hospice/edit";

    }

    @RequestMapping(value = "/insert2")
    public String insertPage(){
        return "insertHospice";
    }

    @RequestMapping(value = "/insert")
    public String insert(HttpServletRequest request)
    {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        String postcode=request.getParameter("postcode");
        int total_room_number= Integer.parseInt(request.getParameter("postcode"));
        int spare_room_number= Integer.parseInt(request.getParameter("spare_room_number"));
        String remarks=request.getParameter("request");
        hospiceService.insert(id,name,address,postcode,total_room_number,spare_room_number,remarks);
        return "redirect:/hospice/edit";
    }
}
