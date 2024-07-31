package com.kwad.sdk.core.webview.p418b.p421c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p418b.C10606a;
import com.kwad.sdk.p435h.p436a.C10772b;
import com.kwad.sdk.utils.C11126t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.b.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10621b {
    public static final Map<String, JSONObject> aEz = new HashMap();
    public static boolean aEA = true;

    /* renamed from: com.kwad.sdk.core.webview.b.c.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10622a {
        public String msg;
    }

    /* renamed from: a */
    public static void m25266a(C10772b c10772b, int i) {
        C9815b.m27691a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(c10772b.aHX).setH5Version(c10772b.version).setLoadType(c10772b.loadType).setState(i).setPackageUrl(c10772b.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - c10772b.m24880Iu())));
    }

    /* renamed from: ae */
    public static void m25261ae(String str, String str2) {
        JSONObject m25256eU = m25256eU(str);
        C11126t.putValue(m25256eU, "c_" + str2, System.currentTimeMillis());
    }

    /* renamed from: af */
    private static void m25260af(String str, String str2) {
        m25264a(str, str2, 1, "");
    }

    /* renamed from: ag */
    public static void m25259ag(String str, String str2) {
        m25264a(str, "", 2, str2);
    }

    /* renamed from: c */
    public static void m25258c(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        JSONObject m25256eU = m25256eU(str);
        C11126t.putValue(m25256eU, "c_responseStart_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    /* renamed from: d */
    public static void m25257d(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        JSONObject m25256eU = m25256eU(str);
        C11126t.putValue(m25256eU, "c_responseEnd_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    /* renamed from: eU */
    private static JSONObject m25256eU(String str) {
        Map<String, JSONObject> map = aEz;
        JSONObject jSONObject = map.get(str);
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            map.put(str, jSONObject2);
            return jSONObject2;
        }
        return jSONObject;
    }

    /* renamed from: eV */
    private static void m25255eV(String str) {
        aEz.remove(str);
    }

    /* renamed from: eW */
    public static void m25254eW(String str) {
        JSONObject m25256eU = m25256eU(str);
        long m25319GW = C10606a.m25320GV().m25319GW();
        long currentTimeMillis = m25319GW <= 0 ? -1L : System.currentTimeMillis() - m25319GW;
        C11126t.putValue(m25256eU, "c_loadUrl", System.currentTimeMillis());
        C11126t.putValue(m25256eU, "c_init_interval", currentTimeMillis);
        C11126t.putValue(m25256eU, "c_init_state", aEA ? 1 : 2);
        aEA = false;
    }

    /* renamed from: a */
    public static void m25265a(C10772b c10772b, int i, int i2, String str) {
        C9815b.m27691a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(c10772b.aHX).setH5Version(c10772b.version).setLoadType(c10772b.loadType).setState(0).setPackageUrl(c10772b.packageUrl).setFailState(i2).setInterval(String.valueOf(System.currentTimeMillis() - c10772b.m24880Iu())).setFailReason(str));
    }

    /* renamed from: a */
    public static void m25263a(String str, String str2, int i, String str3, long j) {
        C9815b.m27678b(i == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i).setInterval(String.valueOf((j > 60000 || j < 0) ? -1L : -1L)).setFailReason(str3));
    }

    /* renamed from: a */
    public static void m25262a(String str, String str2, String str3, String str4) {
        JSONObject m25256eU = m25256eU(str2);
        C11126t.putValue(m25256eU, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str4);
                int optInt = jSONObject.optInt("status");
                String optString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG, "");
                String optString2 = jSONObject.optString("webViewCostParams", "");
                if (!TextUtils.isEmpty(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        m25256eU.put(next, jSONObject2.opt(next));
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (optInt == 1) {
                        m25260af(str, str2);
                    } else {
                        m25259ag(str, optString);
                    }
                }
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            } finally {
                m25255eV(str2);
            }
        }
    }

    /* renamed from: a */
    private static void m25264a(String str, String str2, int i, String str3) {
        long currentTimeMillis;
        JSONObject jSONObject = aEz.get(str2);
        if (jSONObject == null) {
            currentTimeMillis = -3;
        } else {
            long optLong = jSONObject.optLong("c_loadUrl");
            if (optLong <= 0) {
                currentTimeMillis = -2;
            } else {
                currentTimeMillis = System.currentTimeMillis() - optLong;
                if (currentTimeMillis > 100000 || currentTimeMillis < 0) {
                    currentTimeMillis = -1;
                }
            }
        }
        C9815b.m27689a(i == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new WebViewLoadMsg().setUrl(str).setState(i).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
        m25255eV(str2);
    }
}
