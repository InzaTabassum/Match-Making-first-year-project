package com.example.project;

import java.io.Serializable;

public class SignUpData extends LoginData implements Serializable { // inherited from logindata class
    public SignUpData(String username, String password) {
        super(username, password);
    }
}
