package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLoginForm(Model model) {

        //ログイン画面へ遷移。
        return "login";
    }

    @RequestMapping("/task")
    public String login(Model model) {

        //メインページ。
        return "task";
    }
}
