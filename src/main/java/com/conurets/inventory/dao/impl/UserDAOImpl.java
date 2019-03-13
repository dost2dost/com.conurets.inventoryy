package com.conurets.inventory.dao.impl;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.dao.UserDAO;
import com.conurets.inventory.entity.User;
import com.conurets.inventory.exception.EntityNotFoundException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    public User findByName(String firstName, String lastName) throws InventoryException {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq( "firstName", firstName));
        criteria.add(Restrictions.eq( "lastName", lastName));

        User user = (User) criteria.uniqueResult();

        if (user == null) {
            throw new EntityNotFoundException(101, "No user found");
        }

        return user;
    }
}