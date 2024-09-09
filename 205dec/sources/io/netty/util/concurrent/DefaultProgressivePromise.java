package io.netty.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DefaultProgressivePromise<V> extends DefaultPromise<V> implements ProgressivePromise<V> {
    public DefaultProgressivePromise(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    public ProgressivePromise<V> setProgress(long j4, long j5) {
        if (j5 < 0) {
            j5 = -1;
            if (j4 < 0) {
                throw new IllegalArgumentException("progress: " + j4 + " (expected: >= 0)");
            }
        } else if (j4 < 0 || j4 > j5) {
            throw new IllegalArgumentException("progress: " + j4 + " (expected: 0 <= progress <= total (" + j5 + "))");
        }
        if (!isDone()) {
            notifyProgressiveListeners(j4, j5);
            return this;
        }
        throw new IllegalStateException("complete already");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public /* bridge */ /* synthetic */ Promise setSuccess(Object obj) {
        return setSuccess((DefaultProgressivePromise<V>) obj);
    }

    @Override // io.netty.util.concurrent.ProgressivePromise
    public boolean tryProgress(long j4, long j5) {
        if (j5 < 0) {
            j5 = -1;
            if (j4 < 0 || isDone()) {
                return false;
            }
        } else if (j4 < 0 || j4 > j5 || isDone()) {
            return false;
        }
        notifyProgressiveListeners(j4, j5);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultProgressivePromise() {
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public ProgressivePromise<V> setFailure(Throwable th) {
        super.setFailure(th);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise<V> setSuccess(V v3) {
        super.setSuccess((DefaultProgressivePromise<V>) v3);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> await() throws InterruptedException {
        super.await();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> sync() throws InterruptedException {
        super.sync();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }
}
