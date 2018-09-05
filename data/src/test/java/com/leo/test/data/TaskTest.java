package com.leo.test.data;

import android.util.Log;

import com.leo.test.data.dao.load.CategoriesDao;
import com.leo.test.data.http.TaskClouds;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadow.api.Shadow;
import org.robolectric.shadows.ShadowLog;

import java.util.concurrent.Callable;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * @author leo, ZhangWei
 * @date 2018/9/5
 * @function
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class TaskTest {
    @Before
    public void setUp() {
        ShadowLog.stream = System.out;
        initRxJava();
    }

    private void initRxJava() {
        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxAndroidPlugins.reset();
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }

    @Test
    public void testGetCategories() {
        TaskClouds.getCategories().subscribe(new SingleObserver<CategoriesDao>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(CategoriesDao categoriesDao) {
                Log.i("getData", "onSuccess");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("getData", "onError");
            }
        });
    }
}
