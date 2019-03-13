package com.conurets.inventory.service;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.Company;
import com.conurets.inventory.vo.CompanyVO;

import java.util.List;

/**
 * @author MSA
 */

public interface CompanyService {
    List<CompanyVO> findAll() throws InventoryException;

    CompanyVO findById(long id) throws InventoryException;

    void save(Company model) throws InventoryException;

    void update(Company model) throws InventoryException;

    void delete(long id) throws InventoryException;

    CompanyVO findByKeyValue(String key, Object value) throws InventoryException;

    List<CompanyVO> findAllByKeyValue(String key, Object value) throws InventoryException;
}