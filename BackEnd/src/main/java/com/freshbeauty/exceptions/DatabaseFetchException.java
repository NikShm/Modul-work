package com.freshbeauty.exceptions;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class DatabaseFetchException
 * @since 8/13/2022 - 14.32
 **/
public class DatabaseFetchException extends RuntimeException {
    public DatabaseFetchException(Integer id, String entityName) {
        super("Could not find " + entityName + " entity with id " + id);
    }
}
