package io.netty.handler.codec.spdy;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface SpdyWindowUpdateFrame extends SpdyFrame {
    int deltaWindowSize();

    SpdyWindowUpdateFrame setDeltaWindowSize(int i);

    SpdyWindowUpdateFrame setStreamId(int i);

    int streamId();
}
