package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.UserRoleDAO;
import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.entity.UserRole;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

/**
 * @author MSA
 */

@Repository
public class UserRoleDAOImpl extends BaseDAOImpl<UserRole> implements UserRoleDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserRoleDAOImpl.class);

    public UserRole findUserRoleByUserId(long userId) throws InventoryException {
        final String hqlQuery = "from UserRole ur where ur.user.id = :userId";

        TypedQuery<UserRole> query = getSession().createQuery(hqlQuery);
        query.setParameter("userId", userId);

        if (query.setMaxResults(1) == null) {
            InventoryHelper.handleInventoryException(InventoryConstants.STATUS_CODE_NO_CREDENTIAL_FOUND, InventoryConstants.STATUS_MSG_NO_CREDENTIAL_FOUND);
        }

        UserRole userRole = (UserRole) query.getResultList().get(InventoryConstants.INT_ZERO);

        return userRole;
    }
}