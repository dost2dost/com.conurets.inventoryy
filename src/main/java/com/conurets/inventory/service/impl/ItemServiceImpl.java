package com.conurets.inventory.service.impl;

import com.conurets.inventory.converter.ItemConverter;
import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.Item;
import com.conurets.inventory.entity.User;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.service.ItemService;
import com.conurets.inventory.util.InventoryHelper;
import com.conurets.inventory.vo.ItemVO;
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
public class ItemServiceImpl implements ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private DAOFactory daoFactory;
    @Autowired
    private ItemConverter itemConverter;

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(daoFactory, "daoFactory");
        InventoryHelper.checkConfiguration(itemConverter, "itemConverter");
    }

    public List<ItemVO> findAll() throws InventoryException {

        List<Item> itemList = daoFactory.getItemDAO().findAll() ;

        if (itemList == null) {
            InventoryHelper.checkNullOrEmpty(itemList, "list");
        }

        List<ItemVO> itemVOList = itemList.stream()
                .map(itemObject -> itemConverter.toController(itemObject))
                .collect(Collectors.toList());

        return itemVOList;
    }

    public ItemVO findById(long id) throws InventoryException {

        Item item = daoFactory.getItemDAO().findById(id);

        if (item == null) {
            InventoryHelper.checkNull(item, "entity");
        }

        return itemConverter.toController(item);
    }

    public void save(com.conurets.inventory.model.User model) throws InventoryException {
     /*   User user = daoFactory.getUserDAO().findByKeyValue("username", model.getUsername());

        if (user == null) {
            User entity = itemConverter.fromController(model);

            daoFactory.getUserDAO().save(entity);
        } else {
            InventoryHelper.handleInventoryException(InventoryConstants.STATUS_CODE_USER_ALREADY_EXISTS,
                    InventoryConstants.STATUS_MSG_USER_ALREADY_EXISTS);
        }*/
    }

    public void update(com.conurets.inventory.model.User model) throws InventoryException {
        /*User entity = userConverter.fromController(model);

        daoFactory.getUserDAO().update(entity);*/
    }

    public void delete(long id) throws InventoryException {
        User user = daoFactory.getUserDAO().findById(id);

        daoFactory.getUserDAO().delete(user);
    }

    public ItemVO findByKeyValue(String key, Object value) throws InventoryException {
        Item item = daoFactory.getItemDAO().findByKeyValue(key, value);

        if (item == null) {
            InventoryHelper.checkNull(item, "entity");
        }

        return itemConverter.toController(item);
    }

    public List<ItemVO> findAllByKeyValue(String key, Object value) throws InventoryException {
        List<Item> itemList = daoFactory.getItemDAO().findAllByKeyValue(key, value);

        if (itemList == null) {
            InventoryHelper.checkNullOrEmpty(itemList, "list");
        }

        List<ItemVO> itemVOList = itemList.stream()
                .map(userObject -> itemConverter.toController(userObject))
                .collect(Collectors.toList());

        return itemVOList;
    }

    public ItemVO findByName(String firstName, String lastName) throws InventoryException {
        /*User user = daoFactory.getUserDAO().findByName(firstName, lastName);

        if (user == null) {
            InventoryHelper.checkNull(user, "entity");
        }*/

        return itemConverter.toController(null);
    }
}