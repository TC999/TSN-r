package master.flame.danmaku.controller;

import android.graphics.Canvas;
import f3.a;
import master.flame.danmaku.controller.h;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.parser.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DrawTask.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e implements h {

    /* renamed from: w  reason: collision with root package name */
    static final /* synthetic */ boolean f60965w = false;

    /* renamed from: c  reason: collision with root package name */
    protected final DanmakuContext f60966c;

    /* renamed from: d  reason: collision with root package name */
    protected final master.flame.danmaku.danmaku.model.b f60967d;

    /* renamed from: e  reason: collision with root package name */
    protected m f60968e;

    /* renamed from: f  reason: collision with root package name */
    protected master.flame.danmaku.danmaku.parser.a f60969f;

    /* renamed from: g  reason: collision with root package name */
    h.a f60970g;

    /* renamed from: h  reason: collision with root package name */
    final f3.a f60971h;

    /* renamed from: i  reason: collision with root package name */
    master.flame.danmaku.danmaku.model.f f60972i;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f60974k;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f60977n;

    /* renamed from: o  reason: collision with root package name */
    private long f60978o;

    /* renamed from: p  reason: collision with root package name */
    private long f60979p;

    /* renamed from: q  reason: collision with root package name */
    protected int f60980q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f60981r;

    /* renamed from: s  reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f60982s;

    /* renamed from: u  reason: collision with root package name */
    private m f60984u;

    /* renamed from: j  reason: collision with root package name */
    private m f60973j = new master.flame.danmaku.danmaku.model.android.e(4);

    /* renamed from: l  reason: collision with root package name */
    private long f60975l = 0;

    /* renamed from: m  reason: collision with root package name */
    private final a.c f60976m = new a.c();

    /* renamed from: t  reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.android.e f60983t = new master.flame.danmaku.danmaku.model.android.e(4);

    /* renamed from: v  reason: collision with root package name */
    private DanmakuContext.a f60985v = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawTask.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements DanmakuContext.a {
        a() {
        }

        @Override // master.flame.danmaku.danmaku.model.android.DanmakuContext.a
        public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
            return e.this.t(danmakuContext, danmakuConfigTag, objArr);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawTask.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class b implements a.b {
        b() {
        }

        @Override // f3.a.b
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            h.a aVar = e.this.f60970g;
            if (aVar != null) {
                aVar.a(dVar);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawTask.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class c extends m.c<master.flame.danmaku.danmaku.model.d> {
        c() {
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            if (dVar.f61171z) {
                e.this.u(dVar);
                return 2;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawTask.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class d extends m.c<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: e  reason: collision with root package name */
        long f60989e = g3.c.b();

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f60990f;

        d(int i4) {
            this.f60990f = i4;
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            boolean w3 = dVar.w();
            if (g3.c.b() - this.f60989e <= this.f60990f && w3) {
                e.this.f60968e.g(dVar);
                e.this.u(dVar);
                return 2;
            }
            return 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawTask.java */
    /* renamed from: master.flame.danmaku.controller.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class C1238e extends m.c<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ m f60992e;

        C1238e(m mVar) {
            this.f60992e = mVar;
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            if (!dVar.v() || dVar.s()) {
                return 0;
            }
            this.f60992e.i(dVar);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawTask.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class f implements a.InterfaceC1240a {
        f() {
        }

        @Override // master.flame.danmaku.danmaku.parser.a.InterfaceC1240a
        public void b(master.flame.danmaku.danmaku.model.d dVar) {
            h.a aVar = e.this.f60970g;
            if (aVar != null) {
                aVar.b(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawTask.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class g extends m.c<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f60995e;

        g(long j4) {
            this.f60995e = j4;
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            if (dVar.s()) {
                return 2;
            }
            dVar.E(this.f60995e + dVar.f61147b);
            return dVar.f61147b == 0 ? 2 : 0;
        }
    }

    public e(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar) {
        if (danmakuContext != null) {
            this.f60966c = danmakuContext;
            this.f60967d = danmakuContext.g();
            this.f60970g = aVar;
            master.flame.danmaku.danmaku.renderer.android.a aVar2 = new master.flame.danmaku.danmaku.renderer.android.a(danmakuContext);
            this.f60971h = aVar2;
            aVar2.c(new b());
            aVar2.e(danmakuContext.r() || danmakuContext.q());
            r(fVar);
            Boolean valueOf = Boolean.valueOf(danmakuContext.p());
            if (valueOf != null) {
                if (valueOf.booleanValue()) {
                    danmakuContext.C.f("1017_Filter");
                    return;
                } else {
                    danmakuContext.C.k("1017_Filter");
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    private void n(a.c cVar, m mVar, m mVar2) {
        cVar.e();
        cVar.f54681b.update(g3.c.b());
        cVar.f54682c = 0;
        cVar.f54683d = (mVar != null ? mVar.size() : 0) + (mVar2 != null ? mVar2.size() : 0);
    }

    private void p(a.c cVar) {
        boolean z3 = cVar.f54690k == 0;
        cVar.f54695p = z3;
        if (z3) {
            cVar.f54693n = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = cVar.f54684e;
        cVar.f54684e = null;
        cVar.f54694o = dVar != null ? dVar.b() : -1L;
        cVar.f54692m = cVar.f54681b.update(g3.c.b());
    }

    @Override // master.flame.danmaku.controller.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean i4;
        h.a aVar;
        boolean i5;
        if (this.f60968e == null) {
            return;
        }
        if (dVar.f61171z) {
            this.f60983t.i(dVar);
            v(10);
        }
        dVar.f61164s = this.f60968e.size();
        boolean z3 = true;
        if (this.f60978o <= dVar.b() && dVar.b() <= this.f60979p) {
            synchronized (this.f60973j) {
                i5 = this.f60973j.i(dVar);
            }
            z3 = i5;
        } else if (dVar.f61171z) {
            z3 = false;
        }
        synchronized (this.f60968e) {
            i4 = this.f60968e.i(dVar);
        }
        if (!z3 || !i4) {
            this.f60979p = 0L;
            this.f60978o = 0L;
        }
        if (i4 && (aVar = this.f60970g) != null) {
            aVar.b(dVar);
        }
        master.flame.danmaku.danmaku.model.d dVar2 = this.f60982s;
        if (dVar2 == null || (dVar2 != null && dVar.b() > this.f60982s.b())) {
            this.f60982s = dVar;
        }
    }

    @Override // master.flame.danmaku.controller.h
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        this.f60966c.g().w().a(dVar);
        int i4 = dVar.J | 2;
        dVar.J = i4;
        if (z3) {
            dVar.f61161p = -1.0f;
            dVar.f61162q = -1.0f;
            dVar.J = i4 | 1;
            dVar.f61167v++;
        }
    }

    @Override // master.flame.danmaku.controller.h
    public synchronized void c(boolean z3) {
        m mVar = this.f60968e;
        if (mVar != null && !mVar.isEmpty()) {
            synchronized (this.f60968e) {
                if (!z3) {
                    long j4 = this.f60972i.f61172a;
                    long j5 = this.f60966c.D.f61100e;
                    m d4 = this.f60968e.d((j4 - j5) - 100, j4 + j5);
                    if (d4 != null) {
                        this.f60973j = d4;
                    }
                }
                this.f60968e.clear();
            }
        }
    }

    @Override // master.flame.danmaku.controller.h
    public synchronized void d() {
        m mVar = this.f60973j;
        if (mVar != null && !mVar.isEmpty()) {
            synchronized (this.f60973j) {
                this.f60973j.a(new c());
            }
        }
    }

    @Override // master.flame.danmaku.controller.h
    public m e(long j4) {
        m mVar;
        long j5 = this.f60966c.D.f61100e;
        long j6 = (j4 - j5) - 100;
        long j7 = j4 + j5;
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                mVar = null;
                break;
            }
            try {
                mVar = this.f60968e.d(j6, j7);
                break;
            } catch (Exception unused) {
                i4 = i5;
            }
        }
        master.flame.danmaku.danmaku.model.android.e eVar = new master.flame.danmaku.danmaku.model.android.e();
        if (mVar != null && !mVar.isEmpty()) {
            mVar.a(new C1238e(eVar));
        }
        return eVar;
    }

    @Override // master.flame.danmaku.controller.h
    public void f() {
        this.f60979p = 0L;
        this.f60978o = 0L;
        this.f60981r = false;
    }

    @Override // master.flame.danmaku.controller.h
    public void g(master.flame.danmaku.danmaku.parser.a aVar) {
        this.f60969f = aVar;
        this.f60977n = false;
    }

    @Override // master.flame.danmaku.controller.h
    public void h() {
        this.f60974k = true;
    }

    @Override // master.flame.danmaku.controller.h
    public void i() {
        this.f60966c.X();
        f3.a aVar = this.f60971h;
        if (aVar != null) {
            aVar.release();
        }
    }

    @Override // master.flame.danmaku.controller.h
    public synchronized a.c j(master.flame.danmaku.danmaku.model.b bVar) {
        return o(bVar, this.f60972i);
    }

    @Override // master.flame.danmaku.controller.h
    public void k(long j4) {
        reset();
        this.f60966c.B.g();
        this.f60966c.B.c();
        this.f60975l = j4;
    }

    @Override // master.flame.danmaku.controller.h
    public void l() {
        this.f60981r = true;
    }

    @Override // master.flame.danmaku.controller.h
    public void m(long j4, long j5, long j6) {
        m d4 = this.f60976m.d();
        this.f60984u = d4;
        d4.a(new g(j6));
        this.f60975l = j5;
    }

    protected a.c o(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j4;
        m mVar;
        m mVar2;
        if (this.f60974k) {
            this.f60971h.f();
            this.f60974k = false;
        }
        if (this.f60968e != null) {
            master.flame.danmaku.controller.d.a((Canvas) bVar.x());
            if (this.f60981r) {
                return this.f60976m;
            }
            a.c cVar = this.f60976m;
            long j5 = fVar.f61172a;
            long j6 = this.f60966c.D.f61100e;
            long j7 = (j5 - j6) - 100;
            long j8 = j6 + j5;
            m mVar3 = this.f60973j;
            long j9 = this.f60978o;
            if (j9 <= j7) {
                j4 = this.f60979p;
                if (j5 <= j4) {
                    mVar = mVar3;
                    mVar2 = this.f60984u;
                    n(cVar, mVar2, mVar);
                    if (mVar2 != null && !mVar2.isEmpty()) {
                        a.c cVar2 = this.f60976m;
                        cVar2.f54680a = true;
                        this.f60971h.a(bVar, mVar2, 0L, cVar2);
                    }
                    this.f60976m.f54680a = false;
                    if (mVar == null && !mVar.isEmpty()) {
                        this.f60971h.a(this.f60967d, mVar, this.f60975l, cVar);
                        p(cVar);
                        if (cVar.f54695p) {
                            master.flame.danmaku.danmaku.model.d dVar = this.f60982s;
                            if (dVar != null && dVar.w()) {
                                this.f60982s = null;
                                h.a aVar = this.f60970g;
                                if (aVar != null) {
                                    aVar.d();
                                }
                            }
                            if (cVar.f54693n == -1) {
                                cVar.f54693n = j9;
                            }
                            if (cVar.f54694o == -1) {
                                cVar.f54694o = j4;
                            }
                        }
                        return cVar;
                    }
                    cVar.f54695p = true;
                    cVar.f54693n = j9;
                    cVar.f54694o = j4;
                    return cVar;
                }
            }
            m f4 = this.f60968e.f(j7, j8);
            if (f4 != null) {
                this.f60973j = f4;
            }
            this.f60978o = j7;
            this.f60979p = j8;
            j4 = j8;
            j9 = j7;
            mVar = f4;
            mVar2 = this.f60984u;
            n(cVar, mVar2, mVar);
            if (mVar2 != null) {
                a.c cVar22 = this.f60976m;
                cVar22.f54680a = true;
                this.f60971h.a(bVar, mVar2, 0L, cVar22);
            }
            this.f60976m.f54680a = false;
            if (mVar == null) {
            }
            cVar.f54695p = true;
            cVar.f54693n = j9;
            cVar.f54694o = j4;
            return cVar;
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.h
    public void onPlayStateChanged(int i4) {
        this.f60980q = i4;
    }

    @Override // master.flame.danmaku.controller.h
    public void prepare() {
        s(this.f60969f);
        this.f60979p = 0L;
        this.f60978o = 0L;
        h.a aVar = this.f60970g;
        if (aVar != null) {
            aVar.c();
            this.f60977n = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object[] objArr) {
        Boolean bool;
        boolean z3 = false;
        if (danmakuConfigTag == null || DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN.equals(danmakuConfigTag)) {
            return true;
        }
        if (DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED.equals(danmakuConfigTag)) {
            Boolean bool2 = (Boolean) objArr[0];
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    this.f60966c.C.f("1017_Filter");
                    return true;
                }
                this.f60966c.C.k("1017_Filter");
                return true;
            }
        } else if (!DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            if (!DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) && (bool = (Boolean) objArr[0]) != null) {
                    f3.a aVar = this.f60971h;
                    if (aVar != null) {
                        aVar.b(bool.booleanValue());
                        return true;
                    }
                    return true;
                }
            } else {
                f3.a aVar2 = this.f60971h;
                if (aVar2 != null) {
                    aVar2.e((this.f60966c.r() || this.f60966c.q()) ? true : true);
                    return true;
                }
                return true;
            }
        } else {
            h();
        }
        return false;
    }

    protected void r(master.flame.danmaku.danmaku.model.f fVar) {
        this.f60972i = fVar;
    }

    @Override // master.flame.danmaku.controller.h
    public void reset() {
        if (this.f60973j != null) {
            this.f60973j = new master.flame.danmaku.danmaku.model.android.e();
        }
        f3.a aVar = this.f60971h;
        if (aVar != null) {
            aVar.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(master.flame.danmaku.danmaku.parser.a aVar) {
        this.f60968e = aVar.i(this.f60966c).j(this.f60967d).l(this.f60972i).k(new f()).a();
        this.f60966c.B.a();
        m mVar = this.f60968e;
        if (mVar != null) {
            this.f60982s = mVar.last();
        }
    }

    @Override // master.flame.danmaku.controller.h
    public void seek(long j4) {
        master.flame.danmaku.danmaku.model.d last;
        reset();
        this.f60966c.B.g();
        this.f60966c.B.c();
        this.f60966c.B.f();
        this.f60966c.B.e();
        this.f60984u = new master.flame.danmaku.danmaku.model.android.e(4);
        if (j4 < 1000) {
            j4 = 0;
        }
        this.f60975l = j4;
        this.f60976m.e();
        this.f60976m.f54694o = this.f60975l;
        this.f60979p = 0L;
        this.f60978o = 0L;
        m mVar = this.f60968e;
        if (mVar == null || (last = mVar.last()) == null || last.w()) {
            return;
        }
        this.f60982s = last;
    }

    @Override // master.flame.danmaku.controller.h
    public void start() {
        this.f60966c.u(this.f60985v);
    }

    public boolean t(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean q3 = q(danmakuContext, danmakuConfigTag, objArr);
        h.a aVar = this.f60970g;
        if (aVar != null) {
            aVar.e();
        }
        return q3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void v(int i4) {
        m mVar = this.f60968e;
        if (mVar != null && !mVar.isEmpty() && !this.f60983t.isEmpty()) {
            this.f60983t.a(new d(i4));
        }
    }
}
