package com.example.ulan.controllers;


import com.example.ulan.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class MainController {
    private PersonDTO personDTO;

    @Autowired
    public MainController(PersonDTO personDTO) {
        this.personDTO = personDTO;
    }

    @GetMapping
    public String allPeople(Model model){
        model.addAttribute("showAllPeople",personDTO.allUsers());
        return "index";
    }
}
