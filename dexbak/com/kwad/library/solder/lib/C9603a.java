package com.kwad.library.solder.lib;

import android.util.Log;

/* renamed from: com.kwad.library.solder.lib.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9603a {
    /* renamed from: C */
    private static String m28253C(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + m28249wV();
    }

    /* renamed from: e */
    public static void m28252e(String str, String str2) {
        Log.e("Sodler", m28253C(str, str2));
    }

    /* renamed from: wV */
    private static String m28249wV() {
        return "";
    }

    /* renamed from: e */
    public static void m28250e(String str, Throwable th) {
        Log.e("Sodler", m28253C(str, ""), th);
    }

    /* renamed from: e */
    public static void m28251e(String str, String str2, Throwable th) {
        Log.e("Sodler", m28253C(str, str2), th);
    }
}
