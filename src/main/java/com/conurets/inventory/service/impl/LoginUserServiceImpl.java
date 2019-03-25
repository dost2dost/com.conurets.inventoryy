package com.conurets.inventory.service.impl;

import com.conurets.inventory.converter.LoginConvertor;
import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.LoginUser;
import com.conurets.inventory.service.LoginUserService;
import com.conurets.inventory.vo.LoginUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Iraj on 03/15/19.
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private DAOFactory daoFactory;

    @Autowired
    private LoginConvertor loginConvertor;


    public LoginUserVO findByKeyValue(String key, Object value) throws InventoryException {
/*
       LoginUser loginExist = daoFactory.getLoginUserDAO().findByKeyValue(key, value);

        if (loginExist == null) {
            InventoryHelper.checkNull(loginExist, "entity");
        }

        return loginConvertor.toController(loginExist);*/

        return loginConvertor.toController(null);

    }

    public void loginSubmit(LoginUser model) throws InventoryException {



    }


}
