package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.RoleDAO;
import com.conurets.inventory.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class RoleDAOImpl extends BaseDAOImpl<Role> implements RoleDAO {
    private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);
}