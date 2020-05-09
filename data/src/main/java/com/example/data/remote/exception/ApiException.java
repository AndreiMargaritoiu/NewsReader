package com.example.data.remote.exception;

/**
 * Created by mihai.mecea on 03.May.2020
 */
public class ApiException extends RuntimeException {

    public final int httpCode;

    public ApiException(int httpCode) {
        super("server returned http code: " + httpCode);
        this.httpCode = httpCode;
    }
}
