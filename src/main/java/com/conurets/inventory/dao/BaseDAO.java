package com.conurets.inventory.dao;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.entity.BaseEntity;

import java.util.List;

/**
 * @author MSA
 */

public interface BaseDAO<T extends BaseEntity> {
    List<T> findAll() throws InventoryException;

    List<T> findAllByKeyValue(String key, Object value) throws InventoryException;

    T findById(long id) throws InventoryException;

    T findByKeyValue(String key, Object value) throws InventoryException;

    void save(T entity) throws InventoryException;

    void update(T entity) throws InventoryException;

    void delete(T entity) throws InventoryException;

    long count() throws InventoryException;
}