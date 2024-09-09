package io.netty.handler.codec.http2;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2HeaderTable {
    int maxHeaderListSize();

    void maxHeaderListSize(int i4) throws Http2Exception;

    int maxHeaderTableSize();

    void maxHeaderTableSize(int i4) throws Http2Exception;
}
