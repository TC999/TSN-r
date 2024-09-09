package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.dl.a0;
import com.qq.e.comm.plugin.dl.b0;
import com.qq.e.comm.plugin.dl.c0;
import com.qq.e.comm.plugin.dl.d0;
import com.qq.e.comm.plugin.dl.e0;
import com.qq.e.comm.plugin.dl.f0;
import com.qq.e.comm.plugin.dl.g0;
import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.dl.i0;
import com.qq.e.comm.plugin.dl.j0;
import com.qq.e.comm.plugin.dl.n;
import com.qq.e.comm.plugin.dl.t;
import com.qq.e.comm.plugin.dl.u;
import com.qq.e.comm.plugin.dl.v;
import com.qq.e.comm.plugin.dl.w;
import com.qq.e.comm.plugin.dl.x;
import com.qq.e.comm.plugin.dl.y;
import com.qq.e.comm.plugin.dl.z;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f42461j;

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f42462k;

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.dl.l.g f42463a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<String, com.qq.e.comm.plugin.g0.y> f42464b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, com.qq.e.comm.plugin.g0.y> f42465c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.dl.i.f f42466d;

    /* renamed from: e  reason: collision with root package name */
    private final n0 f42467e;

    /* renamed from: f  reason: collision with root package name */
    private final com.qq.e.dl.i.f f42468f;

    /* renamed from: g  reason: collision with root package name */
    private final m f42469g;

    /* renamed from: h  reason: collision with root package name */
    private final com.qq.e.dl.b f42470h;

    /* renamed from: i  reason: collision with root package name */
    private final com.qq.e.dl.d f42471i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final i f42472a = new i();
    }

    static {
        f42461j = (com.qq.e.comm.plugin.d0.a.d().f().a("to", 15) & 32) != 0;
        f42462k = com.qq.e.comm.plugin.t.c.a("ftp", "APP", "", 0) == 0;
    }

    public static i a() {
        return b.f42472a;
    }

    public void b(com.qq.e.comm.plugin.b.g gVar) {
        this.f42467e.b(gVar);
    }

    private i() {
        this.f42463a = new com.qq.e.dl.l.g();
        this.f42464b = new ConcurrentHashMap<>();
        this.f42465c = new HashMap();
        this.f42466d = new com.qq.e.dl.i.f();
        this.f42467e = new n0();
        this.f42468f = new com.qq.e.dl.i.f();
        this.f42469g = new m();
        this.f42470h = new f();
        this.f42471i = new j();
        this.f42463a.a("GDTDLVideoView", new h0.a());
        this.f42463a.a("GDTDLProgressButton", new d0.c());
        this.f42463a.a("GDTDLVolumeView", new i0.b());
        this.f42463a.a("GDTDLGameEntryView", new z.b());
        this.f42463a.a("GDTDLProgressView", new e0.d());
        this.f42463a.a("GDTDLDownloadProgressView", new y.e());
        this.f42463a.a("GDTDLRewardTipView", new f0.b());
        this.f42463a.a("GDTDLAdLogoView", new t.b());
        this.f42463a.a("GDTDLCTAView", new w.b());
        this.f42463a.a("GDTDLAppInfoView", new u.b());
        this.f42463a.a("GDTDLPopupView", new c0.b());
        this.f42463a.a("GDTDLLandingPageVideoView", new a0.b());
        this.f42463a.a("GDTDLWebView", new j0.a());
        this.f42463a.a("GDTDLTwistView", new g0.a());
        this.f42463a.a("GDTDLAutoClickView", new v.a());
        this.f42463a.a("GDTDLNovelPageView", new b0.b());
        this.f42463a.a("GDTDLCircleProgressView", new x.a());
        com.qq.e.dl.k.m.a(new p());
    }

    public s a(Context context, com.qq.e.comm.plugin.g0.e eVar) {
        return a(context, eVar, true);
    }

    public s a(Context context, com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        return a(context, eVar, z3, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.qq.e.comm.plugin.dl.s a(android.content.Context r8, com.qq.e.comm.plugin.g0.e r9, boolean r10, boolean r11) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto Led
            if (r9 != 0) goto L7
            goto Led
        L7:
            android.util.Pair r11 = com.qq.e.comm.plugin.dl.l0.a(r9, r11)
            r1 = 0
            r2 = 1
            if (r10 == 0) goto L1b
            java.lang.Object r10 = r11.first
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L1b
            r10 = 1
            goto L1c
        L1b:
            r10 = 0
        L1c:
            java.lang.Object r11 = r11.second
            java.lang.String r11 = (java.lang.String) r11
            com.qq.e.comm.plugin.g0.y r3 = r9.i0()
            com.qq.e.comm.plugin.b.g r4 = r9.o()
            if (r10 == 0) goto L42
            if (r3 == 0) goto L42
            com.qq.e.dl.i.f r10 = r7.f42466d
            java.lang.String r5 = r3.j()
            com.qq.e.dl.i.b r10 = r10.a(r5)
            com.qq.e.dl.l.l.b r10 = r7.a(r8, r3, r9, r10)
            if (r10 == 0) goto L42
            com.qq.e.comm.plugin.dl.s r8 = new com.qq.e.comm.plugin.dl.s
            r8.<init>(r10, r9, r1)
            return r8
        L42:
            boolean r10 = android.text.TextUtils.isEmpty(r11)
            if (r10 == 0) goto L49
            return r0
        L49:
            if (r3 != 0) goto L4d
            r10 = r0
            goto L51
        L4d:
            java.lang.String r10 = r3.i()
        L51:
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 != 0) goto L9f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            java.lang.String r5 = "_"
            r3.append(r5)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            com.qq.e.dl.i.f r3 = r7.f42466d
            com.qq.e.dl.i.b r3 = r3.a(r10)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.qq.e.comm.plugin.g0.y> r5 = r7.f42464b
            java.lang.Object r5 = r5.get(r10)
            com.qq.e.comm.plugin.g0.y r5 = (com.qq.e.comm.plugin.g0.y) r5
            if (r5 != 0) goto L81
            com.qq.e.comm.plugin.dl.n0 r5 = r7.f42467e
            com.qq.e.comm.plugin.g0.y r5 = r5.a(r4, r10, r2)
        L81:
            int r6 = r5.f43747j
            if (r6 > 0) goto L9f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.qq.e.comm.plugin.g0.y> r6 = r7.f42464b
            r6.put(r10, r5)
            if (r3 != 0) goto L90
            com.qq.e.dl.i.b r3 = r7.a(r4, r5, r10)
        L90:
            com.qq.e.dl.l.l.b r10 = r7.a(r8, r5, r9, r3)
            if (r10 == 0) goto L9f
            r9.a(r5)
            com.qq.e.comm.plugin.dl.s r8 = new com.qq.e.comm.plugin.dl.s
            r8.<init>(r10, r9, r2)
            return r8
        L9f:
            com.qq.e.dl.i.f r10 = r7.f42466d
            com.qq.e.dl.i.b r10 = r10.a(r11)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.qq.e.comm.plugin.g0.y> r3 = r7.f42464b
            java.lang.Object r3 = r3.get(r11)
            com.qq.e.comm.plugin.g0.y r3 = (com.qq.e.comm.plugin.g0.y) r3
            if (r3 != 0) goto Ld6
            boolean r3 = com.qq.e.comm.plugin.dl.i.f42461j
            if (r3 == 0) goto Lc3
            com.qq.e.comm.plugin.dl.n0 r3 = r7.f42467e
            com.qq.e.comm.plugin.g0.y r3 = r3.a(r4, r11, r1)
            int r1 = r3.f43747j
            if (r1 > 0) goto Ld6
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.qq.e.comm.plugin.g0.y> r1 = r7.f42464b
            r1.put(r11, r3)
            goto Ld6
        Lc3:
            com.qq.e.comm.plugin.g0.y r3 = new com.qq.e.comm.plugin.g0.y
            r3.<init>(r11)
            com.qq.e.comm.plugin.dl.n0 r1 = r7.f42467e
            com.qq.e.comm.plugin.g0.y r1 = r1.a(r4, r3, r2)
            if (r1 == 0) goto Ld6
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.qq.e.comm.plugin.g0.y> r3 = r7.f42464b
            r3.put(r11, r1)
            goto Ld7
        Ld6:
            r1 = r3
        Ld7:
            if (r10 != 0) goto Ldd
            com.qq.e.dl.i.b r10 = r7.a(r4, r1, r11)
        Ldd:
            com.qq.e.dl.l.l.b r8 = r7.a(r8, r1, r9, r10)
            if (r8 != 0) goto Le4
            return r0
        Le4:
            r9.a(r1)
            com.qq.e.comm.plugin.dl.s r10 = new com.qq.e.comm.plugin.dl.s
            r10.<init>(r8, r9, r2)
            return r10
        Led:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dl.i.a(android.content.Context, com.qq.e.comm.plugin.g0.e, boolean, boolean):com.qq.e.comm.plugin.dl.s");
    }

    public q a(Context context, com.qq.e.comm.plugin.g0.e eVar, int i4) {
        q a4 = a(context, eVar, 2, g.b(eVar, i4));
        return (a4 == null || a4.j() == null) ? a(context, eVar, 2, g.a(eVar, i4)) : a4;
    }

    private q a(Context context, com.qq.e.comm.plugin.g0.e eVar, int i4, String str) {
        com.qq.e.dl.i.b bVar;
        com.qq.e.comm.plugin.g0.y yVar;
        com.qq.e.dl.i.b a4 = this.f42468f.a(str);
        if (a4 == null) {
            yVar = this.f42469g.a(i4, str);
            if (yVar == null) {
                return null;
            }
            com.qq.e.dl.i.b a5 = this.f42468f.a(str, yVar.r());
            this.f42465c.put(str, yVar);
            bVar = a5;
        } else {
            bVar = a4;
            yVar = this.f42465c.get(str);
        }
        if (bVar == null) {
            n.b(eVar.o(), i4, str, this.f42468f.a());
            return null;
        }
        n.b(eVar.o(), i4, str, 0);
        com.qq.e.dl.l.l.b a6 = a(context, eVar, i4, str, bVar);
        if (a6 == null) {
            return null;
        }
        return new q(a6, eVar, yVar);
    }

    private com.qq.e.dl.l.l.b a(Context context, com.qq.e.comm.plugin.g0.e eVar, int i4, String str, com.qq.e.dl.i.b bVar) {
        com.qq.e.dl.l.l.b a4 = a(context, eVar, bVar);
        if (a4 != null && a4.getRootView() != null) {
            n.a(eVar.o(), i4, str, 0);
            return a4;
        }
        n.a(eVar.o(), i4, str, 1);
        return null;
    }

    private com.qq.e.dl.l.l.b a(Context context, com.qq.e.comm.plugin.g0.y yVar, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.dl.i.b bVar) {
        if (bVar == null) {
            if (yVar.f43747j == 13) {
                yVar.f43747j = eVar.e1() ? 16 : 17;
            }
            n.a(yVar.f43747j, eVar, yVar);
            return null;
        }
        n.a aVar = new n.a();
        com.qq.e.dl.l.l.b a4 = a(context, eVar, bVar);
        if (a4 != null && a4.getRootView() != null) {
            n.a(0, eVar, yVar);
            aVar.f42489b = System.currentTimeMillis();
            aVar.f42490c = h.f42441a;
            n.a(eVar, aVar);
            return a4;
        }
        n.a(2, eVar, yVar);
        return null;
    }

    private com.qq.e.dl.l.l.b a(Context context, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.dl.i.b bVar) {
        com.qq.e.dl.a aVar = new com.qq.e.dl.a(context);
        aVar.a(this.f42470h);
        aVar.a(this.f42471i);
        k kVar = new k();
        kVar.a(eVar);
        aVar.a(kVar);
        o oVar = new o();
        oVar.a(eVar);
        aVar.a((com.qq.e.dl.e) oVar);
        return this.f42463a.a(aVar, bVar, null);
    }

    public JSONArray a(com.qq.e.comm.plugin.b.g gVar) {
        return this.f42467e.a(gVar);
    }

    public void a(com.qq.e.comm.plugin.b.g gVar, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (f42462k || (optJSONObject = jSONObject.optJSONObject("tpl_info_native")) == null || !TextUtils.isEmpty(optJSONObject.optString("data"))) {
            return;
        }
        String optString = optJSONObject.optString("id");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        Pair<Integer, JSONObject> a4 = this.f42467e.a(gVar, optString);
        JSONObject jSONObject2 = (JSONObject) a4.second;
        if (jSONObject2 == null) {
            n.a(gVar, optString, ((Integer) a4.first).intValue());
            return;
        }
        try {
            optJSONObject.put("data", jSONObject2.optString("data"));
            optJSONObject.put("ver", jSONObject2.optString("ver"));
            n.a(gVar, optString, 0);
        } catch (JSONException unused) {
            n.a(gVar, optString, 1000);
        }
    }

    public void a(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.g0.y i02;
        if (eVar == null || (i02 = eVar.i0()) == null) {
            return;
        }
        String j4 = i02.j();
        if (TextUtils.isEmpty(j4)) {
            return;
        }
        com.qq.e.comm.plugin.b.g o4 = eVar.o();
        com.qq.e.dl.i.b a4 = this.f42466d.a(j4);
        if (i02.z()) {
            if (a4 == null) {
                a(o4, this.f42467e.a(o4, i02, false), j4);
            }
        } else if ((a4 == null || this.f42467e.b(o4, i02)) && a(o4, i02, j4) != null) {
            this.f42467e.a(o4, i02);
        }
    }

    private com.qq.e.dl.i.b a(com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.g0.y yVar, String str) {
        if (yVar == null) {
            return null;
        }
        String r3 = yVar.r();
        if (yVar.f43747j <= 0 && !TextUtils.isEmpty(r3)) {
            com.qq.e.dl.i.b a4 = this.f42466d.a(str, r3);
            if (a4 == null) {
                yVar.f43747j = 11;
            }
            return a4;
        }
        return null;
    }
}
