package com.conurets.inventory.service;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.User;
import com.conurets.inventory.vo.SupplierinfoVO;
import com.conurets.inventory.vo.UserVO;

import java.util.List;

/**
 * @author MSA
 */

public interface SupplierService {
    //List<UserVO> findAll() throws InventoryException;

    SupplierinfoVO findById(long id) throws InventoryException;

//    void save(User model) throws InventoryException;
//
//    void update(User model) throws InventoryException;
//
//    void delete(long id) throws InventoryException;
//
//    UserVO findByKeyValue(String key, Object value) throws InventoryException;
//
//    List<UserVO> findAllByKeyValue(String key, Object value) throws InventoryException;
//
//    UserVO findByName(String firstName, String lastName) throws InventoryException;
}