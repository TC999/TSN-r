package com.bytedance.sdk.component.adexpress.sr;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {
    public static boolean c(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean w(String str) {
        return com.bytedance.sdk.component.adexpress.sr.c() && c(str);
    }
}
