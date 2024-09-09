package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2FrameListener {
    int onDataRead(ChannelHandlerContext channelHandlerContext, int i4, ByteBuf byteBuf, int i5, boolean z3) throws Http2Exception;

    void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i4, long j4, ByteBuf byteBuf) throws Http2Exception;

    void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, short s3, boolean z3, int i6, boolean z4) throws Http2Exception;

    void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, boolean z3) throws Http2Exception;

    void onPingAckRead(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Http2Exception;

    void onPingRead(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Http2Exception;

    void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i4, int i5, short s3, boolean z3) throws Http2Exception;

    void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i4, int i5, Http2Headers http2Headers, int i6) throws Http2Exception;

    void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i4, long j4) throws Http2Exception;

    void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception;

    void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception;

    void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b4, int i4, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception;

    void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i4, int i5) throws Http2Exception;
}
