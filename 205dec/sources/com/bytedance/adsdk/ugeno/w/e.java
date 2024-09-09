package com.bytedance.adsdk.ugeno.w;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f26370a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f26371b;

    /* renamed from: c  reason: collision with root package name */
    private String f26372c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f26373d;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f26374a;

        /* renamed from: b  reason: collision with root package name */
        private String f26375b;

        /* renamed from: c  reason: collision with root package name */
        private JSONObject f26376c;

        /* renamed from: d  reason: collision with root package name */
        private List<a> f26377d;

        /* renamed from: e  reason: collision with root package name */
        private a f26378e;

        /* renamed from: f  reason: collision with root package name */
        private String f26379f;

        public String b() {
            return this.f26374a;
        }

        public void e(a aVar) {
            if (this.f26377d == null) {
                this.f26377d = new ArrayList();
            }
            this.f26377d.add(aVar);
        }

        public JSONObject f() {
            return this.f26376c;
        }

        public List<a> g() {
            return this.f26377d;
        }

        public String h() {
            return this.f26379f;
        }

        public String k() {
            return this.f26375b;
        }

        public String toString() {
            return "UGNode{id='" + this.f26374a + "', name='" + this.f26375b + "'}";
        }
    }

    public e(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            this.f26370a = jSONObject.optJSONObject("main_template");
            this.f26371b = jSONObject.optJSONObject("sub_templates");
            JSONObject optJSONObject = jSONObject.optJSONObject("template_info");
            if (optJSONObject != null) {
                this.f26372c = optJSONObject.optString("sdk_version");
            }
            this.f26373d = jSONObject2;
        }
    }

    private a b(JSONObject jSONObject, a aVar) {
        a b4;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        a aVar2 = new a();
        aVar2.f26374a = optString2;
        aVar2.f26375b = optString;
        aVar2.f26376c = jSONObject2;
        aVar2.f26378e = aVar;
        aVar2.f26379f = this.f26372c;
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                String optString3 = optJSONObject.optString("name");
                String a4 = n0.d.a(optJSONObject.optString("id"), this.f26373d);
                if (TextUtils.equals(optString3, "Template")) {
                    JSONObject jSONObject3 = this.f26371b;
                    b4 = jSONObject3 != null ? b(jSONObject3.optJSONObject(a4), aVar2) : null;
                } else {
                    b4 = b(optJSONObject, aVar2);
                }
                if (b4 != null) {
                    aVar2.e(b4);
                }
            }
        }
        return aVar2;
    }

    public static boolean c(a aVar) {
        return (aVar == null || aVar.f26376c == null) ? false : true;
    }

    public a a() {
        return b(this.f26370a, null);
    }

    public String d() {
        return this.f26372c;
    }

    public List<a> e() {
        if (this.f26371b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.f26371b.keys();
        while (keys.hasNext()) {
            a b4 = b(this.f26371b.optJSONObject(keys.next()), null);
            if (b4 != null) {
                arrayList.add(b4);
            }
        }
        return arrayList;
    }
}
