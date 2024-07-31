package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class PromiseNotifier<V, F extends Future<V>> implements GenericFutureListener<F> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PromiseNotifier.class);
    private final boolean logNotifyFailure;
    private final Promise<? super V>[] promises;

    @SafeVarargs
    public PromiseNotifier(Promise<? super V>... promiseArr) {
        this(true, promiseArr);
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(F f) throws Exception {
        Promise<? super V>[] promiseArr;
        int i = 0;
        if (f.isSuccess()) {
            Object obj = f.get();
            Promise<? super V>[] promiseArr2 = this.promises;
            int length = promiseArr2.length;
            while (i < length) {
                Promise<? super V> promise = promiseArr2[i];
                if (!promise.trySuccess(obj) && this.logNotifyFailure) {
                    logger.warn("Failed to mark a promise as success because it is done already: {}", promise);
                }
                i++;
            }
        } else if (f.isCancelled()) {
            for (Promise<? super V> promise2 : this.promises) {
                if (!promise2.cancel(false) && this.logNotifyFailure) {
                    logger.warn("Failed to cancel a promise because it is done already: {}", promise2);
                }
            }
        } else {
            Throwable cause = f.cause();
            Promise<? super V>[] promiseArr3 = this.promises;
            int length2 = promiseArr3.length;
            while (i < length2) {
                Promise<? super V> promise3 = promiseArr3[i];
                if (!promise3.tryFailure(cause) && this.logNotifyFailure) {
                    logger.warn("Failed to mark a promise as failure because it's done already: {}", promise3, cause);
                }
                i++;
            }
        }
    }

    @SafeVarargs
    public PromiseNotifier(boolean z, Promise<? super V>... promiseArr) {
        ObjectUtil.checkNotNull(promiseArr, "promises");
        for (Promise<? super V> promise : promiseArr) {
            if (promise == null) {
                throw new IllegalArgumentException("promises contains null Promise");
            }
        }
        this.promises = (Promise[]) promiseArr.clone();
        this.logNotifyFailure = z;
    }
}
