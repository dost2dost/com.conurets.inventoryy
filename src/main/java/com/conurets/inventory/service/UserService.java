package com.conurets.inventory.service;

import com.conurets.inventory.entity.UserRole;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.User;
import com.conurets.inventory.vo.UserVO;

import java.util.List;

/**
 * @author MSA
 */

public interface UserService {
    List<UserVO> findAll() throws InventoryException;

    UserVO findById(long id) throws InventoryException;

    void save(User model) throws InventoryException;

    void update(User model) throws InventoryException;

    void delete(long id) throws InventoryException;

    UserVO findByKeyValue(String key, Object value) throws InventoryException;

    List<UserVO> findAllByKeyValue(String key, Object value) throws InventoryException;

    UserRole findUserRoleByUserId(long userId) throws InventoryException;
}