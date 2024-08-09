package com.Butterfly.controller;

import com.Butterfly.services.NailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private NailService nailService;
    
    @GetMapping("/")
    public String listado(Model model) {
        var lista = nailService.getNail(false);
        model.addAttribute("nails", lista);
        return "index";
    }
    
}
