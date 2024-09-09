package master.flame.danmaku.danmaku.renderer.android;

import f3.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.renderer.android.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DanmakuRenderer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a extends f3.b {

    /* renamed from: d  reason: collision with root package name */
    private f f61249d;

    /* renamed from: e  reason: collision with root package name */
    private final DanmakuContext f61250e;

    /* renamed from: f  reason: collision with root package name */
    private b.g f61251f;

    /* renamed from: h  reason: collision with root package name */
    private final master.flame.danmaku.danmaku.renderer.android.b f61253h;

    /* renamed from: i  reason: collision with root package name */
    private k f61254i;

    /* renamed from: j  reason: collision with root package name */
    private a.b f61255j;

    /* renamed from: g  reason: collision with root package name */
    private final b.g f61252g = new C1241a();

    /* renamed from: k  reason: collision with root package name */
    private b f61256k = new b(this, null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuRenderer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class C1241a implements b.g {
        C1241a() {
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.g
        public boolean a(d dVar, float f4, int i4, boolean z3) {
            if (dVar.f61160o == 0 && a.this.f61250e.C.c(dVar, i4, 0, a.this.f61249d, z3, a.this.f61250e)) {
                dVar.G(false);
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuRenderer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private class b extends m.c<d> {

        /* renamed from: e  reason: collision with root package name */
        private d f61258e;

        /* renamed from: f  reason: collision with root package name */
        public n f61259f;

        /* renamed from: g  reason: collision with root package name */
        public a.c f61260g;

        /* renamed from: h  reason: collision with root package name */
        public long f61261h;

        private b() {
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        public void b() {
            this.f61260g.f54684e = this.f61258e;
            super.b();
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e */
        public int a(d dVar) {
            this.f61258e = dVar;
            if (dVar.w()) {
                this.f61259f.n(dVar);
                return this.f61260g.f54680a ? 2 : 0;
            } else if (this.f61260g.f54680a || !dVar.r()) {
                if (!dVar.m()) {
                    master.flame.danmaku.controller.b bVar = a.this.f61250e.C;
                    a.c cVar = this.f61260g;
                    bVar.b(dVar, cVar.f54682c, cVar.f54683d, cVar.f54681b, false, a.this.f61250e);
                }
                if (dVar.b() >= this.f61261h && (dVar.f61160o != 0 || !dVar.n())) {
                    if (dVar.p()) {
                        o<?> e4 = dVar.e();
                        if (a.this.f61254i != null && (e4 == null || e4.get() == null)) {
                            a.this.f61254i.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.f61260g.f54682c++;
                    }
                    if (!dVar.q()) {
                        dVar.z(this.f61259f, false);
                    }
                    if (!dVar.u()) {
                        dVar.A(this.f61259f, false);
                    }
                    a.this.f61253h.c(dVar, this.f61259f, a.this.f61251f);
                    if (!dVar.v() || (dVar.f61149d == null && dVar.d() > this.f61259f.getHeight())) {
                        return 0;
                    }
                    int a4 = dVar.a(this.f61259f);
                    if (a4 == 1) {
                        this.f61260g.f54697r++;
                    } else if (a4 == 2) {
                        this.f61260g.f54698s++;
                        if (a.this.f61254i != null) {
                            a.this.f61254i.a(dVar);
                        }
                    }
                    this.f61260g.a(dVar.getType(), 1);
                    this.f61260g.b(1);
                    this.f61260g.c(dVar);
                    if (a.this.f61255j != null && dVar.K != a.this.f61250e.B.f61182d) {
                        dVar.K = a.this.f61250e.B.f61182d;
                        a.this.f61255j.a(dVar);
                    }
                }
                return 0;
            } else {
                return 0;
            }
        }

        /* synthetic */ b(a aVar, C1241a c1241a) {
            this();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.f61250e = danmakuContext;
        this.f61253h = new master.flame.danmaku.danmaku.renderer.android.b(danmakuContext.o());
    }

    @Override // f3.a
    public void a(n nVar, m mVar, long j4, a.c cVar) {
        this.f61249d = cVar.f54681b;
        b bVar = this.f61256k;
        bVar.f61259f = nVar;
        bVar.f61260g = cVar;
        bVar.f61261h = j4;
        mVar.a(bVar);
    }

    @Override // f3.a
    public void b(boolean z3) {
        master.flame.danmaku.danmaku.renderer.android.b bVar = this.f61253h;
        if (bVar != null) {
            bVar.a(z3);
        }
    }

    @Override // f3.a
    public void c(a.b bVar) {
        this.f61255j = bVar;
    }

    @Override // f3.a
    public void clear() {
        f();
        this.f61250e.C.a();
    }

    @Override // f3.a
    public void d(k kVar) {
        this.f61254i = kVar;
    }

    @Override // f3.a
    public void e(boolean z3) {
        this.f61251f = z3 ? this.f61252g : null;
    }

    @Override // f3.a
    public void f() {
        this.f61253h.b();
    }

    @Override // f3.a
    public void g() {
        this.f61255j = null;
    }

    @Override // f3.a
    public void release() {
        this.f61253h.d();
        this.f61250e.C.a();
    }
}
