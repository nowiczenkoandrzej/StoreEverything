package com.an.storeeverything.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.an.storeeverything.models.CustomUserDetails;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("username", userDetails.getUsername());
        return "dashboard";
    }
}
