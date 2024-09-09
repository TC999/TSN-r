package io.netty.handler.codec.http2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Http2FrameTypes {
    public static final byte CONTINUATION = 9;
    public static final byte DATA = 0;
    public static final byte GO_AWAY = 7;
    public static final byte HEADERS = 1;
    public static final byte PING = 6;
    public static final byte PRIORITY = 2;
    public static final byte PUSH_PROMISE = 5;
    public static final byte RST_STREAM = 3;
    public static final byte SETTINGS = 4;
    public static final byte WINDOW_UPDATE = 8;

    private Http2FrameTypes() {
    }
}
