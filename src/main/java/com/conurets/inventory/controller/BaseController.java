package com.conurets.inventory.controller;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.service.*;
import com.conurets.inventory.util.InventoryHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author MSA
 */

public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected UserService userService;
    @Autowired
    protected CompanyService companyService;
    @Autowired
    protected LoginUserService loginUserService;
    @Autowired
    protected ItemService itemService;
    @Autowired
    protected LocationService locationService;
    @Autowired
    protected BasicInfoService basicInfoService;
    @Autowired
    protected CustomUserDetailsService customUserDetailsService;
    @Autowired
    protected DAOFactory daoFactory;

    /**
     * Checking @Autowired object
     */

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(userService, "userService");
        InventoryHelper.checkConfiguration(companyService, "companyService");
        InventoryHelper.checkConfiguration(loginUserService, "loginUserService");
        InventoryHelper.checkConfiguration(itemService, "itemService");
        InventoryHelper.checkConfiguration(locationService, "locationService");
        InventoryHelper.checkConfiguration(basicInfoService, "basicInfoService");
        InventoryHelper.checkConfiguration(customUserDetailsService, "customUserDetailsService");
    }
}