package org.xiaohe.util.concurrent.promise;

import org.xiaohe.util.concurrent.future.Future;
import org.xiaohe.util.concurrent.listener.GenericFutureListener;

public interface Promise<V> extends Future<V> {

    Promise<V> setSuccess(V result);

    boolean trySuccess(V result);

    Promise<V> setFailure(Throwable cause);

    boolean tryFailure(Throwable cause);

    boolean setUncancellable();

    @Override
    Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> listener);

    @Override
    Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... listeners);

    @Override
    Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> listener);

    @Override
    Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... listeners);

    @Override
    Promise<V> await() throws InterruptedException;

    @Override
    Promise<V> awaitUninterruptibly();

    @Override
    Promise<V> sync() throws InterruptedException;

    @Override
    Promise<V> syncUninterruptibly();
}