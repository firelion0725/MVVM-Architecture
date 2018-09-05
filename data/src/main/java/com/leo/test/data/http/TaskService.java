package com.leo.test.data.http;


import com.leo.test.data.dao.load.CategoriesDao;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function
 */
public interface TaskService {

    @GET("api/xiandu/categories")
    Single<CategoriesDao> getCategories();

}
