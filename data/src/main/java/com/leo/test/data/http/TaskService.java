package com.leo.test.data.http;


import com.leo.test.data.dao.load.TaskModel;
import com.leo.test.data.dao.upload.PostTaskModel;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function
 */
public interface TaskService {

    @POST("papi/login/login")
    Single<TaskModel> getTaskData(@Body PostTaskModel body);

}
