package com.leo.test.ui.main;

import android.util.Log;

import com.leo.test.base.BaseViewModel;
import com.leo.test.data.dao.load.TaskModel;
import com.leo.test.data.dao.upload.PostTaskModel;
import com.leo.test.data.http.TaskClouds;
import com.leo.test.data.rx.AbstractSingleHttp;

import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel {

    public MutableLiveData<TaskModel> data = new MutableLiveData<>();

    public void getData() {
        Log.i("MainViewModel", "getData");
        PostTaskModel body = new PostTaskModel("18302278175", "abcd0987");
        TaskClouds.getTaskData(body).subscribe(new AbstractSingleHttp<TaskModel>() {
            @Override
            public void onSuccess(TaskModel taskModel) {
                Log.i("getData", "onSuccess");
                data.setValue(taskModel);
//                data.postValue(taskModel);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("getData", "onError");
                e.printStackTrace();
            }
        });
    }
}
