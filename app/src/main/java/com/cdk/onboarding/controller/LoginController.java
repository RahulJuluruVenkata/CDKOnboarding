package com.cdk.onboarding.controller;

import java.util.Random;

/**
 * Created by julurur on 12/07/17.
 */

public class LoginController {
    public boolean isValidUser(String userName,String password){
        return userName.equals(password);
    }
}
