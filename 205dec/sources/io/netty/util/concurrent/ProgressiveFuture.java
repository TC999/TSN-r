package io.netty.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ProgressiveFuture<V> extends Future<V> {
    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> await() throws InterruptedException;

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> awaitUninterruptibly();

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> sync() throws InterruptedException;

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> syncUninterruptibly();
}
