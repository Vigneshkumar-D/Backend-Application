package com.example.backendapplication.service;

import com.example.backendapplication.model.UserRowMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import com.example.backendapplication.*;
import com.example.backendapplication.model.User;
import com.example.backendapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


// Write your code here

@Service
public class UserH2Service implements UserRepository{

    @Autowired
    private JdbcTemplate db;
    private static final String SECRET_KEY = "your_secret_key_here";
    private static final long EXPIRATION_TIME = 86400000;

    private static String token;

    private static String name;

    @Override
    public String userLogin(User userDetails){
        String hashedPassword = String.valueOf(db.queryForObject("SELECT password FROM userdata WHERE name = ?",
                                new UserRowMapper(),userDetails.getUserName()));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isPasswordMatch = passwordEncoder.matches(userDetails.getPassword(), hashedPassword);
        if(isPasswordMatch){
            name = userDetails.getUserName();
            Date now = new Date();
            Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

            token = Jwts.builder()
                    .setSubject(userDetails.getUserName())
                    .setIssuedAt(now)
                    .setExpiration(expiration)
                    .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                    .compact();

            return token;
        }

        return "Invalid password";
    }
    @Override
    public User userSignup(User userDetails){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encryptPassword =  passwordEncoder.encode(userDetails.getPassword());
        db.update("INSERT INTO userdata(name, password) VALUES(?, ?)", userDetails.getUserName(), encryptPassword);
        User user = db.queryForObject("SELECT * FROM userdata WHERE name = ? and password = ?", new UserRowMapper(),
                    userDetails.getUserName(), encryptPassword);

        return user;

    };

    @Override
    public String userHome(String jwtToken){
        if(jwtToken.equals(token)) {
            return "Welcome " + name;
        }
        return "Invalid User";
    };

}