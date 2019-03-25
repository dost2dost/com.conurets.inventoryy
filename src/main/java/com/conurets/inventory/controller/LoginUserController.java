package com.conurets.inventory.controller;

import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.BaseResponse;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Iraj on 03/18/19.
 */

@RestController
public class LoginUserController extends BaseController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginUserController.class);

    @RequestMapping(value = "/api/login", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginSubmit(@Valid @RequestBody LoginUser model) {
        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS);

        return ResponseEntity.ok(baseResponse);
    }
}