package com.kwad.sdk.crash.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j {
    public static String ay(long j4) {
        String valueOf;
        String valueOf2;
        long j5 = j4 / 60000;
        long j6 = (j4 - (60000 * j5)) / 1000;
        if (j5 < 10) {
            valueOf = "0" + j5;
        } else {
            valueOf = String.valueOf(j5);
        }
        if (j6 < 10) {
            valueOf2 = "0" + j6;
        } else {
            valueOf2 = String.valueOf(j6);
        }
        return valueOf + ":" + valueOf2;
    }
}
