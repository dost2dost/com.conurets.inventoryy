package com.conurets.inventory.dao.impl;

import com.conurets.inventory.entity.Company;
import com.conurets.inventory.dao.CompanyDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class CompanyDAOImpl extends BaseDAOImpl<Company> implements CompanyDAO {
    private static final Logger logger = LoggerFactory.getLogger(CompanyDAOImpl.class);
}