package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpVersion;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class RtspVersions {
    public static final HttpVersion RTSP_1_0 = new HttpVersion("RTSP", 1, 0, true);

    private RtspVersions() {
    }

    public static HttpVersion valueOf(String str) {
        if (str != null) {
            String upperCase = str.trim().toUpperCase();
            if ("RTSP/1.0".equals(upperCase)) {
                return RTSP_1_0;
            }
            return new HttpVersion(upperCase, true);
        }
        throw new NullPointerException("text");
    }
}
