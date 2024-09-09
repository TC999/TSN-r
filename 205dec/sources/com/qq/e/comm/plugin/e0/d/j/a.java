package com.qq.e.comm.plugin.e0.d.j;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.qq.e.comm.plugin.e0.d.h.e;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.r;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a<T> implements com.qq.e.comm.plugin.e0.d.h.c<T> {
    private int A;
    protected int B;
    protected int C;
    private boolean D;

    /* renamed from: a  reason: collision with root package name */
    protected List<com.qq.e.comm.plugin.e0.e.d> f42857a;

    /* renamed from: b  reason: collision with root package name */
    protected List<com.qq.e.comm.plugin.e0.e.d> f42858b;

    /* renamed from: c  reason: collision with root package name */
    protected List<com.qq.e.comm.plugin.e0.e.d> f42859c;

    /* renamed from: d  reason: collision with root package name */
    protected int f42860d;

    /* renamed from: e  reason: collision with root package name */
    protected int f42861e;

    /* renamed from: f  reason: collision with root package name */
    protected int f42862f;

    /* renamed from: g  reason: collision with root package name */
    protected int f42863g;

    /* renamed from: h  reason: collision with root package name */
    protected int f42864h;

    /* renamed from: i  reason: collision with root package name */
    protected d<T> f42865i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f42866j;

    /* renamed from: m  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.e0.d.h.b<T> f42869m;

    /* renamed from: n  reason: collision with root package name */
    protected final e<T> f42870n;

    /* renamed from: o  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.e0.d.h.d<T> f42871o;

    /* renamed from: q  reason: collision with root package name */
    protected T f42873q;

    /* renamed from: r  reason: collision with root package name */
    protected com.qq.e.comm.plugin.e0.e.d f42874r;

    /* renamed from: s  reason: collision with root package name */
    protected T f42875s;

    /* renamed from: t  reason: collision with root package name */
    protected com.qq.e.comm.plugin.e0.e.d f42876t;

    /* renamed from: u  reason: collision with root package name */
    protected T f42877u;

    /* renamed from: v  reason: collision with root package name */
    protected com.qq.e.comm.plugin.e0.e.d f42878v;

    /* renamed from: w  reason: collision with root package name */
    protected boolean f42879w;

    /* renamed from: x  reason: collision with root package name */
    protected boolean f42880x;

    /* renamed from: y  reason: collision with root package name */
    private int f42881y;

    /* renamed from: z  reason: collision with root package name */
    private int f42882z;

    /* renamed from: k  reason: collision with root package name */
    protected Handler f42867k = new Handler(Looper.getMainLooper());

    /* renamed from: l  reason: collision with root package name */
    private final Object f42868l = new Object();

    /* renamed from: p  reason: collision with root package name */
    protected final List<com.qq.e.comm.plugin.e0.e.d> f42872p = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.e0.d.j.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0811a implements Runnable {
        RunnableC0811a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.c()) {
                d1.a("MSDK LoadStrategy loadAd timeout", new Object[0]);
                a.this.f42869m.b();
                a.this.f42871o.b();
                a.this.f42870n.b();
            }
        }
    }

    public a(com.qq.e.comm.plugin.e0.e.a aVar, d<T> dVar) {
        this.f42857a = aVar.j();
        this.f42858b = aVar.b();
        this.f42859c = aVar.g();
        this.f42860d = aVar.i();
        this.f42861e = aVar.a();
        this.f42862f = aVar.h();
        this.f42863g = aVar.d();
        this.f42864h = aVar.f();
        this.f42865i = dVar;
        this.f42869m = new com.qq.e.comm.plugin.e0.d.h.b<>(this.f42858b, this.f42861e, this);
        this.f42870n = new e<>(this.f42857a, this.f42863g, this.f42864h, this);
        this.f42871o = new com.qq.e.comm.plugin.e0.d.h.d<>(this.f42859c, this.f42861e, this.f42862f, aVar.e(), this);
    }

    private void d() {
        this.D = false;
        b(false);
        d1.a("MSDK LoadStrategy waterfallPrice: " + this.A + ", biddingPrice: " + this.f42881y, new Object[0]);
        if (this.A > this.f42881y) {
            com.qq.e.comm.plugin.e0.e.d dVar = this.f42876t;
            if (dVar != null) {
                this.f42869m.a(dVar.q(), this.f42876t.a());
            }
            a(this.f42875s, this.f42876t, this.f42872p, null);
            v.a(1231007, null, 2);
            return;
        }
        com.qq.e.comm.plugin.e0.e.d dVar2 = this.f42874r;
        if (dVar2 != null) {
            this.f42869m.a(dVar2);
            r.a(this.f42874r.p(), this.f42874r.f());
            v.a(1231007, null, 1);
        } else {
            v.a(1231008, (com.qq.e.comm.plugin.n0.c) null);
        }
        a(this.f42873q, this.f42874r, this.f42872p, this.f42870n.d());
    }

    private void e() {
        Handler handler = this.f42867k;
        RunnableC0811a runnableC0811a = new RunnableC0811a();
        Object obj = this.f42868l;
        long uptimeMillis = SystemClock.uptimeMillis();
        int i4 = this.f42860d;
        if (i4 <= 0) {
            i4 = 5000;
        }
        handler.postAtTime(runnableC0811a, obj, uptimeMillis + i4);
    }

    public void a() {
        this.f42866j = true;
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        d1.a("MSDK LoadStrategy executeFinish", new Object[0]);
        this.f42866j = false;
        this.f42872p.addAll(this.f42869m.d());
        this.f42872p.addAll(this.f42870n.e());
        this.f42872p.addAll(this.f42871o.c());
        com.qq.e.comm.plugin.e0.e.d dVar = this.f42874r;
        this.f42881y = dVar != null ? dVar.f() : -1;
        com.qq.e.comm.plugin.e0.e.d dVar2 = this.f42876t;
        this.A = dVar2 != null ? dVar2.q() : -1;
        com.qq.e.comm.plugin.e0.e.d dVar3 = this.f42878v;
        int f4 = dVar3 != null ? dVar3.f() : -1;
        this.f42882z = f4;
        if (f4 >= this.f42881y && f4 >= this.A && this.f42878v != null) {
            this.D = true;
            this.f42871o.f();
            b(false);
            this.f42869m.a(this.f42878v.q(), this.f42878v.a());
            return;
        }
        d();
    }

    public boolean c() {
        return this.f42866j;
    }

    private void a(T t3, com.qq.e.comm.plugin.e0.e.d dVar, List<com.qq.e.comm.plugin.e0.e.d> list, com.qq.e.comm.plugin.e0.e.d dVar2) {
        d1.a("MSDK LoadStrategy finish adapter: " + t3 + ", config: " + dVar + ", firstLoseConfig: " + dVar2 + ", loadedConfigs: " + list, new Object[0]);
        this.f42867k.removeCallbacksAndMessages(this.f42868l);
        this.f42865i.a(t3, dVar, list, dVar2);
    }

    public void a(com.qq.e.comm.plugin.e0.e.b<T> bVar) {
        d1.a("MSDK LoadStrategy recordLoadResult adapter: " + bVar.a() + ", loadState: " + bVar.f() + ", biddingCost: " + bVar.b(), new Object[0]);
        this.f42869m.a(bVar);
        this.f42870n.a(bVar);
        this.f42871o.a(bVar);
    }

    @Override // com.qq.e.comm.plugin.e0.d.h.c
    public T a(com.qq.e.comm.plugin.e0.e.d dVar) {
        return this.f42865i.a(dVar);
    }

    @Override // com.qq.e.comm.plugin.e0.d.h.c
    public void a(T t3, int i4) {
        this.f42865i.a(t3, i4);
    }

    @Override // com.qq.e.comm.plugin.e0.d.h.c
    public void a(T t3, int i4, String str) {
        this.f42865i.a(t3, i4, str);
    }

    @Override // com.qq.e.comm.plugin.e0.d.h.c
    public void a(boolean z3) {
        com.qq.e.comm.plugin.e0.e.d dVar = this.f42878v;
        if (dVar != null) {
            dVar.a(true);
        }
        if (z3) {
            a(this.f42877u, this.f42878v, this.f42872p, null);
        } else {
            a(null, null, this.f42872p, null);
        }
    }

    public void b(boolean z3) {
        int max;
        if (this.D) {
            max = this.f42882z;
        } else {
            max = Math.max(this.A, this.f42881y);
        }
        com.qq.e.comm.plugin.e0.d.i.d.a(this.f42871o.d(), this.f42878v, this.D, z3, String.valueOf(max));
    }
}
