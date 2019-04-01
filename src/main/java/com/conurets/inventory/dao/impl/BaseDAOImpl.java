package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.BaseDAO;
import com.conurets.inventory.entity.BaseEntity;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author MSA
 */

@Transactional
public abstract class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {
    private static final Logger logger = LoggerFactory.getLogger(BaseDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> entityClass;

    public BaseDAOImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Checking @Autowired object
     */

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(sessionFactory, "sessionFactory");
    }

    /**
     * Generic method get all data
     * @return list
     * @throws InventoryException
     */

    public List<T> findAll() throws InventoryException {
        Query<T> q = createQuery();

        return q.getResultList();
    }

    /**
     * Generic method get all data by key and value
     * @param key
     * @param value
     * @return list
     * @throws InventoryException
     */

    public List<T> findAllByKeyValue(String key, Object value) throws InventoryException {
        Query<T> q = createQueryByKeyValue(key, value);

        return q.getResultList();
    }

    /**
     * Generic method get data by key and value
     * @param key
     * @param value
     * @return object
     * @throws InventoryException
     */

    public T findByKeyValue(String key, Object value) throws InventoryException {
        Query<T> q = createQueryByKeyValue(key, value);

        T entity = null;

        if (q.getResultList() != null && q.getResultList().size() > InventoryConstants.INT_ZERO) {
            entity = (T) q.getResultList().get(InventoryConstants.INT_ZERO);
        }

        return entity;
    }

    /**
     * Generic method get data by id
     * @param id
     * @return object
     * @throws InventoryException
     */

    public T findById(long id) throws InventoryException {
        T entity = (T) sessionFactory.getCurrentSession().get(getEntityClass(), id);

        InventoryHelper.checkEntityExists(entityClass, id);

        return entity;
    }

    /**
     * Generic method save data
     * @param entity
     * @throws InventoryException
     */

    public void save(T entity) throws InventoryException {
        InventoryHelper.checkNull(entity, "entity");

        getSession().saveOrUpdate(entity);
    }

    /**
     * Generic method update data
     * @param entity
     * @throws InventoryException
     */

    public void update(T entity) throws InventoryException {
        InventoryHelper.checkNull(entity, "entity");

        getSession().saveOrUpdate(entity);
    }

    /**
     * Generic method delete data
     * @param entity
     * @throws InventoryException
     */

    public void delete(T entity) throws InventoryException {
        InventoryHelper.checkNull(entity, "entity");

        getSession().delete(entity);
    }

    /**
     * Generic method get data count
     * @return long
     * @throws InventoryException
     */

    public long count() throws InventoryException {
        Number count = (Number)createQuery().getFetchSize();

        return count.longValue();
    }

    /**
     * Generic method get all data
     * @return list
     */

    private Query createQuery() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());

        Root<T> root = query.from(getEntityClass());
        query.select(root);

        return getSession().createQuery(query);
    }

    /**
     * Generic method get data by key and value
     * @param key
     * @param value
     * @return object
     */

    private Query createQueryByKeyValue(String key, Object value) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());

        Root<T> root = query.from(getEntityClass());
        query.select(root).where(builder.equal(root.get(key), value));

        return getSession().createQuery(query);
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected Class<T> getEntityClass() {
        return entityClass;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Query getNamedQuery(String queryName) {
        return getSession().getNamedQuery(queryName);
    }
}