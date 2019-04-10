package com.conurets.inventory.service;


import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.BasicInformation;

import com.conurets.inventory.vo.BasicInfoVO;

import java.util.List;

/**
 * Created by Iraj on 03/20/19.
 */
public interface BasicInfoService {

    void save(BasicInformation model) throws InventoryException;


    void update(BasicInformation model) throws InventoryException;

    void delete(long id) throws InventoryException;

    List<BasicInfoVO> fetchBasicInfoReport(String frmDate,String toDate) throws InventoryException;

}
