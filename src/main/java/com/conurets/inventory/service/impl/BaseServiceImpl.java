package com.conurets.inventory.service.impl;

import com.conurets.inventory.dao.BaseDAO;
import com.conurets.inventory.entity.BaseEntity;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.service.BaseService;
import com.conurets.inventory.util.InventoryHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author MSA
 */

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    private BaseDAO<T> baseDAO;

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(baseDAO, "baseDAO");
    }

    public T findById(long id) throws InventoryException {
        InventoryHelper.checkPositive(id, "id");

        T entity = baseDAO.findById(id);

        InventoryHelper.checkEntityExists(entity, id);

        return entity;
    }

    public void save(T entity) throws InventoryException {
        InventoryHelper.checkNull(entity, "entity");

        baseDAO.save(entity);
    }

    public void update(T entity) throws InventoryException {
        InventoryHelper.checkNull(entity, "entity");

        baseDAO.update(entity);
    }

    public void delete(long id) throws InventoryException {
        InventoryHelper.checkPositive(id, "id");

        T entity = baseDAO.findById(id);

        InventoryHelper.checkNull(entity, "entity");

        baseDAO.delete(entity);
    }

    public List<T> findAll() throws InventoryException {
        List<T> entity = baseDAO.findAll();

        InventoryHelper.checkNull(entity, "entity");

        return entity;
    }

    public long count() throws InventoryException {
        return baseDAO.count();
    }

    public List<T> findAllByKeyValue(String key, Object value) throws InventoryException {
        List<T> entity = baseDAO.findAllByKeyValue(key, value);

        InventoryHelper.checkNull(entity, "entity");

        return entity;
    }

    public T findByKeyValue(String key, Object value) throws InventoryException {
        T entity = baseDAO.findByKeyValue(key, value);

        InventoryHelper.checkNull(entity, "entity");

        return entity;
    }

    public BaseDAO<T> getBaseDAO() {
        return baseDAO;
    }
}