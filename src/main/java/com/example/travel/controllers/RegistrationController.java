package com.example.travel.controllers;


import com.example.travel.models.modelUser;
import com.example.travel.models.roleEnum;
import com.example.travel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/registration")
    public String regView() {
        return "/regis";
    }

    @PostMapping("/registration")
    public String reg(modelUser modelUser, Model model) {
        if (modelUser.getUsername() == null || modelUser.getPassword() == null) {
            model.addAttribute("message", "Имя пользователя и пароль не могут быть пустыми");
            return "/regis";
        }

        modelUser modelUserFromDb = userRepository.findByUsername(modelUser.getUsername());
        if (modelUserFromDb != null) {
            model.addAttribute("message", "Пользователь с таким логином уже существует");
            return "/regis";
        }

        modelUser.setActive(true);
        modelUser.setRoles(Collections.singleton(roleEnum.USER));

        userRepository.save(modelUser);

        return "redirect:/login";
    }
}