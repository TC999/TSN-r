package io.netty.handler.codec.http2;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface Http2PingFrame extends Http2Frame {
    boolean ack();

    long content();
}
