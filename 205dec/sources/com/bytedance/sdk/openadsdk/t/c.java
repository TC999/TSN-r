package com.bytedance.sdk.openadsdk.t;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.c.w.b;
import com.bytedance.c.w.e;
import com.bytedance.c.w.g;
import com.bytedance.sdk.component.ev.sr.f;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.ux;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.s;
import com.bytedance.sdk.openadsdk.core.eq.sr;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.eq.z;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.z.xv;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static String f36285c;

    public static Uri c(String str, String str2) {
        return null;
    }

    private static String sr() {
        if (TextUtils.isEmpty(f36285c)) {
            String f4 = i.f();
            if (!TextUtils.isEmpty(f4)) {
                f36285c = ux.w(f4);
            }
        }
        return f36285c;
    }

    public static void w(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("imei", i.f());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public static void xv(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("udid", i.f());
            jSONObject.put("mc", i.fz());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void c(Context context, JSONObject jSONObject) {
        try {
            float f4 = 0.0f;
            float f5 = sr.c(context) == null ? 0.0f : sr.c(context).f33369c;
            if (sr.c(context) != null) {
                f4 = sr.c(context).f33370w;
            }
            jSONObject.put("latitude", f5);
            jSONObject.put("longitude", f4);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public static String w() {
        if (k.sr().ux().sr()) {
            return i.ev();
        }
        return null;
    }

    public static void xv() {
        xv.w().xv();
    }

    public static void w(final Context context) {
        if ((ls.w().nc() & 8) != 0) {
            a.c().c("apm", 2, 2, 2);
            return;
        }
        b.e(new e() { // from class: com.bytedance.sdk.openadsdk.t.c.1
            @Override // com.bytedance.c.w.e
            public boolean c(final Throwable th, final Thread thread) {
                try {
                    com.bytedance.sdk.component.gd.a.f29806w.ux(true);
                    if (c.w(th.getStackTrace())) {
                        ev.w(new p("tt_crash_handle") { // from class: com.bytedance.sdk.openadsdk.t.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                z.c().c(thread, th);
                            }
                        });
                        return true;
                    }
                    return false;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // com.bytedance.c.w.e
            public boolean c() {
                try {
                    return c.w(Looper.getMainLooper().getThread().getStackTrace());
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
        b.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), new g() { // from class: com.bytedance.sdk.openadsdk.t.c.2
            @Override // com.bytedance.c.w.g
            public Map<String, Object> c() {
                HashMap hashMap = new HashMap();
                String w3 = r.c().w();
                if (TextUtils.isEmpty(w3)) {
                    w3 = i.xv();
                }
                if (!TextUtils.isEmpty(w3)) {
                    hashMap.put("device_id", w3);
                }
                hashMap.put("ac", f.xv(context));
                hashMap.put("aid", r.c().ux());
                hashMap.put("app_name", r.c().f());
                String p3 = wv.p();
                if (!TextUtils.isEmpty(p3)) {
                    hashMap.put("app_version", p3);
                }
                String gd = wv.gd();
                if (!TextUtils.isEmpty(gd)) {
                    hashMap.put("version_code", gd);
                    try {
                        hashMap.put("update_version_code", Integer.valueOf(gd));
                    } catch (Exception e4) {
                        hashMap.put("update_version_code", 0);
                        com.bytedance.sdk.component.utils.a.w("NPTHUtils", e4.getMessage());
                    }
                }
                hashMap.put("version_name", "6.1.0.6");
                hashMap.put("sdk_api_version", eq.xv);
                hashMap.put("device_platform", "android");
                hashMap.put("os", "Android");
                String u3 = i.u();
                hashMap.put("device_type", u3);
                hashMap.put("device_mode", u3);
                hashMap.put("rom", com.bytedance.sdk.openadsdk.core.eq.ls.c());
                hashMap.put("cpu_abi", Build.CPU_ABI);
                hashMap.put("device_brand", Build.BRAND);
                hashMap.put("channel", eq.xv());
                hashMap.put("language", Locale.getDefault().getLanguage());
                hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String str = Build.VERSION.RELEASE;
                    if (str != null && str.length() > 10) {
                        str = str.substring(0, 10);
                    }
                    hashMap.put("os_version", str);
                } catch (Exception unused) {
                }
                hashMap.put("openudid", i.ux());
                hashMap.put("dpi", String.valueOf(xk.ev(context)));
                hashMap.put("resolution", xk.sr(context) + "*" + xk.ux(context));
                return hashMap;
            }

            @Override // com.bytedance.c.w.g
            public List<String> f() {
                return null;
            }

            @Override // com.bytedance.c.w.g
            public Map<String, Object> r() {
                HashMap hashMap = new HashMap();
                String ev = k.sr().ev();
                if (TextUtils.isEmpty(ev)) {
                    ev = String.valueOf(r.c().ux());
                }
                hashMap.put("host_appid", ev);
                hashMap.put("sdk_version", "6.1.0.6");
                hashMap.put("plugin_version", "6.1.0.6");
                hashMap.put("channel", eq.xv());
                hashMap.put("sdk_api_version", eq.xv);
                return hashMap;
            }

            @Override // com.bytedance.c.w.g
            public String sr() {
                return null;
            }

            @Override // com.bytedance.c.w.g
            public Map<String, Integer> ux() {
                return null;
            }

            @Override // com.bytedance.c.w.g
            public String w() {
                String xv = i.xv();
                return TextUtils.isEmpty(xv) ? "0" : xv;
            }

            @Override // com.bytedance.c.w.g
            public String xv() {
                return r.c().xv();
            }
        }, (ls.w().nc() & 2) == 0, (ls.w().nc() & 1) == 0);
        com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.t.c.3
            @Override // java.lang.Runnable
            public void run() {
                boolean c4 = com.bytedance.sdk.openadsdk.core.xv.f.c();
                com.bytedance.sdk.component.utils.a.w("NPTHUtils", "bsi:" + c4);
                if (c4) {
                    a.c().c("apm", 2, 0, 4);
                } else if (ls.w().p()) {
                    b.d(new com.bytedance.c.c.b() { // from class: com.bytedance.sdk.openadsdk.t.c.3.1
                        @Override // com.bytedance.c.c.b
                        public void c(boolean z3) {
                            com.bytedance.sdk.component.utils.a.w("NPTHUtils", "result:" + z3);
                            a.c().c("apm", 0, 1, z3 ? 8 : 16);
                        }
                    });
                } else {
                    a.c().c("apm", 1, 1, 32);
                }
            }
        }, 5000L);
    }

    public static void sr(Context context, JSONObject jSONObject) {
        try {
            JSONArray c4 = s.c(context);
            if (c4 != null) {
                jSONObject.put("app_list", c4);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar, List<String> list) {
        if (srVar.c()) {
            list.add("android.permission.ACCESS_COARSE_LOCATION");
            list.add("android.permission.ACCESS_FINE_LOCATION");
        }
    }

    public static void c(JSONObject jSONObject, int i4) {
        com.bytedance.sdk.openadsdk.core.eq.xv c4 = sr.c(ls.getContext(), i4);
        if (c4 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", c4.f33369c);
                jSONObject2.put("longitude", c4.f33370w);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(StackTraceElement[] stackTraceElementArr) {
        if (k.sr().ia()) {
            return false;
        }
        String arrays = Arrays.toString(stackTraceElementArr);
        if (arrays.contains("com.bytedance.sdk.openadsdk") || arrays.contains("com.bytedance.sdk.component") || arrays.contains("com.bykv.vk") || arrays.contains("com.byted.csj.ext_impl") || arrays.contains("com.bytedance.adsdk") || arrays.contains("com.bytedance.msdk") || arrays.contains("com.bytedance.sdk.gromore") || arrays.contains("com.bytedance.sdk.openadsdk.mediation") || arrays.contains("bykvm")) {
            Map<String, String> w3 = com.bytedance.sdk.openadsdk.core.ux.c().w();
            if (w3 != null) {
                if (arrays.contains("com.bytedance.sdk.openadsdk.core.nativeexpress")) {
                    w3.put("express", "true");
                }
                if (arrays.contains(com.bytedance.sdk.openadsdk.core.live.c.class.getPackage().getName()) || arrays.contains("com.bytedance.sdk.openadsdk.live") || arrays.contains("com.bykv.vk.openvk.live")) {
                    w3.put("live_sdk", "true");
                }
                if (!arrays.contains("com.bytedance.msdk") && !arrays.contains("com.bytedance.sdk.gromore") && !arrays.contains("com.bytedance.sdk.openadsdk.mediation") && !arrays.contains("bykvm")) {
                    w3.put("mediation", "false");
                } else {
                    w3.put("mediation", "true");
                }
                b.g(com.bytedance.sdk.openadsdk.core.ux.c().w());
            }
            return true;
        }
        return false;
    }

    public static String c() {
        return !k.sr().ux().xv() ? "" : i.r();
    }

    public static void c(Context context) {
        sr.c(context);
    }

    public static boolean c(String str) {
        return s.c(str);
    }
}
