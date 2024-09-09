package com.qq.e.comm.plugin.g0.l0.f;

import android.text.TextUtils;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    protected static final String f43698h = com.qq.e.comm.plugin.g0.l0.c.f43616o;

    /* renamed from: a  reason: collision with root package name */
    private final String f43699a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f43700b;

    /* renamed from: c  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.l0.f.b f43701c;

    /* renamed from: d  reason: collision with root package name */
    private final g f43702d;

    /* renamed from: e  reason: collision with root package name */
    private AtomicBoolean f43703e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f43704f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private com.qq.e.comm.plugin.edgeanalytics.g f43705g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a(c.f43698h, "readFromFile, \u5df2\u5207\u6362\u5230IO\u7ebf\u7a0b\uff0c\u5f00\u59cb\u5c1d\u8bd5\u83b7\u53d6\u9501");
            synchronized (c.this) {
                d1.a(c.f43698h, "readFromFile, \u5df2\u6210\u529f\u83b7\u53d6\u9501");
                File g4 = b1.g(c.this.f43699a);
                String d4 = b1.d(g4);
                d1.a(c.f43698h, "readFromFile, \u8bfb\u53d6\u7f13\u5b58\u6587\u4ef6%s\u7ed3\u675f\uff0c\u5185\u5bb9\u4e3a: %s", g4.getAbsolutePath(), d4);
                c.this.f43701c.b(c.this.a(d4), false);
                d1.a(c.f43698h, "readFromFile, \u5df2\u6210\u529f\u91ca\u653e\u9501");
                c.this.f43703e.set(true);
                if (c.this.f43704f.compareAndSet(true, false)) {
                    c.this.f();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43707c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f43708d;

        b(int i4, d dVar) {
            this.f43707c = i4;
            this.f43708d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a(c.f43698h, "LocalDataSource.getAd, hash = %s\uff0c\u5df2\u5207\u6362\u5230IO\u7ebf\u7a0b\uff0c\u5c1d\u8bd5\u83b7\u53d6\u9501", Integer.valueOf(this.f43707c));
            synchronized (c.this) {
                d1.a(c.f43698h, "LocalDataSource.getAd, hash = %s, \u6210\u529f\u83b7\u53d6\u9501", Integer.valueOf(this.f43707c));
                com.qq.e.comm.plugin.g0.l0.f.d next = c.this.f43701c.next();
                JSONObject b4 = next.b();
                if (b4 != null) {
                    d1.a(c.f43698h, "LocalDataSource.getAd, hash = %s, \u6210\u529f\u83b7\u53d6\u7f13\u5b58, traceId = %s", Integer.valueOf(this.f43707c), b4.optString("traceid"));
                    if (this.f43708d != null) {
                        this.f43708d.a(next);
                    }
                } else if (this.f43708d != null) {
                    d1.a(c.f43698h, "LocalDataSource.getAd, hash = %s, \u672a\u83b7\u53d6\u5230\u6570\u636e", Integer.valueOf(this.f43707c));
                    this.f43708d.b(next);
                }
                d1.a(c.f43698h, "LocalDataSource.getAd, hash = %s, \u6210\u529f\u91ca\u653e\u9501", Integer.valueOf(this.f43707c));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.g0.l0.f.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0837c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43710c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f43711d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ f f43712e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f43713f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.l0.b f43714g;

        RunnableC0837c(String str, JSONObject jSONObject, f fVar, com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar) {
            this.f43710c = str;
            this.f43711d = jSONObject;
            this.f43712e = fVar;
            this.f43713f = dVar;
            this.f43714g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a(c.f43698h, "remove, \u5df2\u5207\u6362\u5230 IO \u7ebf\u7a0b\u79fb\u9664 traceId = %s \u5230\u6570\u636e, \u5c1d\u8bd5\u83b7\u53d6\u9501", this.f43710c);
            synchronized (c.this) {
                d1.a(c.f43698h, "remove, \u79fb\u9664 traceId = %s \u7684\u6570\u636e, \u83b7\u53d6\u9501\u6210\u529f", this.f43710c);
                c.this.f43701c.a(this.f43710c, this.f43711d);
                if (this.f43712e != null) {
                    this.f43712e.a(this.f43713f, this.f43714g, c.this.f43701c.size());
                }
                d1.a(c.f43698h, "remove, \u79fb\u9664 traceId = %s \u7684\u6570\u636e\u5b8c\u6210, \u6210\u529f\u91ca\u653e\u9501", this.f43710c);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface d {
        void a(com.qq.e.comm.plugin.g0.l0.f.d dVar);

        void b(com.qq.e.comm.plugin.g0.l0.f.d dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class e implements com.qq.e.comm.plugin.edgeanalytics.g {

        /* renamed from: a  reason: collision with root package name */
        private final List<JSONObject> f43716a;

        /* renamed from: b  reason: collision with root package name */
        private final c f43717b;

        /* synthetic */ e(c cVar, List list, a aVar) {
            this(cVar, list);
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.g
        public void a(int i4) {
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.g
        public void a(boolean z3, JSONObject jSONObject) {
            if (this.f43717b == null || !z3 || this.f43716a == null) {
                return;
            }
            this.f43717b.a(com.qq.e.comm.plugin.edgeanalytics.e.a(jSONObject), this.f43716a);
        }

        private e(c cVar, List<JSONObject> list) {
            this.f43717b = cVar;
            this.f43716a = list;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface f {
        void a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, int i4);
    }

    public c(String str, com.qq.e.comm.plugin.n0.c cVar, g gVar) {
        this.f43699a = str;
        this.f43702d = gVar;
        this.f43701c = new com.qq.e.comm.plugin.g0.l0.f.e(this.f43699a, gVar);
        this.f43700b = cVar;
        d();
    }

    public int e() {
        return this.f43701c.size();
    }

    public void f() {
        if (!c()) {
            this.f43704f.set(true);
            return;
        }
        com.qq.e.comm.plugin.g0.l0.a b4 = this.f43701c.b();
        if (b4 == null) {
            return;
        }
        CopyOnWriteArrayList<JSONObject> a4 = b4.a();
        if (a4.size() <= 0) {
            return;
        }
        String a5 = com.qq.e.comm.plugin.edgeanalytics.d.a(this.f43702d, this.f43699a);
        if (com.qq.e.comm.plugin.edgeanalytics.d.a(a5)) {
            return;
        }
        ArrayList arrayList = new ArrayList(a4);
        com.qq.e.comm.plugin.edgeanalytics.c a6 = com.qq.e.comm.plugin.edgeanalytics.d.a(a5, this.f43702d, this.f43699a, arrayList, this.f43701c.a());
        e eVar = new e(this, arrayList, null);
        this.f43705g = eVar;
        a6.a(eVar);
        com.qq.e.comm.plugin.edgeanalytics.b.c().e(a6);
    }

    private void d() {
        d1.a(f43698h, "readFromFile, \u5373\u5c06\u5207\u6362\u5230IO\u7ebf\u7a0b\u5f00\u59cb\u4ece\u672c\u5730\u8bfb\u7f13\u5b58");
        d0.f46406b.execute(new a());
    }

    public int b() {
        return this.f43701c.a();
    }

    public boolean c() {
        return this.f43703e.get();
    }

    public List<JSONObject> a() {
        com.qq.e.comm.plugin.g0.l0.a b4 = this.f43701c.b();
        if (b4 == null) {
            return Collections.emptyList();
        }
        return b4.a();
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || this.f43701c == null) {
            return;
        }
        if (com.qq.e.comm.plugin.t.c.a("itratcl", this.f43702d.b(), this.f43699a, 0) == 1) {
            this.f43701c.b(jSONObject);
            this.f43701c.c();
            v.a(1407024, this.f43700b);
            return;
        }
        this.f43701c.a(jSONObject);
    }

    public void a(com.qq.e.comm.plugin.g0.l0.a aVar) {
        this.f43701c.b(aVar, true);
    }

    public void a(com.qq.e.comm.plugin.g0.l0.a aVar, boolean z3) {
        this.f43701c.a(aVar, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:
        r7 = r7 + 1;
        r0 = r18;
        r4 = r16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONArray r18, java.util.List<org.json.JSONObject> r19) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.g0.l0.f.c.a(org.json.JSONArray, java.util.List):void");
    }

    public com.qq.e.comm.plugin.g0.l0.a a(String str) {
        int length;
        d1.a(f43698h, "parser, \u5f00\u59cb\u89e3\u6790\u5185\u5bb9:%s", str);
        com.qq.e.comm.plugin.g0.l0.d.a(this.f43700b);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (TextUtils.isEmpty(str)) {
            d1.b(f43698h, "parser, content is null or empty");
            com.qq.e.comm.plugin.g0.l0.d.a(this.f43700b, 1);
            return new com.qq.e.comm.plugin.g0.l0.a(copyOnWriteArrayList);
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e4) {
            com.qq.e.comm.plugin.g0.l0.d.a(this.f43700b, 2);
            d1.a(f43698h, "parser, content is not json", e4);
        }
        if (jSONObject == null) {
            return new com.qq.e.comm.plugin.g0.l0.a(copyOnWriteArrayList);
        }
        com.qq.e.comm.plugin.d0.a.d().f().a(this.f43699a, jSONObject.optJSONObject("ctrl_config"));
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            d1.a(f43698h, "parser, \u672c\u6b21\u8bfb\u53d6\u5230 %s \u6761\u6570\u636e", Integer.valueOf(length));
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject == null) {
                    d1.a(f43698h, "parser, \u7b2c %s \u6761\u6570\u636e\u4e3a\u7a7a", Integer.valueOf(i4));
                } else {
                    copyOnWriteArrayList.add(optJSONObject);
                }
            }
            d1.a(f43698h, "parser, \u89e3\u6790\u5b8c\u6bd5\uff0c\u5171\u8fd4\u56de %s \u6761\u6570\u636e", Integer.valueOf(copyOnWriteArrayList.size()));
            com.qq.e.comm.plugin.g0.l0.d.b(this.f43700b);
            return new com.qq.e.comm.plugin.g0.l0.a(copyOnWriteArrayList);
        }
        d1.a(f43698h, "parser, jsonArray is null or empty");
        com.qq.e.comm.plugin.g0.l0.d.a(this.f43700b, 3);
        return new com.qq.e.comm.plugin.g0.l0.a(copyOnWriteArrayList);
    }

    public void a(com.qq.e.comm.plugin.b.d dVar, d dVar2) {
        int hashCode = dVar.hashCode();
        d1.a(f43698h, "LocalDataSource.getAd\uff0chash = %s, \u5373\u5c06\u5207\u6362\u5230 IO \u7ebf\u7a0b\u83b7\u53d6\u7f13\u5b58", Integer.valueOf(hashCode));
        d0.f46406b.execute(new b(hashCode, dVar2));
    }

    public synchronized com.qq.e.comm.plugin.g0.l0.f.d a(com.qq.e.comm.plugin.b.d dVar) {
        return this.f43701c.next();
    }

    public void a(String str, JSONObject jSONObject, com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, f fVar) {
        d1.a(f43698h, "remove, \u5373\u5c06\u5207\u6362\u5230 IO \u7ebf\u7a0b\u79fb\u9664 traceId = %s \u7684\u6570\u636e", str);
        d0.f46406b.execute(new RunnableC0837c(str, jSONObject, fVar, dVar, bVar));
    }

    public boolean a(boolean z3) {
        com.qq.e.comm.plugin.g0.l0.f.b bVar = this.f43701c;
        if (bVar == null) {
            return false;
        }
        return bVar.a(z3);
    }

    public boolean a(JSONObject jSONObject) {
        com.qq.e.comm.plugin.g0.l0.f.b bVar;
        if (jSONObject == null || (bVar = this.f43701c) == null) {
            return false;
        }
        return bVar.c(jSONObject);
    }
}
