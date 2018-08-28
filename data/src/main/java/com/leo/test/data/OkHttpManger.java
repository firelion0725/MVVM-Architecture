package com.leo.test.data;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function okHttp 单例
 */
public class OkHttpManger {

    private static final int TIME_OUT = 10;

    private static class SingletonHolder {
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(getHttpLoggingInterceptor())
                .build();
    }

    public static OkHttpClient getInstance() {
        return SingletonHolder.OK_HTTP_CLIENT;
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Log.d("OkHttpManger", "body: " + message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
