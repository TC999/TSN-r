package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.o;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DrawingCache.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f implements o<g>, master.flame.danmaku.danmaku.model.objectpool.c<f> {

    /* renamed from: c  reason: collision with root package name */
    private f f61123c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f61124d;

    /* renamed from: b  reason: collision with root package name */
    private int f61122b = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f61125e = 0;

    /* renamed from: a  reason: collision with root package name */
    private final g f61121a = new g();

    @Override // master.flame.danmaku.danmaku.model.objectpool.c
    public void a(boolean z3) {
        this.f61124d = z3;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public int b() {
        return this.f61121a.f61131f;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.c
    public boolean d() {
        return this.f61124d;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public void destroy() {
        g gVar = this.f61121a;
        if (gVar != null) {
            gVar.f();
        }
        this.f61122b = 0;
        this.f61125e = 0;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public synchronized void e() {
        this.f61125e--;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public void f(int i4, int i5, int i6, boolean z3, int i7) {
        this.f61121a.a(i4, i5, i6, z3, i7);
        this.f61122b = this.f61121a.f61127b.getRowBytes() * this.f61121a.f61127b.getHeight();
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public int g() {
        return this.f61121a.f61130e;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public void h() {
        this.f61121a.c();
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public synchronized boolean hasReferences() {
        return this.f61125e > 0;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public synchronized void j() {
        this.f61125e++;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    /* renamed from: k */
    public g get() {
        g gVar = this.f61121a;
        if (gVar.f61127b == null) {
            return null;
        }
        return gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.c
    /* renamed from: l */
    public f c() {
        return this.f61123c;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.c
    /* renamed from: m */
    public void i(f fVar) {
        this.f61123c = fVar;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public int size() {
        return this.f61122b;
    }
}
