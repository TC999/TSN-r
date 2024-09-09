package com.bytedance.sdk.openadsdk.core.fz;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.yu;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f33594c;

    private a() {
    }

    public static a c() {
        if (f33594c == null) {
            synchronized (a.class) {
                if (f33594c == null) {
                    f33594c = new a();
                }
            }
        }
        return f33594c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ux(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !str.startsWith("zeus") && !TextUtils.equals("plugin_load_failed", str)) {
                str = "zeus_" + str;
            }
            JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
            if (str2 != null) {
                jSONObject.put("current_version", "6.1.0.6");
                int i4 = Build.VERSION.SDK_INT;
                jSONObject.put("os_api", i4);
                jSONObject.put("support_abi", Arrays.toString(i4 >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            final int optInt = jSONObject.has("status_code") ? jSONObject.optInt("status_code") : jSONObject.optInt("code");
            final String optString = jSONObject.optString("message");
            final String optString2 = jSONObject.optString("duration");
            final String jSONObject2 = jSONObject.toString();
            final String str3 = str;
            w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.33
                @Override // com.bytedance.sdk.openadsdk.p.c.c
                public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                    if ("zeus_load_finish".equals(str3)) {
                        return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(str3).w(jSONObject2).w(optInt).r(optString).ux(optString2).c(a.c("6.1.0.6") ? 1 : 0);
                    }
                    return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(str3).w(jSONObject2).w(optInt).ux(optString2).r(optString);
                }
            }, str, true);
        } catch (Throwable unused) {
        }
    }

    private boolean w(com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar) {
        return xvVar == null;
    }

    private void xv(com.bytedance.sdk.openadsdk.p.c.c cVar, String str) {
        c(cVar, str, true);
    }

    public void ev(final com.bytedance.sdk.openadsdk.p.c.c cVar) {
        if (cVar == null) {
            return;
        }
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.9
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return ((com.bytedance.sdk.openadsdk.core.fz.c.xv) cVar.c()).c("app_env").c(System.currentTimeMillis() / 1000);
            }
        }, "app_env", true);
    }

    public void f(com.bytedance.sdk.openadsdk.p.c.c cVar) {
        sr(cVar, "show_backup_endcard");
    }

    public void r(com.bytedance.sdk.openadsdk.p.c.c cVar) {
        xv(cVar, "splash_creative_check");
    }

    public void w(final String str, final String str2) {
        com.bytedance.sdk.component.gd.ev.xv(new com.bytedance.sdk.component.gd.p("plugin_report") { // from class: com.bytedance.sdk.openadsdk.core.fz.a.32
            @Override // java.lang.Runnable
            public void run() {
                a.ux(str, str2);
            }
        });
    }

    private void sr(final com.bytedance.sdk.openadsdk.p.c.c cVar, final String str) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.5
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar = (com.bytedance.sdk.openadsdk.core.fz.c.xv) cVar.c();
                xvVar.c(str);
                xvVar.c(currentTimeMillis);
                return xvVar;
            }
        }, str, true);
    }

    public void w() {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.2
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.ys.w.xv.sr f4 = com.bytedance.sdk.openadsdk.core.k.sr().f();
                boolean w3 = f4.w();
                boolean c4 = f4.c();
                boolean ux = f4.ux();
                boolean sr = f4.sr();
                boolean xv = f4.xv();
                JSONObject jSONObject = new JSONObject();
                int i4 = 1;
                try {
                    jSONObject.put("access_fine_location", c4 ? 1 : 0);
                    jSONObject.put("applist", w3 ? 1 : 0);
                    jSONObject.put("external_storage", ux ? 1 : 0);
                    jSONObject.put("wifi_state", sr ? 1 : 0);
                    if (!xv) {
                        i4 = 0;
                    }
                    jSONObject.put("phone_state", i4);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("sdk_permission").w(jSONObject.toString());
            }
        }, "sdk_permission", true);
    }

    public void xv(com.bytedance.sdk.openadsdk.p.c.c cVar) {
        xv(cVar, "outer_call_no_rsp");
    }

    public void w(com.bytedance.sdk.openadsdk.p.c.c cVar) {
        xv(cVar, "outer_call_send");
    }

    public void xv(final int i4) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.18
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("get_ad_cache_failed").w(i4);
            }
        }, "get_ad_cache_failed", true);
    }

    public static void xv(final String str, final String str2) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.27
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.w wVar = new com.bytedance.sdk.openadsdk.core.fz.c.w();
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("message", str);
                jSONObject.put("code", 4300);
                jSONObject.putOpt("plugin_package_name", str2);
                wVar.w(jSONObject.toString());
                return wVar;
            }
        }, "plugin_load_failed", false);
    }

    public void sr(com.bytedance.sdk.openadsdk.p.c.c cVar) {
        xv(cVar, "load_timeout");
    }

    public void w(final int i4) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.17
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fetch_adm", i4 == 0 ? 1 : 0);
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("fetch_adm_status").w(i4).w(jSONObject.toString());
            }
        }, "fetch_adm_status", true);
    }

    public void sr(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.30
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("device_qty_compare");
                c4.w(jSONObject.toString());
                return c4;
            }
        }, "device_qty_compare", true);
    }

    public void w(final String str) {
        if (str == null) {
            return;
        }
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.19
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("error_ad_info").c(System.currentTimeMillis() / 1000).gd(str);
            }
        }, "error_ad_info", true);
    }

    public void xv(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.28
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("net_qty_compare");
                c4.w(jSONObject.toString());
                return c4;
            }
        }, "net_qty_compare", true);
    }

    public void w(com.bytedance.sdk.openadsdk.p.c.c cVar, String str) {
        w.xv().c(cVar, str, true);
    }

    public void c(com.bytedance.sdk.openadsdk.p.c.c cVar, String str) {
        w.xv().c(cVar, str, true);
    }

    public void w(final int i4, final me meVar) {
        if (meVar == null) {
            return;
        }
        w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.24
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("code", Integer.valueOf(i4));
                jSONObject.putOpt("isCache", Boolean.valueOf(meVar.fn()));
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("open_live_room").f(meVar.xq()).ev(meVar.cf()).w(jSONObject.toString());
            }
        }, "open_live_room");
    }

    public void c(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.11
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("render_backup").w(jSONObject.toString());
            }
        }, "render_backup", true);
    }

    public void w(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.26
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("BUNetworkRatingReport").w(jSONObject.toString());
            }
        }, "BUNetworkRatingReport");
    }

    public static void c(Result result, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        long j4;
        String str;
        if (result != null) {
            ValueSet values = result.values();
            boolean isSuccess = result.isSuccess();
            int code = result.code();
            String message = result.message();
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("success", isSuccess);
                jSONObject4.put("code", code);
                jSONObject4.put("message", message);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (values != null) {
                JSONObject jSONObject5 = (JSONObject) values.objectValue(10, JSONObject.class);
                String stringValue = values.stringValue(5);
                long currentTimeMillis = jSONObject5 != null ? System.currentTimeMillis() - jSONObject5.optLong("run_package_start", 0L) : -1L;
                jSONObject2 = (JSONObject) values.objectValue(3, JSONObject.class);
                jSONObject3 = (JSONObject) values.objectValue(4, JSONObject.class);
                j4 = currentTimeMillis;
                str = stringValue;
            } else {
                jSONObject2 = null;
                jSONObject3 = null;
                j4 = -1;
                str = null;
            }
            c().c(str, jSONObject != null ? jSONObject.optString("business_type") : "", isSuccess, j4, jSONObject2, jSONObject3, jSONObject4);
        }
    }

    public void ux(com.bytedance.sdk.openadsdk.p.c.c cVar) {
        sr(cVar, "express_ad_render");
    }

    public void c(final long j4, final long j5, final int i4) {
        final long j6 = j5 - j4;
        if (j6 <= 0 || j6 >= 30000000) {
            return;
        }
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.21
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j4);
                    jSONObject.put("endtime", j5);
                    jSONObject.put("start_type", i4);
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("general_label");
                return c4.ux(j6 + "").w(jSONObject.toString());
            }
        }, "general_label", true);
    }

    public void c(final String str, final String str2) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.29
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("close_time_1", str2);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("sdk_retention").ux(str).w(jSONObject.toString());
            }
        }, "sdk_retention", true);
    }

    public void c(String str, int i4, int i5, String str2, final int i6, final String str3, final long j4) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i6);
            jSONObject.put("message", str3);
            jSONObject.put("version", i5);
            jSONObject.put("current_version", i4);
            jSONObject.put("package_name", str);
            jSONObject.put("url", str2);
            jSONObject.put("duration", j4);
        } catch (Throwable unused) {
        }
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.31
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv r3 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("plugin_download").w(i6).r(str3);
                return r3.ux(j4 + "").w(jSONObject.toString());
            }
        }, "plugin_download", true);
    }

    public static boolean c(String str) {
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        String w3 = c4.w("plugin_first_load", "");
        if (TextUtils.isEmpty(w3) || !w3.endsWith(str)) {
            if (!TextUtils.isEmpty(w3)) {
                str = w3 + "-" + str;
            }
            c4.c("plugin_first_load", str);
            return true;
        }
        return false;
    }

    public void c(final String str, final int i4, final int i5, final int i6) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.1
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("enable_pv", i4);
                    jSONObject.put("boost_init", i5);
                    jSONObject.put("step", i6);
                    jSONObject.put("from", str);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("pv_monitor").w(jSONObject.toString());
            }
        }, "pv_monitor", true);
    }

    public void c(Activity activity) {
        final String name = activity.getClass().getName();
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.3
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_name", name);
                xk.c(jSONObject, "");
                String jSONObject2 = jSONObject.toString();
                com.bytedance.sdk.component.utils.a.w("StatsLogManager", "delegate_on_create: " + jSONObject2);
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("delegate_on_create").w(jSONObject2);
            }
        }, "delegate_on_create", true);
    }

    private void c(final com.bytedance.sdk.openadsdk.p.c.c cVar, final String str, boolean z3) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.4
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar = (com.bytedance.sdk.openadsdk.core.fz.c.xv) cVar.c();
                xvVar.c(str);
                xvVar.c(currentTimeMillis);
                return xvVar;
            }
        }, str, true);
    }

    public void c(com.bytedance.sdk.openadsdk.p.c.c cVar) {
        xv(cVar, "outer_call");
    }

    private boolean c(String str, int i4) {
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        boolean z3 = false;
        int w3 = c4.w(str, 0);
        z3 = ((w3 & 2) == 0 || (w3 & 1) != i4) ? true : true;
        if (z3) {
            c4.c(str, i4 + 2);
        }
        return z3;
    }

    public void c(final int i4, me meVar, final boolean z3) {
        final String valueOf = String.valueOf(wv.gd(meVar));
        if (c(valueOf, z3 ? 1 : 0)) {
            w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.6
                @Override // com.bytedance.sdk.openadsdk.p.c.c
                public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                    com.bytedance.sdk.openadsdk.core.fz.c.xv xv = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(i4).xv(valueOf);
                    if (z3) {
                        xv.c("reg_creative");
                    } else {
                        xv.c("no_reg_creative");
                    }
                    return xv;
                }
            }, z3 ? "reg_creative" : "no_reg_creative", true);
        }
    }

    public void c(final com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar) {
        if (w(xvVar)) {
            return;
        }
        xvVar.c("load_icon_error");
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.7
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return xvVar;
            }
        }, "load_icon_error", true);
    }

    public void c(final boolean z3, final String[] strArr) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.8
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                String[] strArr2;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("if_sd", z3 ? 1 : 0);
                    String[] strArr3 = strArr;
                    if (strArr3 != null && strArr3.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str);
                                sb.append(",");
                            }
                        }
                        jSONObject.put("permission", sb.toString());
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("download_permission").c(System.currentTimeMillis() / 1000).w(jSONObject.toString());
            }
        }, "download_permission", true);
    }

    public void c(final String str, final String str2, final String str3, final boolean z3) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.10
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("get_bidding_token");
                boolean w3 = ls.w().w(str);
                JSONObject jSONObject = new JSONObject();
                if (w3) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("cache_req_id", str2);
                    }
                    if (TextUtils.equals(str3, "0")) {
                        jSONObject.put("no_cache_reason", 0);
                    } else if (TextUtils.equals(str3, "1")) {
                        jSONObject.put("no_cache_reason", 1);
                    }
                }
                if (z3) {
                    jSONObject.put("opt_sample", 1);
                }
                c4.w(jSONObject.toString());
                return c4;
            }
        }, "get_bidding_token", z3);
    }

    public void c(final long j4, final com.bytedance.sdk.openadsdk.core.ls.sr srVar) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.12
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j4);
                jSONObject.put("ext_plugin_code", yu.w());
                com.bytedance.sdk.openadsdk.core.ls.sr srVar2 = srVar;
                if (srVar2 != null) {
                    jSONObject.put("success", srVar2.c() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.ls.f w3 = srVar.w();
                    if (w3 != null) {
                        jSONObject.put("msg", w3.toString());
                        jSONObject.put("code", w3.c());
                    }
                }
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("pitaya_init").w(jSONObject.toString());
            }
        }, "pitaya_init", true);
    }

    public void c(final String str, final String str2, final boolean z3, final long j4, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.13
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("duration", j4);
                jSONObject4.put("business", str);
                jSONObject4.put("biztype", str2);
                jSONObject4.put("result", z3);
                JSONObject jSONObject5 = jSONObject;
                if (jSONObject5 != null) {
                    jSONObject4.put("package_info", jSONObject5.toString());
                }
                JSONObject jSONObject6 = jSONObject2;
                if (jSONObject6 != null) {
                    jSONObject4.put("error_info", jSONObject6.toString());
                }
                JSONObject jSONObject7 = jSONObject3;
                if (jSONObject7 != null) {
                    jSONObject4.put("common_info", jSONObject7.toString());
                }
                jSONObject4.put("ext_plugin_code", yu.w());
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("pitaya_run_task").w(jSONObject4.toString());
            }
        }, "pitaya_run_task", true);
    }

    public void c(final int i4, n nVar) {
        if (nVar == null) {
            return;
        }
        final JSONObject c4 = nVar.c(-1L);
        final long w3 = nVar.w();
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.14
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv c5 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("bid_token_time");
                try {
                    c4.put("total", w3);
                    c4.put("opt_sample", 1);
                    c4.put("slot_type", i4);
                    c5.w(c4.toString());
                } catch (Throwable unused) {
                }
                return c5;
            }
        }, "get_bidding_token", true);
    }

    public void c(int i4, long j4, String str) {
        c(i4, j4, (Boolean) null, str);
    }

    public void c(final int i4, final long j4, final Boolean bool, final String str) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.15
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("encrypt_track");
                try {
                    JSONObject jSONObject = new JSONObject();
                    long j5 = j4;
                    if (j5 >= 0) {
                        jSONObject.put("cost_time", j5);
                    }
                    Boolean bool2 = bool;
                    if (bool2 != null) {
                        jSONObject.put("init_succ", bool2.booleanValue() ? 1 : 2);
                    }
                    jSONObject.put("opt_sample", 1);
                    int i5 = i4;
                    if (i5 != -1) {
                        jSONObject.put("event_res", i5);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("type", str);
                    }
                    c4.w(jSONObject.toString());
                } catch (Throwable unused) {
                }
                return c4;
            }
        }, "encrypt_track", true);
    }

    public void c(final int i4) {
        w.xv().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.16
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("has_pre_req").w(i4);
            }
        }, "has_pre_req", true);
    }

    public void c(String str, Throwable th) {
        c(str, (JSONObject) null, th);
    }

    public void c(final String str, JSONObject jSONObject, final Throwable th) {
        w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.20
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("scene", str);
                jSONObject2.putOpt("object", jSONObject2);
                jSONObject2.putOpt("exception", th);
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("exception").w(jSONObject2.toString());
            }
        }, "exception");
    }

    public void c(final boolean z3) {
        w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.22
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", z3);
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("live_init_success").w(jSONObject.toString());
            }
        }, "live_init_success");
    }

    public void c(final int i4, final me meVar) {
        if (meVar == null) {
            return;
        }
        w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.23
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("code", Integer.valueOf(i4));
                jSONObject.putOpt("isCache", Boolean.valueOf(meVar.fn()));
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("reward_to_room").f(meVar.xq()).ev(meVar.cf()).w(jSONObject.toString());
            }
        }, "reward_to_room");
    }

    public void c(final me meVar, final String str, final JSONObject jSONObject) {
        w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.a.25
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(str);
                me meVar2 = meVar;
                if (meVar2 != null) {
                    c4.f(meVar2.xq()).ev(meVar.cf());
                }
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    c4.w(jSONObject2.toString());
                }
                return c4;
            }
        }, str);
    }

    public void c(me meVar, String str) {
        c(meVar, str, (JSONObject) null);
    }
}
