package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2FlowController {
    void channelHandlerContext(ChannelHandlerContext channelHandlerContext) throws Http2Exception;

    void incrementWindowSize(Http2Stream http2Stream, int i4) throws Http2Exception;

    int initialWindowSize();

    void initialWindowSize(int i4) throws Http2Exception;

    int windowSize(Http2Stream http2Stream);
}
