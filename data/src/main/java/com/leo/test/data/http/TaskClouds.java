package com.leo.test.data.http;

import com.leo.test.data.RetrofitManger;
import com.leo.test.data.dao.load.CategoriesDao;
import com.leo.test.data.rx.RxUtils;

import io.reactivex.Single;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function
 */
public class TaskClouds {

    private static class ServiceSingleton {
        private static final TaskService SERVICE = RetrofitManger.getInstance().create(TaskService.class);

        static TaskService getService() {
            return SERVICE;
        }
    }

    public static Single<CategoriesDao> getCategories() {
        return RxUtils.compile(ServiceSingleton.getService().getCategories());
    }

}
