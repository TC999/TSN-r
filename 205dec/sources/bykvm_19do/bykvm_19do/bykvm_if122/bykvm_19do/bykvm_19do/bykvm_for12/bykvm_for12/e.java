package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TNCConfigHandler.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f732e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f733a;

    /* renamed from: b  reason: collision with root package name */
    private d f734b = new d();

    /* renamed from: c  reason: collision with root package name */
    private boolean f735c;

    /* renamed from: d  reason: collision with root package name */
    private int f736d;

    public e(Context context, boolean z3, int i4) {
        this.f733a = context;
        this.f735c = z3;
        this.f736d = i4;
    }

    public void a(JSONObject jSONObject) {
        if (!this.f735c) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        h.a().a(this.f736d).h();
        try {
            boolean z3 = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (h.a().a(this.f736d).g() && z3 && optJSONArray != null) {
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
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.b("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                optJSONObject.put("host_replace_map", jSONObject2);
            }
            d b4 = b(optJSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append("handleConfigChanged, newConfig: ");
            sb.append(b4 == null ? "null" : b4.toString());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", sb.toString());
            if (b4 == null) {
                synchronized (f732e) {
                    this.f733a.getSharedPreferences(h.a().a(this.f736d).f(), 0).edit().putString("tnc_config_str", "").apply();
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.f733a, 1, "", this.f736d);
                }
                return;
            }
            this.f734b = b4;
            String jSONObject5 = optJSONObject.toString();
            synchronized (f732e) {
                this.f733a.getSharedPreferences(h.a().a(this.f736d).f(), 0).edit().putString("tnc_config_str", jSONObject5).apply();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.f733a, 1, jSONObject5, this.f736d);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.f734b = new d();
                synchronized (f732e) {
                    this.f733a.getSharedPreferences(h.a().a(this.f736d).f(), 0).edit().putString("tnc_config_str", "").apply();
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.f733a, 1, "", this.f736d);
                }
            } catch (Throwable th2) {
                synchronized (f732e) {
                    this.f733a.getSharedPreferences(h.a().a(this.f736d).f(), 0).edit().putString("tnc_config_str", "").apply();
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.f733a, 1, "", this.f736d);
                    throw th2;
                }
            }
        }
    }

    public void b() {
        if (this.f735c) {
            String string = this.f733a.getSharedPreferences(h.a().a(this.f736d).f(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                d b4 = b(new JSONObject(string));
                if (b4 != null) {
                    this.f734b = b4;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(b4 == null ? "null" : b4.toString());
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    public void c() {
        try {
            String a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.f733a, 1, this.f736d);
            if (TextUtils.isEmpty(a4)) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            d b4 = b(new JSONObject(a4));
            StringBuilder sb = new StringBuilder();
            sb.append("loadLocalConfigForOtherProcess, config: ");
            sb.append(b4 == null ? "null" : b4.toString());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", sb.toString());
            if (b4 != null) {
                this.f734b = b4;
            }
        } catch (Throwable th) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    private d b(JSONObject jSONObject) {
        try {
            d dVar = new d();
            if (jSONObject.has("local_enable")) {
                dVar.f719a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                dVar.f720b = jSONObject.getInt("probe_enable") != 0;
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
                dVar.f721c = hashMap;
            } else {
                dVar.f721c = null;
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
                dVar.f722d = hashMap2;
            } else {
                dVar.f722d = null;
            }
            dVar.f723e = jSONObject.optInt("req_to_cnt", dVar.f723e);
            dVar.f724f = jSONObject.optInt("req_to_api_cnt", dVar.f724f);
            dVar.f725g = jSONObject.optInt("req_to_ip_cnt", dVar.f725g);
            dVar.f726h = jSONObject.optInt("req_err_cnt", dVar.f726h);
            dVar.f727i = jSONObject.optInt("req_err_api_cnt", dVar.f727i);
            dVar.f728j = jSONObject.optInt("req_err_ip_cnt", dVar.f728j);
            dVar.f729k = jSONObject.optInt("update_interval", dVar.f729k);
            dVar.f730l = jSONObject.optInt("update_random_range", dVar.f730l);
            dVar.f731m = jSONObject.optString("http_code_black", dVar.f731m);
            return dVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public d a() {
        return this.f734b;
    }
}
