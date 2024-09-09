package com.kwad.library.solder.lib;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static String C(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + wV();
    }

    public static void e(String str, String str2) {
        Log.e("Sodler", C(str, str2));
    }

    private static String wV() {
        return "";
    }

    public static void e(String str, Throwable th) {
        Log.e("Sodler", C(str, ""), th);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e("Sodler", C(str, str2), th);
    }
}
