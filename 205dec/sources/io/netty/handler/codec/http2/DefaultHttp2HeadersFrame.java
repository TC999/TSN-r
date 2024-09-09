package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class DefaultHttp2HeadersFrame extends AbstractHttp2StreamFrame implements Http2HeadersFrame {
    private final boolean endStream;
    private final Http2Headers headers;
    private final int padding;

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers) {
        this(http2Headers, false);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttp2HeadersFrame) {
            DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = (DefaultHttp2HeadersFrame) obj;
            return super.equals(defaultHttp2HeadersFrame) && this.headers.equals(defaultHttp2HeadersFrame.headers) && this.endStream == defaultHttp2HeadersFrame.endStream && this.padding == defaultHttp2HeadersFrame.padding;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        return (((((super.hashCode() * 31) + this.headers.hashCode()) * 31) + (!this.endStream ? 1 : 0)) * 31) + this.padding;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersFrame
    public Http2Headers headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersFrame
    public boolean isEndStream() {
        return this.endStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "HEADERS";
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersFrame
    public int padding() {
        return this.padding;
    }

    public String toString() {
        return "DefaultHttp2HeadersFrame(streamId=" + streamId() + ", headers=" + this.headers + ", endStream=" + this.endStream + ", padding=" + this.padding + ")";
    }

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z3) {
        this(http2Headers, z3, 0);
    }

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z3, int i4) {
        this.headers = (Http2Headers) ObjectUtil.checkNotNull(http2Headers, "headers");
        this.endStream = z3;
        Http2CodecUtil.verifyPadding(i4);
        this.padding = i4;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2HeadersFrame setStreamId(int i4) {
        super.setStreamId(i4);
        return this;
    }
}
