package io.netty.handler.codec.http2;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class DefaultHttp2HeaderTableListSize {
    private int maxHeaderListSize = Integer.MAX_VALUE;

    public void maxHeaderListSize(int i) throws Http2Exception {
        if (i < 0) {
            this.maxHeaderListSize = Integer.MAX_VALUE;
        } else {
            this.maxHeaderListSize = i;
        }
    }

    public int maxHeaderListSize() {
        return this.maxHeaderListSize;
    }
}
