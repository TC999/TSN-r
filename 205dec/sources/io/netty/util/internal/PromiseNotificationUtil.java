package io.netty.util.internal;

import io.netty.util.concurrent.Promise;
import io.netty.util.internal.logging.InternalLogger;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class PromiseNotificationUtil {
    private PromiseNotificationUtil() {
    }

    public static void tryCancel(Promise<?> promise, InternalLogger internalLogger) {
        if (promise.cancel(false) || internalLogger == null) {
            return;
        }
        Throwable cause = promise.cause();
        if (cause == null) {
            internalLogger.warn("Failed to cancel promise because it has succeeded already: {}", promise);
        } else {
            internalLogger.warn("Failed to cancel promise because it has failed already: {}, unnotified cause:", promise, cause);
        }
    }

    public static void tryFailure(Promise<?> promise, Throwable th, InternalLogger internalLogger) {
        if (promise.tryFailure(th) || internalLogger == null) {
            return;
        }
        Throwable cause = promise.cause();
        if (cause == null) {
            internalLogger.warn("Failed to mark a promise as failure because it has succeeded already: {}", promise, th);
        } else {
            internalLogger.warn("Failed to mark a promise as failure because it has failed already: {}, unnotified cause: {}", promise, ThrowableUtil.stackTraceToString(cause), th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> void trySuccess(Promise<? super V> promise, V v3, InternalLogger internalLogger) {
        if (promise.trySuccess(v3) || internalLogger == null) {
            return;
        }
        Throwable cause = promise.cause();
        if (cause == null) {
            internalLogger.warn("Failed to mark a promise as success because it has succeeded already: {}", promise);
        } else {
            internalLogger.warn("Failed to mark a promise as success because it has failed already: {}, unnotified cause:", promise, cause);
        }
    }
}
