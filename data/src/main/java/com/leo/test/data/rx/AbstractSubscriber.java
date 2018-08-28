package com.leo.test.data.rx;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author leo, ZhangWei
 * @date 2018/4/24
 * @function
 */
public abstract class AbstractSubscriber<T> implements Subscriber<T> {
    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onComplete() {

    }
}
