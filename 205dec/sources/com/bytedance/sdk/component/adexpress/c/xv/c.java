package com.bytedance.sdk.component.adexpress.c.xv;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.utils.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private String f29045c;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, c> f29046f = new ConcurrentHashMap();
    private List<C0435c> sr;
    private w ux;

    /* renamed from: w  reason: collision with root package name */
    private String f29047w;
    private String xv;

    /* renamed from: com.bytedance.sdk.component.adexpress.c.xv.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0435c {

        /* renamed from: c  reason: collision with root package name */
        private String f29048c;

        /* renamed from: w  reason: collision with root package name */
        private String f29049w;
        private int xv;

        public String c() {
            return this.f29048c;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0435c) {
                String str2 = this.f29048c;
                if (str2 != null) {
                    C0435c c0435c = (C0435c) obj;
                    return str2.equals(c0435c.c()) && (str = this.f29049w) != null && str.equals(c0435c.w());
                }
                return false;
            }
            return super.equals(obj);
        }

        public String w() {
            return this.f29049w;
        }

        public int xv() {
            return this.xv;
        }

        public void c(String str) {
            this.f29048c = str;
        }

        public void w(String str) {
            this.f29049w = str;
        }

        public void c(int i4) {
            this.xv = i4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        private String f29050c;

        /* renamed from: w  reason: collision with root package name */
        private String f29051w;
        private List<Pair<String, String>> xv;

        public String c() {
            return this.f29050c;
        }

        public void w(String str) {
            this.f29051w = str;
        }

        public void c(String str) {
            this.f29050c = str;
        }

        public List<Pair<String, String>> w() {
            return this.xv;
        }

        public void c(List<Pair<String, String>> list) {
            this.xv = list;
        }
    }

    public Map<String, c> c() {
        return this.f29046f;
    }

    public String ev() {
        JSONObject r3;
        if (!f() || (r3 = r()) == null) {
            return null;
        }
        return r3.toString();
    }

    public boolean f() {
        return (TextUtils.isEmpty(sr()) || TextUtils.isEmpty(xv()) || TextUtils.isEmpty(w())) ? false : true;
    }

    public List<C0435c> getResources() {
        if (this.sr == null) {
            this.sr = new ArrayList();
        }
        return this.sr;
    }

    public JSONObject r() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", w());
            jSONObject.putOpt("version", xv());
            jSONObject.putOpt("main", sr());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0435c c0435c : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0435c.c());
                    jSONObject2.putOpt("md5", c0435c.w());
                    jSONObject2.putOpt("level", Integer.valueOf(c0435c.xv()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.f29046f.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z3 = false;
                for (String str : this.f29046f.keySet()) {
                    c cVar = this.f29046f.get(str);
                    if (cVar != null) {
                        jSONObject3.put(str, cVar.r());
                        z3 = true;
                    }
                }
                if (z3) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            w ux = ux();
            if (ux != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", ux.f29050c);
                jSONObject4.put("md5", ux.f29051w);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> w3 = ux.w();
                if (w3 != null) {
                    for (Pair<String, String> pair : w3) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String sr() {
        return this.xv;
    }

    public w ux() {
        return this.ux;
    }

    public String w() {
        return this.f29045c;
    }

    public String xv() {
        return this.f29047w;
    }

    public static c sr(String str) {
        if (str == null) {
            return null;
        }
        try {
            return c(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public void c(String str) {
        this.f29045c = str;
    }

    public void w(String str) {
        this.f29047w = str;
    }

    public void xv(String str) {
        this.xv = str;
    }

    public void c(w wVar) {
        this.ux = wVar;
    }

    public void c(List<C0435c> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.sr = list;
    }

    public static c c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.c(jSONObject.optString("name"));
        cVar.w(jSONObject.optString("version"));
        cVar.xv(jSONObject.optString("main"));
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                C0435c c0435c = new C0435c();
                c0435c.c(optJSONObject2.optString("url"));
                c0435c.w(optJSONObject2.optString("md5"));
                c0435c.c(optJSONObject2.optInt("level"));
                arrayList.add(c0435c);
            }
        }
        cVar.c(arrayList);
        try {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("engines");
            if (optJSONObject3 != null) {
                Iterator<String> keys = optJSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    c c4 = c(optJSONObject3.optJSONObject(next));
                    if (c4 != null) {
                        cVar.c().put(next, c4);
                    }
                }
            }
        } catch (Exception e4) {
            a.w("engine", "parse exception:" + e4.getMessage());
        }
        if (jSONObject.has("resources_archive") && (optJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            w wVar = new w();
            wVar.c(optJSONObject.optString("url"));
            wVar.w(optJSONObject.optString("md5"));
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("map");
            if (optJSONObject4 != null) {
                Iterator<String> keys2 = optJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    arrayList2.add(new Pair<>(next2, optJSONObject4.optString(next2)));
                }
                wVar.c(arrayList2);
            }
            cVar.c(wVar);
        }
        if (cVar.f()) {
            return cVar;
        }
        return null;
    }
}
