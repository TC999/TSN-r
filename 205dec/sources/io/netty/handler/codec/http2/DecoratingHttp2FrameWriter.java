package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DecoratingHttp2FrameWriter implements Http2FrameWriter {
    private final Http2FrameWriter delegate;

    public DecoratingHttp2FrameWriter(Http2FrameWriter http2FrameWriter) {
        this.delegate = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "delegate");
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this.delegate.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i4, ByteBuf byteBuf, int i5, boolean z3, ChannelPromise channelPromise) {
        return this.delegate.writeData(channelHandlerContext, i4, byteBuf, i5, z3, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b4, int i4, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.delegate.writeFrame(channelHandlerContext, b4, i4, http2Flags, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i4, long j4, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.delegate.writeGoAway(channelHandlerContext, i4, j4, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, boolean z3, ChannelPromise channelPromise) {
        return this.delegate.writeHeaders(channelHandlerContext, i4, http2Headers, i5, z3, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z3, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.delegate.writePing(channelHandlerContext, z3, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i4, int i5, short s3, boolean z3, ChannelPromise channelPromise) {
        return this.delegate.writePriority(channelHandlerContext, i4, i5, s3, z3, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i4, int i5, Http2Headers http2Headers, int i6, ChannelPromise channelPromise) {
        return this.delegate.writePushPromise(channelHandlerContext, i4, i5, http2Headers, i6, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i4, long j4, ChannelPromise channelPromise) {
        return this.delegate.writeRstStream(channelHandlerContext, i4, j4, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        return this.delegate.writeSettings(channelHandlerContext, http2Settings, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        return this.delegate.writeSettingsAck(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i4, int i5, ChannelPromise channelPromise) {
        return this.delegate.writeWindowUpdate(channelHandlerContext, i4, i5, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, short s3, boolean z3, int i6, boolean z4, ChannelPromise channelPromise) {
        return this.delegate.writeHeaders(channelHandlerContext, i4, http2Headers, i5, s3, z3, i6, z4, channelPromise);
    }
}
