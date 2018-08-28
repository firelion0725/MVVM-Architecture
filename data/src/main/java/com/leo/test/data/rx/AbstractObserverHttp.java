package com.leo.test.data.rx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function
 */
public abstract class AbstractObserverHttp<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
