package master.flame.danmaku.danmaku.model.objectpool;

import master.flame.danmaku.danmaku.model.objectpool.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FinitePool.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class a<T extends c<T>> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d<T> f61199a;

    /* renamed from: b  reason: collision with root package name */
    private final int f61200b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f61201c;

    /* renamed from: d  reason: collision with root package name */
    private T f61202d;

    /* renamed from: e  reason: collision with root package name */
    private int f61203e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar) {
        this.f61199a = dVar;
        this.f61200b = 0;
        this.f61201c = true;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.b
    public void a(T t3) {
        if (!t3.d()) {
            if (this.f61201c || this.f61203e < this.f61200b) {
                this.f61203e++;
                t3.i(this.f61202d);
                t3.a(true);
                this.f61202d = t3;
            }
            this.f61199a.a(t3);
            return;
        }
        System.out.print("[FinitePool] Element is already in pool: " + t3);
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.b
    public T acquire() {
        T t3 = this.f61202d;
        if (t3 != null) {
            this.f61202d = (T) t3.c();
            this.f61203e--;
        } else {
            t3 = this.f61199a.b();
        }
        if (t3 != null) {
            t3.i(null);
            t3.a(false);
            this.f61199a.c(t3);
        }
        return t3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i4) {
        if (i4 > 0) {
            this.f61199a = dVar;
            this.f61200b = i4;
            this.f61201c = false;
            return;
        }
        throw new IllegalArgumentException("The pool limit must be > 0");
    }
}
