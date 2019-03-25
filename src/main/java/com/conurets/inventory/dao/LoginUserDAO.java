package com.conurets.inventory.dao;

import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.exception.InventoryException;

/**
 * @author MSA
 */

public interface LoginUserDAO extends BaseDAO<LoginUser> {

    LoginUser findByEmail(String emailId) throws InventoryException;
/*
    LoginUser login(LoginUser loginUser) throws InventoryException;*/
}