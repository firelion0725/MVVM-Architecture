package com.leo.test.base;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author leo, ZhangWei
 * @date 2018/8/29
 * @function
 */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {
    protected T viewModel;
}
