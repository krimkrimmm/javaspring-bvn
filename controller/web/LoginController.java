package vn.scrip.buoi24.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }
}
