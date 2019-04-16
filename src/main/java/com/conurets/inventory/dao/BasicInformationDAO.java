package com.conurets.inventory.dao;

import com.conurets.inventory.entity.BasicInformation;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.FormDatain;
import com.conurets.inventory.vo.BasicInfoVO;

import java.util.List;

/**
 * @author MSA
 */

public interface BasicInformationDAO extends BaseDAO<BasicInformation> {

    List<BasicInfoVO> fetchBasicInfoReport(String frmDate, String toDate ) throws InventoryException;
    FormDatain fetchEditForm(String serialno) throws InventoryException;

}