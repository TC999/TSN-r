package io.netty.handler.codec.http2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface StreamByteDistributor {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface StreamState {
        boolean hasFrame();

        int pendingBytes();

        Http2Stream stream();

        int windowSize();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface Writer {
        void write(Http2Stream http2Stream, int i4);
    }

    boolean distribute(int i4, Writer writer) throws Http2Exception;

    void updateStreamableBytes(StreamState streamState);
}
