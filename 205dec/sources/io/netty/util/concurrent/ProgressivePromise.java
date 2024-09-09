package io.netty.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ProgressivePromise<V> extends Promise<V>, ProgressiveFuture<V> {
    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> await() throws InterruptedException;

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> awaitUninterruptibly();

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    ProgressivePromise<V> setFailure(Throwable th);

    ProgressivePromise<V> setProgress(long j4, long j5);

    @Override // 
    ProgressivePromise<V> setSuccess(V v3);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> sync() throws InterruptedException;

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> syncUninterruptibly();

    boolean tryProgress(long j4, long j5);
}
