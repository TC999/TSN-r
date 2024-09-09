package com.bytedance.msdk.f;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ba {
    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            c(str2);
        }
    }

    private static void c(String str) {
        throw new IllegalArgumentException(str);
    }
}
