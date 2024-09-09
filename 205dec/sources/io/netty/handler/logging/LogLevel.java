package io.netty.handler.logging;

import io.netty.util.internal.logging.InternalLogLevel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum LogLevel {
    TRACE(InternalLogLevel.TRACE),
    DEBUG(InternalLogLevel.DEBUG),
    INFO(InternalLogLevel.INFO),
    WARN(InternalLogLevel.WARN),
    ERROR(InternalLogLevel.ERROR);
    
    private final InternalLogLevel internalLevel;

    LogLevel(InternalLogLevel internalLogLevel) {
        this.internalLevel = internalLogLevel;
    }

    public InternalLogLevel toInternalLevel() {
        return this.internalLevel;
    }
}
