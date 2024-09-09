package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Stream;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface Http2FrameStream {
    int id();

    Http2Stream.State state();
}
