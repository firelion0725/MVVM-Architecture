package com.leo.test.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.test.base.BaseFragment;
import com.leo.test.databinding.MainFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MainFragment extends BaseFragment<MainViewModel> {

    private MainFragmentBinding mainFragmentBinding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false);
        mainFragmentBinding.executePendingBindings();
        return mainFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel.data.observe(this, taskModel -> {
            if (taskModel != null) {
                Log.i("observe", "" + taskModel);
                mainFragmentBinding.message.setText("" + taskModel);
            } else {
                Log.i("observe", "no data");
                mainFragmentBinding.message.setText("no data");
            }
        });

        viewModel.getData();
    }
}
