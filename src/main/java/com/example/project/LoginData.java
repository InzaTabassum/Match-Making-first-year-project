package com.example.project;

import java.io.Serializable;

public class LoginData implements Serializable { //used for inheritance
    private String username;
    private String password;

    public LoginData(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
