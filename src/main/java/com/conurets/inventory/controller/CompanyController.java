package com.conurets.inventory.controller;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.Company;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.CompanyVO;
import com.conurets.inventory.vo.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author MSA
 */

@RestController
public class CompanyController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private DAOFactory daoFactory;

    @RequestMapping(value = "/addCompany", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@Valid @RequestBody Company model) throws InventoryException {
        companyService.save(model);

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS);

        return ResponseEntity.ok(baseResponse);
    }

    @RequestMapping(value = "/findAllCompanies", method = GET )
    public ResponseEntity<?> findAll() throws InventoryException {

        List<CompanyVO> companyVOList = companyService.findAll();

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS, companyVOList);

        return ResponseEntity.ok(baseResponse);
    }

    @RequestMapping(value = "/findByCompanyId", method = POST )
    public ResponseEntity<?> findByUserId(@Valid @RequestBody Company model) throws InventoryException {

        CompanyVO companyVO = companyService.findById(model.getCompanyId()) ;

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS, companyVO);

        return ResponseEntity.ok(baseResponse);
    }
}