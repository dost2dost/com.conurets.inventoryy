package com.conurets.inventory.converter;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.User;
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
        entity.setCompanyId(daoFactory.getCompanyDAO().findById(model.getCompanyId()));
        entity.setActive(Boolean.TRUE);
        entity.setCreatedBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setCreatedDate(InventoryUtil.currentDateTime());
        entity.setLastUpdateBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setLastUpdate(InventoryUtil.currentDateTime());

        return entity;
    }

    public UserVO toController(User entity) {
        UserVO userVO = new UserVO();
        userVO.setUsername(entity.getUsername());
        userVO.setEmail(entity.getEmail());
        userVO.setCompanyName(entity.getCompanyId().getCompany());

        return userVO;
    }
}