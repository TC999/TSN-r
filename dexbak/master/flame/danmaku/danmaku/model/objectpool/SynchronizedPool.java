package master.flame.danmaku.danmaku.model.objectpool;

import master.flame.danmaku.danmaku.model.objectpool.InterfaceC15354c;

/* renamed from: master.flame.danmaku.danmaku.model.objectpool.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class SynchronizedPool<T extends InterfaceC15354c<T>> implements Pool<T> {

    /* renamed from: a */
    private final Pool<T> f43921a;

    /* renamed from: b */
    private final Object f43922b;

    public SynchronizedPool(Pool<T> pool) {
        this.f43921a = pool;
        this.f43922b = this;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Pool
    /* renamed from: a */
    public void mo3008a(T t) {
        synchronized (this.f43922b) {
            this.f43921a.mo3008a(t);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Pool
    public T acquire() {
        T acquire;
        synchronized (this.f43922b) {
            acquire = this.f43921a.acquire();
        }
        return acquire;
    }

    public SynchronizedPool(Pool<T> pool, Object obj) {
        this.f43921a = pool;
        this.f43922b = obj;
    }
}
