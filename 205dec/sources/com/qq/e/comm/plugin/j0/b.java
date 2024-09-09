package com.qq.e.comm.plugin.j0;

import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.b.e;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.b.l;
import com.qq.e.comm.plugin.b.m;
import com.qq.e.comm.plugin.b0.f;
import com.qq.e.comm.plugin.dl.i;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.g0.h0;
import com.qq.e.comm.plugin.l0.d;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.p.h;
import com.qq.e.comm.plugin.splash.j;
import com.qq.e.comm.plugin.splash.o;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.comm.plugin.j0.a {

    /* renamed from: e  reason: collision with root package name */
    private static final b f44496e = new b();

    /* renamed from: b  reason: collision with root package name */
    private long f44498b;

    /* renamed from: c  reason: collision with root package name */
    private String f44499c;

    /* renamed from: a  reason: collision with root package name */
    private final Object f44497a = new Object();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Long> f44500d = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f44501a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f44502b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f44503c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f44504d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f44505e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ m f44506f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f44507g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f44508h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f44509i;

        a(g gVar, l lVar, String str, String str2, String str3, m mVar, String str4, int i4, com.qq.e.comm.plugin.n0.c cVar) {
            this.f44501a = gVar;
            this.f44502b = lVar;
            this.f44503c = str;
            this.f44504d = str2;
            this.f44505e = str3;
            this.f44506f = mVar;
            this.f44507g = str4;
            this.f44508h = i4;
            this.f44509i = cVar;
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(JSONObject jSONObject) {
            b.this.a(jSONObject, this.f44501a, this.f44502b, this.f44503c, this.f44504d, this.f44505e, this.f44506f, this.f44507g, this.f44508h);
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            GDTLogger.e("\u9884\u52a0\u8f7d\u5931\u8d25\uff01", bVar);
            v.a(1012004, this.f44509i, Integer.valueOf(this.f44508h));
        }
    }

    private b() {
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f44500d.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static b a() {
        return f44496e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.j0.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0852b implements com.qq.e.comm.plugin.b0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f44511a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f44512b;

        C0852b(b bVar, com.qq.e.comm.plugin.n0.c cVar, int i4) {
            this.f44511a = cVar;
            this.f44512b = i4;
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
            v.a(1012015, this.f44511a, Integer.valueOf(this.f44512b));
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, f fVar) {
            if (fVar.a()) {
                v.a(1012012, this.f44511a, Integer.valueOf(this.f44512b));
            } else {
                v.a(1012014, this.f44511a, Integer.valueOf(this.f44512b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c extends h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f44513a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f44514b;

        c(b bVar, com.qq.e.comm.plugin.n0.c cVar, int i4) {
            this.f44513a = cVar;
            this.f44514b = i4;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            v.a(1012017, this.f44513a, Integer.valueOf(this.f44514b));
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            v.a(1012016, this.f44513a, Integer.valueOf(this.f44514b));
        }
    }

    public void a(String str) {
        this.f44499c = str;
    }

    public void a(g gVar, l lVar, String str, String str2, String str3, m mVar, String str4, LoadAdParams loadAdParams, int i4) {
        com.qq.e.comm.plugin.n0.c c4 = new com.qq.e.comm.plugin.n0.c().c(str2);
        v.a(1012001, c4, Integer.valueOf(i4));
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("preloadNetwork", -1);
        com.qq.e.comm.plugin.d0.e.d n4 = com.qq.e.comm.plugin.d0.a.d().c().n();
        if ((a4 & n4.c()) <= 0) {
            v.b(100052, c4, Integer.valueOf(n4.c()));
            GDTLogger.w("\u5f53\u524d\u8bbe\u5907\u7684\u7f51\u7edc\u7c7b\u578b\u4e0d\u7b26\u5408\u9884\u52a0\u8f7d\u5e7f\u544a\u7684\u6761\u4ef6\uff0c\u8bf7\u5c1d\u8bd5WIFI\u73af\u5883\u3002\u5982\u4ecd\u6709\u95ee\u9898\u8bf7\u8054\u7cfb\u5ba2\u670d");
            return;
        }
        d1.a("preload \u5f00\u59cb", new Object[0]);
        v.a(1012003, c4, Integer.valueOf(i4));
        com.qq.e.comm.plugin.l0.b bVar = new com.qq.e.comm.plugin.l0.b(gVar, str2);
        com.qq.e.comm.plugin.b.d dVar = new com.qq.e.comm.plugin.b.d();
        dVar.n(1);
        dVar.f(str2);
        dVar.g(str3);
        dVar.a(1);
        dVar.b(com.qq.e.comm.plugin.d0.a.d().f().a("splashPreloadAdCount", 10));
        dVar.c(2);
        dVar.l(gVar.d());
        dVar.a(lVar);
        dVar.e(this.f44499c);
        dVar.a(i.a().a(gVar));
        com.qq.e.comm.plugin.b.f a5 = e.a(gVar, com.qq.e.comm.plugin.d0.a.d().c().f());
        dVar.m(a5.b());
        dVar.k(a5.a());
        dVar.h(o.c(str2));
        if (loadAdParams != null) {
            dVar.h(loadAdParams.getUin());
            dVar.d(loadAdParams.getLoginOpenid());
            dVar.c(loadAdParams.getLoginAppId());
            dVar.a(loadAdParams.getDevExtra());
        }
        dVar.a(j.f());
        d.a(dVar, bVar, new a(gVar, lVar, str, str2, str3, mVar, str4, i4, c4));
    }

    public void b(g gVar, l lVar, String str, String str2, String str3, m mVar, String str4, LoadAdParams loadAdParams, int i4) {
        com.qq.e.comm.plugin.n0.c c4 = new com.qq.e.comm.plugin.n0.c().c(str2);
        if (!o.a(str2)) {
            GDTLogger.e("preload \u9884\u52a0\u8f7d\u8c03\u7528\u8fc7\u4e8e\u9891\u7e41");
            v.a(1012002, c4);
            return;
        }
        a(gVar, lVar, str, str2, str3, mVar, str4, loadAdParams, i4);
    }

    public List<c0> b(String str, String str2, String str3, String str4, g gVar, l lVar) {
        return a(str, str2, str3, str4, gVar, lVar, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, g gVar, l lVar, String str, String str2, String str3, m mVar, String str4, int i4) {
        a(jSONObject, gVar, lVar, str, str2, str3, mVar, str4, (c0) null, i4);
    }

    private void a(JSONObject jSONObject, g gVar, l lVar, String str, String str2, String str3, m mVar, String str4, c0 c0Var, int i4) {
        int length;
        com.qq.e.comm.plugin.n0.c cVar;
        int i5;
        c0 c0Var2;
        com.qq.e.comm.plugin.n0.c a4 = new com.qq.e.comm.plugin.n0.c().c(str2).a(gVar);
        if (jSONObject.optInt("ret") != 0) {
            v.a(1012005, a4, Integer.valueOf(i4));
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            v.a(1012005, a4, Integer.valueOf(i4));
            return;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
        if (optJSONObject2 == null) {
            v.a(1012005, a4, Integer.valueOf(i4));
            return;
        }
        int optInt = optJSONObject2.optInt("ret");
        if (optInt != 0) {
            v.a(1012005, a4, Integer.valueOf(i4));
            d1.a("preload data error code = " + optInt, new Object[0]);
            return;
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            for (int i6 = 0; i6 < length; i6++) {
                i.a().a(g.SPLASH, optJSONArray.optJSONObject(i6));
            }
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("cnt", Integer.valueOf(length));
            v.a(1012006, a4, Integer.valueOf(i4), 0, dVar);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("list", optJSONArray);
                a(str2, jSONObject2);
            } catch (JSONException e4) {
                d1.a(e4.getMessage(), e4);
            }
            synchronized (this.f44497a) {
                File h4 = b1.h(str2);
                if (h4.exists()) {
                    b1.a(h4);
                    v.a(1012007, a4, Integer.valueOf(i4));
                }
                if (!h4.mkdirs()) {
                    d1.a("preload create cache dir error", new Object[0]);
                }
                o.e(str2);
                this.f44500d.clear();
                d1.a("preload \u5199\u5165\u5e7f\u544a\u6570\u636e", new Object[0]);
                b1.c(b1.f(str2), jSONObject2.toString());
                v.a(1012008, a4, Integer.valueOf(i4));
            }
            int i7 = 0;
            while (i7 < optJSONArray.length()) {
                JSONArray jSONArray = optJSONArray;
                c0 c0Var3 = new c0(str, str2, str3, str4, optJSONArray.optJSONObject(i7), lVar);
                if (TextUtils.isEmpty(c0Var3.p1()) || TextUtils.isEmpty(c0Var3.r1()) || str2.equals(c0Var3.p1())) {
                    cVar = a4;
                    i5 = 0;
                } else {
                    i5 = 0;
                    cVar = a4;
                    a(jSONObject, gVar, lVar, str, c0Var3.p1(), str3, mVar, str4, c0Var3, i4);
                }
                d1.a("preload uoid:" + c0Var3.u1() + " \u4e0b\u8f7d\u56fe\u7247:" + b1.e(c0Var3.X()), new Object[i5]);
                com.qq.e.comm.plugin.n0.c cVar2 = cVar;
                v.a(1012013, cVar2);
                com.qq.e.comm.plugin.b0.b.a().a(c0Var3.X(), new C0852b(this, cVar2, i4));
                if (TextUtils.isEmpty(c0Var3.L0())) {
                    c0Var2 = c0Var3;
                } else {
                    d1.a("preload \u4e0b\u8f7d\u89c6\u9891:" + b1.d(c0Var3.L0()), new Object[i5]);
                    v.a(1012011, cVar2, Integer.valueOf(i4));
                    c0Var2 = c0Var3;
                    a(c0Var2, cVar2, i4);
                }
                if (c0Var != null && c0Var.q1() == null && c0Var2.q0().equals(c0Var.p1()) && c0Var2.u1().equals(c0Var.r1())) {
                    c0Var.a(c0Var2);
                    return;
                }
                i7++;
                a4 = cVar2;
                optJSONArray = jSONArray;
            }
            return;
        }
        v.a(1012005, a4, Integer.valueOf(i4));
        a(2011007, a4, this.f44498b);
        d1.a("preload data error ad list length = 0", new Object[0]);
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.n0.c cVar, int i4) {
        if ((com.qq.e.comm.plugin.d0.a.d().f().a("preloadResNetwork", -1) & com.qq.e.comm.plugin.d0.a.d().c().n().c()) <= 0) {
            GDTLogger.w("\u5f53\u524d\u8bbe\u5907\u7684\u7f51\u7edc\u7c7b\u578b\u4e0d\u7b26\u5408\u9884\u52a0\u8f7d\u5e7f\u544a\u8d44\u6e90\u7684\u6761\u4ef6\uff0c\u8bf7\u5c1d\u8bd5WIFI\u73af\u5883\u3002\u5982\u4ecd\u6709\u95ee\u9898\u8bf7\u8054\u7cfb\u5ba2\u670d");
            v.a(1012010, cVar, Integer.valueOf(i4));
            return;
        }
        String L0 = eVar.L0();
        File p3 = b1.p();
        String d4 = b1.d(L0);
        File c4 = b1.c(L0);
        if (c4 == null || !c4.exists()) {
            b.C0867b a4 = new b.C0867b().d(L0).a(p3).a(d4).a(cVar);
            b.C0867b c5 = a4.c(com.qq.e.comm.plugin.util.v2.a.b("vcrp") + eVar.o().d());
            if (com.qq.e.comm.plugin.util.v2.a.d(eVar)) {
                double H = eVar.H();
                if (com.qq.e.comm.plugin.util.v2.a.a(H)) {
                    v.a(1400014, cVar);
                    return;
                } else if (com.qq.e.comm.plugin.util.v2.a.b(H)) {
                    c5.a(com.qq.e.comm.plugin.util.v2.a.a(H, eVar.M0()));
                }
            }
            com.qq.e.comm.plugin.o0.g.a.a().a(c5.a(), new c(this, cVar, i4));
        }
    }

    private static boolean a(c0 c0Var) {
        return new File(b1.b(), b1.e(c0Var.X())).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0124 A[EDGE_INSN: B:58:0x0124->B:53:0x0124 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.qq.e.comm.plugin.g0.c0> a(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.qq.e.comm.plugin.b.g r22, com.qq.e.comm.plugin.b.l r23, com.qq.e.comm.plugin.g0.c0 r24) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.j0.b.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.qq.e.comm.plugin.b.g, com.qq.e.comm.plugin.b.l, com.qq.e.comm.plugin.g0.c0):java.util.List");
    }

    public static List<c0> a(List<c0> list) {
        int i4;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        if (list == null || list.size() <= 0) {
            i4 = 0;
        } else {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTime());
            i4 = 0;
            int i6 = 0;
            for (c0 c0Var : list) {
                if (a(c0Var)) {
                    ArrayList arrayList2 = new ArrayList();
                    List<h0> s12 = c0Var.s1();
                    if (s12 == null || s12.size() <= 0) {
                        z3 = false;
                    } else {
                        z3 = false;
                        for (h0 h0Var : s12) {
                            if (format.equals(h0Var.a())) {
                                arrayList2.add(h0Var);
                                z3 = true;
                            }
                        }
                    }
                    if (!z3 || com.qq.e.comm.plugin.util.c.c(c0Var)) {
                        i6++;
                    } else {
                        c0Var.a(arrayList2);
                        arrayList.add(c0Var);
                    }
                } else {
                    i4++;
                }
            }
            i5 = i6;
        }
        if (arrayList.size() == 0) {
            v.a(1013011, null, Integer.valueOf(i4), Integer.valueOf(i5), null);
        }
        return arrayList;
    }

    public List<c0> a(String str, String str2, String str3, String str4, g gVar, l lVar) {
        List<c0> b4 = b(str, str2, str3, str4, gVar, lVar);
        List<c0> a4 = a(b4);
        if (b4.size() > 0 && a4.size() <= 0) {
            a(2011008, new com.qq.e.comm.plugin.n0.c().c(str2), this.f44498b);
        }
        return a4;
    }

    public void a(long j4) {
        this.f44498b = j4;
    }

    private static void a(int i4, com.qq.e.comm.plugin.n0.c cVar, long j4) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(i4);
        hVar.b(j4);
        hVar.b(0);
        hVar.a(cVar);
        v.a(hVar);
    }
}
