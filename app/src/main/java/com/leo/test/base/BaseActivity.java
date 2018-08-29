package com.leo.test.base;

import android.os.Bundle;

import java.lang.reflect.ParameterizedType;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author leo, ZhangWei
 * @date 2018/8/29
 * @function
 */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {
    protected T viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseViewModel(getTClass());
    }

    private void setBaseViewModel(@NonNull Class<T> modelClass) {
        viewModel = ViewModelProviders.of(this).get(modelClass);
        getLifecycle().addObserver(viewModel);
    }

    private Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    protected void onDestroy() {
        viewModel.onCleared();
        viewModel = null;
        super.onDestroy();
    }
}
