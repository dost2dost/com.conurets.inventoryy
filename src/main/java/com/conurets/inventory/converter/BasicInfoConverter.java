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

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    public BasicInformation fromController(com.conurets.inventory.model.BasicInformation model) throws InventoryException, ParseException {

        BasicInformation entity = new BasicInformation();

        entity.setEntryDate(model.getEntryDate()) ;
        entity.setUserId(daoFactory.getUserDAO().findById(model.getUserId()));
        entity.setLocationId(daoFactory.getLocationDAO().findById(model.getLocationId()));
        entity.setCompanyId(daoFactory.getCompanyDAO().findById(model.getCompanyId()));
        entity.setItemId(daoFactory.getItemDAO().findById(model.getItemId()));
        entity.setSerialNumber(model.getSerialNo());
        entity.setQty(model.getQty());
        entity.setWarranty(model.getWarranty());
        entity.setStoredOnShelf(model.getStorageOnShelf());
        entity.setShelfBayNumber(Integer.valueOf(model.getShelfByNo()));
        entity.setStoredInCabinet(model.getStoredInCabnet());
        entity.setCabinetShelfNo(Integer.valueOf(model.getCabnetShelfNo()));
        //Caliberation
        entity.setCalibratedDate(simpleDateFormat.parse(model.getCalibratedDate()));
        entity.setValidityOfCalibration(simpleDateFormat.parse(model.getCalibrationValidity()));
        entity.setCalibrationDueDate(simpleDateFormat.parse(model.getCalibrationDueDate()));
        entity.setItemStorageLocation(model.getStorageLocation());
        //item handling
        entity.setSpecialHandlingNotes(model.getSpecialHandlingNotes());
        entity.setApproxWeight(Integer.valueOf(model.getApproxWeight()));
        entity.setSpecialHandlingRequired(model.getSpcialHandlinReq());
        entity.setItemCondition(model.getItemReconditioned());
        //Supplier info
        entity.setSupplierId(model.getSupplierId());
        entity.setSupplier_Rep_Id(model.getSupplier_Rep_Id());


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
