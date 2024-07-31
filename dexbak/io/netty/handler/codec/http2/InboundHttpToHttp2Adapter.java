package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http2.HttpConversionUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class InboundHttpToHttp2Adapter extends ChannelInboundHandlerAdapter {
    private final Http2Connection connection;
    private final Http2FrameListener listener;

    public InboundHttpToHttp2Adapter(Http2Connection http2Connection, Http2FrameListener http2FrameListener) {
        this.connection = http2Connection;
        this.listener = http2FrameListener;
    }

    private int getStreamId(HttpHeaders httpHeaders) {
        return httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), this.connection.remote().incrementAndGetNextStreamId());
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof FullHttpMessage) {
            FullHttpMessage fullHttpMessage = (FullHttpMessage) obj;
            try {
                int streamId = getStreamId(fullHttpMessage.headers());
                Http2Stream stream = this.connection.stream(streamId);
                if (stream == null) {
                    stream = this.connection.remote().createStream(streamId, false);
                }
                Http2Stream http2Stream = stream;
                fullHttpMessage.headers().set(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), HttpScheme.HTTP.name());
                Http2Headers http2Headers = HttpConversionUtil.toHttp2Headers((HttpMessage) fullHttpMessage, true);
                boolean isReadable = fullHttpMessage.content().isReadable();
                boolean z = !fullHttpMessage.trailingHeaders().isEmpty();
                this.listener.onHeadersRead(channelHandlerContext, streamId, http2Headers, 0, (isReadable || z) ? false : true);
                if (isReadable) {
                    this.listener.onDataRead(channelHandlerContext, streamId, fullHttpMessage.content(), 0, !z);
                }
                if (z) {
                    this.listener.onHeadersRead(channelHandlerContext, streamId, HttpConversionUtil.toHttp2Headers(fullHttpMessage.trailingHeaders(), true), 0, true);
                }
                http2Stream.closeRemoteSide();
                return;
            } finally {
                fullHttpMessage.release();
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }
}
