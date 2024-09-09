package com.qq.e.comm.plugin.q0;

import android.content.Context;
import com.qq.e.comm.plugin.q0.h;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f45454a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f45455b;

    /* renamed from: c  reason: collision with root package name */
    private String f45456c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f45457d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.q0.t.b f45458e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f45459f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45460g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f45461h;

    /* renamed from: i  reason: collision with root package name */
    private h.a f45462i;

    /* renamed from: j  reason: collision with root package name */
    private g f45463j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f45464k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f45465l;

    /* renamed from: m  reason: collision with root package name */
    private String f45466m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements com.qq.e.comm.plugin.apkmanager.w.a {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.g f45467c;

        a(d dVar, com.qq.e.comm.plugin.q0.s.g gVar) {
            this.f45467c = gVar;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.w.a
        public void a(String str, int i4, int i5, long j4) {
            HashMap hashMap = new HashMap();
            hashMap.put("pkgName", str);
            hashMap.put("status", Integer.valueOf(i4));
            hashMap.put("progress", Integer.valueOf(i5));
            hashMap.put("totalSize", Long.valueOf(j4));
            this.f45467c.a(new com.qq.e.comm.plugin.q0.s.b("apkStatusChange", new JSONObject(hashMap)));
        }
    }

    @Deprecated
    public d(Context context, com.qq.e.comm.plugin.g0.e eVar, g gVar) {
        this.f45459f = true;
        this.f45460g = true;
        this.f45461h = true;
        this.f45454a = context;
        this.f45455b = eVar;
        this.f45456c = eVar == null ? null : eVar.q0();
        this.f45463j = gVar;
    }

    public d a(boolean z3) {
        this.f45459f = z3;
        return this;
    }

    public d b(boolean z3) {
        this.f45460g = z3;
        return this;
    }

    public d c(boolean z3) {
        this.f45461h = z3;
        return this;
    }

    @Deprecated
    public d d(boolean z3) {
        this.f45464k = z3;
        return this;
    }

    public static boolean b() {
        return r.a();
    }

    public static boolean c() {
        return k.b();
    }

    @Deprecated
    public d a(com.qq.e.comm.plugin.q0.t.b bVar) {
        this.f45458e = bVar;
        return this;
    }

    @Deprecated
    public d a(h.a aVar) {
        this.f45462i = aVar;
        return this;
    }

    public h a() {
        com.qq.e.comm.plugin.q0.s.g hVar;
        h a4 = new k(this.f45454a, this.f45466m, this.f45465l).a(this.f45455b).a();
        if (!this.f45464k) {
            hVar = new com.qq.e.comm.plugin.q0.s.i(a4);
            com.qq.e.comm.plugin.q0.u.e eVar = new com.qq.e.comm.plugin.q0.u.e(this.f45455b);
            hVar.a("download", eVar).a("package", eVar).a("network", eVar);
            com.qq.e.comm.plugin.q0.u.l.d dVar = new com.qq.e.comm.plugin.q0.u.l.d(this.f45455b);
            hVar.a(dVar.a(), dVar);
        } else {
            hVar = new com.qq.e.comm.plugin.q0.s.h(a4, this.f45463j);
            hVar.a(com.qq.e.comm.plugin.q0.u.f.b()).a(com.qq.e.comm.plugin.q0.u.a.b()).a(com.qq.e.comm.plugin.q0.u.h.b()).a(com.qq.e.comm.plugin.q0.u.c.b());
            com.qq.e.comm.plugin.q0.t.b bVar = this.f45458e;
            if (bVar != null) {
                a4.a(bVar);
            }
            h.a aVar = this.f45462i;
            if (aVar != null) {
                a4.a(aVar);
            }
            a4.a(new a(this, hVar));
        }
        com.qq.e.comm.plugin.q0.u.d dVar2 = new com.qq.e.comm.plugin.q0.u.d(this.f45456c);
        hVar.a(dVar2.a(), dVar2);
        a4.c(!this.f45464k);
        a4.a(hVar);
        a4.a(this.f45457d);
        a4.setFocusable(this.f45459f);
        a4.setFocusableInTouchMode(this.f45460g);
        a4.b(this.f45461h);
        return a4;
    }

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, com.qq.e.comm.plugin.g0.e eVar) {
        this.f45459f = true;
        this.f45460g = true;
        this.f45461h = true;
        this.f45454a = context;
        this.f45455b = eVar;
        this.f45456c = eVar == null ? null : eVar.q0();
    }

    public d(Context context, com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        this(context, eVar);
        this.f45457d = z3;
    }
}
