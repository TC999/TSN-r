package com.bytedance.sdk.component.p.xv;

import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private String f29966c;

    /* renamed from: w  reason: collision with root package name */
    private String f29969w;
    private int xv;
    private final Map<String, String> sr = new HashMap();
    private List<C0449c> ux = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<C0449c> f29967f = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private final List<C0449c> f29968r = new ArrayList();

    /* renamed from: com.bytedance.sdk.component.p.xv.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0449c {

        /* renamed from: c  reason: collision with root package name */
        private String f29970c;

        /* renamed from: w  reason: collision with root package name */
        private String f29971w;

        public C0449c(String str, String str2) {
            this.f29970c = str;
            this.f29971w = str2;
        }

        public String c() {
            return this.f29970c;
        }

        public String w() {
            return this.f29971w;
        }
    }

    public c(JSONObject jSONObject) {
        c(jSONObject);
    }

    public String c() {
        return this.f29966c;
    }

    public List<C0449c> f() {
        return this.f29968r;
    }

    public List<C0449c> sr() {
        return this.ux;
    }

    public List<C0449c> ux() {
        return this.f29967f;
    }

    public String w() {
        return this.f29969w;
    }

    public Map<String, String> xv() {
        return this.sr;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f29966c = jSONObject.optString("name");
        this.xv = jSONObject.optInt("index");
        this.f29969w = jSONObject.optString("scheme");
        JSONObject optJSONObject = jSONObject.optJSONObject(EventMonitor.V3_PARAMS);
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.sr.put(next, optJSONObject.optString(next));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("next");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                if (optJSONObject2 != null) {
                    this.ux.add(new C0449c(optJSONObject2.optString("name"), optJSONObject2.optString("condition")));
                }
            }
        } else {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("next");
            if (optJSONObject3 != null) {
                this.ux.add(new C0449c(optJSONObject3.optString("name"), optJSONObject3.optString("condition")));
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("callback");
        if (optJSONObject4 == null) {
            optJSONObject4 = new JSONObject();
        }
        JSONArray optJSONArray2 = optJSONObject4.optJSONArray("success");
        if (optJSONArray2 == null) {
            optJSONArray2 = new JSONArray();
        }
        for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
            JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i5);
            if (optJSONObject5 != null) {
                this.f29967f.add(new C0449c(optJSONObject5.optString("name"), optJSONObject5.optString("condition")));
            }
        }
        JSONArray optJSONArray3 = optJSONObject4.optJSONArray("fail");
        if (optJSONArray3 == null) {
            optJSONArray3 = new JSONArray();
        }
        for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
            JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i6);
            if (optJSONObject6 != null) {
                this.f29968r.add(new C0449c(optJSONObject6.optString("name"), optJSONObject6.optString("condition")));
            }
        }
    }
}
