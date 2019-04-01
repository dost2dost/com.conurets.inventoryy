package com.conurets.inventory.dao;

import com.conurets.inventory.entity.UserRole;
import com.conurets.inventory.exception.InventoryException;

/**
 * @author MSA
 */

public interface UserRoleDAO extends BaseDAO<UserRole> {
    UserRole findUserRoleByUserId(long userId) throws InventoryException;
}