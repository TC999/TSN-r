package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.handler.codec.http2.internal.hpack.Encoder;
import io.netty.util.internal.ObjectUtil;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultHttp2HeadersEncoder implements Http2HeadersEncoder, Http2HeadersEncoder.Configuration {
    private final Encoder encoder;
    private final Http2HeaderTable headerTable;
    private final Http2HeadersEncoder.SensitivityDetector sensitivityDetector;
    private final ByteBuf tableSizeChangeOutput;

    public DefaultHttp2HeadersEncoder() {
        this(4096, Http2HeadersEncoder.NEVER_SENSITIVE);
    }

    private void encodeHeader(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2) {
        this.encoder.encodeHeader(byteBuf, charSequence, charSequence2, this.sensitivityDetector.isSensitive(charSequence, charSequence2));
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder
    public Http2HeadersEncoder.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder
    public void encodeHeaders(Http2Headers http2Headers, ByteBuf byteBuf) throws Http2Exception {
        try {
            if (http2Headers.size() > this.headerTable.maxHeaderListSize()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Number of headers (%d) exceeds maxHeaderListSize (%d)", Integer.valueOf(http2Headers.size()), Integer.valueOf(this.headerTable.maxHeaderListSize()));
            }
            if (this.tableSizeChangeOutput.isReadable()) {
                byteBuf.writeBytes(this.tableSizeChangeOutput);
                this.tableSizeChangeOutput.clear();
            }
            for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
                encodeHeader(byteBuf, entry.getKey(), entry.getValue());
            }
        } catch (Http2Exception e4) {
            throw e4;
        } catch (Throwable th) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, th, "Failed encoding headers block: %s", th.getMessage());
        }
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.Configuration
    public Http2HeaderTable headerTable() {
        return this.headerTable;
    }

    public DefaultHttp2HeadersEncoder(int i4, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        this.tableSizeChangeOutput = Unpooled.buffer();
        this.sensitivityDetector = (Http2HeadersEncoder.SensitivityDetector) ObjectUtil.checkNotNull(sensitivityDetector, "sensitiveDetector");
        this.encoder = new Encoder(i4);
        this.headerTable = new Http2HeaderTableEncoder();
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class Http2HeaderTableEncoder extends DefaultHttp2HeaderTableListSize implements Http2HeaderTable {
        private Http2HeaderTableEncoder() {
        }

        @Override // io.netty.handler.codec.http2.Http2HeaderTable
        public void maxHeaderTableSize(int i4) throws Http2Exception {
            if (i4 < 0) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be non-negative but was %d", Integer.valueOf(i4));
            }
            try {
                DefaultHttp2HeadersEncoder.this.encoder.setMaxHeaderTableSize(DefaultHttp2HeadersEncoder.this.tableSizeChangeOutput, i4);
            } catch (Throwable th) {
                throw new Http2Exception(Http2Error.PROTOCOL_ERROR, th.getMessage(), th);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2HeaderTable
        public int maxHeaderTableSize() {
            return DefaultHttp2HeadersEncoder.this.encoder.getMaxHeaderTableSize();
        }
    }
}
