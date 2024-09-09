package io.netty.channel.socket;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class ChannelOutputShutdownException extends IOException {
    private static final long serialVersionUID = 6712549938359321378L;

    public ChannelOutputShutdownException(String str) {
        super(str);
    }

    public ChannelOutputShutdownException(String str, Throwable th) {
        super(str, th);
    }
}
