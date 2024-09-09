package com.qq.e.comm.plugin.g0.l0.f;

import android.text.TextUtils;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.dl.i;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class a implements b {

    /* renamed from: i  reason: collision with root package name */
    protected static final String f43688i = com.qq.e.comm.plugin.g0.l0.c.f43616o;

    /* renamed from: b  reason: collision with root package name */
    protected JSONObject f43690b;

    /* renamed from: c  reason: collision with root package name */
    private final String f43691c;

    /* renamed from: d  reason: collision with root package name */
    private g f43692d;

    /* renamed from: f  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.g0.l0.a f43694f;

    /* renamed from: g  reason: collision with root package name */
    protected volatile int f43695g;

    /* renamed from: a  reason: collision with root package name */
    protected volatile CopyOnWriteArrayList<JSONObject> f43689a = new CopyOnWriteArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final Lock f43693e = new ReentrantLock(true);

    /* renamed from: h  reason: collision with root package name */
    private boolean f43696h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.g0.l0.f.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0836a implements Runnable {
        RunnableC0836a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a(a.f43688i, "updateFileCache, \u5df2\u5207\u6362\u5230 IO \u7ebf\u7a0b\uff0c\u7b49\u5f85\u83b7\u53d6\u9501");
            a.this.f43693e.lock();
            d1.a(a.f43688i, "updateFileCache\uff0c\u6210\u529f\u83b7\u53d6\u9501");
            try {
                try {
                } finally {
                    d1.a(a.f43688i, "updateFileCache, \u5df2\u6210\u529f\u91ca\u653e\u9501");
                    a.this.f43693e.unlock();
                }
            } catch (Throwable unused) {
                d1.b(a.f43688i, "updateFileCache fail");
            }
            if (a.this.f43689a.isEmpty()) {
                d1.a(a.f43688i, "updateFileCache\uff0cMemory \u4e2d\u6570\u636e\u4e3a\u7a7a\uff0c\u76f4\u63a5\u6e05\u7a7a\u7f13\u5b58\u6587\u4ef6");
                b1.g(a.this.f43691c).delete();
                return;
            }
            int size = a.this.f43689a.size();
            for (int i4 = 0; i4 < size; i4++) {
                i.a().a(a.this.f43692d, a.this.f43689a.get(i4));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("list", new ArrayList(a.this.f43689a));
            hashMap.put("ctrl_config", com.qq.e.comm.plugin.d0.a.d().f().b(a.this.f43691c));
            JSONObject jSONObject = new JSONObject(hashMap);
            File j4 = b1.j();
            if (!j4.exists()) {
                boolean mkdir = j4.mkdir();
                d1.a("\u7f13\u5b58\u76ee\u5f55\u521b\u5efa\u7ed3\u679c:" + mkdir, new Object[0]);
            }
            b1.c(b1.g(a.this.f43691c), jSONObject.toString());
            d1.a(a.f43688i, "updateFileCache, \u672c\u6b21\u6570\u636e\u66f4\u65b0\u6210\u529f\uff0c\u66f4\u65b0\u540e\u672c\u5730\u6709 %s \u6761\u6570\u636e", Integer.valueOf(size));
        }
    }

    public a(String str, g gVar) {
        this.f43691c = str;
        this.f43692d = gVar;
    }

    public abstract JSONObject d();

    public boolean d(JSONObject jSONObject) {
        return a(jSONObject, true);
    }

    protected abstract boolean e(JSONObject jSONObject);

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public d next() {
        d dVar = new d();
        if (this.f43689a.isEmpty()) {
            dVar.a(1);
            return dVar;
        }
        JSONObject d4 = d();
        if (d4 == null) {
            dVar.a(2);
        } else if (com.qq.e.comm.plugin.edgeanalytics.e.a(d4.optLong("adReturnTime"), this.f43692d)) {
            dVar.a(3);
            com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
            cVar.a(this.f43692d);
            cVar.c(this.f43691c);
            v.a(1407040, cVar, 0);
        } else {
            dVar.a(d4);
        }
        return dVar;
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public int size() {
        return this.f43689a.size();
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public void a(com.qq.e.comm.plugin.g0.l0.a aVar, boolean z3) {
        d1.a(f43688i, "addDataSource, \u66f4\u65b0 Memory \u7f13\u5b58");
        CopyOnWriteArrayList<JSONObject> a4 = aVar.a();
        if (a4.isEmpty()) {
            if (z3 && this.f43696h) {
                c();
                return;
            }
            return;
        }
        if (this.f43689a.isEmpty()) {
            b(aVar, false);
        } else {
            CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(this.f43689a);
            copyOnWriteArrayList.addAll(a4);
            this.f43689a = copyOnWriteArrayList;
            this.f43694f = new com.qq.e.comm.plugin.g0.l0.a(copyOnWriteArrayList);
        }
        if (z3) {
            c();
        } else {
            this.f43696h = true;
        }
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public void b(com.qq.e.comm.plugin.g0.l0.a aVar, boolean z3) {
        d1.a(f43688i, "setDataSource, \u66f4\u65b0 Memory \u7f13\u5b58");
        this.f43695g = 0;
        this.f43694f = aVar;
        this.f43689a = aVar.a();
        if (z3) {
            c();
        }
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public void c() {
        this.f43696h = false;
        d1.a(f43688i, "updateFileCache, \u5373\u5c06\u5207\u6362\u5230 IO \u7ebf\u7a0b\u66f4\u65b0\u7f13\u5b58\u6587\u4ef6");
        d0.f46406b.execute(new RunnableC0836a());
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public boolean c(JSONObject jSONObject) {
        return this.f43689a.contains(jSONObject);
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public com.qq.e.comm.plugin.g0.l0.a b() {
        return this.f43694f;
    }

    protected JSONObject a(String str) {
        Iterator<JSONObject> it = this.f43689a.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (TextUtils.equals(str, next.optString("traceid"))) {
                return next;
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public boolean a(boolean z3) {
        if (a(this.f43690b, false) && com.qq.e.comm.plugin.t.c.a("phcirae", this.f43692d.b(), this.f43691c, 0) == 1) {
            return true;
        }
        if (this.f43689a.isEmpty()) {
            return false;
        }
        Iterator<JSONObject> it = this.f43689a.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (a(next, false)) {
                if (!a(z3, next)) {
                    return true;
                }
                z4 = true;
            }
        }
        if (z4) {
            com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
            cVar.a(this.f43692d);
            cVar.c(this.f43691c);
            v.a(1407040, cVar, 1);
        }
        return false;
    }

    private boolean a(boolean z3, JSONObject jSONObject) {
        if (z3) {
            return com.qq.e.comm.plugin.edgeanalytics.e.a(jSONObject.optLong("adReturnTime"), this.f43692d);
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public void a(String str, JSONObject jSONObject) {
        boolean z3;
        HashSet<JSONObject> hashSet = new HashSet();
        JSONObject a4 = a(str);
        if (a4 != null) {
            d1.a(f43688i, "remove, traceId = %s \u7684\u6570\u636e\u8fd8\u5728\u7f13\u5b58\u4e2d", str);
            hashSet.add(a4);
        } else {
            d1.a(f43688i, "remove, traceId = %s \u7684\u6570\u636e\u5df2\u4e0d\u5728\u7f13\u5b58\u4e2d", str);
        }
        d1.a(f43688i, "remove, \u68c0\u67e5\u662f\u5426\u6709\u8fc7\u671f\u7684\u5e7f\u544a");
        Iterator<JSONObject> it = this.f43689a.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (!d(next)) {
                hashSet.add(next);
            }
        }
        d1.a(f43688i, "remove, \u68c0\u6d4b\u5230\u8fc7\u671f\u6570\u636e %s \u6761", Integer.valueOf(Math.max(hashSet.size() - 1, 0)));
        boolean z4 = false;
        for (JSONObject jSONObject2 : hashSet) {
            z4 |= e(jSONObject2);
        }
        d1.a(f43688i, "remove, Memory \u6570\u636e\u5df2\u79fb\u9664\u5b8c\u6bd5\uff0c\u662f\u5426\u9700\u8981\u66f4\u65b0\u6587\u4ef6\u7f13\u5b58 = %s ", Boolean.valueOf(z4));
        if (z4) {
            JSONObject jSONObject3 = this.f43690b;
            if (jSONObject3 != null) {
                this.f43690b = null;
                jSONObject = jSONObject3;
            }
            if (jSONObject != null) {
                z3 = d(jSONObject);
                if (z3) {
                    b(jSONObject);
                }
            } else {
                z3 = false;
            }
            d1.a(f43688i, "insertToCurrentIndex, standbyData\u662f\u5426\u6709\u6548 = %s", Boolean.valueOf(z3));
            c();
        }
    }

    public boolean a(JSONObject jSONObject, boolean z3) {
        if (jSONObject == null) {
            return false;
        }
        b0 b0Var = null;
        try {
            b0Var = new b0(jSONObject.optJSONObject("posCfg"));
        } catch (Exception unused) {
            d1.a(f43688i, "isValid\uff0cconfig parse error");
        }
        int a4 = com.qq.e.comm.plugin.util.c.a(jSONObject.optInt("ad_expire"), com.qq.e.comm.plugin.util.c.a(this.f43691c, b0Var, this.f43692d));
        long optLong = jSONObject.optLong("adCachedTime");
        long a5 = a(a4, optLong);
        boolean z4 = a5 <= 0;
        if (!z4) {
            if (z3) {
                h hVar = new h(2301002);
                hVar.b((a5 / 1000) / 60);
                v.a(hVar);
            }
            String str = f43688i;
            d1.b(str, "data is invalid, loadTime = " + optLong + " ms, expireTime = " + a4 + " min, currentTime = " + System.currentTimeMillis() + " ms");
        }
        return z4;
    }

    private long a(long j4, long j5) {
        return System.currentTimeMillis() - (j5 + ((j4 * 60) * 1000));
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public void a(JSONObject jSONObject) {
        this.f43690b = jSONObject;
    }
}
