package com.conurets.inventory.dao.factory;

import com.conurets.inventory.dao.CompanyDAO;
import com.conurets.inventory.dao.LoginUserDAO;
import com.conurets.inventory.dao.UserDAO;
import com.conurets.inventory.dao.*;

/**
 * @author MSA
 */

public interface DAOFactory {
    UserDAO getUserDAO();

    CompanyDAO getCompanyDAO();

    LoginUserDAO getLoginUserDAO();

    ItemDAO getItemDAO();

    LocationDAO getLocationDAO();

    BasicInformationDAO getBasicInfoDAO();

    RoleDAO getRoleDAO();

    UserRoleDAO getUserRoleDAO();
}