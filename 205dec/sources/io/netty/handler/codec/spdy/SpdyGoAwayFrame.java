package io.netty.handler.codec.spdy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface SpdyGoAwayFrame extends SpdyFrame {
    int lastGoodStreamId();

    SpdyGoAwayFrame setLastGoodStreamId(int i4);

    SpdyGoAwayFrame setStatus(SpdySessionStatus spdySessionStatus);

    SpdySessionStatus status();
}
