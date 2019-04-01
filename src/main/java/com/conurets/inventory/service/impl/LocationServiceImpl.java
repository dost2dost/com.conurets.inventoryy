package com.conurets.inventory.service.impl;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.Location;
import com.conurets.inventory.entity.User;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.service.LocationService;
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
public class LocationServiceImpl implements LocationService {
    private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private DAOFactory daoFactory;

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(daoFactory, "daoFactory");
    }

    public List<UserVO> findAll() throws InventoryException {
        List<Location> locationList = daoFactory.getLocationDAO().findAll();

        if (locationList == null) {
            InventoryHelper.checkNullOrEmpty(locationList, "list");
        }

        return null;
    }
}