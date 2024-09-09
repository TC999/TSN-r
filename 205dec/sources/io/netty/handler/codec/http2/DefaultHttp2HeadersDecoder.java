package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.handler.codec.http2.internal.hpack.Decoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultHttp2HeadersDecoder implements Http2HeadersDecoder, Http2HeadersDecoder.Configuration {
    private static final float HEADERS_COUNT_WEIGHT_HISTORICAL = 0.8f;
    private static final float HEADERS_COUNT_WEIGHT_NEW = 0.2f;
    private final Decoder decoder;
    private float headerArraySizeAccumulator;
    private final Http2HeaderTable headerTable;
    private final int maxHeaderSize;
    private final boolean validateHeaders;

    public DefaultHttp2HeadersDecoder() {
        this(true);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder
    public Http2HeadersDecoder.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder
    public Http2Headers decodeHeaders(ByteBuf byteBuf) throws Http2Exception {
        try {
            DefaultHttp2Headers defaultHttp2Headers = new DefaultHttp2Headers(this.validateHeaders, (int) this.headerArraySizeAccumulator);
            this.decoder.decode(byteBuf, defaultHttp2Headers);
            this.headerArraySizeAccumulator = (defaultHttp2Headers.size() * 0.2f) + (this.headerArraySizeAccumulator * 0.8f);
            return defaultHttp2Headers;
        } catch (Http2Exception e4) {
            throw e4;
        } catch (Throwable th) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, th, th.getMessage(), new Object[0]);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public Http2HeaderTable headerTable() {
        return this.headerTable;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public int maxHeaderSize() {
        return this.maxHeaderSize;
    }

    public DefaultHttp2HeadersDecoder(boolean z3) {
        this(8192, 4096, z3, 32);
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class Http2HeaderTableDecoder extends DefaultHttp2HeaderTableListSize implements Http2HeaderTable {
        private Http2HeaderTableDecoder() {
        }

        @Override // io.netty.handler.codec.http2.Http2HeaderTable
        public void maxHeaderTableSize(int i4) throws Http2Exception {
            if (i4 < 0) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be non-negative but was %d", Integer.valueOf(i4));
            }
            try {
                DefaultHttp2HeadersDecoder.this.decoder.setMaxHeaderTableSize(i4);
            } catch (Throwable th) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, th.getMessage(), th);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2HeaderTable
        public int maxHeaderTableSize() {
            return DefaultHttp2HeadersDecoder.this.decoder.getMaxHeaderTableSize();
        }
    }

    public DefaultHttp2HeadersDecoder(int i4, int i5, boolean z3, int i6) {
        this.headerArraySizeAccumulator = 8.0f;
        if (i4 > 0) {
            this.decoder = new Decoder(i4, i5, i6);
            this.headerTable = new Http2HeaderTableDecoder();
            this.maxHeaderSize = i4;
            this.validateHeaders = z3;
            return;
        }
        throw new IllegalArgumentException("maxHeaderSize must be positive: " + i4);
    }
}
