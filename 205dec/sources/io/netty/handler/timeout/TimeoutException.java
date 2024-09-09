package io.netty.handler.timeout;

import io.netty.channel.ChannelException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class TimeoutException extends ChannelException {
    private static final long serialVersionUID = 4673641882869672533L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeoutException() {
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeoutException(boolean z3) {
        super(null, null, z3);
    }
}
