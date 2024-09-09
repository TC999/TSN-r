package com.qq.e.comm.plugin.i;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.g0.f0;
import com.qq.e.comm.plugin.util.i2;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h {
    private Future<com.qq.e.comm.plugin.g0.g> A;
    String B;
    public final com.qq.e.comm.plugin.g0.e C;
    public final int D;
    public final boolean E;
    public final boolean F;
    public boolean G;
    public int H;

    /* renamed from: a  reason: collision with root package name */
    public final long f44128a;

    /* renamed from: b  reason: collision with root package name */
    final com.qq.e.comm.plugin.b.g f44129b;

    /* renamed from: c  reason: collision with root package name */
    final int f44130c;

    /* renamed from: d  reason: collision with root package name */
    final String f44131d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f44132e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f44133f;

    /* renamed from: g  reason: collision with root package name */
    final String f44134g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f44135h;

    /* renamed from: i  reason: collision with root package name */
    final int f44136i;

    /* renamed from: j  reason: collision with root package name */
    final Boolean f44137j;

    /* renamed from: k  reason: collision with root package name */
    final com.qq.e.comm.plugin.g0.h f44138k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f44139l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f44140m;

    /* renamed from: n  reason: collision with root package name */
    final String f44141n;

    /* renamed from: o  reason: collision with root package name */
    final int f44142o;

    /* renamed from: p  reason: collision with root package name */
    final com.qq.e.comm.plugin.b.h f44143p;

    /* renamed from: q  reason: collision with root package name */
    final boolean f44144q;

    /* renamed from: r  reason: collision with root package name */
    final boolean f44145r;

    /* renamed from: s  reason: collision with root package name */
    final Integer f44146s;

    /* renamed from: t  reason: collision with root package name */
    final long f44147t;

    /* renamed from: u  reason: collision with root package name */
    final boolean f44148u;

    /* renamed from: v  reason: collision with root package name */
    final boolean f44149v;

    /* renamed from: w  reason: collision with root package name */
    final boolean f44150w;

    /* renamed from: x  reason: collision with root package name */
    final Context f44151x;

    /* renamed from: y  reason: collision with root package name */
    final int f44152y;

    /* renamed from: z  reason: collision with root package name */
    final com.qq.e.comm.plugin.n0.c f44153z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private com.qq.e.comm.plugin.g0.e f44154a;

        /* renamed from: b  reason: collision with root package name */
        private String f44155b;

        /* renamed from: d  reason: collision with root package name */
        private com.qq.e.comm.plugin.b.h f44157d;

        /* renamed from: h  reason: collision with root package name */
        private long f44161h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f44162i;

        /* renamed from: l  reason: collision with root package name */
        private int f44165l;

        /* renamed from: o  reason: collision with root package name */
        private JSONObject f44168o;

        /* renamed from: p  reason: collision with root package name */
        private int f44169p;

        /* renamed from: c  reason: collision with root package name */
        private int f44156c = -999;

        /* renamed from: e  reason: collision with root package name */
        private boolean f44158e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f44159f = false;

        /* renamed from: g  reason: collision with root package name */
        private Integer f44160g = 0;

        /* renamed from: j  reason: collision with root package name */
        private boolean f44163j = true;

        /* renamed from: k  reason: collision with root package name */
        private boolean f44164k = true;

        /* renamed from: m  reason: collision with root package name */
        private int f44166m = -1;

        /* renamed from: n  reason: collision with root package name */
        private boolean f44167n = false;

        public b(com.qq.e.comm.plugin.g0.e eVar) {
            this.f44154a = eVar;
            this.f44161h = eVar.E0();
        }

        public b a(String str) {
            this.f44155b = str;
            return this;
        }

        public b b(int i4) {
            this.f44160g = Integer.valueOf(i4);
            return this;
        }

        public b c(boolean z3) {
            this.f44158e = z3 && !this.f44154a.k1();
            return this;
        }

        public b d(boolean z3) {
            this.f44162i = z3;
            return this;
        }

        public b e(boolean z3) {
            this.f44159f = z3;
            return this;
        }

        public b f(boolean z3) {
            this.f44167n = z3;
            return this;
        }

        public b a(int i4) {
            this.f44156c = i4;
            return this;
        }

        public b b(boolean z3) {
            this.f44164k = z3;
            return this;
        }

        public b c(int i4) {
            this.f44165l = i4;
            return this;
        }

        public b d(int i4) {
            this.f44169p = i4;
            return this;
        }

        public b e(int i4) {
            this.f44166m = i4;
            return this;
        }

        public b a(com.qq.e.comm.plugin.b.h hVar) {
            this.f44157d = hVar;
            return this;
        }

        public b a(boolean z3) {
            this.f44163j = z3;
            return this;
        }

        public b a(JSONObject jSONObject) {
            this.f44168o = jSONObject;
            return this;
        }

        public h a() {
            return new h(this);
        }
    }

    void a(Future<com.qq.e.comm.plugin.g0.g> future) {
        if (future == null) {
            return;
        }
        this.A = future;
    }

    private h(b bVar) {
        String b4;
        List<com.qq.e.comm.plugin.g0.j> f02;
        this.f44128a = System.currentTimeMillis();
        this.G = true;
        com.qq.e.comm.plugin.g0.e eVar = bVar.f44154a;
        this.C = eVar;
        this.f44129b = eVar.o();
        this.f44130c = this.C.g();
        if (bVar.f44166m > -1 && (f02 = this.C.f0()) != null && f02.size() > bVar.f44166m) {
            com.qq.e.comm.plugin.g0.j jVar = f02.get(bVar.f44166m);
            String a4 = jVar.a();
            this.f44131d = TextUtils.isEmpty(a4) ? this.C.x() : a4;
            b4 = jVar.b();
            if (TextUtils.isEmpty(b4)) {
                b4 = this.C.b();
            }
        } else {
            this.f44131d = this.C.x();
            b4 = this.C.b();
        }
        this.f44132e = this.C.l1();
        boolean c4 = i2.c(b4);
        this.f44133f = c4;
        this.f44134g = c4 ? b4 : null;
        this.f44135h = this.C.X0();
        com.qq.e.comm.plugin.g0.b q3 = this.C.q();
        if (q3 != null && !TextUtils.isEmpty(q3.e())) {
            this.f44136i = com.qq.e.comm.plugin.apkmanager.k.e().b(q3.e());
        } else {
            this.f44136i = 0;
        }
        if (com.qq.e.comm.plugin.util.c.e(this.C)) {
            this.f44137j = Boolean.TRUE;
        } else if (com.qq.e.comm.plugin.util.c.d(this.C)) {
            this.f44137j = Boolean.FALSE;
        } else {
            this.f44137j = null;
        }
        this.f44138k = this.C.z();
        this.f44139l = this.C.j1();
        com.qq.e.comm.plugin.g0.e eVar2 = this.C;
        this.f44140m = (eVar2 instanceof f0) && ((f0) eVar2).q1() == com.qq.e.comm.plugin.rewardvideo.f.PAGE;
        this.E = this.C.D() == 1;
        this.f44141n = bVar.f44155b;
        this.f44142o = bVar.f44156c;
        this.f44143p = bVar.f44157d;
        this.f44144q = bVar.f44158e;
        this.f44145r = bVar.f44159f;
        this.f44146s = bVar.f44160g;
        this.f44147t = bVar.f44161h;
        this.f44148u = bVar.f44162i;
        this.f44149v = bVar.f44163j;
        this.f44150w = bVar.f44164k;
        this.f44151x = com.qq.e.comm.plugin.d0.a.d().a();
        this.f44153z = com.qq.e.comm.plugin.n0.c.a(this.C);
        this.f44152y = i.a();
        this.D = bVar.f44165l;
        this.F = bVar.f44167n;
        JSONObject unused = bVar.f44168o;
        this.H = bVar.f44169p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.g0.g a() {
        try {
            return this.A.get();
        } catch (Exception unused) {
            return new com.qq.e.comm.plugin.g0.g(-1);
        }
    }
}
