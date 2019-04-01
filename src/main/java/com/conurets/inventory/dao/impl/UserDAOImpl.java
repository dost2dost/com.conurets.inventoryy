package com.conurets.inventory.dao.impl;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.dao.UserDAO;
import com.conurets.inventory.entity.User;
import com.conurets.inventory.exception.EntityNotFoundException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryHelper;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author MSA
 */

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    /**
     * Get data by username and email
     * @param username
     * @param email
     * @return user object
     * @throws InventoryException
     */

    public User findByName(String username, String email) throws InventoryException {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(getEntityClass());

        Root<User> root = query.from(User.class);
        query.select(root);
        query.where(
                builder.and(
                        builder.equal(root.get("username"), username),
                        builder.equal(root.get("email"), email)));

        User user = (User) getSession().createQuery(query).uniqueResult();

        InventoryHelper.checkNullOrEmpty(user, InventoryConstants.STATUS_CODE_NO_USER_FOUND, InventoryConstants.STATUS_MSG_NO_USER_FOUND);

        return user;
    }
}