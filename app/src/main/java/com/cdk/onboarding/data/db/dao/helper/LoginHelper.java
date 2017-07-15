package com.cdk.onboarding.data.db.dao.helper;

/**
 * Created by julurur on 12/07/17.
 */

public class LoginHelper {
    public boolean isValidUser(String userName,String password){
        return userName.equals(password);
    }
}
