package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.CharBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Http2ServerUpgradeCodec implements HttpServerUpgradeHandler.UpgradeCodec {
    private final Http2ConnectionHandler connectionHandler;
    private final Http2FrameReader frameReader;
    private final String handlerName;
    private final ChannelHandler upgradeToHandler;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2ServerUpgradeCodec.class);
    private static final List<CharSequence> REQUIRED_UPGRADE_HEADERS = Collections.singletonList(Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER);

    public Http2ServerUpgradeCodec(Http2ConnectionHandler http2ConnectionHandler) {
        this((String) null, http2ConnectionHandler);
    }

    private static ByteBuf createSettingsFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        ByteBuf buffer = channelHandlerContext.alloc().buffer(byteBuf.readableBytes() + 9);
        Http2CodecUtil.writeFrameHeader(buffer, byteBuf.readableBytes(), (byte) 4, new Http2Flags(), 0);
        buffer.writeBytes(byteBuf);
        byteBuf.release();
        return buffer;
    }

    private Http2Settings decodeSettings(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Http2Exception {
        try {
            final Http2Settings http2Settings = new Http2Settings();
            this.frameReader.readFrame(channelHandlerContext, byteBuf, new Http2FrameAdapter() { // from class: io.netty.handler.codec.http2.Http2ServerUpgradeCodec.1
                @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
                public void onSettingsRead(ChannelHandlerContext channelHandlerContext2, Http2Settings http2Settings2) {
                    http2Settings.copyFrom(http2Settings2);
                }
            });
            return http2Settings;
        } finally {
            byteBuf.release();
        }
    }

    private Http2Settings decodeSettingsHeader(ChannelHandlerContext channelHandlerContext, CharSequence charSequence) throws Http2Exception {
        ByteBuf encodeString = ByteBufUtil.encodeString(channelHandlerContext.alloc(), CharBuffer.wrap(charSequence), CharsetUtil.UTF_8);
        try {
            return decodeSettings(channelHandlerContext, createSettingsFrame(channelHandlerContext, Base64.decode(encodeString, Base64Dialect.URL_SAFE)));
        } finally {
            encodeString.release();
        }
    }

    @Override // io.netty.handler.codec.http.HttpServerUpgradeHandler.UpgradeCodec
    public boolean prepareUpgradeResponse(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders) {
        try {
            HttpHeaders headers = fullHttpRequest.headers();
            CharSequence charSequence = Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER;
            List<String> all = headers.getAll(charSequence);
            if (!all.isEmpty() && all.size() <= 1) {
                this.connectionHandler.onHttpServerUpgrade(decodeSettingsHeader(channelHandlerContext, all.get(0)));
                return true;
            }
            throw new IllegalArgumentException("There must be 1 and only 1 " + ((Object) charSequence) + " header.");
        } catch (Throwable th) {
            logger.info("Error during upgrade to HTTP/2", th);
            return false;
        }
    }

    @Override // io.netty.handler.codec.http.HttpServerUpgradeHandler.UpgradeCodec
    public Collection<CharSequence> requiredUpgradeHeaders() {
        return REQUIRED_UPGRADE_HEADERS;
    }

    @Override // io.netty.handler.codec.http.HttpServerUpgradeHandler.UpgradeCodec
    public void upgradeTo(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), this.handlerName, this.upgradeToHandler);
    }

    public Http2ServerUpgradeCodec(Http2Codec http2Codec) {
        this((String) null, http2Codec);
    }

    public Http2ServerUpgradeCodec(String str, Http2ConnectionHandler http2ConnectionHandler) {
        this(str, http2ConnectionHandler, http2ConnectionHandler);
    }

    public Http2ServerUpgradeCodec(String str, Http2Codec http2Codec) {
        this(str, http2Codec.frameCodec().connectionHandler(), http2Codec);
    }

    Http2ServerUpgradeCodec(String str, Http2ConnectionHandler http2ConnectionHandler, ChannelHandler channelHandler) {
        this.handlerName = str;
        this.connectionHandler = (Http2ConnectionHandler) ObjectUtil.checkNotNull(http2ConnectionHandler, "connectionHandler");
        this.upgradeToHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "upgradeToHandler");
        this.frameReader = new DefaultHttp2FrameReader();
    }
}
