package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.util.c2;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h {
    public ServerSideVerificationOptions A;
    public c2 B;

    /* renamed from: a  reason: collision with root package name */
    public final Context f46089a;

    /* renamed from: b  reason: collision with root package name */
    public final String f46090b;

    /* renamed from: c  reason: collision with root package name */
    public final String f46091c;

    /* renamed from: d  reason: collision with root package name */
    public final String f46092d;

    /* renamed from: e  reason: collision with root package name */
    public final com.qq.e.comm.plugin.b.g f46093e;

    /* renamed from: f  reason: collision with root package name */
    public final com.qq.e.comm.plugin.b.m f46094f;

    /* renamed from: g  reason: collision with root package name */
    public final String f46095g;

    /* renamed from: h  reason: collision with root package name */
    public final com.qq.e.comm.plugin.l0.b f46096h;

    /* renamed from: i  reason: collision with root package name */
    public String f46097i;

    /* renamed from: j  reason: collision with root package name */
    public LoadAdParams f46098j;

    /* renamed from: k  reason: collision with root package name */
    public com.qq.e.comm.plugin.b.l f46099k;

    /* renamed from: l  reason: collision with root package name */
    public ADListener f46100l;

    /* renamed from: m  reason: collision with root package name */
    public int f46101m;

    /* renamed from: n  reason: collision with root package name */
    public byte[] f46102n;

    /* renamed from: p  reason: collision with root package name */
    public int f46104p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f46105q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f46106r;

    /* renamed from: s  reason: collision with root package name */
    public ViewGroup f46107s;

    /* renamed from: t  reason: collision with root package name */
    public int f46108t;

    /* renamed from: u  reason: collision with root package name */
    private c0 f46109u;

    /* renamed from: v  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f46110v;

    /* renamed from: x  reason: collision with root package name */
    public View f46112x;

    /* renamed from: y  reason: collision with root package name */
    public long f46113y;

    /* renamed from: z  reason: collision with root package name */
    public long f46114z;

    /* renamed from: o  reason: collision with root package name */
    public int f46103o = 10;

    /* renamed from: w  reason: collision with root package name */
    public final AtomicReference<Boolean> f46111w = new AtomicReference<>(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, String str, String str2, String str3) {
        this.f46089a = context;
        this.f46090b = str;
        this.f46091c = str2;
        this.f46092d = str3;
        com.qq.e.comm.plugin.b.g gVar = com.qq.e.comm.plugin.b.g.SPLASH;
        this.f46093e = gVar;
        this.f46094f = new com.qq.e.comm.plugin.b.m(str2, gVar, (com.qq.e.comm.plugin.b.f) null);
        this.f46095g = com.qq.e.comm.plugin.util.b.a(str, str2);
        this.f46096h = new com.qq.e.comm.plugin.l0.b(this.f46093e, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f46112x = null;
        this.f46111w.set(null);
        this.f46107s = null;
    }

    public c0 b() {
        return this.f46109u;
    }

    public com.qq.e.comm.plugin.n0.c c() {
        return this.f46110v;
    }

    public int d() {
        int a4;
        int t12;
        y i02 = this.f46109u.i0();
        if (i02 == null || (a4 = i02.g()) <= 0) {
            if (f() && this.f46111w.get() != null) {
                if (this.f46111w.get().booleanValue()) {
                    t12 = this.f46109u.M0();
                } else if (this.f46109u.t1() > 0) {
                    t12 = this.f46109u.t1();
                } else {
                    a4 = j.a((com.qq.e.comm.plugin.g0.e) this.f46109u);
                }
                a4 = t12 * 1000;
            } else {
                a4 = j.a((com.qq.e.comm.plugin.g0.e) this.f46109u);
            }
        }
        return (this.f46103o != 3 || i02 == null || !com.qq.e.comm.plugin.dl.d.d(this.f46109u) || i02.e() <= 0) ? a4 : a4 + i02.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f46105q = false;
        this.f46106r = false;
        this.f46107s = null;
        this.f46108t = j.c();
        this.f46109u = null;
        this.f46110v = new com.qq.e.comm.plugin.n0.c().a(com.qq.e.comm.plugin.b.g.SPLASH).c(this.f46091c);
        this.f46113y = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        c0 c0Var = this.f46109u;
        return c0Var != null && c0Var.e1() && this.f46109u.Y0();
    }

    public boolean g() {
        return this.f46108t > 0 && TextUtils.isEmpty(this.f46092d) && com.qq.e.comm.plugin.edgeanalytics.e.d(com.qq.e.comm.plugin.b.g.SPLASH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c0 c0Var) {
        this.f46109u = c0Var;
        this.f46110v = com.qq.e.comm.plugin.n0.c.a(c0Var);
        if (f()) {
            c0Var.z1();
        }
    }
}
