package io.netty.handler.codec.rtsp;

import com.baidu.mobads.sdk.internal.C2573a;
import io.netty.handler.codec.http.HttpVersion;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        throw new NullPointerException(C2573a.f8443b);
    }
}
