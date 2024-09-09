package master.flame.danmaku.danmaku.model.objectpool;

import master.flame.danmaku.danmaku.model.objectpool.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SynchronizedPool.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class f<T extends c<T>> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f61204a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f61205b;

    public f(b<T> bVar) {
        this.f61204a = bVar;
        this.f61205b = this;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.b
    public void a(T t3) {
        synchronized (this.f61205b) {
            this.f61204a.a(t3);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.b
    public T acquire() {
        T acquire;
        synchronized (this.f61205b) {
            acquire = this.f61204a.acquire();
        }
        return acquire;
    }

    public f(b<T> bVar, Object obj) {
        this.f61204a = bVar;
        this.f61205b = obj;
    }
}
