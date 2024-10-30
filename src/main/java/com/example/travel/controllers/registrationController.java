package com.example.travel.controllers;


import com.example.travel.models.User;
import com.example.travel.models.roleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class registrationController {
    @Autowired
    private com.example.travel.repositories.userRepository userRepository;
    @GetMapping("/registration")
    private String RegView()
    {
        return "auth/regis";
    }
    @PostMapping("/registration")
    private String Reg(User user, Model model)
    {
        User user_from_db = userRepository.findByUsername(user.getUsername());
        if (user_from_db != null)
        {
            model.addAttribute("message", "Пользователь с таким логином уже существует");
            return "auth/regis";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(roleEnum.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}