package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DecoratingHttp2ConnectionDecoder implements Http2ConnectionDecoder {
    private final Http2ConnectionDecoder delegate;

    public DecoratingHttp2ConnectionDecoder(Http2ConnectionDecoder http2ConnectionDecoder) {
        this.delegate = (Http2ConnectionDecoder) ObjectUtil.checkNotNull(http2ConnectionDecoder, "delegate");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Connection connection() {
        return this.delegate.connection();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void decodeFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Http2Exception {
        this.delegate.decodeFrame(channelHandlerContext, byteBuf, list);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2LocalFlowController flowController() {
        return this.delegate.flowController();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void frameListener(Http2FrameListener http2FrameListener) {
        this.delegate.frameListener(http2FrameListener);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.delegate.lifecycleManager(http2LifecycleManager);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Settings localSettings() {
        return this.delegate.localSettings();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public boolean prefaceReceived() {
        return this.delegate.prefaceReceived();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2FrameListener frameListener() {
        return this.delegate.frameListener();
    }
}
