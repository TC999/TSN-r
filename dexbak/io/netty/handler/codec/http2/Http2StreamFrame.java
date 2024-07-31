package io.netty.handler.codec.http2;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Http2StreamFrame extends Http2Frame {
    Http2StreamFrame setStreamId(int i);

    int streamId();
}
