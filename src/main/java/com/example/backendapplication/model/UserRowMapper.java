package com.example.backendapplication.model;
import com.example.backendapplication.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

// Write your code here

public class UserRowMapper implements RowMapper<User>{
    public User mapRow(ResultSet rs, int rowNum) throws SQLException{

        return new User(
                rs.getString("userName"),
                rs.getString("password")
        );

    }
}