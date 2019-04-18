package com.conurets.inventory.service.impl;

import com.conurets.inventory.converter.BasicInfoConverter;
import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.BasicInformation;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.FormDatain;
import com.conurets.inventory.service.BasicInfoService;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryHelper;
import com.conurets.inventory.vo.BasicInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Iraj on 03/20/19.
 */

@Service
public class BasicInfoServiceImpl implements BasicInfoService {

    private static final Logger logger = LoggerFactory.getLogger(BasicInfoServiceImpl.class);

    @Autowired
    private DAOFactory daoFactory;
    @Autowired
    private BasicInfoConverter basicInfoConverter;

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(daoFactory, "daoFactory");
        InventoryHelper.checkConfiguration(basicInfoConverter, "basicInfoConverter");
    }


    public void save(com.conurets.inventory.model.BasicInformation model) throws InventoryException {

        BasicInformation basicInfo = daoFactory.getBasicInfoDAO().findByKeyValue("serialNumber", model.getSerialNo());

        if (basicInfo == null) {
            try{
                BasicInformation entity = basicInfoConverter.fromController(model);

                daoFactory.getBasicInfoDAO().save(entity);
            }catch (Exception ex){
                ex.printStackTrace();
            }


        } else {
            InventoryHelper.handleInventoryException(InventoryConstants.STATUS_CODE_USER_ALREADY_EXISTS,
                    InventoryConstants.STATUS_MSG_BASIC_INFO_ALREADY_EXISTS);
        }

    }



    public void update(com.conurets.inventory.model.BasicInformation model) throws InventoryException {

        try{
            BasicInformation entity = basicInfoConverter.fromControllerupdate(model);
            daoFactory.getBasicInfoDAO().update(entity);

        }catch (Exception ex){
            ex.printStackTrace();
        }



    }

    public void delete(long id) throws InventoryException {

        BasicInformation basicInfo = daoFactory.getBasicInfoDAO().findById(id);

        daoFactory.getBasicInfoDAO().delete(basicInfo);
    }

    public List<BasicInfoVO> fetchBasicInfoReport(String frmDate,String toDate ) throws InventoryException {

        List<BasicInfoVO> basicInfoVOList = daoFactory.getBasicInfoDAO().fetchBasicInfoReport(frmDate,toDate);

        return basicInfoVOList;
    }

    @Override
    public FormDatain fetchEditform(String frmDate) throws InventoryException {
      FormDatain  basicInfoVOList = daoFactory.getBasicInfoDAO().fetchEditForm(frmDate);
        return basicInfoVOList;
    }

    public FormDatain fetchEditForm(String serialno) throws InventoryException {

        FormDatain basicInfoVOList = daoFactory.getBasicInfoDAO().fetchEditForm(serialno);

        return basicInfoVOList;
    }


}
