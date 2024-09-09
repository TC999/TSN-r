package com.bytedance.sdk.component.ev.xv;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    private static final Object sr = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Context f29766c;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private xv f29767w = new xv();
    private boolean xv;

    public sr(Context context, boolean z3, int i4) {
        this.f29766c = context;
        this.xv = z3;
        this.ux = i4;
    }

    public void c(JSONObject jSONObject) {
        if (!this.xv) {
            com.bytedance.sdk.component.ev.sr.xv.xv("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        r.c().c(this.ux).ux();
        try {
            boolean z3 = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (r.c().c(this.ux).xv() && z3 && optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject jSONObject3 = ((JSONObject) optJSONArray.get(i4)).getJSONObject("param");
                    if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    jSONObject2 = new JSONObject();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        JSONObject jSONObject4 = (JSONObject) it.next();
                        Iterator<String> keys = jSONObject4.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, jSONObject4.getString(next));
                        }
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tnc_config");
            if (optJSONObject == null && jSONObject2 == null) {
                com.bytedance.sdk.component.ev.sr.xv.c("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                optJSONObject.put("host_replace_map", jSONObject2);
            }
            xv w3 = w(optJSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append("handleConfigChanged, newConfig: ");
            sb.append(w3 == null ? "null" : w3.toString());
            com.bytedance.sdk.component.ev.sr.xv.xv("TNCConfigHandler", sb.toString());
            if (w3 == null) {
                synchronized (sr) {
                    com.bytedance.sdk.openadsdk.api.plugin.w.w(this.f29766c, r.c().c(this.ux).c(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.ev.sr.sr.c(this.f29766c, 1, "", this.ux);
                }
                return;
            }
            this.f29767w = w3;
            String jSONObject5 = optJSONObject.toString();
            synchronized (sr) {
                com.bytedance.sdk.openadsdk.api.plugin.w.w(this.f29766c, r.c().c(this.ux).c(), 0).edit().putString("tnc_config_str", jSONObject5).apply();
                com.bytedance.sdk.component.ev.sr.sr.c(this.f29766c, 1, jSONObject5, this.ux);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.f29767w = new xv();
                synchronized (sr) {
                    com.bytedance.sdk.openadsdk.api.plugin.w.w(this.f29766c, r.c().c(this.ux).c(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.ev.sr.sr.c(this.f29766c, 1, "", this.ux);
                }
            } catch (Throwable th2) {
                synchronized (sr) {
                    com.bytedance.sdk.openadsdk.api.plugin.w.w(this.f29766c, r.c().c(this.ux).c(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.ev.sr.sr.c(this.f29766c, 1, "", this.ux);
                    throw th2;
                }
            }
        }
    }

    public void w() {
        try {
            String c4 = com.bytedance.sdk.component.ev.sr.sr.c(this.f29766c, 1, this.ux);
            if (TextUtils.isEmpty(c4)) {
                com.bytedance.sdk.component.ev.sr.xv.xv("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            xv w3 = w(new JSONObject(c4));
            StringBuilder sb = new StringBuilder();
            sb.append("loadLocalConfigForOtherProcess, config: ");
            sb.append(w3 == null ? "null" : w3.toString());
            com.bytedance.sdk.component.ev.sr.xv.xv("TNCConfigHandler", sb.toString());
            if (w3 != null) {
                this.f29767w = w3;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.ev.sr.xv.xv("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public xv xv() {
        return this.f29767w;
    }

    private xv w(JSONObject jSONObject) {
        try {
            xv xvVar = new xv();
            if (jSONObject.has("local_enable")) {
                xvVar.f29779c = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                xvVar.f29785w = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        String string = jSONArray.getString(i4);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                xvVar.xv = hashMap;
            } else {
                xvVar.xv = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap hashMap2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            hashMap2.put(next, string2);
                        }
                    }
                }
                xvVar.sr = hashMap2;
            } else {
                xvVar.sr = null;
            }
            xvVar.ux = jSONObject.optInt("req_to_cnt", xvVar.ux);
            xvVar.f29780f = jSONObject.optInt("req_to_api_cnt", xvVar.f29780f);
            xvVar.f29783r = jSONObject.optInt("req_to_ip_cnt", xvVar.f29783r);
            xvVar.ev = jSONObject.optInt("req_err_cnt", xvVar.ev);
            xvVar.gd = jSONObject.optInt("req_err_api_cnt", xvVar.gd);
            xvVar.f29782p = jSONObject.optInt("req_err_ip_cnt", xvVar.f29782p);
            xvVar.f29781k = jSONObject.optInt("update_interval", xvVar.f29781k);
            xvVar.f29778a = jSONObject.optInt("update_random_range", xvVar.f29778a);
            xvVar.bk = jSONObject.optString("http_code_black", xvVar.bk);
            return xvVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void c() {
        if (this.xv) {
            String string = com.bytedance.sdk.openadsdk.api.plugin.w.w(this.f29766c, r.c().c(this.ux).c(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.component.ev.sr.xv.xv("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                xv w3 = w(new JSONObject(string));
                if (w3 != null) {
                    this.f29767w = w3;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(w3 == null ? "null" : w3.toString());
                com.bytedance.sdk.component.ev.sr.xv.xv("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.component.ev.sr.xv.xv("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }
}
