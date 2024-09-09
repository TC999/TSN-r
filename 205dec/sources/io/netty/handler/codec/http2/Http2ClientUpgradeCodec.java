package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.collection.CharObjectMap;
import io.netty.util.internal.ObjectUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Http2ClientUpgradeCodec implements HttpClientUpgradeHandler.UpgradeCodec {
    private static final List<CharSequence> UPGRADE_HEADERS = Collections.singletonList(Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER);
    private final Http2ConnectionHandler connectionHandler;
    private final String handlerName;

    public Http2ClientUpgradeCodec(Http2ConnectionHandler http2ConnectionHandler) {
        this(null, http2ConnectionHandler);
    }

    private CharSequence getSettingsHeaderValue(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf;
        Http2Settings localSettings;
        ByteBuf buffer;
        ByteBuf byteBuf2 = null;
        try {
            localSettings = this.connectionHandler.decoder().localSettings();
            buffer = channelHandlerContext.alloc().buffer(localSettings.size() * 6);
        } catch (Throwable th) {
            th = th;
            byteBuf = null;
        }
        try {
            for (CharObjectMap.PrimitiveEntry<Long> primitiveEntry : localSettings.entries()) {
                Http2CodecUtil.writeUnsignedShort(primitiveEntry.key(), buffer);
                Http2CodecUtil.writeUnsignedInt(primitiveEntry.value().longValue(), buffer);
            }
            byteBuf2 = Base64.encode(buffer, Base64Dialect.URL_SAFE);
            String byteBuf3 = byteBuf2.toString(CharsetUtil.UTF_8);
            ReferenceCountUtil.release(buffer);
            ReferenceCountUtil.release(byteBuf2);
            return byteBuf3;
        } catch (Throwable th2) {
            th = th2;
            ByteBuf byteBuf4 = byteBuf2;
            byteBuf2 = buffer;
            byteBuf = byteBuf4;
            ReferenceCountUtil.release(byteBuf2);
            ReferenceCountUtil.release(byteBuf);
            throw th;
        }
    }

    @Override // io.netty.handler.codec.http.HttpClientUpgradeHandler.UpgradeCodec
    public CharSequence protocol() {
        return Http2CodecUtil.HTTP_UPGRADE_PROTOCOL_NAME;
    }

    @Override // io.netty.handler.codec.http.HttpClientUpgradeHandler.UpgradeCodec
    public Collection<CharSequence> setUpgradeHeaders(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) {
        httpRequest.headers().set(Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER, getSettingsHeaderValue(channelHandlerContext));
        return UPGRADE_HEADERS;
    }

    @Override // io.netty.handler.codec.http.HttpClientUpgradeHandler.UpgradeCodec
    public void upgradeTo(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) throws Exception {
        this.connectionHandler.onHttpClientUpgrade();
        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), this.handlerName, this.connectionHandler);
    }

    public Http2ClientUpgradeCodec(String str, Http2ConnectionHandler http2ConnectionHandler) {
        this.handlerName = str;
        this.connectionHandler = (Http2ConnectionHandler) ObjectUtil.checkNotNull(http2ConnectionHandler, "connectionHandler");
    }
}
