package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.UserDtls;
import com.example.demo.Repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/preinscription")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserDtls());
        return "error";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDtls u, HttpSession session) {
        System.out.println(u);
        repo.save(u);

        if (u.getNote() > 12) {
           
            return "redirect:/successPage";
        } else {
     
            return "redirect:/failurePage";
        }
    }

    @GetMapping("/successPage")
    public String successPage() {
        return "successPage";  
    }

    @GetMapping("/failurePage")
    public String failurePage() {
        return "failurePage";  
    }
}
