package com.beizi.p051ad.internal;

import android.text.TextUtils;

/* renamed from: com.beizi.ad.internal.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Validator {
    /* renamed from: a */
    public static String m49296a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    /* renamed from: a */
    public static <T> T m49297a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: a */
    public static void m49295a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: a */
    public static void m49294a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
