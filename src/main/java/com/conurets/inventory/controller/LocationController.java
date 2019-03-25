package com.conurets.inventory.controller;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.Location;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Iraj on 03/19/19.
 */

@RestController
public class LocationController extends BaseController {
    @Autowired
    DAOFactory daoFactory;

    @RequestMapping(value = "/findAllLocations", method = GET)
    public ResponseEntity<?> findAll() throws InventoryException {
        List<Location> locationList = daoFactory.getLocationDAO().findAll();

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS, locationList);

        return ResponseEntity.ok(baseResponse);
    }
}