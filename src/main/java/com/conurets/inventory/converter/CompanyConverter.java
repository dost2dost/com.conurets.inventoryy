package com.conurets.inventory.converter;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.CompanyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 */

@Component
public class CompanyConverter {
    private static final Logger logger = LoggerFactory.getLogger(CompanyConverter.class);

    public com.conurets.inventory.entity.Company fromController(com.conurets.inventory.model.Company model) throws InventoryException {
        com.conurets.inventory.entity.Company entity = new com.conurets.inventory.entity.Company();
        entity.setCompany(model.getCompany());
        entity.setRepresentative(model.getRepresentative());
        entity.setEmail(model.getEmail());
        entity.setMobile(model.getMobile());
        entity.setPhone(model.getPhone());
        entity.setActive(Boolean.TRUE);
        entity.setCreatedBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setCreatedDate(InventoryUtil.currentDateTime());
        entity.setLastUpdateBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setLastUpdate(InventoryUtil.currentDateTime());

        return entity;
    }

    public CompanyVO toController(com.conurets.inventory.entity.Company entity) {
        CompanyVO companyVO = new CompanyVO();
        companyVO.setCompany(entity.getCompany());
        companyVO.setRepresentative(entity.getRepresentative());
        companyVO.setEmail(entity.getEmail());
        companyVO.setMobile(entity.getMobile());
        companyVO.setPhone(entity.getPhone());

        return companyVO;
    }
}