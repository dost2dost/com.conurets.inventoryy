package com.conurets.inventory.converter;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.vo.LoginUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Iraj on 03/15/19.
 */
@Component
public class LoginConvertor {

    private static final Logger logger = LoggerFactory.getLogger(UserConverter.class);

    @Autowired
    private DAOFactory daoFactory;

    public LoginUserVO toController(LoginUser entity) {

        LoginUserVO loginUserVO = new LoginUserVO();

        loginUserVO.setUserId(entity.getUserId());
        loginUserVO.setEmail(entity.getEmail());
        loginUserVO.setPassword(entity.getPassword());

        return loginUserVO;
    }
}
