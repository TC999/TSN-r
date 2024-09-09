package com.bytedance.msdk.core.w;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.msdk.f.j;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private int f28283c;

    /* renamed from: w  reason: collision with root package name */
    private final Map<String, Float> f28284w = new ConcurrentHashMap();
    private final Map<String, sr> xv = new ConcurrentHashMap();

    public w(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            this.f28283c = jSONObject.optInt("lt_days");
            JSONObject optJSONObject = jSONObject.optJSONObject("estimate");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.f28284w.put(next, Float.valueOf((float) optJSONObject.optDouble(next)));
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rule_excs");
            if (optJSONObject2 == null || optJSONObject2.length() == 0) {
                return;
            }
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next2);
                if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("prime_rits")) != null && optJSONArray.length() > 0) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        String optString = optJSONArray.optString(i4);
                        this.xv.put(optString, new sr(next2, optString, optJSONObject3));
                    }
                }
            }
        }
    }

    public JSONObject c(String str, @NonNull j jVar) {
        ux uxVar;
        if (!com.bytedance.msdk.core.c.w().me() || str == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        float c4 = c(str);
        sr srVar = this.xv.get(str);
        if (srVar != null) {
            Map<String, ux> ux = srVar.ux();
            String[] xv = srVar.xv();
            if (ux != null && !ux.isEmpty() && xv != null && xv.length > 0) {
                for (String str2 : xv) {
                    if (!TextUtils.isEmpty(str2) && (uxVar = ux.get(str2)) != null) {
                        try {
                            jSONObject.putOpt(str2, Integer.valueOf(uxVar.c(c4)));
                        } catch (Exception e4) {
                            com.bytedance.msdk.adapter.sr.xv.sr("", "calculateRangeByScore\u8ba1\u7b97\u5f02\u5e38\uff1a(tableName\uff1a" + str2 + ",primeRit:" + str + "\uff09\uff0c" + e4.getMessage());
                        }
                    }
                }
            }
        }
        jVar.put("gm_policy", jSONObject);
        jVar.put("adl_scr", Float.valueOf(c4));
        com.bytedance.msdk.core.w.k().c(str, c4);
        return jSONObject;
    }

    public sr w(String str) {
        return this.xv.get(str);
    }

    public String xv(String str) {
        sr w3;
        if (str == null || (w3 = w(str)) == null) {
            return null;
        }
        return w3.c();
    }

    public float c(String str) {
        sr srVar = this.xv.get(str);
        float f4 = -1.0f;
        if (srVar != null) {
            Map<String, Float> w3 = srVar.w();
            String sr = srVar.sr();
            if (w3 != null) {
                if (w3.containsKey("lt_x_times")) {
                    Float f5 = w3.get("lt_x_times");
                    int w4 = c.w();
                    if (f5 != null) {
                        f4 = c(sr, f5.floatValue() * w4, -1.0f);
                    }
                }
                if (w3.containsKey("active_duration")) {
                    Float f6 = w3.get("active_duration");
                    long f7 = c.f();
                    if (f6 != null) {
                        f4 = c(sr, f6.floatValue() * ((float) f7), f4);
                    }
                }
                if (w3.containsKey("active_count")) {
                    Float f8 = w3.get("active_count");
                    int sr2 = c.sr();
                    if (f8 != null) {
                        f4 = c(sr, f8.floatValue() * sr2, f4);
                    }
                }
                if (w3.containsKey("show_period")) {
                    Float f9 = w3.get("show_period");
                    long ev = c.ev(str);
                    if (f9 != null) {
                        f4 = c(sr, f9.floatValue() * ((float) ev), f4);
                    }
                }
                if (w3.containsKey("show_count")) {
                    Float f10 = w3.get("show_count");
                    int sr3 = c.sr(str);
                    if (f10 != null) {
                        f4 = c(sr, f10.floatValue() * sr3, f4);
                    }
                }
                if (w3.containsKey("dislike_count")) {
                    Float f11 = w3.get("dislike_count");
                    int w5 = c.w(str);
                    if (f11 != null) {
                        f4 = c(sr, f11.floatValue() * w5, f4);
                    }
                }
                if (w3.containsKey("click_count")) {
                    Float f12 = w3.get("click_count");
                    int f13 = c.f(str);
                    if (f12 != null) {
                        f4 = c(sr, f12.floatValue() * f13, f4);
                    }
                }
                if (w3.containsKey("install_days")) {
                    Float f14 = w3.get("install_days");
                    int ux = c.ux();
                    if (f14 != null) {
                        f4 = c(sr, f14.floatValue() * ux, f4);
                    }
                }
                if (!this.f28284w.isEmpty()) {
                    for (Map.Entry<String, Float> entry : this.f28284w.entrySet()) {
                        if (entry != null) {
                            float floatValue = entry.getValue().floatValue();
                            Float f15 = w3.get(entry.getKey());
                            if (f15 != null) {
                                f4 = c(sr, f15.floatValue() * floatValue, f4);
                            }
                        }
                    }
                }
            }
        }
        return f4;
    }

    private float c(String str, float f4, float f5) {
        if (f5 == -1.0f) {
            return f4;
        }
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 42:
                if (str.equals("*")) {
                    c4 = 0;
                    break;
                }
                break;
            case 43:
                if (str.equals("+")) {
                    c4 = 1;
                    break;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    c4 = 2;
                    break;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return f5 * f4;
            case 1:
                return f5 + f4;
            case 2:
                return Math.max(f4, f5);
            case 3:
                return Math.min(f4, f5);
            default:
                return f5;
        }
    }

    public int c() {
        return this.f28283c;
    }
}
