package com.qq.e.comm.plugin.splash;

import android.text.TextUtils;
import android.util.Pair;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.g0.h0;
import com.qq.e.comm.plugin.l0.d;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.a1;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    private h f46078a;

    /* renamed from: c  reason: collision with root package name */
    private c0 f46080c;

    /* renamed from: e  reason: collision with root package name */
    private b f46082e;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.splash.r.e<c0> f46079b = new com.qq.e.comm.plugin.splash.r.e<>();

    /* renamed from: d  reason: collision with root package name */
    private volatile List<c0> f46081d = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        h f46086c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f46087d = new AtomicBoolean(false);

        /* renamed from: e  reason: collision with root package name */
        int f46088e;

        b(h hVar) {
            this.f46086c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = this.f46086c;
            if (hVar == null || !this.f46087d.compareAndSet(false, true)) {
                return;
            }
            com.qq.e.comm.plugin.j0.b.a().a(hVar.f46093e, hVar.f46099k, hVar.f46090b, hVar.f46091c, hVar.f46092d, hVar.f46094f, hVar.f46095g, hVar.f46098j, this.f46088e);
        }
    }

    public boolean c() {
        com.qq.e.comm.plugin.splash.r.e<c0> eVar = this.f46079b;
        return eVar.f46177c == null || !eVar.k();
    }

    public void d() {
        d0.f46406b.execute(new a());
    }

    public void e() {
        h hVar = this.f46078a;
        if (hVar == null) {
            return;
        }
        com.qq.e.comm.plugin.j0.b.a().b(hVar.f46093e, hVar.f46099k, hVar.f46090b, hVar.f46091c, hVar.f46092d, hVar.f46094f, hVar.f46095g, hVar.f46098j, 1);
    }

    public void b(int i4) {
        h hVar = this.f46078a;
        if (this.f46079b.f46177c == null || hVar == null || !hVar.g()) {
            return;
        }
        b bVar = this.f46082e;
        if (bVar == null) {
            b bVar2 = new b(hVar);
            this.f46082e = bVar2;
            bVar2.f46088e = i4;
            d0.f46410f.schedule(bVar2, hVar.f46108t, TimeUnit.MILLISECONDS);
        } else if (bVar.f46087d.get()) {
        } else {
            b bVar3 = this.f46082e;
            bVar3.f46088e = i4;
            bVar3.run();
        }
    }

    public void a(h hVar, com.qq.e.comm.plugin.splash.r.d<c0> dVar) {
        this.f46078a = hVar;
        this.f46079b.f46177c = dVar;
    }

    public void a() {
        b bVar = this.f46082e;
        if (bVar != null) {
            bVar.f46086c = null;
            this.f46082e = null;
        }
        this.f46079b.f46177c = null;
        this.f46080c = null;
        this.f46081d = null;
    }

    public c0 b() {
        int size;
        if (this.f46080c != null) {
            n.a(this.f46078a, true);
            d1.a("\u5f00\u5c4f\u5c1d\u8bd5\u7f13\u5b58-\u5728\u7ebf\u9009\u5355", new Object[0]);
            return this.f46080c;
        }
        List<c0> list = this.f46081d;
        if (list != null && (size = list.size()) > 0) {
            n.a(this.f46078a, false);
            for (int i4 = 0; i4 < size; i4++) {
                h hVar = this.f46078a;
                if (hVar == null) {
                    return null;
                }
                c0 c0Var = list.get(o.b(hVar.f46091c) % size);
                if (com.qq.e.comm.plugin.edgeanalytics.e.a(c0Var)) {
                    v.a(1407040, this.f46078a.c(), 0);
                    return null;
                }
                com.qq.e.comm.plugin.j0.b.a().b(c0Var.K0());
                if (c0Var.e1()) {
                    d1.a("\u5f00\u5c4f\u5c1d\u8bd5\u7f13\u5b58-\u79bb\u7ebf\u9009\u5355", new Object[0]);
                    return c0Var;
                }
            }
            return null;
        }
        d1.a("\u5f00\u5c4f\u5c1d\u8bd5\u7f13\u5b58-\u65e0\u7f13\u5b58", new Object[0]);
        n.a(this.f46078a);
        a(6);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.s.b bVar) {
        if (c()) {
            return;
        }
        if (j.d(this.f46078a.f46091c)) {
            c0 b4 = b();
            if (b4 != null) {
                this.f46079b.a((com.qq.e.comm.plugin.splash.r.e<c0>) b4);
                n.a(true, this.f46078a.c());
                return;
            }
            this.f46079b.a(bVar);
            n.a(false, this.f46078a.c());
            return;
        }
        this.f46079b.a(bVar);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = g.this.f46078a;
            if (g.this.c()) {
                return;
            }
            g.this.f46081d = com.qq.e.comm.plugin.j0.b.a().a(hVar.f46090b, hVar.f46091c, hVar.f46092d, hVar.f46095g, hVar.f46093e, hVar.f46099k);
            g gVar = g.this;
            com.qq.e.comm.plugin.b.d a4 = gVar.a(gVar.f46078a);
            if (a4 == null) {
                return;
            }
            com.qq.e.comm.plugin.l0.d.a(a4, hVar.f46096h, new C0893a(a4.K()));
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.splash.g$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C0893a implements d.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f46084a;

            C0893a(boolean z3) {
                this.f46084a = z3;
            }

            @Override // com.qq.e.comm.plugin.l0.d.c
            public void a(JSONObject jSONObject) {
                if (g.this.c()) {
                    GDTLogger.d("SplashOnADLoadSuccess but timeout");
                    com.qq.e.comm.plugin.l0.e.a(g.this.f46078a == null ? null : g.this.f46078a.c(), 9000, this.f46084a);
                    return;
                }
                GDTLogger.d("SplashOnADLoadSuccess");
                g gVar = g.this;
                Pair a4 = gVar.a(jSONObject, gVar.f46078a, this.f46084a);
                if (a4 == null || g.this.c()) {
                    return;
                }
                if (((Integer) a4.first).intValue() != 0) {
                    g.this.a(new com.qq.e.comm.plugin.s.b("", ((Integer) a4.first).intValue()));
                } else {
                    c0 c0Var = (c0) ((List) a4.second).get(0);
                    j.c(c0Var);
                    g.this.f46079b.a((com.qq.e.comm.plugin.splash.r.e) c0Var);
                    g.this.a(5);
                }
                g.this.a(4);
            }

            @Override // com.qq.e.comm.plugin.l0.d.c
            public void a(com.qq.e.comm.plugin.s.b bVar) {
                if (!g.this.c()) {
                    g.this.a(bVar);
                    g.this.a(4);
                    return;
                }
                GDTLogger.d("LoadGDTSplashADFail but timeout");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        if (c()) {
            return;
        }
        if ((this.f46081d == null || this.f46081d.isEmpty()) && j.a(this.f46078a.f46091c) == i4) {
            b(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qq.e.comm.plugin.b.d a(h hVar) {
        if (hVar == null) {
            return null;
        }
        com.qq.e.comm.plugin.b.d dVar = new com.qq.e.comm.plugin.b.d();
        dVar.f(hVar.f46091c);
        dVar.g(hVar.f46092d);
        dVar.a(1);
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("splashReqAdCount", 1);
        GDTLogger.d("splashReqAdCount is " + a4);
        dVar.b(a4);
        dVar.c(2);
        dVar.l(hVar.f46093e.d());
        dVar.a(hVar.f46099k);
        dVar.e(hVar.f46097i);
        com.qq.e.comm.plugin.b.f a5 = com.qq.e.comm.plugin.b.e.a(hVar.f46093e, com.qq.e.comm.plugin.d0.a.d().c().f());
        dVar.m(a5.b());
        dVar.k(a5.a());
        dVar.g(hVar.f46105q ? 1 : 0);
        dVar.c(true);
        dVar.a(com.qq.e.comm.plugin.dl.i.a().a(hVar.f46093e));
        dVar.h(o.c(hVar.f46091c));
        LoadAdParams loadAdParams = hVar.f46098j;
        if (loadAdParams != null) {
            dVar.h(loadAdParams.getUin());
            dVar.d(hVar.f46098j.getLoginOpenid());
            dVar.c(hVar.f46098j.getLoginAppId());
            dVar.a(hVar.f46098j.getDevExtra());
        }
        List<c0> list = this.f46081d;
        if (list != null && list.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (c0 c0Var : list) {
                List<h0> s12 = c0Var.s1();
                if (s12 != null && s12.size() > 0) {
                    for (h0 h0Var : s12) {
                        List<Integer> b4 = h0Var.b();
                        if (b4 != null && b4.size() > 0) {
                            for (Integer num : b4) {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("ad_id", c0Var.k());
                                    jSONObject2.put(BidResponsedEx.KEY_CID, c0Var.o1());
                                    jSONObject2.put("uoid", c0Var.u1());
                                    jSONObject2.put("is_empty", c0Var.w1() ? 1 : 0);
                                    jSONObject2.put("is_contract", c0Var.Y0() ? 1 : 0);
                                    jSONObject.put(num.toString(), jSONObject2);
                                    GDTLogger.d("preload request wl add uoid:" + c0Var.u1());
                                } catch (JSONException unused) {
                                }
                            }
                        }
                    }
                }
            }
            dVar.c(jSONObject);
        } else {
            GDTLogger.d("preload is empty");
        }
        dVar.a(j.f());
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, List<c0>> a(JSONObject jSONObject, h hVar, boolean z3) {
        int length;
        if (jSONObject == null || hVar == null) {
            return null;
        }
        int optInt = jSONObject.optInt("ret");
        if (optInt != 0) {
            com.qq.e.comm.plugin.l0.e.a(hVar.c(), optInt, z3);
            return new Pair<>(Integer.valueOf(optInt), null);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            com.qq.e.comm.plugin.l0.e.a(hVar.c(), 5004, z3);
            return new Pair<>(5004, null);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(hVar.f46091c);
        if (optJSONObject2 == null) {
            com.qq.e.comm.plugin.l0.e.a(hVar.c(), 5004, z3);
            return new Pair<>(5004, null);
        }
        int optInt2 = optJSONObject2.optInt("ret");
        if (optInt2 != 0) {
            com.qq.e.comm.plugin.l0.e.a(hVar.c(), optInt2, z3);
            return new Pair<>(Integer.valueOf(optInt2), null);
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            com.qq.e.comm.plugin.l0.e.a(hVar.c(), length);
            List<JSONObject> a4 = com.qq.e.comm.plugin.util.c.a(optJSONArray, hVar.f46094f);
            if (a4.size() <= 0) {
                com.qq.e.comm.plugin.l0.e.a(5014, hVar.c(), length);
                return new Pair<>(5014, null);
            }
            int size = a4.size();
            c0 a5 = a(a4, hVar, this.f46081d);
            if (a5 == null) {
                com.qq.e.comm.plugin.l0.e.a(5047, hVar.c(), size);
                return new Pair<>(5047, null);
            }
            if (a5.w1()) {
                o.d(hVar.f46091c);
            }
            if (a5.x1() && a5.w1()) {
                v.a(1010025, hVar.c());
                a1.a(a5.O());
                return new Pair<>(5004, null);
            }
            com.qq.e.comm.plugin.l0.e.b(hVar.c(), this.f46080c == null ? 1 : 2);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(a5);
            return new Pair<>(0, arrayList);
        }
        com.qq.e.comm.plugin.l0.e.a(hVar.c(), 5025, z3);
        return new Pair<>(5025, null);
    }

    private c0 a(List<JSONObject> list, h hVar, List<c0> list2) {
        c0 c0Var = null;
        c0 c0Var2 = null;
        for (int i4 = 0; i4 < list.size(); i4++) {
            JSONObject jSONObject = list.get(i4);
            String optString = jSONObject.optString("uoid");
            if (TextUtils.isEmpty(optString)) {
                if (c0Var == null) {
                    c0Var = new c0(hVar.f46090b, hVar.f46091c, hVar.f46092d, hVar.f46095g, jSONObject, hVar.f46099k);
                    GDTLogger.d("preload \u83b7\u53d6\u5230\u5b9e\u65f6\u5e7f\u544a");
                }
            } else if (c0Var2 == null && list2 != null) {
                Iterator<c0> it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        c0 next = it.next();
                        if (optString.equals(next.u1())) {
                            next.b(jSONObject);
                            GDTLogger.d("preload \u83b7\u53d6\u5230\u9884\u52a0\u8f7d\u5e7f\u544a uoid:" + optString);
                            c0Var2 = next;
                            break;
                        }
                    }
                }
            }
        }
        if (c0Var == null) {
            return c0Var2;
        }
        this.f46080c = c0Var2;
        return c0Var;
    }
}
