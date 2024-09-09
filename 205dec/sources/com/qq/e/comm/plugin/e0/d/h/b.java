package com.qq.e.comm.plugin.e0.d.h;

import android.os.SystemClock;
import com.qq.e.comm.plugin.e0.d.g;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.r;
import com.qq.e.comm.plugin.util.t0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b<T> extends com.qq.e.comm.plugin.e0.d.h.a<T> {

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f42811d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Integer, com.qq.e.comm.plugin.e0.e.d> f42812e;

    /* renamed from: f  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.e0.a> f42813f;

    /* renamed from: g  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.e0.e.d> f42814g;

    /* renamed from: h  reason: collision with root package name */
    private final int f42815h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f42816i;

    /* renamed from: j  reason: collision with root package name */
    private volatile T f42817j;

    /* renamed from: k  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.e0.e.d f42818k;

    /* renamed from: l  reason: collision with root package name */
    private int f42819l;

    /* renamed from: m  reason: collision with root package name */
    private int f42820m;

    /* renamed from: n  reason: collision with root package name */
    private int f42821n;

    /* renamed from: o  reason: collision with root package name */
    private T f42822o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a("MSDK C2SBiddingAdaptersLoader timeout mIsLoading: " + b.this.f42816i, new Object[0]);
            if (b.this.f42816i) {
                b.this.f42811d.set(0);
                b.this.a();
            }
        }
    }

    public b(List<com.qq.e.comm.plugin.e0.e.d> list, int i4, c<T> cVar) {
        super(cVar);
        this.f42811d = new AtomicInteger(0);
        this.f42812e = new HashMap();
        this.f42813f = new ArrayList();
        this.f42819l = -1;
        this.f42820m = -1;
        this.f42821n = -1;
        this.f42814g = list;
        this.f42815h = i4;
    }

    private void c() {
        int i4 = this.f42811d.get();
        if (i4 > 0) {
            return;
        }
        if (i4 < 0) {
            d1.a("MSDK C2SBiddingAdaptersLoader checkBiddingConfigsResult error, not expectation!!!!! " + i4);
            return;
        }
        a();
    }

    private void f() {
        this.f42808a.postAtTime(new a(), this.f42809b, SystemClock.uptimeMillis() + this.f42815h);
    }

    public List<com.qq.e.comm.plugin.e0.e.d> d() {
        return this.f42814g;
    }

    public void e() {
        this.f42816i = true;
        List<com.qq.e.comm.plugin.e0.e.d> list = this.f42814g;
        if (list != null && list.size() > 0) {
            int i4 = 0;
            for (com.qq.e.comm.plugin.e0.e.d dVar : this.f42814g) {
                dVar.w();
                T a4 = this.f42810c.a(dVar);
                if (a4 != null) {
                    if (a4 instanceof com.qq.e.comm.plugin.e0.a) {
                        this.f42813f.add((com.qq.e.comm.plugin.e0.a) a4);
                        g.a(dVar.p(), dVar.i());
                    }
                    dVar.c(2);
                    this.f42812e.put(Integer.valueOf(a4.hashCode()), dVar);
                    if (a4 instanceof com.qq.e.comm.plugin.e0.b) {
                        ((com.qq.e.comm.plugin.e0.b) a4).setMediationId(dVar.n());
                    }
                    if (dVar.a() == 100 && this.f42822o == null) {
                        this.f42822o = a4;
                        d1.a("MSDK C2SBiddingAdaptersLoader loadBiddingConfigs mFirstYlhAdapter: " + this.f42822o + ", config = " + dVar, new Object[0]);
                    }
                    this.f42810c.a(a4, dVar.a());
                    i4++;
                }
            }
            d1.a("MSDK C2SBiddingAdaptersLoader loadBiddingConfigs bidding count: " + i4, new Object[0]);
            if (i4 == 0) {
                a();
                return;
            }
            this.f42811d.set(i4);
            f();
            return;
        }
        d1.a("MSDK C2SBiddingAdaptersLoader loadBiddingConfigs: no bidding config", new Object[0]);
        a();
    }

    public void a(com.qq.e.comm.plugin.e0.e.b<T> bVar) {
        T a4 = bVar.a();
        int b4 = bVar.b();
        int f4 = bVar.f();
        d1.a("MSDK C2SBiddingAdaptersLoader recordBiddingResult adapter: " + a4 + ", loadState: " + f4 + ", biddingCost: " + b4 + ", mIsLoading: " + this.f42816i, new Object[0]);
        com.qq.e.comm.plugin.e0.e.d dVar = this.f42812e.get(Integer.valueOf(a4.hashCode()));
        if (dVar != null) {
            d1.a("MSDK C2SBiddingAdaptersLoader recordBiddingResult config: " + dVar, new Object[0]);
            if (this.f42816i) {
                dVar.c(f4);
            }
            dVar.b(b4);
            dVar.b(bVar.g());
            dVar.b(bVar.c());
            dVar.a(bVar.d());
            dVar.a(bVar.e());
            if (this.f42822o == a4) {
                this.f42821n = b4;
                d1.a("MSDK C2SBiddingAdaptersLoader recordBiddingResult mFirstYlhBidingCost: " + this.f42821n + ", config = " + dVar, new Object[0]);
            }
            if (f4 == 3) {
                if (this.f42817j == null) {
                    this.f42817j = a4;
                    this.f42819l = b4;
                    this.f42818k = dVar;
                } else if (b4 > this.f42819l) {
                    this.f42817j = a4;
                    this.f42820m = this.f42819l;
                    this.f42819l = b4;
                    this.f42818k = dVar;
                }
            }
            int decrementAndGet = this.f42811d.decrementAndGet();
            d1.a("MSDK C2SBiddingAdaptersLoader recordBiddingResult count: " + decrementAndGet, new Object[0]);
            c();
        }
    }

    public void b(int i4, int i5) {
        Iterator<com.qq.e.comm.plugin.e0.a> it = this.f42813f.iterator();
        while (it.hasNext() && (r1 = it.next().getCompetitionWinUrls()) != null) {
            for (String str : r1) {
                r.a(str, i4, i5);
            }
        }
    }

    public void a(com.qq.e.comm.plugin.e0.e.d dVar) {
        if (dVar != this.f42818k) {
            d1.b("MSDK C2SBiddingAdaptersLoader ", "reportCompetitionResult error config");
        }
        if (this.f42818k != null && this.f42818k.q() != this.f42819l) {
            d1.b("MSDK C2SBiddingAdaptersLoader ", "reportCompetitionResult error cost");
        }
        if (t0.a(dVar)) {
            b(dVar.u() ? dVar.f() : dVar.q(), this.f42820m);
        } else {
            a(dVar.u() ? dVar.f() : dVar.q(), dVar.a());
        }
    }

    public void a(int i4, int i5) {
        Iterator<com.qq.e.comm.plugin.e0.a> it = this.f42813f.iterator();
        while (it.hasNext() && (r1 = it.next().getCompetitionFailureUrls()) != null) {
            for (String str : r1) {
                r.a(str, String.valueOf(i5), i4, 1);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.e0.d.h.a
    protected void a() {
        d1.a("MSDK C2SBiddingAdaptersLoader finishLoad: " + this.f42816i, new Object[0]);
        if (this.f42816i) {
            this.f42808a.removeCallbacksAndMessages(this.f42809b);
            this.f42816i = false;
            List<com.qq.e.comm.plugin.e0.e.d> list = this.f42814g;
            if (list != null && list.size() > 0) {
                for (com.qq.e.comm.plugin.e0.e.d dVar : this.f42814g) {
                    dVar.e(this.f42821n);
                    int f4 = (dVar.f() - this.f42821n) - 2;
                    dVar.a(f4);
                    d1.a("MSDK C2SBiddingAdaptersLoader finishLoad set param: " + dVar + ", mFirstYlhBidingCost = " + this.f42821n + ", bpg = " + f4 + ", ecpm = " + dVar.f(), new Object[0]);
                }
            }
            this.f42810c.a(this, (b<T>) this.f42817j, this.f42818k);
        }
    }
}
