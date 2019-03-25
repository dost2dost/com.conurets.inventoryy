package com.conurets.inventory.converter;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.BasicInformation;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Iraj on 03/20/19.
 */
@Component
public class BasicInfoConverter {

    private static final Logger logger = LoggerFactory.getLogger(BasicInfoConverter.class);

    @Autowired
    private DAOFactory daoFactory;

    public BasicInformation fromController(com.conurets.inventory.model.BasicInformation model) throws InventoryException {

        BasicInformation entity = new BasicInformation();

        entity.setEntryDate(model.getEntryDate()) ;
        entity.setUserId(daoFactory.getUserDAO().findById(model.getUserId()));
        entity.setLocationId(daoFactory.getLocationDAO().findById(model.getLocationId()));
        entity.setCompanyId(daoFactory.getCompanyDAO().findById(model.getCompanyId()));
        entity.setItemId(daoFactory.getItemDAO().findById(model.getItemId()));
        entity.setSerialNumber(model.getSerialNo());

        entity.setCreatedBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setCreatedDate(InventoryUtil.currentDateTime());
        entity.setLastUpdateBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setLastUpdate(InventoryUtil.currentDateTime());

        return entity;
    }
/*
    public Basic toController(User entity) {
        UserVO userVO = new UserVO();
        userVO.setUsername(entity.getUsername());
        userVO.setEmail(entity.getEmail());
        userVO.setCompanyName(entity.getCompanyId().getCompany());

        return userVO;
    }*/
}
