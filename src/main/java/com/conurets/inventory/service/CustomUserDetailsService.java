package com.conurets.inventory.service;

import com.conurets.inventory.vo.LoginUserVO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author MSA
 */

public interface CustomUserDetailsService extends UserDetailsService {
    LoginUserVO login(String username, String password);
}