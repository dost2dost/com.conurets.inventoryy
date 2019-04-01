package com.conurets.inventory.service.impl;

import com.conurets.inventory.converter.UserConverter;
import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.entity.User;
import com.conurets.inventory.entity.UserRole;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.service.UserService;
import com.conurets.inventory.util.InventoryHelper;
import com.conurets.inventory.vo.UserVO;
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
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private DAOFactory daoFactory;
    @Autowired
    private UserConverter userConverter;

    /**
     * Checking @Autowired object
     */

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(daoFactory, "daoFactory");
        InventoryHelper.checkConfiguration(userConverter, "userConverter");
    }

    /**
     * Get all user list
     * @return user list
     * @throws InventoryException
     */

    public List<UserVO> findAll() throws InventoryException {
        List<User> userList = daoFactory.getUserDAO().findAll();

        if (userList == null) {
            InventoryHelper.checkNullOrEmpty(userList, "list");
        }

        List<UserVO> userVOList = userList.stream()
                .map(userObject -> userConverter.toController(userObject))
                .collect(Collectors.toList());

        return userVOList;
    }

    /**
     * Get user data by user id
     * @param id
     * @return user object
     * @throws InventoryException
     */

    public UserVO findById(long id) throws InventoryException {

        User user = daoFactory.getUserDAO().findById(id);

        if (user == null) {
            InventoryHelper.checkNull(user, "entity");
        }

        return userConverter.toController(user);
    }

    /**
     * Save user data
     * @param model
     * @throws InventoryException
     */

    public void save(com.conurets.inventory.model.User model) throws InventoryException {
        /*User user = daoFactory.getUserDAO().findByKeyValue("username", model.getUsername());

        if (user == null) {
            User entity = userConverter.fromController(model);

            daoFactory.getUserDAO().save(entity);

            LoginUser loginUser = userConverter.setLoginUser(entity, model);

            daoFactory.getLoginUserDAO().save(loginUser);
        } else {
            InventoryHelper.handleInventoryException(InventoryConstants.STATUS_CODE_USER_ALREADY_EXISTS,
                    InventoryConstants.STATUS_MSG_USER_ALREADY_EXISTS);
        }*/

        User entity = userConverter.fromController(model);

        daoFactory.getUserDAO().save(entity);

        LoginUser loginUser = userConverter.setLoginUser(entity, model);

        daoFactory.getLoginUserDAO().save(loginUser);

        UserRole userRole = userConverter.setUserRole(entity, model);

        daoFactory.getUserRoleDAO().save(userRole);
    }

    /**
     * Update user data
     * @param model
     * @throws InventoryException
     */

    public void update(com.conurets.inventory.model.User model) throws InventoryException {
        User entity = userConverter.fromController(model);

        daoFactory.getUserDAO().update(entity);
    }

    /**
     * Delete user data
     * @param id
     * @throws InventoryException
     */

    public void delete(long id) throws InventoryException {
        User user = daoFactory.getUserDAO().findById(id);

        daoFactory.getUserDAO().delete(user);
    }

    /**
     * Get user data by key and value
     * @param key
     * @param value
     * @return user object
     * @throws InventoryException
     */

    public UserVO findByKeyValue(String key, Object value) throws InventoryException {
        User user = daoFactory.getUserDAO().findByKeyValue(key, value);

        if (user == null) {
            InventoryHelper.checkNull(user, "entity");
        }

        return userConverter.toController(user);
    }

    /**
     * Get user data list by key and value
     * @param key
     * @param value
     * @return user list
     * @throws InventoryException
     */

    public List<UserVO> findAllByKeyValue(String key, Object value) throws InventoryException {
        List<User> userList = daoFactory.getUserDAO().findAllByKeyValue(key, value);

        if (userList == null) {
            InventoryHelper.checkNullOrEmpty(userList, "list");
        }

        List<UserVO> userVOList = userList.stream()
                .map(userObject -> userConverter.toController(userObject))
                .collect(Collectors.toList());

        return userVOList;
    }

    public UserRole findUserRoleByUserId(long userId) throws InventoryException {
        return daoFactory.getUserRoleDAO().findUserRoleByUserId(userId);
    }
}