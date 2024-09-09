package cn.jiguang.bm;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f2741a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f2742b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f2743c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static a f2744d;

    /* renamed from: e  reason: collision with root package name */
    private Set<String> f2745e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private Map<String, cn.jiguang.bn.a> f2746f = new HashMap();

    private a() {
    }

    public static a a(Context context) {
        if (f2744d == null) {
            synchronized (a.class) {
                if (f2744d == null) {
                    f2744d = new a();
                    cn.jiguang.bp.g.c(context);
                    String c4 = c(context);
                    if (c4 != null) {
                        f2744d.a(a(new JSONArray(c4)));
                    }
                    String b4 = b(context);
                    if (b4 != null) {
                        f2744d.a(b(new JSONArray(b4)));
                    }
                }
            }
        }
        return f2744d;
    }

    private static cn.jiguang.bn.a a(JSONObject jSONObject) {
        return new cn.jiguang.bn.a(jSONObject);
    }

    public static Set<String> a(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            hashSet.add(jSONArray.optString(i4));
        }
        return hashSet;
    }

    private static String b(Context context) {
        return cn.jiguang.bp.f.d(context);
    }

    public static Map<String, cn.jiguang.bn.a> b(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            cn.jiguang.bn.a a4 = a(jSONArray.optJSONObject(i4));
            hashMap.put(a4.a(), a4);
        }
        return hashMap;
    }

    private static String c(Context context) {
        return cn.jiguang.bp.f.c(context);
    }

    public synchronized JSONArray a() {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        for (String str : this.f2745e) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public synchronized void a(Map<String, cn.jiguang.bn.a> map) {
        this.f2746f.clear();
        this.f2746f.putAll(map);
    }

    public synchronized void a(Set<String> set) {
        this.f2745e.clear();
        this.f2745e.addAll(set);
    }

    public synchronized boolean a(String str) {
        return this.f2745e.contains(str);
    }

    public synchronized Set<Map.Entry<String, cn.jiguang.bn.a>> b() {
        return this.f2746f.entrySet();
    }

    public synchronized JSONArray c() {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        for (Map.Entry<String, cn.jiguang.bn.a> entry : this.f2746f.entrySet()) {
            jSONArray.put(entry.getValue().c());
        }
        return jSONArray;
    }
}
