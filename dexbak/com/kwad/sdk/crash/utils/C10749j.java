package com.kwad.sdk.crash.utils;

/* renamed from: com.kwad.sdk.crash.utils.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10749j {
    /* renamed from: ay */
    public static String m24937ay(long j) {
        String valueOf;
        String valueOf2;
        long j2 = j / 60000;
        long j3 = (j - (60000 * j2)) / 1000;
        if (j2 < 10) {
            valueOf = "0" + j2;
        } else {
            valueOf = String.valueOf(j2);
        }
        if (j3 < 10) {
            valueOf2 = "0" + j3;
        } else {
            valueOf2 = String.valueOf(j3);
        }
        return valueOf + ":" + valueOf2;
    }
}
