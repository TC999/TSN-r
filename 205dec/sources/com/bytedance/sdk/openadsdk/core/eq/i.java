package com.bytedance.sdk.openadsdk.core.eq;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f33261c = "";

    /* renamed from: w  reason: collision with root package name */
    private static volatile String f33262w = "";
    private static volatile boolean xv;

    public static void c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            xv = true;
            f33261c = str;
            com.bytedance.sdk.openadsdk.tools.w.w(7, f33261c == null ? "" : f33261c);
            update();
        } catch (Throwable unused) {
        }
    }

    private static void update() {
        if (TextUtils.isEmpty(f33261c)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xv.ux.c().ux("app_log_oaid", f33261c);
    }

    public static String c() {
        if (TextUtils.isEmpty(f33261c)) {
            f33261c = com.bytedance.sdk.openadsdk.core.xv.ux.c().xv("app_log_oaid", 86400000L);
            com.bytedance.sdk.openadsdk.tools.w.w(7, f33261c == null ? "" : f33261c);
        }
        if (TextUtils.isEmpty(f33261c) && !xv) {
            com.bytedance.sdk.openadsdk.ys.w.xv.sr f4 = com.bytedance.sdk.openadsdk.core.k.sr().f();
            if (f4 != null && !TextUtils.isEmpty(f4.k())) {
                f33261c = f4.k();
                update();
            }
            com.bytedance.sdk.openadsdk.tools.w.w(7, f33261c == null ? "" : f33261c);
        }
        return f33261c == null ? "" : f33261c;
    }

    public static String c(boolean z3) {
        long j4;
        if (!TextUtils.isEmpty(f33261c)) {
            return f33261c;
        }
        if (z3 && !TextUtils.isEmpty(f33262w)) {
            return f33262w;
        }
        try {
            String sr = com.bytedance.sdk.openadsdk.core.xv.ux.c().sr("app_log_oaid", null);
            j4 = 0;
            if (!TextUtils.isEmpty(sr)) {
                JSONObject jSONObject = new JSONObject(sr);
                f33262w = jSONObject.getString("value");
                j4 = jSONObject.getLong("time");
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(f33262w) && (z3 || System.currentTimeMillis() - j4 < 86400000)) {
            return f33262w;
        }
        if (!xv) {
            com.bytedance.sdk.openadsdk.ys.w.xv.sr f4 = com.bytedance.sdk.openadsdk.core.k.sr().f();
            if (f4 != null && !TextUtils.isEmpty(f4.k())) {
                f33261c = f4.k();
                update();
            }
            com.bytedance.sdk.openadsdk.tools.w.w(7, f33261c == null ? "" : f33261c);
        }
        return f33261c == null ? "" : f33261c;
    }
}
