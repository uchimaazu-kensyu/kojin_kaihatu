package com.example.mailer.Service;


import com.example.mailer.Dao.UserDao;
import com.example.mailer.Entity.Parts;
import com.example.mailer.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public Parts getParts(){return userDao.getParts();}

}
