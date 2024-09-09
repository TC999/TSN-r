package com.bytedance.sdk.component.utils;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia {
    public static void c(Object obj, String str) {
        if (obj == null) {
            w(str);
        }
    }

    private static void w(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            w(str2);
        }
    }

    public static void c(boolean z3, String str) {
        if (z3) {
            return;
        }
        w(str);
    }

    public static void c(String str) {
        w(str);
    }
}
