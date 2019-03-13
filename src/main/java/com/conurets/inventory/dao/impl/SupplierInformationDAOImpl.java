package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.SupplierInformationDAO;
import com.conurets.inventory.entity.SupplierInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class SupplierInformationDAOImpl extends BaseDAOImpl<SupplierInformation> implements SupplierInformationDAO {
    private static final Logger logger = LoggerFactory.getLogger(SupplierInformationDAOImpl.class);
}