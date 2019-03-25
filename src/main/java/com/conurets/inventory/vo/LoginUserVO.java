package com.conurets.inventory.vo;

import java.io.Serializable;

/**
 * Created by Iraj on 03/15/19.
 */

public class LoginUserVO implements Serializable {

    private Integer userId;
    private String email;
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
