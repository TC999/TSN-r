package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;

/* renamed from: com.mbridge.msdk.foundation.tools.ag */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class StringUtils {
    /* renamed from: a */
    public static boolean m21957a(String str) {
        return str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str);
    }

    /* renamed from: b */
    public static boolean m21956b(String str) {
        return (str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str)) ? false : true;
    }
}
