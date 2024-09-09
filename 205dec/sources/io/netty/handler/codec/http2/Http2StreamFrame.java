package io.netty.handler.codec.http2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2StreamFrame extends Http2Frame {
    Http2StreamFrame setStreamId(int i4);

    int streamId();
}
