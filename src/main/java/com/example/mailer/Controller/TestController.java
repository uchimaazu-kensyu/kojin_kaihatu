package com.example.mailer.Controller;

import com.example.mailer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestController {

    @Autowired
    UserService userService;


    @GetMapping("/index")
    public String index(){
        userService.findAll();
        return "index";
    }

}
