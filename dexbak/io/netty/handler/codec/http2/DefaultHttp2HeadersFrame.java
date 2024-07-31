package io.netty.handler.codec.http2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z) {
        this(http2Headers, z, 0);
    }

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z, int i) {
        this.headers = (Http2Headers) ObjectUtil.checkNotNull(http2Headers, TTDownloadField.TT_HEADERS);
        this.endStream = z;
        Http2CodecUtil.verifyPadding(i);
        this.padding = i;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2HeadersFrame setStreamId(int i) {
        super.setStreamId(i);
        return this;
    }
}
