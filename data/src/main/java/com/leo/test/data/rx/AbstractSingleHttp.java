package com.leo.test.data.rx;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * @author leo, ZhangWei
 * @date 2018/4/8
 * @function
 */
public abstract class AbstractSingleHttp<T> implements SingleObserver<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }
}
