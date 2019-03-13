package com.conurets.inventory.dao.factory.impl;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.dao.CompanyDAO;
import com.conurets.inventory.dao.UserDAO;
import com.conurets.inventory.util.InventoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author MSA
 */

@Service
public class DAOFactoryImpl implements DAOFactory {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CompanyDAO companyDAO;

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(userDAO, "userDAO");
        InventoryHelper.checkConfiguration(companyDAO, "companyDAO");
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public CompanyDAO getCompanyDAO() {
        return companyDAO;
    }

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
}