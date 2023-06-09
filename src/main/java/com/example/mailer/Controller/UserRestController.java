package com.example.mailer.Controller;


import com.example.mailer.Entity.Parts;
import com.example.mailer.Entity.SendTo;
import com.example.mailer.Entity.User;
import com.example.mailer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
        try{
            List<User> userList =userService.findAll();;
            return userList ;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/confirmation")
    public Parts confirmation(){
        try{
            Parts result =userService.getParts();
            return result ;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getMail")
    public SendTo getMail(){
        try{
            SendTo result =userService.getMail();
            return result ;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateMail")
    public int updateMail(@RequestBody SendTo mailInfo){
        int result =userService.updateMail(mailInfo);
        return result;
    }


    @PostMapping("/addUser")
    public int addUser(@RequestBody User userInfo){
        int result =userService.addUser(userInfo);
        return result;
    }



    @PutMapping("/updateUser")
    public int updateUser(@RequestBody User userInfo){
        int result =userService.updateUser(userInfo);
        return result;
    }

    @DeleteMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable("id") int id){
        int result =userService.deleteUser(id);
        return result;
    }


//    @PostMapping("/sendTemplate")
//    public void updateTemplate(@RequestBody Parts newTemplate){
//        System.out.println(newTemplate);
//        userService.updateTemplate(newTemplate);
//    }

    @PostMapping(value = "/sendTemplate", consumes = "text/plain;charset=UTF-8")
    public void updateTemplate(@RequestBody String newTemplate){
        if(newTemplate.equals("reset")){
            userService.resetTemplate();
            return;
        }
        userService.updateTemplate(newTemplate);
    }

    @PostMapping(value = "updateSubject",consumes = "text/plain;charset=UTF-8")
    public int updateSubject(@RequestBody String newSubject){
        if(newSubject.equals("reset")){
            return  userService.resetSubject();
        }
        return userService.updateSubject(newSubject);

    }




}
