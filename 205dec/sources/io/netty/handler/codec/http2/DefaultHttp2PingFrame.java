package io.netty.handler.codec.http2;

import io.netty.util.internal.StringUtil;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class DefaultHttp2PingFrame implements Http2PingFrame {
    private final boolean ack;
    private final long content;

    public DefaultHttp2PingFrame(long j4) {
        this(j4, false);
    }

    @Override // io.netty.handler.codec.http2.Http2PingFrame
    public boolean ack() {
        return this.ack;
    }

    @Override // io.netty.handler.codec.http2.Http2PingFrame
    public long content() {
        return this.content;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Http2PingFrame) {
            Http2PingFrame http2PingFrame = (Http2PingFrame) obj;
            return this.ack == http2PingFrame.ack() && this.content == http2PingFrame.content();
        }
        return false;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.ack ? 1 : 0);
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "PING";
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(content=" + this.content + ", ack=" + this.ack + ')';
    }

    public DefaultHttp2PingFrame(long j4, boolean z3) {
        this.content = j4;
        this.ack = z3;
    }
}
