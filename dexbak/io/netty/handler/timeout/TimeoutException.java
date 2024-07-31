package io.netty.handler.timeout;

import io.netty.channel.ChannelException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TimeoutException extends ChannelException {
    private static final long serialVersionUID = 4673641882869672533L;

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
