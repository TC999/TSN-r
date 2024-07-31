package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.C1003b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.MultiProcessFileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TNCConfigHandler {

    /* renamed from: e */
    private static final Object f739e = new Object();

    /* renamed from: a */
    private Context f740a;

    /* renamed from: b */
    private TNCConfig f741b = new TNCConfig();

    /* renamed from: c */
    private boolean f742c;

    /* renamed from: d */
    private int f743d;

    public TNCConfigHandler(Context context, boolean z, int i) {
        this.f740a = context;
        this.f742c = z;
        this.f743d = i;
    }

    /* renamed from: a */
    public void m59037a(JSONObject jSONObject) {
        if (!this.f742c) {
            C1003b.m58992a("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        TncInstanceManager.m59006a().m59005a(this.f743d).m59010h();
        try {
            boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (TncInstanceManager.m59006a().m59005a(this.f743d).m59011g() && z && optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = ((JSONObject) optJSONArray.get(i)).getJSONObject("param");
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
                C1003b.m58991b("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                optJSONObject.put("host_replace_map", jSONObject2);
            }
            TNCConfig m59035b = m59035b(optJSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append("handleConfigChanged, newConfig: ");
            sb.append(m59035b == null ? "null" : m59035b.toString());
            C1003b.m58992a("TNCConfigHandler", sb.toString());
            if (m59035b == null) {
                synchronized (f739e) {
                    this.f740a.getSharedPreferences(TncInstanceManager.m59006a().m59005a(this.f743d).m59012f(), 0).edit().putString("tnc_config_str", "").apply();
                    MultiProcessFileUtils.m58985a(this.f740a, 1, "", this.f743d);
                }
                return;
            }
            this.f741b = m59035b;
            String jSONObject5 = optJSONObject.toString();
            synchronized (f739e) {
                this.f740a.getSharedPreferences(TncInstanceManager.m59006a().m59005a(this.f743d).m59012f(), 0).edit().putString("tnc_config_str", jSONObject5).apply();
                MultiProcessFileUtils.m58985a(this.f740a, 1, jSONObject5, this.f743d);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.f741b = new TNCConfig();
                synchronized (f739e) {
                    this.f740a.getSharedPreferences(TncInstanceManager.m59006a().m59005a(this.f743d).m59012f(), 0).edit().putString("tnc_config_str", "").apply();
                    MultiProcessFileUtils.m58985a(this.f740a, 1, "", this.f743d);
                }
            } catch (Throwable th2) {
                synchronized (f739e) {
                    this.f740a.getSharedPreferences(TncInstanceManager.m59006a().m59005a(this.f743d).m59012f(), 0).edit().putString("tnc_config_str", "").apply();
                    MultiProcessFileUtils.m58985a(this.f740a, 1, "", this.f743d);
                    throw th2;
                }
            }
        }
    }

    /* renamed from: b */
    public void m59036b() {
        if (this.f742c) {
            String string = this.f740a.getSharedPreferences(TncInstanceManager.m59006a().m59005a(this.f743d).m59012f(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                C1003b.m58992a("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                TNCConfig m59035b = m59035b(new JSONObject(string));
                if (m59035b != null) {
                    this.f741b = m59035b;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(m59035b == null ? "null" : m59035b.toString());
                C1003b.m58992a("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                C1003b.m58992a("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    /* renamed from: c */
    public void m59034c() {
        try {
            String m58986a = MultiProcessFileUtils.m58986a(this.f740a, 1, this.f743d);
            if (TextUtils.isEmpty(m58986a)) {
                C1003b.m58992a("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            TNCConfig m59035b = m59035b(new JSONObject(m58986a));
            StringBuilder sb = new StringBuilder();
            sb.append("loadLocalConfigForOtherProcess, config: ");
            sb.append(m59035b == null ? "null" : m59035b.toString());
            C1003b.m58992a("TNCConfigHandler", sb.toString());
            if (m59035b != null) {
                this.f741b = m59035b;
            }
        } catch (Throwable th) {
            C1003b.m58992a("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    /* renamed from: b */
    private TNCConfig m59035b(JSONObject jSONObject) {
        try {
            TNCConfig tNCConfig = new TNCConfig();
            if (jSONObject.has("local_enable")) {
                tNCConfig.f726a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                tNCConfig.f727b = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                tNCConfig.f728c = hashMap;
            } else {
                tNCConfig.f728c = null;
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
                tNCConfig.f729d = hashMap2;
            } else {
                tNCConfig.f729d = null;
            }
            tNCConfig.f730e = jSONObject.optInt("req_to_cnt", tNCConfig.f730e);
            tNCConfig.f731f = jSONObject.optInt("req_to_api_cnt", tNCConfig.f731f);
            tNCConfig.f732g = jSONObject.optInt("req_to_ip_cnt", tNCConfig.f732g);
            tNCConfig.f733h = jSONObject.optInt("req_err_cnt", tNCConfig.f733h);
            tNCConfig.f734i = jSONObject.optInt("req_err_api_cnt", tNCConfig.f734i);
            tNCConfig.f735j = jSONObject.optInt("req_err_ip_cnt", tNCConfig.f735j);
            tNCConfig.f736k = jSONObject.optInt("update_interval", tNCConfig.f736k);
            tNCConfig.f737l = jSONObject.optInt("update_random_range", tNCConfig.f737l);
            tNCConfig.f738m = jSONObject.optString("http_code_black", tNCConfig.f738m);
            return tNCConfig;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public TNCConfig m59038a() {
        return this.f741b;
    }
}
