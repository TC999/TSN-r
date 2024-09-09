package com.bytedance.sdk.component.p.xv;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum w {
    INSTANCE;
    

    /* renamed from: w  reason: collision with root package name */
    private Map<String, xv> f29973w = new HashMap();

    w() {
    }

    public xv c(String str) {
        return this.f29973w.get(str);
    }

    public void c(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = keys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                xv xvVar = new xv(jSONObject2);
                this.f29973w.put(xvVar.w(), xvVar);
            } catch (JSONException unused) {
            }
        }
    }
}
