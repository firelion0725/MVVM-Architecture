package com.leo.test.data.rx;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * @author leo, ZhangWei
 * @date 2018/4/10
 * @function
 */
public class RxBus {

    private final Subject<Object> mBus;

    private RxBus() {
        mBus = PublishSubject.create();
    }

    public static RxBus getDefault() {
        return RxBusHolder.RX_BUS;
    }

    private static class RxBusHolder {
        private static final RxBus RX_BUS = new RxBus();
    }

    public void post(Object o) {
        mBus.onNext(o);
    }

    public <T> Observable<T> toObservable(Class<T> eventType) {
        return mBus.ofType(eventType);
    }

}
