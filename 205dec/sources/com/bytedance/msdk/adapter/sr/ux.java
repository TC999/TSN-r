package com.bytedance.msdk.adapter.sr;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {
    public static String c() {
        return "TTMediationSDK_";
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return c();
        }
        return "TTMediationSDK_" + str + "_";
    }

    public static String w(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return c();
        }
        if (TextUtils.isEmpty(str2)) {
            return c(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return c();
        }
        if (TextUtils.isEmpty(str2)) {
            return c(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }
}
