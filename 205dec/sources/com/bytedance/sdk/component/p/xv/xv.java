package com.bytedance.sdk.component.p.xv;

import android.text.TextUtils;
import com.bytedance.adsdk.w.w.a;
import com.bytedance.sdk.component.p.xv.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private String f29974c;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f29975f;
    private final Map<String, c> sr = new HashMap();
    private c ux;

    /* renamed from: w  reason: collision with root package name */
    private String f29976w;
    private boolean xv;

    public xv(JSONObject jSONObject) {
        this.xv = false;
        String next = jSONObject.keys().next();
        this.f29976w = next;
        JSONObject optJSONObject = jSONObject.optJSONObject(next);
        this.f29974c = optJSONObject.optString("version");
        boolean optBoolean = optJSONObject.optBoolean("lazyLoad");
        this.xv = optBoolean;
        if (!optBoolean) {
            c(optJSONObject);
        } else {
            this.f29975f = optJSONObject;
        }
    }

    private void c(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("events");
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            c cVar = new c(optJSONArray.optJSONObject(i4));
            this.sr.put(cVar.c(), cVar);
            if (cVar.c().equals(jSONObject.optString("main"))) {
                this.ux = cVar;
            }
        }
    }

    public String w() {
        return this.f29976w;
    }

    public List<c> xv(c cVar, JSONObject jSONObject, Map<String, Object> map) {
        List<c.C0449c> sr = cVar.sr();
        ArrayList arrayList = new ArrayList();
        for (c.C0449c c0449c : sr) {
            if (c0449c != null && c(c0449c.w(), jSONObject, map)) {
                arrayList.add(c(c0449c.c()));
            }
        }
        return arrayList;
    }

    public List<c> w(c cVar, JSONObject jSONObject, Map<String, Object> map) {
        return c(jSONObject, map, cVar.f());
    }

    public c c(String str) {
        if (this.xv) {
            c(this.f29975f);
        }
        return this.sr.get(str);
    }

    public c c() {
        if (this.xv) {
            c(this.f29975f);
        }
        return this.ux;
    }

    public List<c> c(c cVar, JSONObject jSONObject, Map<String, Object> map) {
        return c(jSONObject, map, cVar.ux());
    }

    private List<c> c(JSONObject jSONObject, Map<String, Object> map, List<c.C0449c> list) {
        c c4;
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (c.C0449c c0449c : list) {
            if (c0449c != null && (c4 = c(c0449c.c())) != null && c(c0449c.w(), jSONObject, map)) {
                arrayList.add(c4);
            }
        }
        return arrayList;
    }

    private static boolean c(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith("}")) {
                return Boolean.parseBoolean(a.a(str.substring(2, str.length() - 1)).c(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
