package com.conurets.inventory.exception;

import com.conurets.inventory.bean.ErrorResponse;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @author MSA
 */

@RestControllerAdvice
public class InventoryExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(InventoryExceptionHandler.class);

    @ExceptionHandler(InventoryException.class)
    public ResponseEntity<ErrorResponse> handleMarta(InventoryException e) {
        ErrorResponse response = InventoryUtil.setErrorResponse(e.getPosition(), e.getMessage());

        logger.error("handleMarta: "+ e);

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(ConfigurationException.class)
    public ResponseEntity<ErrorResponse> handleConfiguration(ConfigurationException e) {
        ErrorResponse response = InventoryUtil.setErrorResponse(e.getPosition(), e.getMessage());

        logger.error("handleMarta: "+ e);

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidData(InvalidDataException e) {
        ErrorResponse response = InventoryUtil.setErrorResponse(e.getPosition(), e.getMessage());

        logger.error("handleInvalidData: "+ e);

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException e) {
        ErrorResponse response = InventoryUtil.setErrorResponse(e.getPosition(), e.getMessage());

        logger.error("handleEntityNotFound: "+ e);

        return ResponseEntity.ok(response);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(SQLException e) {
        ErrorResponse response = InventoryUtil.setErrorResponse(InventoryConstants.STATUS_CODE_INVALID_DATA, e.getMessage());

        logger.error("handleBadRequest: "+ e);

        return ResponseEntity.ok(response);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse response = InventoryUtil.setErrorResponse(InventoryConstants.STATUS_CODE_UNKONWN, e.getMessage());

        logger.error("handleException: "+ e);

        return ResponseEntity.ok(response);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException e) {
        ErrorResponse response = InventoryUtil.setErrorResponse(InventoryConstants.STATUS_CODE_INVALID_INPUT_DATA, e.getBindingResult());

        logger.error("handleValidation: "+ e);

        return ResponseEntity.ok(response);
    }
}