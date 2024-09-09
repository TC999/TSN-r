package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;

/* compiled from: StringUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ag {
    public static boolean a(String str) {
        return str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str);
    }

    public static boolean b(String str) {
        return (str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str)) ? false : true;
    }
}
