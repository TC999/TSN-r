package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UnaryPromiseNotifier<T> implements FutureListener<T> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(UnaryPromiseNotifier.class);
    private final Promise<? super T> promise;

    public UnaryPromiseNotifier(Promise<? super T> promise) {
        this.promise = (Promise) ObjectUtil.checkNotNull(promise, "promise");
    }

    public static <X> void cascadeTo(Future<X> future, Promise<? super X> promise) {
        if (future.isSuccess()) {
            if (promise.trySuccess(future.getNow())) {
                return;
            }
            logger.warn("Failed to mark a promise as success because it is done already: {}", promise);
        } else if (future.isCancelled()) {
            if (promise.cancel(false)) {
                return;
            }
            logger.warn("Failed to cancel a promise because it is done already: {}", promise);
        } else if (promise.tryFailure(future.cause())) {
        } else {
            logger.warn("Failed to mark a promise as failure because it's done already: {}", promise, future.cause());
        }
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(Future<T> future) throws Exception {
        cascadeTo(future, this.promise);
    }
}
