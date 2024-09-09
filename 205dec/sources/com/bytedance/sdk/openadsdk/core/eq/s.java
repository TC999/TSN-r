package com.bytedance.sdk.openadsdk.core.eq;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s {

    /* renamed from: c  reason: collision with root package name */
    private static final String f33306c = null;

    /* renamed from: w  reason: collision with root package name */
    private static long f33307w = -1;

    public static JSONArray c(final Context context) {
        if (System.currentTimeMillis() - f33307w <= 1000) {
            return null;
        }
        f33307w = System.currentTimeMillis();
        if (com.bytedance.sdk.openadsdk.core.z.ux.ux() && w() && com.bytedance.sdk.openadsdk.core.ls.w().iw() && com.bytedance.sdk.openadsdk.core.k.sr().ux().w()) {
            com.bytedance.sdk.component.gd.ev.c(new com.bytedance.sdk.component.gd.p("getIncrementalInstallApps") { // from class: com.bytedance.sdk.openadsdk.core.eq.s.1
                @Override // java.lang.Runnable
                public void run() {
                    s.xv(context);
                }
            }, 1);
            return c();
        }
        return null;
    }

    private static List<String> sr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(Context context) {
        try {
            List<String> c4 = com.bytedance.sdk.openadsdk.core.z.xv.w().c(context);
            if (c4 != null && !c4.isEmpty()) {
                List<String> sr = sr(com.bytedance.sdk.openadsdk.core.xv.c().w("install_app_string", f33306c));
                w(c(c4));
                if (sr != null && !sr.isEmpty()) {
                    c4.removeAll(sr);
                }
                xv(c(c4));
            }
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.c("InstallAppUtils", "loadIncrementInstallApps error: ", e4);
        }
    }

    private static void w(String str) {
        com.bytedance.sdk.openadsdk.core.xv.c().c("install_app_string", str);
    }

    private static boolean w() {
        long w3 = com.bytedance.sdk.openadsdk.core.xv.c().w("apptime", -1L);
        return w3 == -1 || System.currentTimeMillis() - w3 > 43200000;
    }

    private static JSONArray c() {
        try {
            String w3 = com.bytedance.sdk.openadsdk.core.xv.c().w("install_app_incremental_string", f33306c);
            if (TextUtils.isEmpty(w3)) {
                return null;
            }
            return new JSONArray((Collection) sr(w3));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.c("InstallAppUtils", "getCacheIncrementalApps error: ", th);
            return null;
        }
    }

    private static void xv(String str) {
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        c4.c("install_app_incremental_string", str);
        c4.c("apptime", System.currentTimeMillis());
    }

    private static String c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < list.size(); i4++) {
            sb.append(list.get(i4));
            if (i4 != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            c(0, 0, null);
            return false;
        }
        if (wv.f(com.bytedance.sdk.openadsdk.core.ls.getContext()) && !wv.xv(com.bytedance.sdk.openadsdk.core.ls.getContext(), str)) {
            c(0, 0, null);
        }
        return false;
    }

    private static void c(final int i4, final int i5, final String str) {
        com.bytedance.sdk.openadsdk.core.fz.w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.s.2
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("call_api_status", i4);
                    jSONObject.put("has_actived", i5);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("error_msg", str);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("call_active_api").w(jSONObject.toString());
            }
        }, "call_active_api", true);
    }
}
