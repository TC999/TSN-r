package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectDecoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class RtspObjectDecoder extends HttpObjectDecoder {
    protected RtspObjectDecoder() {
        this(4096, 8192, 8192);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        boolean isContentAlwaysEmpty = super.isContentAlwaysEmpty(httpMessage);
        if (!isContentAlwaysEmpty && httpMessage.headers().contains(RtspHeaderNames.CONTENT_LENGTH)) {
            return isContentAlwaysEmpty;
        }
        return true;
    }

    protected RtspObjectDecoder(int i4, int i5, int i6) {
        super(i4, i5, i6 * 2, false);
    }

    protected RtspObjectDecoder(int i4, int i5, int i6, boolean z3) {
        super(i4, i5, i6 * 2, false, z3);
    }
}
