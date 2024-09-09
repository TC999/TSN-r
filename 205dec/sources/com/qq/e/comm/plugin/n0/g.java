package com.qq.e.comm.plugin.n0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f44751a = "g";

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f44752b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, f> f44753c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Integer, Boolean> f44754d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Boolean> f44755e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Integer> f44756f = new ConcurrentHashMap();

    private static void a() {
        if (f44752b) {
            return;
        }
        synchronized (g.class) {
            if (f44752b) {
                return;
            }
            String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("epatelc", "");
            d1.a(f44751a, "config: %s", b4);
            JSONObject a4 = j0.a(b4).a();
            Iterator<String> keys = a4.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                f44753c.put(next, new f(a4.optJSONObject(next)));
            }
            d1.a(f44751a, "rule size: %s", Integer.valueOf(f44753c.size()));
            for (String str : com.qq.e.comm.plugin.d0.a.d().f().b("epatelb", "").split(",")) {
                try {
                    f44754d.put(Integer.valueOf(Integer.parseInt(str.trim())), Boolean.TRUE);
                } catch (NumberFormatException unused) {
                }
            }
            f44752b = true;
        }
    }

    private static boolean b() {
        return f44753c.containsKey("*");
    }

    private static List<Integer> b(b bVar) {
        Integer num;
        f fVar = f44753c.get("*");
        if (fVar != null && fVar.a(bVar.c(), null)) {
            return new ArrayList(f44756f.values());
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, f> entry : f44753c.entrySet()) {
            String key = entry.getKey();
            f value = entry.getValue();
            c a4 = bVar.a();
            if (value.a(bVar.c(), a4 == null ? null : Integer.valueOf(a4.b())) && (num = f44756f.get(key)) != null) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    public static void a(JSONObject jSONObject) {
        a();
        if (jSONObject == null || jSONObject.length() == 0 || !b()) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String optString = jSONObject.optString(keys.next());
                if (a(optString)) {
                    f44755e.put(optString, Boolean.TRUE);
                }
            }
        } catch (Throwable th) {
            d1.a(f44751a, "record expIds error", th);
        }
    }

    private static boolean a(String str) {
        try {
            return Integer.parseInt(str) > 10000;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(b0 b0Var) {
        Set<String> keySet;
        if (b()) {
            keySet = f44755e.keySet();
        } else {
            keySet = f44753c.keySet();
        }
        if (keySet.isEmpty() || b0Var == null) {
            return;
        }
        try {
            if (b0Var.f43488b == null) {
                return;
            }
            JSONObject jSONObject = b0Var.f43488b;
            for (String str : keySet) {
                String optString = jSONObject.optString(str);
                if (!TextUtils.isEmpty(optString)) {
                    a(str, optString);
                }
            }
        } catch (Throwable th) {
            d1.a(f44751a, "record exp param error", th);
        }
    }

    public static void a(String str, String str2) {
        if (f44756f.containsKey(str)) {
            return;
        }
        f44756f.put(str, Integer.valueOf(String.format("%s_%s", str, str2).hashCode()));
    }

    public static void a(b bVar) {
        if (f44753c.size() == 0 || f44754d.containsKey(Integer.valueOf(bVar.c()))) {
            return;
        }
        List<Integer> b4 = b(bVar);
        if (b4.size() == 0) {
            return;
        }
        Collections.sort(b4);
        bVar.a(TextUtils.join(",", b4));
    }
}
