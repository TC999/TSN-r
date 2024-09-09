package com.bytedance.sdk.openadsdk.core.gb.c;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.ev.w.sr;
import com.bytedance.sdk.component.ev.w.xv;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.ux;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.i;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.r;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends p {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.gb.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0494c {

        /* renamed from: c  reason: collision with root package name */
        private static final c f33692c = new c();
    }

    private JSONObject sr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, i.c());
            jSONObject.put("conn_type", ys.w(ls.getContext()));
            int i4 = 1;
            jSONObject.put("os", 1);
            int i5 = Build.VERSION.SDK_INT;
            jSONObject.put("os_api", i5);
            jSONObject.put("sdk_version", eq.xv);
            jSONObject.put("plugin_version", "6.1.0.6");
            jSONObject.put("package_name", wv.ev());
            jSONObject.put("app_version", wv.p());
            jSONObject.put("app_code", wv.gd());
            jSONObject.put("vendor", Build.MANUFACTURER);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String ev = k.sr().ev();
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("app_id", ev);
            jSONObject.put("req_sign", ux.w(ev != null ? ev.concat(String.valueOf(currentTimeMillis)).concat(eq.xv) : ""));
            jSONObject.put("channel", eq.f33188f);
            jSONObject.put("applog_did", r.c().w());
            jSONObject.put("imei", com.bytedance.sdk.openadsdk.core.i.f());
            jSONObject.put("source", 1);
            if (i5 >= 21) {
                jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            }
            jSONObject.put("plugins", ux());
            if (!k.sr().j()) {
                i4 = 0;
            }
            jSONObject.put("csj_type", i4);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject ux() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject fz = k.sr().fz();
        boolean zg = ls.w().zg();
        if (fz != null) {
            Iterator<String> keys = fz.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    JSONObject optJSONObject = fz.optJSONObject(next);
                    if (optJSONObject != null) {
                        optJSONObject.put("plugin_update_network", k.sr().a().c(next));
                    }
                    if (zg && next.equals("com.byted.live.lite")) {
                        jSONObject.putOpt(w.w(), optJSONObject);
                    } else {
                        jSONObject.putOpt(next, optJSONObject);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static c w() {
        return C0494c.f33692c;
    }

    @Override // java.lang.Runnable
    public void run() {
        sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
        w3.c(wv.r("/api/ad/union/sdk/settings/plugins"));
        w3.w("User-Agent", wv.f());
        w3.c(com.bytedance.sdk.component.utils.c.c(sr()));
        w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.gb.c.c.1
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                if (wVar == null || !wVar.ev() || TextUtils.isEmpty(wVar.sr())) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(wVar.sr());
                    if (jSONObject.optInt("cypher") == 3) {
                        String xv = com.bytedance.sdk.component.utils.c.xv(jSONObject.optString("message"));
                        if (TextUtils.isEmpty(xv)) {
                            return;
                        }
                        w.c().c(new JSONObject(xv).optJSONArray("plugins"));
                    }
                } catch (JSONException unused) {
                }
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(xv xvVar, IOException iOException) {
                try {
                    Iterator<String> keys = k.sr().fz().keys();
                    while (keys.hasNext()) {
                        w.c().c(keys.next(), 1007);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void xv() {
        if (ys.c(ls.getContext())) {
            ev.w(this);
        }
    }

    private c() {
        super("PluginSettingsFetchTask");
    }
}
