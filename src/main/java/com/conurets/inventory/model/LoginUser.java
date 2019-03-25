package com.conurets.inventory.model;

import com.conurets.inventory.util.validation.annotation.InventoryNotNull;

import java.io.Serializable;

/**
 * Created by Iraj on 03/18/19.
 */
public class LoginUser implements Serializable {

    private Long loginId;

    @InventoryNotNull(message = "UserId cannot be null")
    private Integer userId;

    @InventoryNotNull(message = "Email address cannot be null")
    private String email;

    @InventoryNotNull(message = "Password cannot be null")
    private String password;


    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

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
