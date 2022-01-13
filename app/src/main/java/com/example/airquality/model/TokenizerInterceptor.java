package com.example.airquality.model;

import com.example.airquality.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenizerInterceptor implements Interceptor  {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url()
                .newBuilder()
                .addQueryParameter("token", BuildConfig.API_TOKEN)
                .build();

        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }

}
