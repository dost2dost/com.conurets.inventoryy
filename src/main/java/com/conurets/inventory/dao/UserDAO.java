package com.conurets.inventory.dao;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.entity.User;

/**
 * @author MSA
 */

public interface UserDAO extends BaseDAO<User> {
    User findByName(String firstName, String lastName) throws InventoryException;
}