package com.leo.test.ui.main;

import android.util.Log;

import com.leo.test.base.BaseViewModel;
import com.leo.test.data.dao.load.CategoriesDao;
import com.leo.test.data.http.TaskClouds;

import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<CategoriesDao> data = new MutableLiveData<>();

    public MutableLiveData<CategoriesDao> getLiveData() {
        return data;
    }

    public void getData() {
        TaskClouds.getCategories()
                .subscribe(new BaseViewModelSingleObserver<CategoriesDao>() {
                    @Override
                    public void onSuccess(CategoriesDao categoriesDao) {
                        Log.i("TaskClouds", "" + categoriesDao);
                        data.setValue(categoriesDao);
                    }

                    @Override
                    public void onError(Throwable e) {
                        data.setValue(null);
                        e.printStackTrace();
                    }
                });
    }

}
