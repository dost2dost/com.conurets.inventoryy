package com.conurets.inventory.dao.impl;

import com.conurets.inventory.entity.BasicInformation;
import com.conurets.inventory.dao.BasicInformationDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class BasicInformationDAOImpl extends BaseDAOImpl<BasicInformation> implements BasicInformationDAO {
    private static final Logger logger = LoggerFactory.getLogger(BasicInformationDAOImpl.class);
}