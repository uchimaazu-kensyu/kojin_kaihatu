package com.example.mailer.Dao;

import com.example.mailer.Entity.Parts;
import com.example.mailer.Entity.SendTo;
import com.example.mailer.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

//    @Autowired
//    private JdbcTemplate jdbcForMaxId;

    public List<User> findAll(){

        var result = jdbcTemplate.query("SELECT * FROM Users ORDER BY id ",
                new DataClassRowMapper<>(User.class));

        System.out.println(result);
        return result;
    }

    public Parts getParts(){
        List<Parts> result =jdbcTemplate.query("SELECT * FROM parts WHERE id =1",
                new DataClassRowMapper<>(Parts.class));

        System.out.println(result);
        return result.isEmpty()? null:result.get(0);
    }


    public SendTo getMail(){
        List<SendTo> result =jdbcTemplate.query("SELECT * FROM sendto WHERE id =1",
                new DataClassRowMapper<>(SendTo.class));

        System.out.println(result);
        return result.isEmpty()? null:result.get(0);
    }

    public int updateMail(SendTo mailInfo){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("mail", mailInfo.getMail());
        param.addValue("cc1", mailInfo.getCc1());
        param.addValue("cc2", mailInfo.getCc2());
        param.addValue("cc3", mailInfo.getCc3());
        param.addValue("cc4", mailInfo.getCc4());
        param.addValue("cc5", mailInfo.getCc5());

        return jdbcTemplate.update("UPDATE sendto SET mail = :mail ,cc1 = :cc1,cc2 = :cc2,cc3 = :cc3,cc4 = :cc4,cc5 = :cc5 WHERE id = 1", param);

    }



    public int addUser(User userInfo){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", userInfo.getName());
        param.addValue("selectedFlg", userInfo.getSelectedFlg());
        return jdbcTemplate.update("INSERT INTO users (name,selectedFlg) VALUES(:name,:selectedFlg) ", param);
    }

    public int updateUser(User userInfo){
        MapSqlParameterSource param = new MapSqlParameterSource();

        param.addValue("id", userInfo.getId());
        param.addValue("name", userInfo.getName());
        param.addValue("selectedFlg", userInfo.getSelectedFlg());
        return jdbcTemplate.update("UPDATE users SET name = :name ,selectedFlg = :selectedFlg WHERE id = :id", param);
    }

    public int deleteUser(int id){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        return jdbcTemplate.update("DELETE FROM users WHERE id = :id", param);
    }

    public void updateTemplate(String newTemplate){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("newTemplate", newTemplate);
        jdbcTemplate.update("UPDATE parts set template = :newTemplate WHERE id =1", param);

    }

    public int updateSubject(String newSubject){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("newSubject",newSubject);
        return jdbcTemplate.update("UPDATE parts set subject = :newSubject WHERE id =1",param);

    }

    public int resetSubject(){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id",2);
        return jdbcTemplate.update("UPDATE parts set subject = (SELECT subject FROM parts WHERE id=:id) WHERE id =1;",param);
    }

    public int resetTemplate(){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id",2);
        return jdbcTemplate.update("UPDATE parts set template = (SELECT template FROM parts WHERE id=:id) WHERE id =1;",param);
    }







}
