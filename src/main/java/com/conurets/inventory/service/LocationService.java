package com.conurets.inventory.service;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.User;
import com.conurets.inventory.vo.UserVO;

import java.util.List;

/**
 * @author MSA
 */

public interface LocationService {
    List<UserVO> findAll() throws InventoryException;
}