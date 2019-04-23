package com.conurets.inventory.service;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.Items;
import com.conurets.inventory.model.User;
import com.conurets.inventory.vo.ItemVO;

import java.util.List;

/**
 * @author MSA
 */

public interface ItemService {

    List<ItemVO> findAll() throws InventoryException;

    ItemVO findById(long id) throws InventoryException;

    void save(Items model) throws InventoryException;

    void update(User model) throws InventoryException;

    void delete(long id) throws InventoryException;

    ItemVO findByKeyValue(String key, Object value) throws InventoryException;

    List<ItemVO> findAllByKeyValue(String key, Object value) throws InventoryException;

    ItemVO findByName(String firstName, String lastName) throws InventoryException;
}