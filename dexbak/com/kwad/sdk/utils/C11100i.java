package com.kwad.sdk.utils;

import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.sdk.utils.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11100i {
    /* renamed from: ap */
    public static void m23787ap(String str, String str2) {
        C10331c.m26254d("callbackLog", str + str2);
    }

    /* renamed from: e */
    public static void m23786e(String str, String str2, String str3, String str4) {
        m23787ap(str, str2 + "_" + str3 + "_" + str4);
    }

    /* renamed from: s */
    public static void m23785s(String str, int i) {
        C10331c.m26254d("audioVideoLog", str + "_type_" + i + "_time_" + System.currentTimeMillis());
    }
}
