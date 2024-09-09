package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class DefaultHttp2ResetFrame extends AbstractHttp2StreamFrame implements Http2ResetFrame {
    private final long errorCode;

    public DefaultHttp2ResetFrame(Http2Error http2Error) {
        this.errorCode = ((Http2Error) ObjectUtil.checkNotNull(http2Error, "error")).code();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttp2ResetFrame) {
            return super.equals(obj) && this.errorCode == ((DefaultHttp2ResetFrame) obj).errorCode;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.Http2ResetFrame
    public long errorCode() {
        return this.errorCode;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        long j4 = this.errorCode;
        return (super.hashCode() * 31) + ((int) (j4 ^ (j4 >>> 32)));
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "RST_STREAM";
    }

    public String toString() {
        return "DefaultHttp2ResetFrame(stream=" + streamId() + "errorCode=" + this.errorCode + ")";
    }

    public DefaultHttp2ResetFrame(long j4) {
        this.errorCode = j4;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2ResetFrame setStreamId(int i4) {
        super.setStreamId(i4);
        return this;
    }
}
