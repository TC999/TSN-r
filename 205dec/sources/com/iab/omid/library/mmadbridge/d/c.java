package com.iab.omid.library.mmadbridge.d;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    public static void a(String str) {
        if (!com.iab.omid.library.mmadbridge.c.f37731a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("OMIDLIB", str);
    }

    public static void b(String str, Exception exc) {
        if ((!com.iab.omid.library.mmadbridge.c.f37731a.booleanValue() || TextUtils.isEmpty(str)) && exc == null) {
            return;
        }
        Log.e("OMIDLIB", str, exc);
    }
}
