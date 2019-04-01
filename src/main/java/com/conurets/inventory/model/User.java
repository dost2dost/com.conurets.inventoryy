package com.conurets.inventory.model;

import com.conurets.inventory.util.validation.annotation.InventoryNotNull;
import com.conurets.inventory.util.validation.annotation.InventoryUsername;

import java.io.Serializable;

/**
 * @author MSA
 */

public class User implements Serializable {
    private Long userId;
    @InventoryNotNull(message = "Username cannot be null")
    @InventoryUsername(message = "Username already exists. Please try again")
    private String username;
    @InventoryNotNull(message = "Password cannot be null")
    private String password;
    @InventoryNotNull(message = "Email address cannot be null")
    private String email;
    @InventoryNotNull(message = "Company id cannot be null")
    private Long companyId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}