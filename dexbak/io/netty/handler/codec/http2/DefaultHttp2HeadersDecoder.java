package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.handler.codec.http2.internal.hpack.Decoder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
            this.headerArraySizeAccumulator = (defaultHttp2Headers.size() * 0.2f) + (this.headerArraySizeAccumulator * HEADERS_COUNT_WEIGHT_HISTORICAL);
            return defaultHttp2Headers;
        } catch (Http2Exception e) {
            throw e;
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

    public DefaultHttp2HeadersDecoder(boolean z) {
        this(8192, 4096, z, 32);
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class Http2HeaderTableDecoder extends DefaultHttp2HeaderTableListSize implements Http2HeaderTable {
        private Http2HeaderTableDecoder() {
        }

        @Override // io.netty.handler.codec.http2.Http2HeaderTable
        public void maxHeaderTableSize(int i) throws Http2Exception {
            if (i < 0) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be non-negative but was %d", Integer.valueOf(i));
            }
            try {
                DefaultHttp2HeadersDecoder.this.decoder.setMaxHeaderTableSize(i);
            } catch (Throwable th) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, th.getMessage(), th);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2HeaderTable
        public int maxHeaderTableSize() {
            return DefaultHttp2HeadersDecoder.this.decoder.getMaxHeaderTableSize();
        }
    }

    public DefaultHttp2HeadersDecoder(int i, int i2, boolean z, int i3) {
        this.headerArraySizeAccumulator = 8.0f;
        if (i > 0) {
            this.decoder = new Decoder(i, i2, i3);
            this.headerTable = new Http2HeaderTableDecoder();
            this.maxHeaderSize = i;
            this.validateHeaders = z;
            return;
        }
        throw new IllegalArgumentException("maxHeaderSize must be positive: " + i);
    }
}
