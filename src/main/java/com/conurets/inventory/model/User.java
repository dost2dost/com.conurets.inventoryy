package com.conurets.inventory.model;

import com.conurets.inventory.util.validation.annotation.InventoryNotNull;

import java.io.Serializable;

/**
 * @author MSA
 */

public class User implements Serializable {
    private Long userId;
    @InventoryNotNull(message = "Username cannot be null")
    private String username;
    @InventoryNotNull(message = "Email address cannot be null")
    private String email;
    @InventoryNotNull(message = "Company id cannot be null")
    private Integer companyId;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}