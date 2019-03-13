package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.BaseDAO;
import com.conurets.inventory.entity.BaseEntity;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
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
    protected Class<T> entityClass;

    public BaseDAOImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(sessionFactory, "sessionFactory");
    }

    public List<T> findAll() throws InventoryException {
        Query<T> q = createQuery();

        return q.getResultList();
    }

    public List<T> findAllByKeyValue(String key, Object value) throws InventoryException {
        Query<T> q = createQueryByKeyValue(key, value);

        return q.getResultList();
    }

    public T findByKeyValue(String key, Object value) throws InventoryException {
        Query<T> q = createQueryByKeyValue(key, value);

        T entity = null;

        if (q.getResultList() != null && q.getResultList().size() > 0) {
            entity = (T) q.getResultList().get(0);
        }

        return entity;
    }

    public T findById(long id) throws InventoryException {
        T entity = (T) sessionFactory.getCurrentSession().get(getEntityClass(), id);

        InventoryHelper.checkEntityExists(entityClass, id);

        return entity;
    }

    public void save(T entity) throws InventoryException {
        InventoryHelper.checkNull(entity, "entity");

        getSession().saveOrUpdate(entity);
    }

    public void update(T entity) throws InventoryException {
        InventoryHelper.checkNull(entity, "entity");

        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity) throws InventoryException {
        InventoryHelper.checkNull(entity, "entity");

        getSession().delete(entity);
    }

    public long count() throws InventoryException {
        Number count = (Number)createEntityCriteria().setProjection(Projections.rowCount()).uniqueResult();

        return count.longValue();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Criteria createEntityCriteria() {
        return getSession().createCriteria(entityClass);
    }

    public Query getNamedQuery(String queryName) {
        return getSession().getNamedQuery(queryName);
    }

    public Query createQuery() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());

        Root<T> root = query.from(getEntityClass());
        query.select(root);

        return getSession().createQuery(query);
    }

    public Query createQueryByKeyValue(String key, Object value) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());

        Root<T> root = query.from(getEntityClass());
        query.select(root).where(builder.equal(root.get(key), value));

        return getSession().createQuery(query);
    }
}