package com.conurets.inventory.service.impl;

import com.conurets.inventory.converter.CompanyConverter;
import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.Company;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.service.CompanyService;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryHelper;
import com.conurets.inventory.vo.CompanyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MSA
 */

@Service
public class CompanyServiceImpl implements CompanyService {
    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    private DAOFactory daoFactory;
    @Autowired
    private CompanyConverter companyConverter;

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(daoFactory, "daoFactory");
        InventoryHelper.checkConfiguration(companyConverter, "companyConverter");
    }

    public List<CompanyVO> findAll() throws InventoryException {
        List<Company> userList = daoFactory.getCompanyDAO().findAll();

        if (userList == null) {
            InventoryHelper.checkNullOrEmpty(userList, "list");
        }

        List<CompanyVO> userVOList = userList.stream()
                .map(userObject -> companyConverter.toController(userObject))
                .collect(Collectors.toList());

        return userVOList;
    }

    public CompanyVO findById(long id) throws InventoryException {
        Company user = daoFactory.getCompanyDAO().findById(id);

        if (user == null) {
            InventoryHelper.checkNull(user, "entity");
        }

        return companyConverter.toController(user);
    }

    public void save(com.conurets.inventory.model.Company model) throws InventoryException {
        Company user = daoFactory.getCompanyDAO().findByKeyValue("company", model.getCompany());

        if (user == null) {
            Company entity = companyConverter.fromController(model);

            daoFactory.getCompanyDAO().save(entity);
        } else {
            InventoryHelper.handleInventoryException(InventoryConstants.STATUS_CODE_USER_ALREADY_EXISTS,
                    InventoryConstants.STATUS_MSG_USER_ALREADY_EXISTS);
        }
    }

    public void update(com.conurets.inventory.model.Company model) throws InventoryException {
        Company entity = companyConverter.fromController(model);

        daoFactory.getCompanyDAO().update(entity);
    }

    public void delete(long id) throws InventoryException {
        Company user = daoFactory.getCompanyDAO().findById(id);

        daoFactory.getCompanyDAO().delete(user);
    }

    public CompanyVO findByKeyValue(String key, Object value) throws InventoryException {
        Company entity = daoFactory.getCompanyDAO().findByKeyValue(key, value);

        if (entity == null) {
            InventoryHelper.checkNull(entity, "entity");
        }

        return companyConverter.toController(entity);
    }

    public List<CompanyVO> findAllByKeyValue(String key, Object value) throws InventoryException {
        List<Company> userList = daoFactory.getCompanyDAO().findAllByKeyValue(key, value);

        if (userList == null) {
            InventoryHelper.checkNullOrEmpty(userList, "list");
        }

        List<CompanyVO> userVOList = userList.stream()
                .map(userObject -> companyConverter.toController(userObject))
                .collect(Collectors.toList());

        return userVOList;
    }
}