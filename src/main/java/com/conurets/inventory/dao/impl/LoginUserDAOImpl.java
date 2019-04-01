package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.LoginUserDAO;
import com.conurets.inventory.entity.LoginUser;
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
public class LoginUserDAOImpl extends BaseDAOImpl<LoginUser> implements LoginUserDAO {
    private static final Logger logger = LoggerFactory.getLogger(LoginUserDAOImpl.class);

    /**
     * Get login user details
     * @param userId
     * @return login user object
     * @throws InventoryException
     */

    public LoginUser findByUserId(long userId) throws InventoryException {
        final String hqlQuery = "from LoginUser lu where lu.user.id = :userId";

        TypedQuery<LoginUser> query = getSession().createQuery(hqlQuery);
        query.setParameter("userId", userId);

        if (query.setMaxResults(1) == null) {
            InventoryHelper.handleInventoryException(InventoryConstants.STATUS_CODE_NO_CREDENTIAL_FOUND, InventoryConstants.STATUS_MSG_NO_CREDENTIAL_FOUND);
        }

        LoginUser loginUser = (LoginUser) query.getResultList().get(InventoryConstants.INT_ZERO);

        return loginUser;
    }
}