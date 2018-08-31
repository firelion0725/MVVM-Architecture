package com.leo.test.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function retrofit单例
 */
public class RetrofitManger {

    private static class SingletonHolder {
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BaseUrlManger.BASE_URL)
                .client(OkHttpManger.getInstance())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static Retrofit getInstance() {
        return SingletonHolder.RETROFIT_CLIENT;
    }
}
