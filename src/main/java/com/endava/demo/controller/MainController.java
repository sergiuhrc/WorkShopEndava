package com.endava.demo.controller;

import com.endava.demo.dao.InternDAO;
import com.endava.demo.entity.Intern;
import com.endava.demo.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

import static com.endava.demo.entity.InternStreams.JAVA;

@Controller
public class MainController {

    @Autowired
    private InternService internService;

    @GetMapping("/")
    public String view(Model model){
        model.addAttribute("interns", internService.getAllInterns());
        return "index";
    }



}
