package com.conurets.inventory.dao.factory;

import com.conurets.inventory.dao.CompanyDAO;
import com.conurets.inventory.dao.UserDAO;

/**
 * @author MSA
 */

public interface DAOFactory {
    UserDAO getUserDAO();

    CompanyDAO getCompanyDAO();
}