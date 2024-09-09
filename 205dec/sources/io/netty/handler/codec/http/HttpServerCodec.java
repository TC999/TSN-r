package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class HttpServerCodec extends CombinedChannelDuplexHandler<HttpRequestDecoder, HttpResponseEncoder> implements HttpServerUpgradeHandler.SourceCodec {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private final class HttpServerResponseEncoder extends HttpResponseEncoder {
        private HttpMethod method;

        private HttpServerResponseEncoder() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean isContentAlwaysEmpty(HttpResponse httpResponse) {
            HttpMethod httpMethod = (HttpMethod) HttpServerCodec.access$100(HttpServerCodec.this).poll();
            this.method = httpMethod;
            return HttpMethod.HEAD.equals(httpMethod) || super.isContentAlwaysEmpty(httpResponse);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void sanitizeHeadersBeforeEncode(HttpResponse httpResponse, boolean z3) {
            if (!z3 && HttpMethod.CONNECT.equals(this.method) && httpResponse.status().codeClass() == HttpStatusClass.SUCCESS) {
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
            } else {
                super.sanitizeHeadersBeforeEncode(httpResponse, z3);
            }
        }
    }

    public HttpServerCodec() {
        this(4096, 8192, 8192);
    }

    @Override // io.netty.handler.codec.http.HttpServerUpgradeHandler.SourceCodec
    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this);
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private final class HttpServerRequestDecoder extends HttpRequestDecoder {
        HttpServerRequestDecoder(int i4, int i5, int i6) {
            super(i4, i5, i6);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.http.HttpObjectDecoder, io.netty.handler.codec.ByteToMessageDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            super.decode(channelHandlerContext, byteBuf, list);
            int size = list.size();
            for (int size2 = list.size(); size2 < size; size2++) {
                Object obj = list.get(size2);
                if (obj instanceof HttpRequest) {
                    HttpServerCodec.access$100(HttpServerCodec.this).add(((HttpRequest) obj).method());
                }
            }
        }

        HttpServerRequestDecoder(int i4, int i5, int i6, boolean z3) {
            super(i4, i5, i6, z3);
        }

        HttpServerRequestDecoder(int i4, int i5, int i6, boolean z3, int i7) {
            super(i4, i5, i6, z3, i7);
        }
    }

    public HttpServerCodec(int i4, int i5, int i6) {
        super(new HttpRequestDecoder(i4, i5, i6), new HttpResponseEncoder());
    }

    public HttpServerCodec(int i4, int i5, int i6, boolean z3) {
        super(new HttpRequestDecoder(i4, i5, i6, z3), new HttpResponseEncoder());
    }

    public HttpServerCodec(int i4, int i5, int i6, boolean z3, int i7) {
        super(new HttpRequestDecoder(i4, i5, i6, z3, i7), new HttpResponseEncoder());
    }
}
