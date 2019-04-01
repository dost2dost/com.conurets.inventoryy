package com.conurets.inventory.controller;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.User;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.BaseResponse;
import com.conurets.inventory.vo.LoginUserVO;
import com.conurets.inventory.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author MSA
 */

@RestController
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * Verify user credentials and set user details
     * @param model
     * @return token, user id, user name, company id, company name
     * @throws InventoryException
     */

    @RequestMapping(value = "/api/login", method = POST)
    public ResponseEntity<?> login(@RequestBody User model) throws InventoryException {
        LoginUserVO loginUserVO = customUserDetailsService.login(model.getUsername(), model.getPassword());

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS, loginUserVO);

        return ResponseEntity.ok(baseResponse);
    }

    /**
     * Add new user
     * @param model
     * @return status
     * @throws InventoryException
     */

    @RequestMapping(value = "/api/addUser", method = POST)
    public ResponseEntity<?> addUser(@Valid @RequestBody User model) throws InventoryException {
        userService.save(model);

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS);

        return ResponseEntity.ok(baseResponse);
    }

    /**
     * fetch all users
     * @return user list
     * @throws InventoryException
     */

    @RequestMapping(value = "/api/findAllUsers", method = GET)
    public ResponseEntity<?> findAll() throws InventoryException {
        List<UserVO> userVOList = userService.findAll();

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS, userVOList);

        return ResponseEntity.ok(baseResponse);
    }

    @RequestMapping(value = "/api/logout", method = GET)
    public ResponseEntity<?> logout() throws InventoryException {
        SecurityContextHolder.getContext().setAuthentication(null);

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS);

        return ResponseEntity.ok(baseResponse);
    }
}