package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class PromiseCombiner {
    private Promise<Void> aggregatePromise;
    private Throwable cause;
    private int doneCount;
    private final EventExecutor executor;
    private int expectedCount;
    private final GenericFutureListener<Future<?>> listener;

    @Deprecated
    public PromiseCombiner() {
        this(ImmediateEventExecutor.INSTANCE);
    }

    static /* synthetic */ int access$204(PromiseCombiner promiseCombiner) {
        int i4 = promiseCombiner.doneCount + 1;
        promiseCombiner.doneCount = i4;
        return i4;
    }

    private void checkAddAllowed() {
        if (this.aggregatePromise != null) {
            throw new IllegalStateException("Adding promises is not allowed after finished adding");
        }
    }

    private void checkInEventLoop() {
        if (!this.executor.inEventLoop()) {
            throw new IllegalStateException("Must be called from EventExecutor thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryPromise() {
        Throwable th = this.cause;
        return th == null ? this.aggregatePromise.trySuccess(null) : this.aggregatePromise.tryFailure(th);
    }

    @Deprecated
    public void add(Promise promise) {
        add((Future) promise);
    }

    @Deprecated
    public void addAll(Promise... promiseArr) {
        addAll((Future[]) promiseArr);
    }

    public void finish(Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "aggregatePromise");
        checkInEventLoop();
        if (this.aggregatePromise == null) {
            this.aggregatePromise = promise;
            if (this.doneCount == this.expectedCount) {
                tryPromise();
                return;
            }
            return;
        }
        throw new IllegalStateException("Already finished");
    }

    public PromiseCombiner(EventExecutor eventExecutor) {
        this.listener = new GenericFutureListener<Future<?>>() { // from class: io.netty.util.concurrent.PromiseCombiner.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            /* JADX INFO: Access modifiers changed from: private */
            public void operationComplete0(Future<?> future) {
                PromiseCombiner.access$204(PromiseCombiner.this);
                if (!future.isSuccess() && PromiseCombiner.this.cause == null) {
                    PromiseCombiner.this.cause = future.cause();
                }
                if (PromiseCombiner.this.doneCount != PromiseCombiner.this.expectedCount || PromiseCombiner.this.aggregatePromise == null) {
                    return;
                }
                PromiseCombiner.this.tryPromise();
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(final Future<?> future) {
                if (PromiseCombiner.this.executor.inEventLoop()) {
                    operationComplete0(future);
                } else {
                    PromiseCombiner.this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.PromiseCombiner.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            operationComplete0(future);
                        }
                    });
                }
            }
        };
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    public void add(Future future) {
        checkAddAllowed();
        checkInEventLoop();
        this.expectedCount++;
        future.addListener(this.listener);
    }

    public void addAll(Future... futureArr) {
        for (Future future : futureArr) {
            add(future);
        }
    }
}
