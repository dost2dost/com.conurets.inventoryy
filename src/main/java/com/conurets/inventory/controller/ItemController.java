package com.conurets.inventory.controller;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.BaseResponse;
import com.conurets.inventory.vo.ItemVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Iraj on 03/18/19.
 */

@RestController
public class ItemController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private DAOFactory daoFactory;

    @RequestMapping(value = "/findAllItems", method = GET)
    public ResponseEntity<?> findAll() throws InventoryException {

        List<ItemVO> itemVOList = itemService.findAll();

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS, itemVOList);

        return ResponseEntity.ok(baseResponse);
    }

}