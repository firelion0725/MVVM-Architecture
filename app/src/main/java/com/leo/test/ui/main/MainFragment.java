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

/**
 * @author Leo.ZhangTJ
 */
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
        viewModel.getLiveData().observe(this, categoriesDao -> {
            if (categoriesDao != null) {
                Log.i("observe", "" + categoriesDao);
                mainFragmentBinding.message.setText(categoriesDao.toString());
            } else {
                Log.i("observe", "no data");
                mainFragmentBinding.message.setText("no data");
            }
        });

        viewModel.getData();
    }

    @Override
    public void onDestroy() {
        viewModel.getLiveData().removeObservers(this);
        super.onDestroy();
    }
}
