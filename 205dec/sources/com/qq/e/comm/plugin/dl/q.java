package com.qq.e.comm.plugin.dl;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.dysi.IGDTBiz;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.x1;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q implements com.qq.e.comm.plugin.h.f {

    /* renamed from: q  reason: collision with root package name */
    protected static final String f42563q = "com.qq.e.comm.plugin.dl.q";

    /* renamed from: c  reason: collision with root package name */
    protected final com.qq.e.dl.l.l.b f42564c;

    /* renamed from: d  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.g0.e f42565d;

    /* renamed from: e  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.g0.y f42566e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.n0.c f42567f;

    /* renamed from: h  reason: collision with root package name */
    private h0.b f42569h;

    /* renamed from: j  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.q.e f42571j;

    /* renamed from: k  reason: collision with root package name */
    protected List<String> f42572k;

    /* renamed from: l  reason: collision with root package name */
    protected List<String> f42573l;

    /* renamed from: m  reason: collision with root package name */
    protected r f42574m;

    /* renamed from: n  reason: collision with root package name */
    private Set<com.qq.e.dl.l.h> f42575n;

    /* renamed from: g  reason: collision with root package name */
    protected final JSONObject f42568g = new JSONObject();

    /* renamed from: i  reason: collision with root package name */
    private boolean f42570i = true;

    /* renamed from: o  reason: collision with root package name */
    private final com.qq.e.comm.plugin.h.e f42576o = new com.qq.e.comm.plugin.h.e();

    /* renamed from: p  reason: collision with root package name */
    private boolean f42577p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements h0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h0.c f42578a;

        a(h0.c cVar) {
            this.f42578a = cVar;
        }

        @Override // com.qq.e.comm.plugin.dl.h0.c
        public void a(int i4) {
            com.qq.e.comm.plugin.b.g o4;
            h0.c cVar = this.f42578a;
            if (cVar != null) {
                cVar.a(i4);
            }
            com.qq.e.comm.plugin.g0.e eVar = q.this.f42565d;
            if (eVar != null && (o4 = eVar.o()) != null && !o4.g() && !o4.j() && !o4.k()) {
                q.this.a(i4);
            }
            d1.a(q.f42563q, "onPositionUpdate: position = %s", Integer.valueOf(i4));
        }

        @Override // com.qq.e.comm.plugin.dl.h0.c
        public void onPlayStateChange(f.t tVar, int i4) {
            IGDTBiz c4;
            d1.a(q.f42563q, "onPlayStateChange: state = %s, position = %s", tVar, Integer.valueOf(i4));
            h0.c cVar = this.f42578a;
            if (cVar != null) {
                cVar.onPlayStateChange(tVar, i4);
            }
            com.qq.e.comm.plugin.q.e eVar = q.this.f42571j;
            if (eVar == null || (c4 = eVar.c()) == null) {
                return;
            }
            c4.onPlayStateChange(tVar, i4);
        }
    }

    public q(com.qq.e.dl.l.l.b bVar, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.g0.y yVar) {
        this.f42564c = bVar;
        this.f42565d = eVar;
        this.f42566e = yVar;
        this.f42567f = com.qq.e.comm.plugin.n0.c.a(eVar, yVar);
        com.qq.e.dl.a a4 = bVar.a();
        a4.a(l.a(eVar, yVar));
        a4.b(com.qq.e.dl.j.f.a(l.a(eVar)));
        this.f42571j = com.qq.e.comm.plugin.q.e.a(this, bVar, eVar, yVar);
        a();
    }

    private void c(JSONObject jSONObject) {
        if (this.f42573l == null || this.f42571j == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject2 = new JSONObject();
            for (String str : this.f42573l) {
                Object opt = jSONObject.opt(str);
                if (!JSONObject.NULL.equals(opt)) {
                    jSONObject2.putOpt(str, opt);
                }
            }
            if (jSONObject2.length() > 0) {
                this.f42571j.d().onBindData(jSONObject2);
                com.qq.e.comm.plugin.q.i.a(System.currentTimeMillis() - currentTimeMillis, this.f42567f);
            }
        } catch (Exception e4) {
            d1.a(f42563q, "notifyOnBindDLInfoData error", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str, Object... objArr) {
        if (this.f42571j == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Object b4 = this.f42571j.b(com.qq.e.comm.plugin.q.e.a(str, objArr));
        com.qq.e.comm.plugin.q.i.a((int) (System.currentTimeMillis() - currentTimeMillis), this.f42567f, str);
        return b4;
    }

    public void b(String str) {
        List<String> list = this.f42572k;
        if (list != null && list.contains(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f42571j.d().onStartAnimation(str);
            com.qq.e.comm.plugin.q.i.b(System.currentTimeMillis() - currentTimeMillis, this.f42567f);
        }
        com.qq.e.dl.f.i a4 = this.f42564c.a(str);
        if (a4 != null) {
            a4.start();
        }
    }

    public com.qq.e.dl.a d() {
        return this.f42564c.a();
    }

    public h0.b e() {
        h0.b bVar = this.f42569h;
        if (bVar != null) {
            return bVar;
        }
        if (this.f42570i) {
            this.f42569h = (h0.b) this.f42564c.getRootView().findViewWithTag("GDTDLVideoView");
            this.f42570i = false;
        }
        return this.f42569h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IGDTBiz f() {
        com.qq.e.comm.plugin.q.e eVar = this.f42571j;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.h.f
    public com.qq.e.comm.plugin.h.e g() {
        return this.f42576o;
    }

    public com.qq.e.comm.plugin.g0.y h() {
        return this.f42566e;
    }

    public com.qq.e.comm.plugin.o0.h.f i() {
        if (e() == null) {
            return null;
        }
        return e().b();
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return this.f42577p;
    }

    public View j() {
        return this.f42564c.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.qq.e.dl.l.l.b k() {
        return this.f42564c;
    }

    public boolean l() {
        IGDTBiz f4 = f();
        return f4 != null && f4.isTimerTickEnable();
    }

    public void b() {
        com.qq.e.comm.plugin.q.e eVar = this.f42571j;
        if (eVar != null) {
            eVar.b();
        }
        this.f42577p = true;
    }

    public void a(JSONObject jSONObject) {
        if (com.qq.e.comm.plugin.util.k0.a(jSONObject)) {
            return;
        }
        try {
            c(jSONObject);
            this.f42568g.putOpt("dlInfo", jSONObject);
            this.f42564c.a(this.f42568g);
        } catch (JSONException unused) {
        }
    }

    public void b(JSONObject jSONObject) {
        r rVar = this.f42574m;
        if (rVar == null) {
            return;
        }
        rVar.a(jSONObject);
    }

    public void a(r rVar) {
        this.f42574m = rVar;
        this.f42564c.a(rVar);
    }

    public void b(com.qq.e.dl.l.j.c cVar) {
        r rVar = this.f42574m;
        if (rVar == null) {
            return;
        }
        rVar.g(cVar);
    }

    public void a(com.qq.e.dl.h.b bVar) {
        this.f42564c.a(bVar);
    }

    private void c(com.qq.e.dl.l.h hVar) {
        if (b(hVar)) {
            a(hVar);
        }
        if (hVar instanceof com.qq.e.dl.l.k.d) {
            for (com.qq.e.dl.l.h hVar2 : ((com.qq.e.dl.l.k.d) hVar).x()) {
                c(hVar2);
            }
        }
    }

    public void a(String str) {
        this.f42564c.a(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.qq.e.dl.l.h r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L42
            java.util.List r1 = r5.h()
            int r1 = r1.size()
            if (r1 != 0) goto Le
            goto L42
        Le:
            java.util.List r5 = r5.h()
            java.util.Iterator r5 = r5.iterator()
        L16:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L42
            java.lang.Object r1 = r5.next()
            com.qq.e.dl.l.j.c r1 = (com.qq.e.dl.l.j.c) r1
            java.lang.String r2 = r1.f47121b
            java.lang.String r3 = "adClose"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L40
            java.lang.String r2 = r1.f47121b
            java.lang.String r3 = "endCardClose"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L40
            java.lang.String r1 = r1.f47121b
            java.lang.String r2 = "forceCloseAd"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L16
        L40:
            r5 = 1
            return r5
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dl.q.b(com.qq.e.dl.l.h):boolean");
    }

    public void a(h0.c cVar) {
        a("initVideo");
        h0.b e4 = e();
        if (e4 == null) {
            return;
        }
        e4.a(new a(cVar));
    }

    public Set<com.qq.e.dl.l.h> c() {
        return this.f42575n;
    }

    protected void a() {
        com.qq.e.comm.plugin.util.j0 j0Var = new com.qq.e.comm.plugin.util.j0();
        j0Var.a("adModel", this.f42565d);
        a(j0Var);
        c(j0Var.a());
        this.f42564c.a(new com.qq.e.comm.plugin.util.j0(this.f42565d.m()).a("posID", this.f42565d.q0()).a("dlInfo", j0Var.a()).a());
        c(((com.qq.e.dl.l.l.d) this.f42564c).d());
    }

    private void a(com.qq.e.comm.plugin.util.j0 j0Var) {
        a(j0Var.a(), this.f42565d);
    }

    public static void a(JSONObject jSONObject, com.qq.e.comm.plugin.g0.e eVar) {
        Object B;
        try {
            jSONObject.put("safeArea", com.qq.e.comm.plugin.d0.a.d().c().x() ? 10 : 1);
            jSONObject.put("widgetVis", TextUtils.isEmpty(eVar.Q0()) ? 2 : 0);
            String a4 = com.qq.e.comm.plugin.f0.f.a(eVar);
            if (TextUtils.isEmpty(a4)) {
                jSONObject.put("appInfoVis", 2);
            } else {
                jSONObject.put("miitInfo", a4);
            }
            com.qq.e.comm.plugin.b.g o4 = eVar.o();
            if (o4.k()) {
                B = com.qq.e.comm.plugin.y.a.b(eVar);
            } else if (o4.h()) {
                B = com.qq.e.comm.plugin.y.a.a(eVar);
            } else {
                B = eVar.B();
            }
            jSONObject.put("gxbText", B);
            jSONObject.put("complianceText", eVar.C());
            if (eVar.X0()) {
                if (eVar.q() != null) {
                    Pair<String, String> a5 = x1.a(eVar.q().f());
                    jSONObject.put("pkgSize", a5.first);
                    jSONObject.put("pkgSizeUnit", a5.second);
                }
                JSONArray jSONArray = new JSONArray();
                List<String> A0 = eVar.A0();
                if (A0.size() != 0) {
                    for (String str : A0) {
                        jSONArray.put(new JSONObject().put("screenshot_url", str));
                    }
                } else {
                    jSONArray.put(new JSONObject().put("screenshot_url", eVar.X()));
                }
                jSONObject.put("screenshots", jSONArray);
            }
        } catch (JSONException e4) {
            d1.a(f42563q, "prepareDLInfo error", e4);
        }
    }

    public void a(List<String> list, List<String> list2) {
        this.f42573l = list;
        this.f42572k = list2;
    }

    public void a(long j4) {
        com.qq.e.comm.plugin.q.e eVar = this.f42571j;
        if (eVar == null) {
            return;
        }
        eVar.a(j4);
        IGDTBiz c4 = this.f42571j.c();
        if (c4 == null) {
            return;
        }
        c4.onTimerTick(j4);
    }

    public void a(com.qq.e.comm.plugin.i.f fVar) {
        r rVar = this.f42574m;
        if (rVar == null) {
            return;
        }
        rVar.a(fVar, (com.qq.e.dl.l.j.c) null);
    }

    public void a(com.qq.e.dl.l.j.c cVar) {
        r rVar = this.f42574m;
        if (rVar == null) {
            return;
        }
        rVar.d(cVar);
    }

    private void a(com.qq.e.dl.l.h hVar) {
        if (this.f42575n == null) {
            this.f42575n = new HashSet();
        }
        this.f42575n.add(hVar);
    }
}
