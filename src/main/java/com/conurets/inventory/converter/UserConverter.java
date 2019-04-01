package com.conurets.inventory.converter;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.entity.User;
import com.conurets.inventory.entity.UserRole;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 */

@Component
public class UserConverter {
    private static final Logger logger = LoggerFactory.getLogger(UserConverter.class);

    @Autowired
    private DAOFactory daoFactory;

    public User fromController(com.conurets.inventory.model.User model) throws InventoryException {
        User entity = new User();
        entity.setUsername(model.getUsername());
        entity.setEmail(model.getEmail());
        entity.setCompany(daoFactory.getCompanyDAO().findById(model.getCompanyId()));
        entity.setActive(Boolean.TRUE);
        entity.setCreatedBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setCreatedDate(InventoryUtil.currentDateTime());
        entity.setLastUpdateBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setLastUpdate(InventoryUtil.currentDateTime());

        return entity;
    }

    public LoginUser setLoginUser(User entity, com.conurets.inventory.model.User model) {
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(entity);
        loginUser.setPassword(InventoryUtil.generatePassword(model.getPassword()));
        loginUser.setCreatedBy(InventoryConstants.DEFAULT_CREATED_BY);
        loginUser.setCreatedDate(InventoryUtil.currentDateTime());
        loginUser.setLastUpdateBy(InventoryConstants.DEFAULT_CREATED_BY);
        loginUser.setLastUpdate(InventoryUtil.currentDateTime());

        return loginUser;
    }

    public UserVO toController(User entity) {
        UserVO userVO = new UserVO();

        userVO.setUserId(entity.getUserId());
        userVO.setUsername(entity.getUsername());
        userVO.setEmail(entity.getEmail());
        userVO.setCompanyName(entity.getCompany().getCompany());

        return userVO;
    }

    public UserRole setUserRole(User entity, com.conurets.inventory.model.User model) {
        UserRole userRole = new UserRole();

        userRole.setUser(entity);
        userRole.setRole(daoFactory.getRoleDAO().findById(model.getRoleId()));
        userRole.setCreatedBy(InventoryConstants.DEFAULT_CREATED_BY);
        userRole.setCreatedDate(InventoryUtil.currentDateTime());
        userRole.setLastUpdateBy(InventoryConstants.DEFAULT_CREATED_BY);
        userRole.setLastUpdate(InventoryUtil.currentDateTime());

        return userRole;
    }
}