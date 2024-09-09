package com.bytedance.sdk.openadsdk.core.xv;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.openadsdk.core.eq.gb;
import com.bytedance.sdk.openadsdk.core.eq.gd;
import com.bytedance.sdk.openadsdk.core.eq.ls;
import com.bytedance.sdk.openadsdk.core.eq.p;
import com.bytedance.sdk.openadsdk.core.eq.q;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static long f35600c = -1;
    private static volatile String sr;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f35601w;
    private static AtomicBoolean xv = new AtomicBoolean(false);

    public static boolean w() {
        if (f35601w) {
            return true;
        }
        if (f35600c == -1) {
            return false;
        }
        boolean z3 = SystemClock.elapsedRealtime() - f35600c > 60000;
        f35601w = z3;
        return z3;
    }

    public static String xv() {
        if (!TextUtils.isEmpty(sr)) {
            return sr;
        }
        sr = ux.c().ux((String) null);
        return sr;
    }

    public static void c() {
        if (f35600c > -1) {
            return;
        }
        f35600c = SystemClock.elapsedRealtime();
    }

    public static JSONObject c(Context context, int i4) {
        return sr.c().f(i4) ? w(context, i4) : c(context);
    }

    public static JSONObject c(Context context) {
        boolean z3;
        boolean z4;
        boolean z5;
        JSONObject jSONObject = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.ys.w.xv.sr ux = k.sr().ux();
            if (ux != null) {
                z4 = ux.xv();
                z5 = ux.sr();
                z3 = ux.c();
            } else {
                z3 = true;
                z4 = true;
                z5 = true;
            }
            jSONObject.put("imei", i.c(z4));
            jSONObject.put("android_id", i.ux());
            jSONObject.put("uuid", xv());
            jSONObject.put("ssid", i.c(z5, z3));
            jSONObject.put("wifi_mac", i.w(z5, z3));
            jSONObject.put("imsi", i.w(z4));
            jSONObject.put("boot", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + "");
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put("rom_version", ls.c());
            jSONObject.put("sys_compiling_time", i.sr());
            jSONObject.put("type", gd.c(context, false));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", i.u());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", gd.sr());
            jSONObject.put("mac", i.xv(z5));
            int[] xv2 = xk.xv(context);
            jSONObject.put("screen_width", xv2[0]);
            jSONObject.put("screen_height", xv2[1]);
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, com.bytedance.sdk.openadsdk.core.eq.i.c());
            jSONObject.put("free_space", p.f33287c);
            jSONObject.put("locale_language", gd.gd());
            jSONObject.put("screen_bright", Math.ceil(gd.p() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", gd.c() ? 0 : 1);
            jSONObject.put("cpu_num", wv.bk());
            jSONObject.put("cpu_max_freq", wv.t());
            jSONObject.put("cpu_min_freq", wv.ys());
            jSONObject.put("battery_remaining_pct", (int) gd.w.w());
            jSONObject.put("is_charging", gd.w.c());
            jSONObject.put("total_mem", String.valueOf(Long.parseLong(wv.k()) * 1024));
            jSONObject.put("total_space", String.valueOf(wv.c(context)));
            jSONObject.put("free_space_in", String.valueOf(wv.w(context)));
            jSONObject.put("sdcard_size", String.valueOf(wv.xv(context)));
            jSONObject.put("rooted", wv.sr(context));
            jSONObject.put("enable_assisted_clicking", gd.k());
            jSONObject.put("mnc", i.ia());
            jSONObject.put("mcc", i.ys());
            jSONObject.put("mnc_2", i.s());
            jSONObject.put("mcc_2", i.fp());
            jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.core.r.c.c(context));
            jSONObject.put("is_app_log_con", com.bytedance.sdk.component.r.w.xv.c.c());
            jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.r.c().w());
            jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.c.c.c.w());
            long bk = gd.bk();
            if (bk != -1) {
                jSONObject.put("client_global_did", bk);
            }
            jSONObject.put("sys_vol", gd.t());
            String gd = q.gd();
            if (gd != null) {
                jSONObject.put("ud", gd);
            }
            gd.c(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x0381 A[Catch: all -> 0x039e, TryCatch #0 {all -> 0x039e, blocks: (B:3:0x0005, B:6:0x0017, B:8:0x0021, B:11:0x0028, B:18:0x0041, B:20:0x004b, B:23:0x0052, B:28:0x0067, B:31:0x0074, B:33:0x007e, B:36:0x0085, B:41:0x009a, B:44:0x00a6, B:48:0x00b9, B:50:0x00c3, B:53:0x00ca, B:58:0x00df, B:61:0x017b, B:63:0x0185, B:66:0x018c, B:71:0x01a1, B:74:0x01eb, B:76:0x026b, B:79:0x0278, B:81:0x0282, B:84:0x0289, B:92:0x02a3, B:94:0x02ad, B:97:0x02b4, B:105:0x02ce, B:107:0x02d8, B:110:0x02df, B:118:0x02f9, B:120:0x0303, B:124:0x030b, B:132:0x0325, B:134:0x032f, B:139:0x0344, B:142:0x0351, B:144:0x035f, B:146:0x036e, B:148:0x0381, B:149:0x0386, B:151:0x0395, B:152:0x039a, B:145:0x0363, B:135:0x0333, B:138:0x0341, B:125:0x030f, B:129:0x031e, B:111:0x02e3, B:115:0x02f2, B:98:0x02b8, B:102:0x02c7, B:85:0x028d, B:89:0x029c, B:67:0x0190, B:70:0x019e, B:54:0x00ce, B:57:0x00dc, B:45:0x00ae, B:37:0x0089, B:40:0x0097, B:24:0x0056, B:27:0x0064, B:12:0x002c, B:15:0x003a), top: B:157:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0395 A[Catch: all -> 0x039e, TryCatch #0 {all -> 0x039e, blocks: (B:3:0x0005, B:6:0x0017, B:8:0x0021, B:11:0x0028, B:18:0x0041, B:20:0x004b, B:23:0x0052, B:28:0x0067, B:31:0x0074, B:33:0x007e, B:36:0x0085, B:41:0x009a, B:44:0x00a6, B:48:0x00b9, B:50:0x00c3, B:53:0x00ca, B:58:0x00df, B:61:0x017b, B:63:0x0185, B:66:0x018c, B:71:0x01a1, B:74:0x01eb, B:76:0x026b, B:79:0x0278, B:81:0x0282, B:84:0x0289, B:92:0x02a3, B:94:0x02ad, B:97:0x02b4, B:105:0x02ce, B:107:0x02d8, B:110:0x02df, B:118:0x02f9, B:120:0x0303, B:124:0x030b, B:132:0x0325, B:134:0x032f, B:139:0x0344, B:142:0x0351, B:144:0x035f, B:146:0x036e, B:148:0x0381, B:149:0x0386, B:151:0x0395, B:152:0x039a, B:145:0x0363, B:135:0x0333, B:138:0x0341, B:125:0x030f, B:129:0x031e, B:111:0x02e3, B:115:0x02f2, B:98:0x02b8, B:102:0x02c7, B:85:0x028d, B:89:0x029c, B:67:0x0190, B:70:0x019e, B:54:0x00ce, B:57:0x00dc, B:45:0x00ae, B:37:0x0089, B:40:0x0097, B:24:0x0056, B:27:0x0064, B:12:0x002c, B:15:0x003a), top: B:157:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject w(android.content.Context r12, int r13) {
        /*
            Method dump skipped, instructions count: 931
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.xv.c.w(android.content.Context, int):org.json.JSONObject");
    }

    public static void c(JSONObject jSONObject, int i4) throws JSONException {
        if (!sr.c().f(i4)) {
            w(jSONObject);
            return;
        }
        JSONArray u3 = ux.c().u();
        if (u3 != null) {
            if (u3.length() > 0) {
                jSONObject.put("scheme_success_list", u3);
            }
            if (xv.get()) {
                return;
            }
            xv.set(true);
            ev.w(new com.bytedance.sdk.component.gd.p("tt-scheme") { // from class: com.bytedance.sdk.openadsdk.core.xv.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.w(null);
                    } catch (Exception unused) {
                    }
                    c.xv.set(false);
                }
            });
            return;
        }
        w(jSONObject);
    }

    public static String[] c(int i4) {
        try {
            if (sr.c().f(i4)) {
                return gd.c(!w());
            }
            return gd.f();
        } catch (Exception unused) {
            return new String[]{"", ""};
        }
    }

    public static String c(String str, int i4) {
        if (!sr.c().f(i4)) {
            str = null;
        }
        return gd.c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(JSONObject jSONObject) throws JSONException {
        List<String> qy = com.bytedance.sdk.openadsdk.core.ls.w().qy();
        if (qy == null || qy.size() <= 0) {
            return;
        }
        Map<String, Boolean> c4 = gb.c(259200000L);
        final JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, Boolean> entry : c4.entrySet()) {
            String key = entry.getKey();
            if (qy.contains(key)) {
                String scheme = Uri.parse(key).getScheme();
                if (entry.getValue().booleanValue()) {
                    jSONArray.put(scheme);
                } else {
                    jSONArray2.put(scheme);
                }
            }
        }
        if (jSONObject != null && jSONArray.length() > 0) {
            jSONObject.put("scheme_success_list", jSONArray);
        }
        if (jSONObject != null && jSONArray2.length() > 0) {
            jSONObject.put("scheme_fail_list", jSONArray2);
        }
        if (jSONObject == null) {
            ux.c().c(jSONArray);
        } else {
            ev.w(new com.bytedance.sdk.component.gd.p("tt-scheme-save") { // from class: com.bytedance.sdk.openadsdk.core.xv.c.2
                @Override // java.lang.Runnable
                public void run() {
                    ux.c().c(jSONArray);
                }
            });
        }
    }
}
