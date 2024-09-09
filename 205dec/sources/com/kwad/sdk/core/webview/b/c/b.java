package com.kwad.sdk.core.webview.b.c;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static final Map<String, JSONObject> aEz = new HashMap();
    public static boolean aEA = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        public String msg;
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i4) {
        com.kwad.sdk.commercial.b.a("ad_client_apm_log", new HybridLoadMsg().setSceneId(bVar.aHX).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i4).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Iu())));
    }

    public static void ae(String str, String str2) {
        JSONObject eU = eU(str);
        t.putValue(eU, "c_" + str2, System.currentTimeMillis());
    }

    private static void af(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void ag(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void c(String str, String str2, String str3) {
        if (str3.contains(TTPathConst.sSeparator)) {
            str3 = str3.substring(str3.lastIndexOf(TTPathConst.sSeparator) + 1);
        }
        JSONObject eU = eU(str);
        t.putValue(eU, "c_responseStart_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    public static void d(String str, String str2, String str3) {
        if (str3.contains(TTPathConst.sSeparator)) {
            str3 = str3.substring(str3.lastIndexOf(TTPathConst.sSeparator) + 1);
        }
        JSONObject eU = eU(str);
        t.putValue(eU, "c_responseEnd_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    private static JSONObject eU(String str) {
        Map<String, JSONObject> map = aEz;
        JSONObject jSONObject = map.get(str);
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            map.put(str, jSONObject2);
            return jSONObject2;
        }
        return jSONObject;
    }

    private static void eV(String str) {
        aEz.remove(str);
    }

    public static void eW(String str) {
        JSONObject eU = eU(str);
        long GW = com.kwad.sdk.core.webview.b.a.GV().GW();
        long currentTimeMillis = GW <= 0 ? -1L : System.currentTimeMillis() - GW;
        t.putValue(eU, "c_loadUrl", System.currentTimeMillis());
        t.putValue(eU, "c_init_interval", currentTimeMillis);
        t.putValue(eU, "c_init_state", aEA ? 1 : 2);
        aEA = false;
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i4, int i5, String str) {
        com.kwad.sdk.commercial.b.a("ad_client_error_log", new HybridLoadMsg().setSceneId(bVar.aHX).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i5).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Iu())).setFailReason(str));
    }

    public static void a(String str, String str2, int i4, String str3, long j4) {
        com.kwad.sdk.commercial.b.b(i4 == 2 ? "ad_client_error_log" : "ad_client_apm_log", new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i4).setInterval(String.valueOf((j4 > 60000 || j4 < 0) ? -1L : -1L)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject eU = eU(str2);
        t.putValue(eU, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str4);
                int optInt = jSONObject.optInt("status");
                String optString = jSONObject.optString("errorMsg", "");
                String optString2 = jSONObject.optString("webViewCostParams", "");
                if (!TextUtils.isEmpty(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        eU.put(next, jSONObject2.opt(next));
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (optInt == 1) {
                        af(str, str2);
                    } else {
                        ag(str, optString);
                    }
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            } finally {
                eV(str2);
            }
        }
    }

    private static void a(String str, String str2, int i4, String str3) {
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
        com.kwad.sdk.commercial.b.a(i4 == 2 ? "ad_client_error_log" : "ad_client_apm_log", new WebViewLoadMsg().setUrl(str).setState(i4).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
        eV(str2);
    }
}
