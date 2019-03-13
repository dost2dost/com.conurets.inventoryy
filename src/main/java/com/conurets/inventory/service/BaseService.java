package com.conurets.inventory.service;

import com.conurets.inventory.entity.BaseEntity;
import com.conurets.inventory.exception.InventoryException;

import java.util.List;

/**
 * @author MSA
 */

public interface BaseService<T extends BaseEntity> {
    T findById(long id) throws InventoryException;

    void save(T entity) throws InventoryException;

    void update(T entity) throws InventoryException;

    void delete(long id) throws InventoryException;

    List<T> findAll() throws InventoryException;

    long count() throws InventoryException;

    List<T> findAllByKeyValue(String key, Object value) throws InventoryException;

    T findByKeyValue(String key, Object value) throws InventoryException;
}