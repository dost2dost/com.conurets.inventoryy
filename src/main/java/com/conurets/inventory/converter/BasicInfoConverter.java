package com.conurets.inventory.converter;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.BasicInformation;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.BasicInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<BasicInfoVO> toReportController(List<BasicInformation> entity) {

        List<BasicInfoVO> basicInfoVOList = null;

        if(entity!=null){

            basicInfoVOList = new ArrayList<>();

            for(int i=0; i<entity.size();i++){

                BasicInfoVO basicVO = new BasicInfoVO();

                basicVO.setEntryDate(entity.get(i).getEntryDate());
                basicVO.setUserName(daoFactory.getUserDAO().findById(entity.get(i).getUserId().getUserId()).getUsername());
                basicVO.setLocationName(daoFactory.getLocationDAO().findById(entity.get(i).getLocationId().getLoginUserId()).getLocation()) ;
                basicVO.setCompanyName(daoFactory.getCompanyDAO().findById(entity.get(i).getCompanyId().getCompanyId()).getCompany());
                basicVO.setItemName(daoFactory.getItemDAO().findById(entity.get(i).getItemId().getItemId()).getItemDescription()) ;
                basicVO.setItemId(daoFactory.getItemDAO().findById(entity.get(i).getItemId().getItemId()).getItemId());

                basicVO.setSerialNumber(entity.get(i).getSerialNumber());
                basicVO.setQty(entity.get(i).getQty());

                basicInfoVOList.add(basicVO);
            }


        }

        return basicInfoVOList;
    }
}
