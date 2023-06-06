package com.example.mailer.Controller;


import com.example.mailer.Entity.Parts;
import com.example.mailer.Entity.User;
import com.example.mailer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserRestController {



    @Autowired
    private UserService userService;

    public UserRestController() {
    }


    @GetMapping("/getUsers")
    public List<User> getUsers(){
        System.out.println("getUsers(Javaレストコントローラー)");
        try{
            List<User> userList =userService.findAll();;
            return userList ;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/confirmation")
    public Parts confirmation(){
        System.out.println("confirmationまで来た");
        try{
            Parts result =userService.getParts();
            return result ;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }




}
