package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2HeadersDecoder {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface Configuration {
        Http2HeaderTable headerTable();

        int maxHeaderSize();
    }

    Configuration configuration();

    Http2Headers decodeHeaders(ByteBuf byteBuf) throws Http2Exception;
}
