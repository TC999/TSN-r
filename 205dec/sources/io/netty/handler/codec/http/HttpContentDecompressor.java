package io.netty.handler.codec.http;

import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HttpContentDecompressor extends HttpContentDecoder {
    private final boolean strict;

    public HttpContentDecompressor() {
        this(false);
    }

    @Override // io.netty.handler.codec.http.HttpContentDecoder
    protected EmbeddedChannel newContentDecoder(String str) throws Exception {
        if (!HttpHeaderValues.GZIP.contentEqualsIgnoreCase(str) && !HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(str)) {
            if (HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(str) || HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(str)) {
                return new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibDecoder(this.strict ? ZlibWrapper.ZLIB : ZlibWrapper.ZLIB_OR_NONE));
            }
            return null;
        }
        return new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP));
    }

    public HttpContentDecompressor(boolean z3) {
        this.strict = z3;
    }
}
