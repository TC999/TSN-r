package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractHttp2StreamStateEvent implements Http2StreamStateEvent {
    private final int streamId;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttp2StreamStateEvent(int i4) {
        this.streamId = ObjectUtil.checkPositiveOrZero(i4, "streamId");
    }

    @Override // io.netty.handler.codec.http2.Http2StreamStateEvent
    public int streamId() {
        return this.streamId;
    }
}
