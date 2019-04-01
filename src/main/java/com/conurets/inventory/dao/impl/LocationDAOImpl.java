package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.LocationDAO;
import com.conurets.inventory.entity.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class LocationDAOImpl extends BaseDAOImpl<Location> implements LocationDAO {
    private static final Logger logger = LoggerFactory.getLogger(LocationDAOImpl.class);
}