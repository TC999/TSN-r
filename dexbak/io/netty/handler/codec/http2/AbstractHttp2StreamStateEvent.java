package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractHttp2StreamStateEvent implements Http2StreamStateEvent {
    private final int streamId;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttp2StreamStateEvent(int i) {
        this.streamId = ObjectUtil.checkPositiveOrZero(i, "streamId");
    }

    @Override // io.netty.handler.codec.http2.Http2StreamStateEvent
    public int streamId() {
        return this.streamId;
    }
}
