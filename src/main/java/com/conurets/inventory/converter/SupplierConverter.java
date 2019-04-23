package com.conurets.inventory.converter;

import com.conurets.inventory.entity.SupplierInformation;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.CompanyVO;
import com.conurets.inventory.vo.SupplierinfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 */

@Component
public class SupplierConverter {
    private static final Logger logger = LoggerFactory.getLogger(SupplierConverter.class);

    public static com.conurets.inventory.entity.SupplierInformation fromController(com.conurets.inventory.model.SupplierIformation model) throws InventoryException {
        com.conurets.inventory.entity.SupplierInformation entity = new com.conurets.inventory.entity.SupplierInformation();
        entity.setSupplier(model.getSupplier());
        entity.setRepresentative(model.getRepresentative());
        entity.setMobile(model.getMobile());
        entity.setEmail(model.getEmail());
        entity.setActive(true);
       // entity.getCreatedBy(1);


        return entity;
    }

    public static SupplierinfoVO toController(com.conurets.inventory.entity.SupplierInformation entity) {

        SupplierinfoVO companyVO = new SupplierinfoVO();
        companyVO.setSupplierInformationId(entity.getSupplierInformationId());
        companyVO.setSupplier(entity.getSupplier());
        companyVO.setActive(entity.getActive());
        companyVO.setEmail(entity.getEmail());
        companyVO.setMobile(entity.getMobile());
        companyVO.setRepresentative(entity.getRepresentative());

        return companyVO;
    }
}