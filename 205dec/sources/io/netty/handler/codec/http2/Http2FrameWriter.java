package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.io.Closeable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2FrameWriter extends Http2DataWriter, Closeable {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface Configuration {
        Http2FrameSizePolicy frameSizePolicy();

        Http2HeaderTable headerTable();
    }

    void close();

    Configuration configuration();

    ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b4, int i4, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise);

    ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i4, long j4, ByteBuf byteBuf, ChannelPromise channelPromise);

    ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, short s3, boolean z3, int i6, boolean z4, ChannelPromise channelPromise);

    ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, boolean z3, ChannelPromise channelPromise);

    ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z3, ByteBuf byteBuf, ChannelPromise channelPromise);

    ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i4, int i5, short s3, boolean z3, ChannelPromise channelPromise);

    ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i4, int i5, Http2Headers http2Headers, int i6, ChannelPromise channelPromise);

    ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i4, long j4, ChannelPromise channelPromise);

    ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise);

    ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i4, int i5, ChannelPromise channelPromise);
}
