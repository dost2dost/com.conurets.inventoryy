package com.conurets.inventory.dao;

import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.exception.InventoryException;

/**
 * @author MSA
 */

public interface LoginUserDAO extends BaseDAO<LoginUser> {
    LoginUser findByUserId(long userId) throws InventoryException;
}