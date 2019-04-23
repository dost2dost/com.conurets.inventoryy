package com.conurets.inventory.converter;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.Item;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.vo.ItemVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Iraj on 03/18/19.
 */
@Component
public class ItemConverter {

    private static final Logger logger = LoggerFactory.getLogger(ItemConverter.class);

    @Autowired
    private DAOFactory daoFactory;

    public ItemVO toController(Item item){

        ItemVO itemVO= new ItemVO();
        itemVO.setId(item.getItemId());
        itemVO.setItemCode(item.getItemCode());
        itemVO.setItemDescription(item.getItemDescription());
        itemVO.setManufacturer(item.getManufacturer());
        return itemVO;
    }
    public com.conurets.inventory.entity.Item fromController(com.conurets.inventory.model.Items model) throws InventoryException {
        com.conurets.inventory.entity.Item entity = new com.conurets.inventory.entity.Item();
        entity.setItemCode(model.getItemCode());
        entity.setActive(model.getActive());
        entity.setItemDescription(model.getItemDescription());
        entity.setCalibrationRequired(model.getCalibrationRequired());
        entity.setManufacturer(model.getManufacturer());

        return entity;
    }



}
