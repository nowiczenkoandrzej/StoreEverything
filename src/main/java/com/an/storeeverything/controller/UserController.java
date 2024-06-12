package com.an.storeeverything.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.an.storeeverything.models.UserEntity;
import com.an.storeeverything.models.RolesEntity;
import com.an.storeeverything.services.UserService;
import com.an.storeeverything.repository.RolesRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserEntity user = new UserEntity();
        List<RolesEntity> roles = rolesRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserEntity user) {
        try {
            userService.save(user);
            return "redirect:/login";
        } catch (Exception e) {
            e.printStackTrace();
            return "register";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new UserEntity());

        return "login";
    }

    @PostMapping("/login-user")
    public String loginUser(@ModelAttribute UserEntity user, Model model) {
        var currentUser = userService.findByUsername(user.getUsername());

        System.out.println(user);
        System.out.println(currentUser);


        if(currentUser == null) {
            System.out.println("User not found");
            return "login";
        }

        if(currentUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", user);
            return "redirect:/home";
        } else return "login";


    }


    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
