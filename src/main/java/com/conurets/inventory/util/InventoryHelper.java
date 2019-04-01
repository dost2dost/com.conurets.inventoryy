package com.conurets.inventory.util;

import com.conurets.inventory.exception.ConfigurationException;
import com.conurets.inventory.exception.EntityNotFoundException;
import com.conurets.inventory.exception.InvalidDataException;
import com.conurets.inventory.exception.InventoryException;

import java.util.Collection;

/**
 * @author MSA
 */

public final class InventoryHelper {
    private InventoryHelper() {
    }

    /**
     * Check null object
     * @param object
     * @param name
     * @throws InvalidDataException
     */

    public static void checkNull(Object object, String name) throws InvalidDataException {
        if (object == null) {
            throw new InvalidDataException(name + " is not provided");
        }
    }

    /**
     * Check null and empty object
     * @param list
     * @param name
     * @throws InvalidDataException
     */

    public static void checkNullOrEmpty(Collection<?> list, String name) throws InvalidDataException {
        if (list == null || list.isEmpty()) {
            throw new InvalidDataException(name + " is not provided");
        }
    }

    /**
     * Check negative value
     * @param value
     * @param name
     * @throws InvalidDataException
     */

    public static void checkPositive(long value, String name) throws InvalidDataException {
        if (value <= 0) {
            throw new InvalidDataException(name + " should be a positive value.");
        }
    }

    /**
     * Check null and empty object and throw code and message
     * @param object
     * @param code
     * @param message
     * @throws InvalidDataException
     */

    public static void checkNullOrEmpty(Object object, int code, String message) throws InvalidDataException {
        if (object == null) {
            throw new InvalidDataException(code, message);
        }
    }

    /**
     * Check @Autowired object
     * @param object
     * @param name
     */

    public static void checkConfiguration(Object object, String name) {
        if (object == null) {
            throw new ConfigurationException(String.format("%s should be provided", name));
        }
    }

    /**
     * Check entity object
     * @param entity
     * @param id
     * @throws EntityNotFoundException
     */

    public static void checkEntityExists(Object entity, long id) throws EntityNotFoundException {
        if (entity == null) {
            throw new EntityNotFoundException(id + " No result found.");
        }
    }

    /**
     * Check entity object
     * @param entity
     * @param id
     * @throws EntityNotFoundException
     */

    public static void checkEntityExists(Object entity, String id) throws EntityNotFoundException {
        if (entity == null) {
            throw new EntityNotFoundException(id + " No result found.");
        }
    }

    /**
     * Handle and throw exception
     * @param code
     * @param message
     * @throws InventoryException
     */

    public static void handleInventoryException(int code, String message) throws InventoryException {
        throw new InvalidDataException(code, message);
    }
}