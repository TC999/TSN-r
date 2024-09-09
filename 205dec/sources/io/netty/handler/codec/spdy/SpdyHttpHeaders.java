package io.netty.handler.codec.spdy;

import io.netty.util.AsciiString;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SpdyHttpHeaders {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Names {
        public static final AsciiString STREAM_ID = new AsciiString("x-spdy-stream-id");
        public static final AsciiString ASSOCIATED_TO_STREAM_ID = new AsciiString("x-spdy-associated-to-stream-id");
        public static final AsciiString PRIORITY = new AsciiString("x-spdy-priority");
        public static final AsciiString SCHEME = new AsciiString("x-spdy-scheme");

        private Names() {
        }
    }

    private SpdyHttpHeaders() {
    }
}
