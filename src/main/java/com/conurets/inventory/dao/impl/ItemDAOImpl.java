package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.ItemDAO;
import com.conurets.inventory.entity.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class ItemDAOImpl extends BaseDAOImpl<Item> implements ItemDAO {
    private static final Logger logger = LoggerFactory.getLogger(ItemDAOImpl.class);
}