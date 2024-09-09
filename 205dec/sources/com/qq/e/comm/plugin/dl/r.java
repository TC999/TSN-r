package com.qq.e.comm.plugin.dl;

import android.text.TextUtils;
import com.qq.e.comm.plugin.f0.g;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.k2;
import com.qq.e.comm.plugin.util.o2;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.x1;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class r implements com.qq.e.dl.l.d {

    /* renamed from: i  reason: collision with root package name */
    private static final String f42580i = "r";

    /* renamed from: j  reason: collision with root package name */
    private static final String f42581j = x1.a("anNlcw");

    /* renamed from: k  reason: collision with root package name */
    private static final String f42582k = x1.a("anNlcA");

    /* renamed from: l  reason: collision with root package name */
    private static final String f42583l = x1.a("Y2pzbQ");

    /* renamed from: m  reason: collision with root package name */
    private static final String f42584m = x1.a("anNlZQ");

    /* renamed from: c  reason: collision with root package name */
    private final q f42585c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.dl.l.l.b f42586d;

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f42587e;

    /* renamed from: f  reason: collision with root package name */
    private final g.b f42588f;

    /* renamed from: g  reason: collision with root package name */
    protected final List<d> f42589g;

    /* renamed from: h  reason: collision with root package name */
    private com.qq.e.dl.l.j.c f42590h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.dl.l.j.c f42591c;

        a(com.qq.e.dl.l.j.c cVar) {
            this.f42591c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.d(this.f42591c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.f f42593c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.dl.l.j.c f42594d;

        b(com.qq.e.comm.plugin.i.f fVar, com.qq.e.dl.l.j.c cVar) {
            this.f42593c = fVar;
            this.f42594d = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.a(this.f42593c, this.f42594d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements d {

        /* renamed from: a  reason: collision with root package name */
        private final Set<String> f42596a;

        public c(Set<String> set) {
            this.f42596a = set;
        }

        @Override // com.qq.e.comm.plugin.dl.r.d
        public boolean a(int i4) {
            if (this.f42596a.isEmpty()) {
                d1.a(r.f42580i, "BXGClickEventInterceptor isIntercept = false, control server is empty");
                return false;
            } else if (i4 <= 0) {
                d1.a(r.f42580i, "BXGClickEventInterceptor isIntercept = false, componentId <= 0");
                return false;
            } else {
                return !this.f42596a.contains(String.valueOf(i4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface d {
        boolean a(int i4);
    }

    public r(q qVar, com.qq.e.comm.plugin.g0.e eVar) {
        this(qVar, eVar, null);
    }

    private void n(com.qq.e.dl.l.j.c cVar) {
        int a4 = cVar.a();
        for (d dVar : this.f42589g) {
            if (dVar.a(a4)) {
                return;
            }
        }
        b(cVar);
    }

    @Override // com.qq.e.dl.l.d
    public boolean b(com.qq.e.dl.l.h hVar, com.qq.e.dl.l.j.c cVar) {
        JSONObject jSONObject = cVar.f47122c;
        d1.a("handleEvent: eventType: %s, eventAction: %s, eventParams: %s, eventTarget: %s", Integer.valueOf(cVar.f47120a), cVar.f47121b, jSONObject, cVar.f47123d);
        String a4 = a(hVar, jSONObject, f42583l);
        if (a4 == null) {
            a4 = cVar.f47121b;
        } else if (a4.length() == 0) {
            this.f42590h = cVar;
            return true;
        }
        return a(a4, cVar);
    }

    public void c() {
    }

    @Override // com.qq.e.dl.l.d
    public void c(com.qq.e.dl.l.h hVar, com.qq.e.dl.l.j.c cVar) {
        a(hVar, cVar.f47122c, f42584m);
    }

    public void c(com.qq.e.dl.l.j.c cVar) {
    }

    public void d(com.qq.e.dl.l.j.c cVar) {
    }

    public void e(com.qq.e.dl.l.j.c cVar) {
    }

    public void f(com.qq.e.dl.l.j.c cVar) {
    }

    public void g(com.qq.e.dl.l.j.c cVar) {
    }

    public void h(com.qq.e.dl.l.j.c cVar) {
    }

    public void i(com.qq.e.dl.l.j.c cVar) {
        com.qq.e.comm.plugin.f0.f.a(a(cVar), this.f42588f);
    }

    public void j(com.qq.e.dl.l.j.c cVar) {
        this.f42586d.a(cVar.f47121b, cVar.f47122c);
    }

    public void k(com.qq.e.dl.l.j.c cVar) {
    }

    public void l(com.qq.e.dl.l.j.c cVar) {
    }

    public void m(com.qq.e.dl.l.j.c cVar) {
    }

    public r(q qVar, com.qq.e.comm.plugin.g0.e eVar, g.b bVar) {
        this.f42585c = qVar;
        this.f42586d = qVar.k();
        this.f42587e = eVar;
        this.f42588f = bVar;
        this.f42589g = new CopyOnWriteArrayList();
        b();
    }

    @Override // com.qq.e.dl.l.d
    public void a(com.qq.e.dl.l.h hVar, com.qq.e.dl.l.j.c cVar) {
        a(hVar, cVar.f47122c, f42581j);
    }

    @Override // com.qq.e.dl.l.d
    public void a(com.qq.e.dl.l.h hVar, com.qq.e.dl.l.j.c cVar, float f4) {
        a(hVar, cVar.f47122c, f42582k);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean a(String str, com.qq.e.dl.l.j.c cVar) {
        char c4;
        boolean z3 = false;
        switch (str.hashCode()) {
            case -1936979796:
                if (str.equals("popupClose")) {
                    c4 = 11;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1625740791:
                if (str.equals("showLandingPage")) {
                    c4 = 15;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1178343643:
                if (str.equals("adClick")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1178337387:
                if (str.equals("adClose")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case -841999016:
                if (str.equals("ctaClick")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case -682345939:
                if (str.equals("endCardClose")) {
                    c4 = '\r';
                    break;
                }
                c4 = '\uffff';
                break;
            case -264639046:
                if (str.equals("adLogoClick")) {
                    c4 = 6;
                    break;
                }
                c4 = '\uffff';
                break;
            case -155481098:
                if (str.equals("popupSucceed")) {
                    c4 = '\t';
                    break;
                }
                c4 = '\uffff';
                break;
            case 94750088:
                if (str.equals("click")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 94756344:
                if (str.equals("close")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 158711817:
                if (str.equals("popupFailed")) {
                    c4 = '\n';
                    break;
                }
                c4 = '\uffff';
                break;
            case 976974752:
                if (str.equals("gameEntry")) {
                    c4 = '\b';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1046787284:
                if (str.equals("replayVideo")) {
                    c4 = 14;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1148342887:
                if (str.equals("stopAutoAction")) {
                    c4 = 16;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1372735184:
                if (str.equals("forceCloseAd")) {
                    c4 = '\f';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1522058230:
                if (str.equals("miitActivity")) {
                    c4 = 5;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1756742202:
                if (str.equals("volumeChanged")) {
                    c4 = 7;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        switch (c4) {
            case 0:
                z3 = true;
            case 1:
                a(cVar, z3);
                break;
            case 2:
                p0.a((Runnable) new a(cVar));
                break;
            case 3:
                n(cVar);
                break;
            case 4:
                c(cVar);
                break;
            case 5:
                i(cVar);
                break;
            case 6:
                e(cVar);
                break;
            case 7:
                c();
                break;
            case '\b':
                h(cVar);
                break;
            case '\t':
            case '\n':
            case 11:
                j(cVar);
                break;
            case '\f':
                g(cVar);
                break;
            case '\r':
                f(cVar);
                break;
            case 14:
                k(cVar);
                break;
            case 15:
                l(cVar);
                break;
            case 16:
                m(cVar);
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean b(com.qq.e.dl.l.h hVar) {
        if (hVar == null) {
            return false;
        }
        while (hVar != null) {
            if (!hVar.t() || hVar.m().getAlpha() == 0.0f) {
                return false;
            }
            hVar = hVar.o();
        }
        return true;
    }

    public void b(com.qq.e.dl.l.j.c cVar) {
        int i4 = cVar.f47120a;
        if (i4 == 5 || i4 == 8) {
            k2.a();
        }
    }

    public void b() {
        this.f42589g.add(new c(com.qq.e.comm.plugin.dl.c.a(a((com.qq.e.dl.l.j.c) null))));
    }

    private com.qq.e.comm.plugin.i.f a(com.qq.e.dl.l.j.c cVar, int i4) {
        JSONObject jSONObject = cVar.f47122c;
        com.qq.e.comm.plugin.i.f fVar = new com.qq.e.comm.plugin.i.f(a(cVar));
        fVar.f44110g = a(jSONObject, cVar.f47120a);
        fVar.f44109f = jSONObject.optInt("ca", -999);
        fVar.f44106c = cVar.a();
        fVar.f44108e = i4;
        fVar.f44114k = jSONObject.optInt("viewIndex", -1);
        int i5 = cVar.f47120a;
        boolean z3 = false;
        if (i5 == 5) {
            fVar.f44111h = (float[]) jSONObject.opt("shakeMaxAcceleration");
        } else if (i5 == 8) {
            fVar.f44112i = new int[]{jSONObject.optInt("tx"), jSONObject.optInt("ty"), jSONObject.optInt("tz")};
            fVar.f44113j = jSONObject.optLong("nt", -999L);
        }
        fVar.f44115l = jSONObject;
        a(fVar);
        int i6 = cVar.f47120a;
        if (i6 == 5 || i6 == 8) {
            fVar.f44118o = jSONObject.optLong("motionDuration", -999L);
        }
        int a4 = this.f42586d.a().a();
        fVar.f44119p = (a4 == 2 || a4 == 1) ? true : true;
        return fVar;
    }

    private void a(com.qq.e.comm.plugin.i.f fVar) {
        Set<com.qq.e.dl.l.h> c4 = this.f42585c.c();
        if (c4 == null || c4.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        int[] iArr = new int[2];
        this.f42586d.getRootView().getLocationOnScreen(iArr);
        for (com.qq.e.dl.l.h hVar : c4) {
            if (b(hVar)) {
                int[] iArr2 = new int[2];
                hVar.m().getLocationOnScreen(iArr2);
                com.qq.e.comm.plugin.util.j0 j0Var = new com.qq.e.comm.plugin.util.j0();
                j0Var.a("cvx", String.valueOf(com.qq.e.dl.j.f.b(iArr2[0] - iArr[0])));
                j0Var.a("cvy", String.valueOf(com.qq.e.dl.j.f.b(iArr2[1] - iArr[1])));
                j0Var.a("cvw", String.valueOf(com.qq.e.dl.j.f.b(hVar.m().getWidth())));
                j0Var.a("cvh", String.valueOf(com.qq.e.dl.j.f.b(hVar.m().getHeight())));
                j0Var.a("cvt", String.valueOf(a(hVar)));
                j0Var.a("cvv", ((Boolean) o2.a(hVar.m(), 50, -1).first).booleanValue() ? "1" : "-1");
                jSONArray.put(j0Var.a());
            }
        }
        if (jSONArray.length() >= 0) {
            fVar.f44117n = jSONArray;
        }
    }

    private int a(com.qq.e.dl.l.h hVar) {
        if (hVar == null) {
            return -1;
        }
        for (com.qq.e.dl.l.j.c cVar : hVar.h()) {
            if ("adClose".equals(cVar.f47121b)) {
                return 1;
            }
            if ("endCardClose".equals(cVar.f47121b)) {
                return 2;
            }
            if ("forceCloseAd".equals(cVar.f47121b)) {
                return 3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.g0.e a(com.qq.e.dl.l.j.c cVar) {
        if (cVar == null) {
            return this.f42587e;
        }
        com.qq.e.comm.plugin.g0.e a4 = this.f42587e.a(cVar.f47122c.optString("tid"));
        return a4 != null ? a4 : this.f42587e;
    }

    private int a(JSONObject jSONObject, int i4) {
        int optInt = jSONObject.optInt("sld", -999);
        if (optInt != -999) {
            return optInt;
        }
        if (i4 == 1) {
            return com.qq.e.dl.l.j.b.a(jSONObject) ? 4 : 0;
        } else if (i4 == 5) {
            return 2;
        } else {
            if (i4 == 4) {
                return 1;
            }
            if (i4 == 8) {
                return 5;
            }
            return optInt;
        }
    }

    public void a(com.qq.e.comm.plugin.i.f fVar, com.qq.e.dl.l.j.c cVar) {
        if (cVar != null) {
            int i4 = cVar.f47120a;
            if (i4 == 5 || i4 == 8) {
                k2.a();
            }
        }
    }

    private String a(com.qq.e.dl.l.h hVar, JSONObject jSONObject, String str) {
        Object a4;
        if (jSONObject.length() > 0) {
            String optString = jSONObject.optString(str);
            if (TextUtils.isEmpty(optString) || (a4 = this.f42585c.a(optString, jSONObject)) == null) {
                return null;
            }
            return a4.toString();
        }
        return null;
    }

    private void a(com.qq.e.dl.l.j.c cVar, boolean z3) {
        int i4 = -1;
        if (z3) {
            com.qq.e.comm.plugin.g0.e a4 = a(cVar);
            if (a4.z() != null) {
                i4 = a4.z().e();
            }
        }
        com.qq.e.comm.plugin.i.f a5 = a(cVar, i4);
        for (d dVar : this.f42589g) {
            if (dVar.a(a5.f44106c)) {
                return;
            }
        }
        p0.a((Runnable) new b(a5, cVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        com.qq.e.dl.l.j.c cVar = this.f42590h;
        this.f42590h = null;
        if (cVar == null) {
            return;
        }
        a(cVar.f47121b, cVar);
    }
}
