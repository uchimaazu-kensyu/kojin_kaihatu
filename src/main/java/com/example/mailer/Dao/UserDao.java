package com.example.mailer.Dao;

import com.example.mailer.Entity.Parts;
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




}
