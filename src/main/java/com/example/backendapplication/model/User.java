// Write your code here
package com.example.backendapplication.model;

public class User{
    private String userName;
    private String password;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }

    public void setPassword(String userName){
        this.userName = userName;
    }
    public String getPassword(){
        return this.userName;
    }
}