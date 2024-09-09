package com.qq.e.dl.i;

import android.util.Pair;
import com.qq.e.dl.k.j;
import com.qq.e.dl.k.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f46973a;

    /* renamed from: b  reason: collision with root package name */
    public final g[] f46974b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, j> f46975c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, j> f46976d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, com.qq.e.dl.k.c> f46977e;

    /* renamed from: f  reason: collision with root package name */
    public final c[] f46978f;

    /* renamed from: g  reason: collision with root package name */
    public final e[] f46979g;

    /* renamed from: h  reason: collision with root package name */
    public final com.qq.e.dl.i.a[] f46980h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f46981i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f46982j;

    /* renamed from: k  reason: collision with root package name */
    public final String f46983k;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f46984a;

        /* renamed from: b  reason: collision with root package name */
        public g[] f46985b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, j> f46986c = new HashMap(10);

        /* renamed from: d  reason: collision with root package name */
        public Map<String, com.qq.e.dl.k.c> f46987d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public c[] f46988e;

        /* renamed from: f  reason: collision with root package name */
        public e[] f46989f;

        /* renamed from: g  reason: collision with root package name */
        public com.qq.e.dl.i.a[] f46990g;

        /* renamed from: h  reason: collision with root package name */
        public String f46991h;

        public g a() {
            return new g(this);
        }
    }

    private boolean a() {
        if (this.f46977e == null) {
            return false;
        }
        for (String str : com.qq.e.dl.g.a.f46893b) {
            if (this.f46977e.get(str) != null) {
                return true;
            }
        }
        for (String str2 : com.qq.e.dl.g.a.f46892a) {
            if (this.f46977e.get(str2) != null) {
                return true;
            }
        }
        return false;
    }

    private boolean b() {
        g[] gVarArr = this.f46974b;
        if (gVarArr == null) {
            return false;
        }
        for (g gVar : gVarArr) {
            if (gVar != null && gVar.f46981i) {
                return true;
            }
        }
        return false;
    }

    private Pair<Boolean, Map<String, j>> c() {
        boolean z3;
        String[] strArr;
        Map<String, j> a4;
        Map<String, j> map = null;
        if (this.f46975c == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        String[] strArr2 = com.qq.e.dl.g.a.f46893b;
        int length = strArr2.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                z3 = false;
                break;
            }
            j jVar = this.f46975c.get(strArr2[i4]);
            if (jVar != null && jVar.f(new JSONObject[0]).c()) {
                z3 = true;
                break;
            }
            i4++;
        }
        for (String str : com.qq.e.dl.g.a.f46892a) {
            j jVar2 = this.f46975c.get(str);
            if (jVar2 != null) {
                Object c4 = jVar2.c(new JSONObject[0]);
                if (c4 instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) c4;
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        String optString = jSONArray.optString(i5);
                        if (optString != null && l.c((Object) optString).f(new JSONObject[0]).c()) {
                            a4 = a(map, str, jVar2);
                            map = a4;
                            z3 = true;
                            break;
                        }
                    }
                } else if (jVar2.f(new JSONObject[0]).c()) {
                    a4 = a(map, str, jVar2);
                    map = a4;
                    z3 = true;
                    break;
                    break;
                }
            }
        }
        return new Pair<>(Boolean.valueOf(z3), map);
    }

    private g(b bVar) {
        this.f46973a = bVar.f46984a;
        this.f46974b = bVar.f46985b;
        this.f46975c = bVar.f46986c.size() > 0 ? bVar.f46986c : null;
        this.f46977e = bVar.f46987d.size() > 0 ? bVar.f46987d : null;
        this.f46978f = bVar.f46988e;
        this.f46979g = bVar.f46989f;
        this.f46980h = bVar.f46990g;
        Pair<Boolean, Map<String, j>> c4 = c();
        this.f46981i = ((Boolean) c4.first).booleanValue() || a();
        this.f46976d = (Map) c4.second;
        this.f46982j = b();
        this.f46983k = bVar.f46991h;
    }

    private Map<String, j> a(Map<String, j> map, String str, j jVar) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str, jVar);
        this.f46975c.remove(str);
        return map;
    }
}
