package com.qq.e.comm.plugin.e0.d.h;

import android.os.SystemClock;
import com.qq.e.comm.plugin.util.d1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e<T> extends com.qq.e.comm.plugin.e0.d.h.a<T> {

    /* renamed from: d  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.e0.e.d> f42836d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInteger f42837e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f42838f;

    /* renamed from: g  reason: collision with root package name */
    private final int f42839g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Integer, com.qq.e.comm.plugin.e0.e.d> f42840h;

    /* renamed from: i  reason: collision with root package name */
    private final CopyOnWriteArrayList<com.qq.e.comm.plugin.e0.e.d> f42841i;

    /* renamed from: j  reason: collision with root package name */
    private final int f42842j;

    /* renamed from: k  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.e0.e.d f42843k;

    /* renamed from: l  reason: collision with root package name */
    private volatile T f42844l;

    /* renamed from: m  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.e0.e.d f42845m;

    /* renamed from: n  reason: collision with root package name */
    private volatile int f42846n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f42847o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f42848p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f42849c;

        a(int i4) {
            this.f42849c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a("MSDK WaterfallAdaptersLoader WaterfallConfigsTimeout index: " + this.f42849c + ", mIsLoading: " + e.this.f42848p, new Object[0]);
            if (e.this.f42848p) {
                e.this.f42838f.set(0);
                e.this.b(this.f42849c);
            }
        }
    }

    public e(List<com.qq.e.comm.plugin.e0.e.d> list, int i4, int i5, c<T> cVar) {
        super(cVar);
        this.f42837e = new AtomicInteger(-1);
        this.f42838f = new AtomicInteger(0);
        this.f42840h = new ConcurrentHashMap();
        this.f42841i = new CopyOnWriteArrayList<>();
        this.f42846n = -1;
        this.f42836d = com.qq.e.comm.plugin.e0.d.b.a(list);
        this.f42839g = i4;
        this.f42842j = i5;
    }

    private void c() {
        if (this.f42843k == null || !this.f42847o) {
            int i4 = this.f42847o ? this.f42837e.get() + 1 : 0;
            int size = this.f42836d.size();
            d1.a("MSDK WaterfallAdaptersLoader findFirstLoseConfig start: " + i4 + ", end: " + size, new Object[0]);
            if (i4 >= size) {
                return;
            }
            while (i4 < size) {
                com.qq.e.comm.plugin.e0.e.d dVar = this.f42836d.get(i4);
                d1.a("MSDK WaterfallAdaptersLoader findFirstLoseConfig config.getPrice() : " + dVar.q() + ", mBiddingVictorCost: " + this.f42846n, new Object[0]);
                if (dVar.q() <= this.f42846n) {
                    d1.a("MSDK WaterfallAdaptersLoader findFirstLoseConfig mFirstLoseWaterfallConfig : " + dVar, new Object[0]);
                    this.f42843k = dVar;
                    return;
                }
                i4++;
            }
        }
    }

    private void g() {
        h();
        int size = this.f42836d.size();
        int i4 = this.f42837e.get();
        int i5 = (size - i4) - 1;
        d1.a("MSDK WaterfallAdaptersLoader loadLayers totalSize: " + size + ", lastLoadedIndex: " + i4 + ", mFirstLoseWaterfallConfig: " + this.f42843k, new Object[0]);
        if (i5 > 0 && this.f42843k == null) {
            int min = Math.min(this.f42842j, i5);
            int i6 = i4 + 1;
            int i7 = min + i6;
            int i8 = 0;
            while (true) {
                int i9 = i6;
                int i10 = i4;
                i4 = i9;
                if (i4 >= i7) {
                    i4 = i10;
                    break;
                }
                com.qq.e.comm.plugin.e0.e.d dVar = this.f42836d.get(i4);
                dVar.w();
                d1.a("MSDK WaterfallAdaptersLoader loadWaterfallLayer config index: " + i4 + ", config: " + dVar + ", mBiddingVictorCost: " + this.f42846n, new Object[0]);
                if (dVar.q() <= this.f42846n) {
                    d1.a("MSDK WaterfallAdaptersLoader loadWaterfallLayer mFirstLoseWaterfallConfig : " + dVar, new Object[0]);
                    this.f42843k = dVar;
                    break;
                }
                T a4 = this.f42810c.a(dVar);
                if (a4 != null) {
                    i8++;
                    this.f42840h.put(Integer.valueOf(a4.hashCode()), dVar);
                    this.f42841i.add(dVar);
                    dVar.c(2);
                    if (a4 instanceof com.qq.e.comm.plugin.e0.b) {
                        ((com.qq.e.comm.plugin.e0.b) a4).setMediationId(dVar.n());
                    }
                    this.f42810c.a(a4, dVar.a());
                } else {
                    d1.b("MSDK WaterfallAdaptersLoader ", "loadWaterfallLayer adapter is null, " + dVar);
                }
                i6 = i4 + 1;
            }
            this.f42838f.set(i8);
            this.f42837e.set(i4);
            d1.a("MSDK WaterfallAdaptersLoader loadWaterfallLayer current layer adapter count: " + i8, new Object[0]);
            if (i8 > 0) {
                a(i4);
                return;
            } else {
                g();
                return;
            }
        }
        a();
    }

    private void h() {
        this.f42808a.removeCallbacksAndMessages(this.f42809b);
    }

    public com.qq.e.comm.plugin.e0.e.d d() {
        c();
        return this.f42843k;
    }

    public List<com.qq.e.comm.plugin.e0.e.d> e() {
        return this.f42841i;
    }

    public void f() {
        this.f42848p = true;
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4) {
        d1.a("MSDK WaterfallAdaptersLoader waterfallLayerLoadFinish index: " + i4 + ", mLoadedWaterfallIndex: " + this.f42837e.get() + ", mParallelConfigCount: " + this.f42842j + ", mWaterfallVictor: " + this.f42844l + ", mIsLoading: " + this.f42848p, new Object[0]);
        if (this.f42848p) {
            if (i4 / this.f42842j == this.f42837e.get() / this.f42842j) {
                if (this.f42844l != null) {
                    a();
                    return;
                } else {
                    g();
                    return;
                }
            }
            d1.b("MSDK WaterfallAdaptersLoader ", "waterfallLayerLoadFinish has finish!");
        }
    }

    public void a(int i4, boolean z3) {
        this.f42846n = i4;
        this.f42847o = z3;
    }

    public void a(com.qq.e.comm.plugin.e0.e.b<T> bVar) {
        com.qq.e.comm.plugin.e0.e.d dVar;
        T a4 = bVar.a();
        int f4 = bVar.f();
        d1.a("MSDK WaterfallAdaptersLoader recordWaterfallResult adapter:" + a4 + ", loadState: " + f4 + ", biddingCost: " + bVar.b() + ", mIsLoading: " + this.f42848p, new Object[0]);
        if (this.f42848p && (dVar = this.f42840h.get(Integer.valueOf(a4.hashCode()))) != null) {
            dVar.b(bVar.c());
            dVar.a(bVar.d());
            dVar.a(bVar.e());
            d1.a("MSDK WaterfallAdaptersLoader recordWaterfallResult config:" + dVar, new Object[0]);
            dVar.c(f4);
            dVar.b(bVar.g());
            if (f4 == 3) {
                if (this.f42844l == null) {
                    this.f42844l = a4;
                    this.f42845m = dVar;
                } else {
                    com.qq.e.comm.plugin.e0.e.d dVar2 = this.f42840h.get(Integer.valueOf(this.f42844l.hashCode()));
                    if (dVar2 == null || dVar.q() > dVar2.q()) {
                        this.f42844l = a4;
                        this.f42845m = dVar;
                    }
                }
            }
            d1.a("MSDK WaterfallAdaptersLoader recordWaterfallResult mWaterfallVictor: " + this.f42844l + ", mWaterfallVictorConfig: " + this.f42845m, new Object[0]);
            int indexOf = this.f42836d.indexOf(dVar);
            int decrementAndGet = this.f42838f.decrementAndGet();
            d1.a("MSDK WaterfallAdaptersLoader recordWaterfallResult nullResultCount: " + decrementAndGet, new Object[0]);
            a(decrementAndGet, indexOf);
        }
    }

    private void a(int i4, int i5) {
        d1.a("MSDK WaterfallAdaptersLoader checkWaterfallLayerConfigsResult index: " + i5 + ", mNullResultWaterfallConfigCount: " + this.f42838f.get(), new Object[0]);
        if (i4 > 0) {
            return;
        }
        if (i4 < 0) {
            d1.b("MSDK WaterfallAdaptersLoader ", "checkWaterfallLayerConfigsResult error, not expectation!!!!! " + i4);
            return;
        }
        b(i5);
    }

    private void a(int i4) {
        d1.a("MSDK WaterfallAdaptersLoader startWaterfallConfigsCounter index: " + i4, new Object[0]);
        this.f42808a.postAtTime(new a(i4), this.f42809b, SystemClock.uptimeMillis() + ((long) this.f42839g));
    }

    @Override // com.qq.e.comm.plugin.e0.d.h.a
    protected void a() {
        d1.a("MSDK WaterfallAdaptersLoader finishLoad: " + this.f42848p, new Object[0]);
        if (this.f42848p) {
            h();
            this.f42848p = false;
            this.f42810c.a(this, (e<T>) this.f42844l, this.f42845m);
        }
    }
}
