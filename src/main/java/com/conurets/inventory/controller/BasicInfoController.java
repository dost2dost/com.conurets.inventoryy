package com.conurets.inventory.controller;

import com.conurets.inventory.model.BasicInformation;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Iraj on 03/20/19.
 */

@RestController
public class BasicInfoController extends BaseController {

    @RequestMapping(value = "/saveBasicInfo", method = POST)
    public ResponseEntity<?> saveRecord(@Valid @RequestBody BasicInformation basicInfo){

        basicInfoService.save(basicInfo);

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS);

        return ResponseEntity.ok(baseResponse);
    }
}