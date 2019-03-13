package com.conurets.inventory.util;

import com.conurets.inventory.exception.InvalidDataException;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.exception.EntityNotFoundException;
import com.conurets.inventory.exception.ConfigurationException;

import java.util.Collection;

/**
 * @author MSA
 */

public final class InventoryHelper {
    private InventoryHelper() {
    }

    public static void checkNull(Object object, String name) throws InvalidDataException {
        if (object == null) {
            throw new InvalidDataException(name + " is not provided");
        }
    }

    public static void checkNullOrEmpty(String str, String name) throws InvalidDataException {
        if (str == null || str.trim().isEmpty()) {
            throw new InvalidDataException("" + name + " is not provided");
        }
    }

    public static void checkNullOrEmpty(Collection<?> list, String name) throws InvalidDataException {
        if (list == null || list.isEmpty()) {
            throw new InvalidDataException("" + name + " is not provided");
        }
    }

    public static void checkPositive(long value, String name) throws InvalidDataException {
        if (value <= 0) {
            throw new InvalidDataException(name + " should be a positive value.");
        }
    }

    public static void checkConfigState(boolean state, String message) {
        if (!state) {
            throw new ConfigurationException(message);
        }
    }

    public static void checkConfiguration(Object object, String name) {
        if (object == null) {
            throw new ConfigurationException(String.format("%s should be provided", name));
        }
    }

    public static void checkEntityExists(Object entity, long id) throws EntityNotFoundException {
        if (entity == null) {
            throw new EntityNotFoundException(id + " No result found.");
        }
    }

    public static void checkEntityExists(Object entity, String id) throws EntityNotFoundException {
        if (entity == null) {
            throw new EntityNotFoundException(id + "No result found.");
        }
    }

    public static void handleInventoryException(int code, String message) throws InventoryException {
        throw new InvalidDataException(code, message);
    }
}