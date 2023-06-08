package com.example.mailer.Service;


import com.example.mailer.Dao.UserDao;
import com.example.mailer.Entity.Parts;
import com.example.mailer.Entity.SendTo;
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

    public SendTo getMail(){return userDao.getMail();}

    public int updateMail(SendTo mailInfo){return userDao.updateMail(mailInfo);}

    public int addUser(User userInfo){return userDao.addUser(userInfo);}

    public int updateUser(User userInfo){return userDao.updateUser(userInfo);}

    public int deleteUser(int id){return userDao.deleteUser(id);}

    public void updateTemplate(String newTemplate){ userDao.updateTemplate(newTemplate);}

    public int updateSubject(String newSubject){return userDao.updateSubject(newSubject);}

    public int resetSubject(){return userDao.resetSubject();}

    public int resetTemplate(){return userDao.resetTemplate();}


}
