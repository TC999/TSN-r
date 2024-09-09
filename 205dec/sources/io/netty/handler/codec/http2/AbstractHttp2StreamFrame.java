package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractHttp2StreamFrame implements Http2StreamFrame {
    private int streamId = -1;

    public boolean equals(Object obj) {
        return (obj instanceof Http2StreamFrame) && this.streamId == ((Http2StreamFrame) obj).streamId();
    }

    public int hashCode() {
        return this.streamId;
    }

    @Override // io.netty.handler.codec.http2.Http2StreamFrame
    public int streamId() {
        return this.streamId;
    }

    @Override // io.netty.handler.codec.http2.Http2StreamFrame
    public AbstractHttp2StreamFrame setStreamId(int i4) {
        if (this.streamId == -1) {
            this.streamId = ObjectUtil.checkPositiveOrZero(i4, "streamId");
            return this;
        }
        throw new IllegalStateException("Stream identifier may only be set once.");
    }
}
