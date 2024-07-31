package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class PromiseCombiner {
    private Promise<Void> aggregatePromise;
    private Throwable cause;
    private boolean doneAdding;
    private int doneCount;
    private int expectedCount;
    private final GenericFutureListener<Future<?>> listener = new GenericFutureListener<Future<?>>() { // from class: io.netty.util.concurrent.PromiseCombiner.1
        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<?> future) throws Exception {
            PromiseCombiner.access$004(PromiseCombiner.this);
            if (!future.isSuccess() && PromiseCombiner.this.cause == null) {
                PromiseCombiner.this.cause = future.cause();
            }
            if (PromiseCombiner.this.doneCount == PromiseCombiner.this.expectedCount && PromiseCombiner.this.doneAdding) {
                PromiseCombiner.this.tryPromise();
            }
        }
    };

    static /* synthetic */ int access$004(PromiseCombiner promiseCombiner) {
        int i = promiseCombiner.doneCount + 1;
        promiseCombiner.doneCount = i;
        return i;
    }

    private void checkAddAllowed() {
        if (this.doneAdding) {
            throw new IllegalStateException("Adding promises is not allowed after finished adding");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryPromise() {
        Throwable th = this.cause;
        return th == null ? this.aggregatePromise.trySuccess(null) : this.aggregatePromise.tryFailure(th);
    }

    public void add(Promise promise) {
        checkAddAllowed();
        this.expectedCount++;
        promise.addListener((GenericFutureListener) this.listener);
    }

    public void addAll(Promise... promiseArr) {
        checkAddAllowed();
        this.expectedCount += promiseArr.length;
        for (Promise promise : promiseArr) {
            promise.addListener((GenericFutureListener) this.listener);
        }
    }

    public void finish(Promise<Void> promise) {
        if (!this.doneAdding) {
            this.doneAdding = true;
            this.aggregatePromise = (Promise) ObjectUtil.checkNotNull(promise, "aggregatePromise");
            if (this.doneCount == this.expectedCount) {
                tryPromise();
                return;
            }
            return;
        }
        throw new IllegalStateException("Already finished");
    }
}
