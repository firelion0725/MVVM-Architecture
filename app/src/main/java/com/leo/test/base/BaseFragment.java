package com.leo.test.base;

import android.os.Bundle;

import java.lang.reflect.ParameterizedType;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author leo, ZhangWei
 * @date 2018/8/28
 * @function
 */
public abstract class BaseFragment<T extends BaseViewModel> extends Fragment {

    protected T viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setBaseViewModel(getTClass());
    }

    private void setBaseViewModel(@NonNull Class<T> modelClass) {
        viewModel = ViewModelProviders.of(this).get(modelClass);
        getLifecycle().addObserver(viewModel);
    }

    private Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
