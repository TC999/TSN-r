package cn.jiguang.common.n;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.ah.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f3548a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f3549b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicLong f3550c = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    private AtomicLong f3551d = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, cn.jiguang.common.m.c> f3552e = null;

    private cn.jiguang.at.a a(int i4) {
        return i4 != 1001 ? i4 != 1003 ? new cn.jiguang.at.b() : new cn.jiguang.at.b() : new cn.jiguang.at.c();
    }

    public static c a() {
        if (f3548a == null) {
            synchronized (c.class) {
                if (f3548a == null) {
                    f3548a = new c();
                }
            }
        }
        return f3548a;
    }

    private void a(Context context, HashMap<String, cn.jiguang.common.m.c> hashMap) {
        int size;
        try {
            for (cn.jiguang.common.m.c cVar : hashMap.values()) {
                cn.jiguang.common.m.c cVar2 = this.f3552e.get(cVar.f3488a);
                if (cVar2 == null) {
                    cVar2 = new cn.jiguang.common.m.c();
                }
                int size2 = cVar2.f3492e.size();
                boolean z3 = cVar.f3492e.size() > 0 && cVar.f3492e.get(0).longValue() > 0;
                if (z3) {
                    long longValue = cVar.f3492e.get(0).longValue();
                    if (size2 <= 0 || longValue > cVar2.f3492e.get(size2 - 1).longValue()) {
                        cVar2.f3492e.add(Long.valueOf(longValue));
                        cVar2.f3491d.add(cVar.f3491d.get(0));
                    }
                }
                if (cVar.f3494g.size() > 0) {
                    long longValue2 = cVar.f3494g.get(0).longValue();
                    if (longValue2 > 0 && ((size = cVar2.f3494g.size()) == 0 || (!z3 && cVar2.f3494g.get(size - 1).longValue() != longValue2))) {
                        long currentTimeMillis = System.currentTimeMillis();
                        cVar2.f3494g.add(Long.valueOf(longValue2));
                        cVar2.f3492e.add(Long.valueOf(currentTimeMillis));
                        cVar2.f3491d.add(2);
                    }
                }
                cVar2.f3488a = cVar.f3488a;
                cVar2.f3489b = cVar.f3489b;
                cVar2.f3490c = cVar.f3490c;
                this.f3552e.put(cVar.f3488a, cVar2);
            }
            f(context);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JAppActiveHelper", "updateAppActiveData error, " + th.getMessage());
        }
    }

    private boolean b() {
        return System.currentTimeMillis() - this.f3550c.get() >= 108000000;
    }

    private void c() {
        this.f3550c.set(System.currentTimeMillis());
    }

    private void d() {
        this.f3551d.set(System.currentTimeMillis());
    }

    private void e(Context context) {
        HashMap<String, cn.jiguang.common.m.c> hashMap = this.f3552e;
        if (hashMap == null || hashMap.size() <= 0) {
            try {
                this.f3552e = new LinkedHashMap();
                String c4 = cn.jiguang.ao.e.c(context, "atv.cache");
                if (!TextUtils.isEmpty(c4)) {
                    JSONObject jSONObject = new JSONObject(c4);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jiguang.common.m.c a4 = cn.jiguang.common.m.c.a(jSONObject.getJSONObject(keys.next()).toString());
                        this.f3552e.put(a4.f3488a, a4);
                    }
                }
                cn.jiguang.w.a.b("JAppActiveHelper", "read app active from cache file, file size: " + this.f3552e.size());
            } catch (Throwable th) {
                cn.jiguang.w.a.b("JAppActiveHelper", "read app active data from cache file failed, " + th.getMessage());
            }
        }
    }

    private void f(Context context) {
        HashMap<String, cn.jiguang.common.m.c> hashMap = this.f3552e;
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, cn.jiguang.common.m.c> entry : this.f3552e.entrySet()) {
                cn.jiguang.common.m.c value = entry.getValue();
                String key = entry.getKey();
                if (value != null) {
                    jSONObject.put(key, value.a(128));
                }
            }
            cn.jiguang.ao.e.d(context, "atv.cache");
            cn.jiguang.ao.e.a(context, "atv.cache", jSONObject.toString());
        } catch (Throwable th) {
            cn.jiguang.w.a.b("JAppActiveHelper", "app active date cache to file failed, " + th.getMessage());
        }
    }

    private void g(Context context) {
        int size;
        try {
            d();
            e(context);
            long currentTimeMillis = System.currentTimeMillis();
            HashMap<String, cn.jiguang.common.m.c> a4 = a(1001).a(context, null);
            if (a4.size() > 0) {
                cn.jiguang.y.a.a(context, "app_active", 0);
                cn.jiguang.w.a.b("JAppActiveHelper", "collect active by usage state manager, size: " + a4.size());
                a(context, a4);
                return;
            }
            HashMap<String, cn.jiguang.common.m.c> a5 = a(1003).a(context, d(context));
            HashMap<String, cn.jiguang.common.m.c> hashMap = new HashMap<>();
            for (cn.jiguang.common.m.c cVar : a5.values()) {
                if (!TextUtils.isEmpty(cVar.f3488a)) {
                    cn.jiguang.common.m.c cVar2 = new cn.jiguang.common.m.c();
                    if (cVar.f3494g.size() > 0) {
                        cVar2.f3494g = cVar.f3494g;
                    }
                    if (cVar.f3492e.size() > 0) {
                        long longValue = cVar.f3492e.get(0).longValue();
                        if (longValue > 0 && ((size = cVar2.f3492e.size()) == 0 || cVar2.f3492e.get(size - 1).longValue() < longValue)) {
                            cVar2.f3492e.add(Long.valueOf(longValue));
                            cVar2.f3491d.add(cVar.f3491d.get(0));
                        }
                    }
                    cVar2.f3488a = cVar.f3488a;
                    hashMap.put(cVar.f3488a, cVar2);
                }
            }
            if (hashMap.size() > 0) {
                a(context, hashMap);
                cn.jiguang.y.a.a(context, "app_active", 0);
            } else {
                cn.jiguang.y.a.a(context, "app_active", 2);
            }
            if (a.C0049a.f2212a) {
                cn.jiguang.w.a.b("JAppActiveHelper", "collect app active done, cost_time: " + (System.currentTimeMillis() - currentTimeMillis) + ", active size: " + hashMap.size());
            }
        } catch (Throwable th) {
            cn.jiguang.y.a.a(context, "app_active", -1);
            cn.jiguang.w.a.f("JAppActiveHelper", "collect app active failed: " + th.getMessage());
        }
    }

    public void a(Context context) {
        cn.jiguang.w.a.b("JAppActiveHelper", "start app active collect business");
        g(context);
        if (cn.jiguang.ah.c.j(context)) {
            return;
        }
        cn.jiguang.ao.e.e(context, "wxatv.cache");
        cn.jiguang.ao.e.e(context, "afm.cache");
        cn.jiguang.ao.e.e(context, "wxids.cache");
        cn.jiguang.ah.c.b(context, true);
        cn.jiguang.w.a.e("JAppActiveHelper", "clear active cache success");
    }

    public HashMap<String, cn.jiguang.common.m.c> b(Context context) {
        HashMap<String, cn.jiguang.common.m.c> hashMap = this.f3552e;
        if (hashMap == null || hashMap.isEmpty()) {
            e(context);
        }
        return this.f3552e;
    }

    public void c(Context context) {
        HashMap<String, cn.jiguang.common.m.c> hashMap = this.f3552e;
        if (hashMap != null) {
            hashMap.clear();
        }
        cn.jiguang.ao.e.e(context, "atv.cache");
        cn.jiguang.w.a.b("JAppActiveHelper", "after app list report, reset old app active data");
    }

    public synchronized List<String> d(Context context) {
        if (this.f3549b == null) {
            this.f3549b = new ArrayList();
        }
        if (this.f3549b.size() > 0 && !b()) {
            return this.f3549b;
        }
        ArrayList arrayList = new ArrayList();
        if (d.a(context, false, (Object) arrayList) instanceof List) {
            c();
            this.f3549b.clear();
            this.f3549b.addAll(arrayList);
        }
        return this.f3549b;
    }
}
