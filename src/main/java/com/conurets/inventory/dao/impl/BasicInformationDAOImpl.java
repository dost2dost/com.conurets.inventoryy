package com.conurets.inventory.dao.impl;

import com.conurets.inventory.converter.BasicInfoConverter;
import com.conurets.inventory.dao.BasicInformationDAO;
import com.conurets.inventory.entity.BasicInformation;
import com.conurets.inventory.exception.EntityNotFoundException;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.FormDatain;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.BasicInfoVO;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MSA
 */

@Repository
public class BasicInformationDAOImpl extends BaseDAOImpl<BasicInformation> implements BasicInformationDAO {

    private static final Logger logger = LoggerFactory.getLogger(BasicInformationDAOImpl.class);

    @Autowired
    BasicInfoConverter basicInfoConverter;

    /* input : from and to date
    *  output : return list
    *
    * */

    public List<BasicInfoVO> fetchBasicInfoReport(String frmDate, String toDate ) throws InventoryException{


        Query<BasicInformation> query = getSession().createQuery("from BasicInformation" +
                " where entryDate between '"+ InventoryUtil.convertFromStringToDate(frmDate) + "' " +
                " and '"+ InventoryUtil.convertFromStringToDate(toDate) +"' ");

        List<BasicInformation> basicInfoList = query.getResultList();

        if (basicInfoList == null) {
            throw new EntityNotFoundException(101, "No Basic Information found");
        }


        return basicInfoConverter.toReportController(basicInfoList);
    }

    @Override
    public FormDatain fetchEditForm(String serialno) throws InventoryException {

        Query<BasicInformation> query = getSession().createQuery("from BasicInformation" +
                " where serial_number = '"+ serialno + "' ");

        BasicInformation basicInfoList = query.getSingleResult();

        if (basicInfoList == null) {
            throw new EntityNotFoundException(101, "No Basic Information found");
        }





        return basicInfoConverter.toEditForm(basicInfoList);
    }


}