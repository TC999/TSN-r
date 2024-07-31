package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import java.util.LinkedHashSet;
import java.util.Set;

@Deprecated
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class PromiseAggregator<V, F extends Future<V>> implements GenericFutureListener<F> {
    private final Promise<?> aggregatePromise;
    private final boolean failPending;
    private Set<Promise<V>> pendingPromises;

    public PromiseAggregator(Promise<Void> promise, boolean z) {
        if (promise != null) {
            this.aggregatePromise = promise;
            this.failPending = z;
            return;
        }
        throw new NullPointerException("aggregatePromise");
    }

    @SafeVarargs
    public final PromiseAggregator<V, F> add(Promise<V>... promiseArr) {
        if (promiseArr != null) {
            if (promiseArr.length == 0) {
                return this;
            }
            synchronized (this) {
                if (this.pendingPromises == null) {
                    this.pendingPromises = new LinkedHashSet(promiseArr.length > 1 ? promiseArr.length : 2);
                }
                for (Promise<V> promise : promiseArr) {
                    if (promise != null) {
                        this.pendingPromises.add(promise);
                        promise.addListener((GenericFutureListener) this);
                    }
                }
            }
            return this;
        }
        throw new NullPointerException("promises");
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public synchronized void operationComplete(F f) throws Exception {
        Set<Promise<V>> set = this.pendingPromises;
        if (set == null) {
            this.aggregatePromise.setSuccess(null);
        } else {
            set.remove(f);
            if (!f.isSuccess()) {
                Throwable cause = f.cause();
                this.aggregatePromise.setFailure(cause);
                if (this.failPending) {
                    for (Promise<V> promise : this.pendingPromises) {
                        promise.setFailure(cause);
                    }
                }
            } else if (this.pendingPromises.isEmpty()) {
                this.aggregatePromise.setSuccess(null);
            }
        }
    }

    public PromiseAggregator(Promise<Void> promise) {
        this(promise, true);
    }
}
