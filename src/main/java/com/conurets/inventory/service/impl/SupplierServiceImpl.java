package com.conurets.inventory.service.impl;

import com.conurets.inventory.converter.UserConverter;
import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.service.SupplierService;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.vo.UserVO;
import com.conurets.inventory.util.InventoryHelper;
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
public class SupplierServiceImpl implements SupplierService {
    private static final Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);

    @Autowired
    private DAOFactory daoFactory;
    @Autowired
    private UserConverter userConverter;

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(daoFactory, "daoFactory");
        InventoryHelper.checkConfiguration(userConverter, "userConverter");
    }

    public List<UserVO> findAll() throws InventoryException {
        List<com.conurets.inventory.entity.User> userList = daoFactory.getUserDAO().findAll();

        if (userList == null) {
            InventoryHelper.checkNullOrEmpty(userList, "list");
        }

        List<UserVO> userVOList = userList.stream()
                .map(userObject -> userConverter.toController(userObject))
                .collect(Collectors.toList());

        return userVOList;
    }

    public UserVO findById(long id) throws InventoryException {
        com.conurets.inventory.entity.User user = daoFactory.getUserDAO().findById(id);

        if (user == null) {
            InventoryHelper.checkNull(user, "entity");
        }

        return userConverter.toController(user);
    }

    public void save(com.conurets.inventory.model.User model) throws InventoryException {
        com.conurets.inventory.entity.User user = daoFactory.getUserDAO().findByKeyValue("username", model.getUsername());

        if (user == null) {
            com.conurets.inventory.entity.User entity = userConverter.fromController(model);

            daoFactory.getUserDAO().save(entity);
        } else {
            InventoryHelper.handleInventoryException(InventoryConstants.STATUS_CODE_USER_ALREADY_EXISTS,
                    InventoryConstants.STATUS_MSG_USER_ALREADY_EXISTS);
        }
    }

    public void update(com.conurets.inventory.model.User model) throws InventoryException {
        com.conurets.inventory.entity.User entity = userConverter.fromController(model);

        daoFactory.getUserDAO().update(entity);
    }

    public void delete(long id) throws InventoryException {
        com.conurets.inventory.entity.User user = daoFactory.getUserDAO().findById(id);

        daoFactory.getUserDAO().delete(user);
    }

    public UserVO findByKeyValue(String key, Object value) throws InventoryException {
        com.conurets.inventory.entity.User user = daoFactory.getUserDAO().findByKeyValue(key, value);

        if (user == null) {
            InventoryHelper.checkNull(user, "entity");
        }

        return userConverter.toController(user);
    }

    public List<UserVO> findAllByKeyValue(String key, Object value) throws InventoryException {
        List<com.conurets.inventory.entity.User> userList = daoFactory.getUserDAO().findAllByKeyValue(key, value);

        if (userList == null) {
            InventoryHelper.checkNullOrEmpty(userList, "list");
        }

        List<UserVO> userVOList = userList.stream()
                .map(userObject -> userConverter.toController(userObject))
                .collect(Collectors.toList());

        return userVOList;
    }

    public UserVO findByName(String firstName, String lastName) throws InventoryException {
        com.conurets.inventory.entity.User user = daoFactory.getUserDAO().findByName(firstName, lastName);

        if (user == null) {
            InventoryHelper.checkNull(user, "entity");
        }

        return userConverter.toController(user);
    }
}