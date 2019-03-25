package com.conurets.inventory.dao.factory.impl;

import com.conurets.inventory.dao.*;
import com.conurets.inventory.dao.factory.DAOFactory;
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

    @Autowired
    private LoginUserDAO loginUserDAO;

    @Autowired
    private ItemDAO itemDAO;


    @Autowired
    private LocationDAO locationDAO;

    @Autowired
    private BasicInformationDAO basicInfoDAO;


    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(userDAO, "userDAO");
        InventoryHelper.checkConfiguration(companyDAO, "companyDAO");
        InventoryHelper.checkConfiguration(loginUserDAO, "loginUserDAO");
        InventoryHelper.checkConfiguration(itemDAO, "itemDAO");
        InventoryHelper.checkConfiguration(locationDAO, "locationDAO");
        InventoryHelper.checkConfiguration(basicInfoDAO, "basicInfoDAO");
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

    public LoginUserDAO getLoginUserDAO() {
        return loginUserDAO;
    }

    public void setLoginUserDAO(LoginUserDAO loginUserDAO) {
        this.loginUserDAO = loginUserDAO;
    }

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public LocationDAO getLocationDAO() {
        return locationDAO;
    }

    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    public BasicInformationDAO getBasicInfoDAO() {
        return basicInfoDAO;
    }

    public void setBasicInfoDAO(BasicInformationDAO basicInfoDAO) {
        this.basicInfoDAO = basicInfoDAO;
    }

}