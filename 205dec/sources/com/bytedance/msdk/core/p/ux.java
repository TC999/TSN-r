package com.bytedance.msdk.core.p;

import android.text.TextUtils;
import com.bytedance.msdk.core.ux.w.ev;
import com.bytedance.msdk.f.bw;
import com.bytedance.msdk.f.wv;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends c {
    private static volatile ux ux;
    private final Map<String, double[]> sr;
    protected final Map<String, String> xv;

    private ux() {
        super("label_v_v_s");
        this.xv = new ConcurrentHashMap();
        this.sr = new ConcurrentHashMap();
        w();
    }

    public static ux sr() {
        if (ux == null) {
            synchronized (ux.class) {
                if (ux == null) {
                    ux = new ux();
                }
            }
        }
        return ux;
    }

    public static String ux() {
        if (com.bytedance.msdk.core.c.w().gw()) {
            Set<Map.Entry<String, com.bytedance.msdk.core.k.sr>> entrySet = com.bytedance.msdk.core.c.w().bw().entrySet();
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, com.bytedance.msdk.core.k.sr> entry : entrySet) {
                String key = entry.getKey();
                com.bytedance.msdk.core.k.sr value = entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("label_name", value.c());
                    jSONObject2.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, value.w());
                    jSONObject2.putOpt("lower_bound", Double.valueOf(value.f()));
                    jSONObject2.putOpt("upper_bound", Double.valueOf(value.ux()));
                    jSONObject.putOpt(c.c(Integer.parseInt(key)), jSONObject2);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return null;
    }

    public static String xv(int i4) {
        com.bytedance.msdk.core.k.sr srVar;
        if (com.bytedance.msdk.core.c.w().gw() && (srVar = com.bytedance.msdk.core.c.w().bw().get(String.valueOf(i4))) != null) {
            return srVar.c();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i4, double d4) {
        if (com.bytedance.msdk.core.c.w().gw()) {
            c(2, String.valueOf(i4), 1, d4);
        }
    }

    public Map<String, JSONObject> w(int i4) {
        if (!com.bytedance.msdk.core.c.w().gw()) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        for (Map.Entry<String, double[]> entry : (i4 == 2 ? this.sr : w(this.xv)).entrySet()) {
            String key = entry.getKey();
            double[] value = entry.getValue();
            try {
                if (!TextUtils.isEmpty(key)) {
                    Map<String, JSONObject> c4 = c(key, value);
                    JSONObject jSONObject3 = c4.get("config_req_label_value");
                    JSONObject jSONObject4 = c4.get("event_label_value");
                    if (jSONObject4 != null) {
                        jSONObject.putOpt(key, jSONObject4);
                    }
                    if (jSONObject3 != null) {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        jSONObject2.putOpt(key, jSONObject3);
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        hashMap.put("event_label_value_root", jSONObject);
        if (jSONObject2 != null) {
            hashMap.put("config_req_label_value_root", jSONObject2);
        }
        sr(i4);
        return hashMap;
    }

    private Map<String, JSONObject> c(String str, double[] dArr) {
        JSONObject jSONObject;
        JSONException e4;
        HashMap hashMap = new HashMap();
        String c4 = c(dArr);
        JSONObject jSONObject2 = null;
        try {
        } catch (JSONException e5) {
            jSONObject = null;
            e4 = e5;
        }
        if (!c4.equals("-1")) {
            jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("input", w(c4));
                jSONObject.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            } catch (JSONException e6) {
                e4 = e6;
                e4.printStackTrace();
                jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("ecpm", c4);
                jSONObject4.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
                jSONObject3.putOpt("ecpm_info", jSONObject4);
                hashMap.put("config_req_label_value", jSONObject2);
                hashMap.put("event_label_value", jSONObject3);
                return hashMap;
            }
            jSONObject2 = jSONObject;
        }
        JSONObject jSONObject32 = new JSONObject();
        JSONObject jSONObject42 = new JSONObject();
        try {
            jSONObject42.putOpt("ecpm", c4);
            jSONObject42.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject32.putOpt("ecpm_info", jSONObject42);
        } catch (JSONException e7) {
            e7.printStackTrace();
        }
        hashMap.put("config_req_label_value", jSONObject2);
        hashMap.put("event_label_value", jSONObject32);
        return hashMap;
    }

    private void sr(int i4) {
        if (i4 == 2) {
            this.sr.clear();
            return;
        }
        this.xv.clear();
        wv wvVar = this.f28089w;
        if (wvVar != null) {
            wvVar.xv();
        }
    }

    public void c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (com.bytedance.msdk.core.c.w().gw() && jSONObject2 != null) {
            try {
                jSONObject.putOpt("label_inputs", jSONObject2);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    private Map<String, double[]> w(Map<String, String> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (map != null && map.size() != 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(value)) {
                        String[] split = value.split("_");
                        String str = split[0];
                        String str2 = split[1];
                        String str3 = split[2];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            if (com.bytedance.msdk.core.c.w().c(System.currentTimeMillis() - Long.parseLong(split[2]))) {
                                double[] dArr = (double[]) concurrentHashMap.get(str);
                                if (dArr == null) {
                                    dArr = new double[2];
                                }
                                dArr[0] = dArr[0] + 1.0d;
                                dArr[1] = dArr[1] + Double.parseDouble(str2);
                                concurrentHashMap.put(str, dArr);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return concurrentHashMap;
    }

    public void c(JSONObject jSONObject) {
        if (com.bytedance.msdk.core.c.w().gw()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, com.bytedance.msdk.core.k.sr> entry : com.bytedance.msdk.core.c.w().bw().entrySet()) {
                String key = entry.getKey();
                com.bytedance.msdk.core.k.sr value = entry.getValue();
                if (value != null) {
                    try {
                        jSONObject2.putOpt(key, c(value));
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject2.length();
            }
            try {
                jSONObject.putOpt("last_label_outputs", jSONObject2);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z3, com.bytedance.msdk.xv.sr srVar, JSONObject jSONObject, Map<String, Object> map) {
        srVar.c("reason", Integer.valueOf(!z3 ? 1 : 0));
        if (map != null) {
            w(jSONObject);
            if (jSONObject != null) {
                map.put("label", jSONObject);
            }
        }
    }

    @Override // com.bytedance.msdk.core.p.c
    protected JSONObject c(com.bytedance.msdk.core.k.sr srVar) {
        if (srVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("label_name", srVar.c());
                jSONObject.putOpt("label_id", Integer.valueOf(srVar.xv()));
                jSONObject.putOpt("label_version", srVar.sr());
                jSONObject.putOpt("upper_bound", Double.valueOf(srVar.ux()));
                jSONObject.putOpt("lower_bound", Double.valueOf(srVar.f()));
                jSONObject.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, srVar.w());
                return jSONObject;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private void w(JSONObject jSONObject) {
        Map<String, com.bytedance.msdk.core.k.sr> bw = com.bytedance.msdk.core.c.w().bw();
        if (bw.size() > 0 && jSONObject == null) {
            jSONObject = new JSONObject();
        }
        for (Map.Entry<String, com.bytedance.msdk.core.k.sr> entry : bw.entrySet()) {
            String key = entry.getKey();
            com.bytedance.msdk.core.k.sr value = entry.getValue();
            if (value != null) {
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject(String.valueOf(key));
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(key), optJSONObject);
                        optJSONObject.put("ecpm_info", new JSONObject());
                    }
                    optJSONObject.putOpt("label_info", c(value));
                    optJSONObject.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.c.w().vc()));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void c(Map<String, ConcurrentHashMap<String, List<ev>>> map) {
        int i4;
        ConcurrentHashMap<String, List<ev>> value;
        if (com.bytedance.msdk.core.c.w().gw() && map != null && map.size() > 0) {
            for (Map.Entry<String, ConcurrentHashMap<String, List<ev>>> entry : map.entrySet()) {
                String key = entry.getKey();
                ConcurrentHashMap<String, List<ev>> value2 = entry.getValue();
                if (value2 != null) {
                    for (Map.Entry<String, List<ev>> entry2 : value2.entrySet()) {
                        List<ev> value3 = entry2.getValue();
                        if (value3 != null && value3.size() > 0 && value3.get(0) != null && value3.get(0).f28224c != null) {
                            i4 = value3.get(0).f28224c.getAdType();
                            break;
                        }
                    }
                }
                i4 = 0;
                com.bytedance.msdk.core.k.w c4 = com.bytedance.msdk.ux.c.c.p().c(key, i4, 101);
                if (c4 != null && c4.f() == 1 && (value = entry.getValue()) != null) {
                    for (Map.Entry<String, List<ev>> entry3 : value.entrySet()) {
                        List<ev> value4 = entry3.getValue();
                        if (value4 != null && value4.size() > 0 && value4.get(0) != null && value4.get(0).f28224c != null) {
                            bw.c(value4);
                            ev evVar = value4.get(0);
                            w(evVar.f28224c.getAdType(), evVar.f28224c.getCpm());
                        }
                    }
                }
            }
            com.bytedance.msdk.core.fp.w.c(com.bytedance.msdk.core.c.w()).c(2);
        }
    }

    @Override // com.bytedance.msdk.core.p.c
    protected boolean w(String str, JSONObject jSONObject, Map<String, Object> map) {
        com.bytedance.msdk.core.k.sr srVar = com.bytedance.msdk.core.c.w().bw().get(str);
        if (srVar != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(str, jSONObject2);
                jSONObject2.putOpt("label_info", c(srVar));
                jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.c.w().vc()));
                return true;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public void w(int i4, double d4) {
        if (com.bytedance.msdk.core.c.w().gw()) {
            String valueOf = String.valueOf(i4);
            double[] dArr = this.sr.get(valueOf);
            if (dArr == null) {
                dArr = new double[2];
            }
            dArr[0] = dArr[0] + 1.0d;
            dArr[1] = dArr[1] + d4;
            this.sr.put(valueOf, dArr);
        }
    }

    @Override // com.bytedance.msdk.core.p.c
    protected void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("cpm_key_")) {
            return;
        }
        this.xv.put(str, str2);
    }

    @Override // com.bytedance.msdk.core.p.c
    protected Map<String, String> c() {
        return this.xv;
    }

    @Override // com.bytedance.msdk.core.p.c
    protected void c(String str, int i4, String str2) {
        if (i4 == 2) {
            this.xv.put(str, str2);
        }
    }
}
