package com.leo.test.ui.main;

import android.os.Bundle;
import android.util.Log;
import com.leo.test.R;
import com.leo.test.base.BaseActivity;

public class TestActivity extends BaseActivity<MainViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        viewModel.getLiveData().observe(this, taskModel -> {
            if (taskModel != null) {
                Log.i("observe", "" + taskModel);
            }else{
                Log.i("observe", "no data");
            }
        });

        viewModel.getData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.getLiveData().removeObservers(this);
    }
}
