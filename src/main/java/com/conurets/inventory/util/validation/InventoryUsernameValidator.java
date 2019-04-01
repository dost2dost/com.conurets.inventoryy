package com.conurets.inventory.util.validation;

import com.conurets.inventory.dao.UserDAO;
import com.conurets.inventory.entity.User;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryHelper;
import com.conurets.inventory.util.validation.annotation.InventoryUsername;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author MSA
 * @version 1.0
 */

public class InventoryUsernameValidator implements ConstraintValidator<InventoryUsername, String> {
    @Autowired
    private UserDAO userDAO;

    /**
     * Checking @Autowired object
     */

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(userDAO, "userDAO");
    }

    /**
     * Verify username on request submittion
     * @param value
     * @param context
     * @return boolean
     */

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (InventoryConstants.SC_EMPTY.equals(value) || value == null) {
            return Boolean.FALSE;
        } else {
            User user = userDAO.findByKeyValue("username", value);

            if (user == null) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }
    }
}