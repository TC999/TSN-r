package com.bytedance.sdk.component.r.w.c.c;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(), 10);
    }

    public static String w(String str) {
        return TextUtils.isEmpty(str) ? "" : new String(Base64.decode(str, 10));
    }
}
