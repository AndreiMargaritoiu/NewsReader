package com.example.data.remote;

import com.misca.data.remote.exception.ApiException;
import com.misca.data.remote.exception.ConnectivityException;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mihai.mecea on 03.May.2020
 */
class HttpSuccessInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) {
        Request request = chain.request();
        Response response;
        try {
            response = chain.proceed(request);
        } catch (IOException exception) {
            throw new ConnectivityException(exception.getMessage());
        }
        if (!response.isSuccessful()) {
            throw new ApiException(response.code());
        }
        return response;
    }
}
