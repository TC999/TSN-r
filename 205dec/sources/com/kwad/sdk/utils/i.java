package com.kwad.sdk.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i {
    public static void ap(String str, String str2) {
        com.kwad.sdk.core.e.c.d("callbackLog", str + str2);
    }

    public static void e(String str, String str2, String str3, String str4) {
        ap(str, str2 + "_" + str3 + "_" + str4);
    }

    public static void s(String str, int i4) {
        com.kwad.sdk.core.e.c.d("audioVideoLog", str + "_type_" + i4 + "_time_" + System.currentTimeMillis());
    }
}
