package io.netty.handler.codec.spdy;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface SpdyStreamFrame extends SpdyFrame {
    boolean isLast();

    SpdyStreamFrame setLast(boolean z);

    SpdyStreamFrame setStreamId(int i);

    int streamId();
}
