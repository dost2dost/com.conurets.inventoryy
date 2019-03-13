package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.ItemSupplierDAO;
import com.conurets.inventory.entity.ItemSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class ItemSupplierDAOImpl extends BaseDAOImpl<ItemSupplier> implements ItemSupplierDAO {
    private static final Logger logger = LoggerFactory.getLogger(ItemSupplierDAOImpl.class);
}