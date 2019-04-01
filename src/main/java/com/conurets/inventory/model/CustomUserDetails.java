package com.conurets.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author MSA
 */

public class CustomUserDetails implements UserDetails {
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private Boolean isAccountNonExpired;
    @JsonIgnore
    private Boolean isAccountNonLocked;
    @JsonIgnore
    private Boolean isCredentialsNonExpired;
    @JsonIgnore
    private Boolean isEnabled;
    private String token;
    private Long userId;
    private Long companyId;
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             Long userId, Long companyId) {
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = Boolean.TRUE;
        this.isAccountNonLocked = Boolean.TRUE;
        this.isCredentialsNonExpired = Boolean.TRUE;
        this.isEnabled = Boolean.TRUE;
        this.authorities = authorities;
        this.userId = userId;
        this.companyId = companyId;
    }

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             Long userId, Long companyId, String token) {
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = Boolean.TRUE;
        this.isAccountNonLocked = Boolean.TRUE;
        this.isCredentialsNonExpired = Boolean.TRUE;
        this.isEnabled = Boolean.TRUE;
        this.authorities = authorities;
        this.userId = userId;
        this.companyId = companyId;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @JsonIgnore
    public boolean isEnabled() {
        return isEnabled;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCompanyId() {
        return companyId;
    }
}