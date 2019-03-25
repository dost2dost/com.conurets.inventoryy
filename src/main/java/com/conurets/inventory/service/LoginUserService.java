package com.conurets.inventory.service;

import com.conurets.inventory.model.LoginUser;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.vo.LoginUserVO;

/**
 * Created by Iraj on 03/15/19.
 */
public interface LoginUserService {


    LoginUserVO findByKeyValue(String key, Object value) throws InventoryException;

    void loginSubmit(LoginUser model) throws InventoryException ;

}
