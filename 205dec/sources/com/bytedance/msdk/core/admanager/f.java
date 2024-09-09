package com.bytedance.msdk.core.admanager;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f27706c = {"TTTransparentActivity", "openadsdk", "com.qq", "com.kwad", "baidu", "mbridge", "sigmob", "unity", "klevin"};

    /* renamed from: w  reason: collision with root package name */
    private static final String[] f27707w = {"not include str"};

    public static boolean c(String str, int i4, int i5) {
        return TextUtils.equals("baidu", str);
    }

    public static boolean w(String str, int i4, int i5) {
        if (i4 == 10 && i5 == 1) {
            return TextUtils.equals("ks", str) || TextUtils.equals("gdt", str);
        }
        return false;
    }

    public static boolean c(String str) {
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- activityStr: " + str);
        for (String str2 : f27706c) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
