package com.example.backendapplication.repository;

import com.example.backendapplication.model.User;
// import java.util.*;

public interface UserRepository{
    String userLogin(User userDetails);
    User userSignup(User userDetails);
    String userHome(String jwsToken);
    // String getPlayerById(int playerId);
    // Player addPlayer(Player player);
    // Player updatePlayer(int playerId, Player player);
    // void deletePlayer(int playerId);
}