package com.conurets.inventory.converter;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.model.CustomUserDetails;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.LoginUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * Created by Iraj on 03/15/19.
 */
@Component
public class LoginConvertor {
    private static final Logger logger = LoggerFactory.getLogger(UserConverter.class);

    @Autowired
    private DAOFactory daoFactory;

    public LoginUserVO toController(CustomUserDetails customUserDetails) {
        LoginUserVO loginUserVO = new LoginUserVO();

        loginUserVO.setUserId(customUserDetails.getUserId());
        loginUserVO.setUsername(customUserDetails.getUsername());
        loginUserVO.setCompanyId(customUserDetails.getCompanyId());
        loginUserVO.setCompanyName(daoFactory.getCompanyDAO().findById(customUserDetails.getCompanyId()).getCompany());
        loginUserVO.setToken(InventoryUtil.encode(customUserDetails.getToken()));
        loginUserVO.setAuthority(InventoryUtil.getUserRole(customUserDetails.getAuthorities()));

        return loginUserVO;
    }
}