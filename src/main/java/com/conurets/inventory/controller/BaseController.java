package com.conurets.inventory.controller;

import com.conurets.inventory.service.CompanyService;
import com.conurets.inventory.service.UserService;
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

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(userService, "userService");
        InventoryHelper.checkConfiguration(companyService, "companyService");
    }
}