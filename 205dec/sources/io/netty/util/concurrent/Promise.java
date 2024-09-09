package io.netty.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface Promise<V> extends Future<V> {
    @Override // io.netty.util.concurrent.Future
    Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Future
    Promise<V> await() throws InterruptedException;

    @Override // io.netty.util.concurrent.Future
    Promise<V> awaitUninterruptibly();

    @Override // io.netty.util.concurrent.Future
    Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Promise<V> setFailure(Throwable th);

    Promise<V> setSuccess(V v3);

    boolean setUncancellable();

    @Override // io.netty.util.concurrent.Future
    Promise<V> sync() throws InterruptedException;

    @Override // io.netty.util.concurrent.Future
    Promise<V> syncUninterruptibly();

    boolean tryFailure(Throwable th);

    boolean trySuccess(V v3);
}
