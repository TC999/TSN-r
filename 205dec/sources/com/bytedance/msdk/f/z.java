package com.bytedance.msdk.f;

import android.text.TextUtils;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class z {

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f28377c = "";

    /* renamed from: w  reason: collision with root package name */
    private static volatile boolean f28378w;

    static {
        try {
            if (TextUtils.isEmpty(f28377c)) {
                f28377c = wv.c("tt_device_info", com.bytedance.msdk.core.c.getContext()).w(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, "");
            }
        } catch (Throwable unused) {
        }
    }

    public static String c() {
        try {
            if (TextUtils.isEmpty(f28377c)) {
                f28377c = ia.w();
                c(f28377c);
            }
        } catch (Throwable unused) {
        }
        return f28377c == null ? "" : f28377c;
    }

    private static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        wv.c("tt_device_info", com.bytedance.msdk.core.c.getContext()).c(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, str);
    }
}
