package io.netty.channel;

import java.nio.channels.ClosedChannelException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class ExtendedClosedChannelException extends ClosedChannelException {
    ExtendedClosedChannelException(Throwable th) {
        if (th != null) {
            initCause(th);
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
