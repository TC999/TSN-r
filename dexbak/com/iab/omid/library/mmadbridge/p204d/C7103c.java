package com.iab.omid.library.mmadbridge.p204d;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.mmadbridge.C7093c;

/* renamed from: com.iab.omid.library.mmadbridge.d.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7103c {
    /* renamed from: a */
    public static void m34677a(String str) {
        if (!C7093c.f24249a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("OMIDLIB", str);
    }

    /* renamed from: b */
    public static void m34676b(String str, Exception exc) {
        if ((!C7093c.f24249a.booleanValue() || TextUtils.isEmpty(str)) && exc == null) {
            return;
        }
        Log.e("OMIDLIB", str, exc);
    }
}
