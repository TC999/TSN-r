package master.flame.danmaku.danmaku.model.objectpool;

import master.flame.danmaku.danmaku.model.objectpool.InterfaceC15354c;

/* renamed from: master.flame.danmaku.danmaku.model.objectpool.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class FinitePool<T extends InterfaceC15354c<T>> implements Pool<T> {

    /* renamed from: a */
    private final PoolableManager<T> f43916a;

    /* renamed from: b */
    private final int f43917b;

    /* renamed from: c */
    private final boolean f43918c;

    /* renamed from: d */
    private T f43919d;

    /* renamed from: e */
    private int f43920e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinitePool(PoolableManager<T> poolableManager) {
        this.f43916a = poolableManager;
        this.f43917b = 0;
        this.f43918c = true;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Pool
    /* renamed from: a */
    public void mo3008a(T t) {
        if (!t.mo3017d()) {
            if (this.f43918c || this.f43920e < this.f43917b) {
                this.f43920e++;
                t.mo3016i(this.f43919d);
                t.mo3019a(true);
                this.f43919d = t;
            }
            this.f43916a.mo3015a(t);
            return;
        }
        System.out.print("[FinitePool] Element is already in pool: " + t);
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Pool
    public T acquire() {
        T t = this.f43919d;
        if (t != null) {
            this.f43919d = (T) t.mo3018c();
            this.f43920e--;
        } else {
            t = this.f43916a.mo3014b();
        }
        if (t != null) {
            t.mo3016i(null);
            t.mo3019a(false);
            this.f43916a.mo3013c(t);
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinitePool(PoolableManager<T> poolableManager, int i) {
        if (i > 0) {
            this.f43916a = poolableManager;
            this.f43917b = i;
            this.f43918c = false;
            return;
        }
        throw new IllegalArgumentException("The pool limit must be > 0");
    }
}
