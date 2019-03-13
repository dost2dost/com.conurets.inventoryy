package com.conurets.inventory.dao.impl;

import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.dao.LoginUserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class LoginUserDAOImpl extends BaseDAOImpl<LoginUser> implements LoginUserDAO {
    private static final Logger logger = LoggerFactory.getLogger(LoginUserDAOImpl.class);
}