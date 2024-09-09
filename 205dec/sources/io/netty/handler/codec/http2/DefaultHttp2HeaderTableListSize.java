package io.netty.handler.codec.http2;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
class DefaultHttp2HeaderTableListSize {
    private int maxHeaderListSize = Integer.MAX_VALUE;

    public void maxHeaderListSize(int i4) throws Http2Exception {
        if (i4 < 0) {
            this.maxHeaderListSize = Integer.MAX_VALUE;
        } else {
            this.maxHeaderListSize = i4;
        }
    }

    public int maxHeaderListSize() {
        return this.maxHeaderListSize;
    }
}
