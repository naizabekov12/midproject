package kg.ulan.SpringSecurityApp.controllers;

import kg.ulan.SpringSecurityApp.models.Person;
import kg.ulan.SpringSecurityApp.security.PersonDetails;
import kg.ulan.SpringSecurityApp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HelloController {
    private final PersonService personService;

    @Autowired
    public HelloController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        List<Person> list = personService.findAll();
        model.addAttribute("findAll",list);
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.person());
        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
