package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Http2HeadersDecoder {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface Configuration {
        Http2HeaderTable headerTable();

        int maxHeaderSize();
    }

    Configuration configuration();

    Http2Headers decodeHeaders(ByteBuf byteBuf) throws Http2Exception;
}
