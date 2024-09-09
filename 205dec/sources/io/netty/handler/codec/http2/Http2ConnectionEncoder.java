package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2ConnectionEncoder extends Http2FrameWriter {
    Http2Connection connection();

    Http2RemoteFlowController flowController();

    Http2FrameWriter frameWriter();

    void lifecycleManager(Http2LifecycleManager http2LifecycleManager);

    Http2Settings pollSentSettings();

    void remoteSettings(Http2Settings http2Settings) throws Http2Exception;

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b4, int i4, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise);
}
