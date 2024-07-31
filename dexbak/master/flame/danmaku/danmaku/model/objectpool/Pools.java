package master.flame.danmaku.danmaku.model.objectpool;

/* renamed from: master.flame.danmaku.danmaku.model.objectpool.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Pools {
    private Pools() {
    }

    /* renamed from: a */
    public static <T extends InterfaceC15354c<T>> Pool<T> m3012a(PoolableManager<T> poolableManager, int i) {
        return new FinitePool(poolableManager, i);
    }

    /* renamed from: b */
    public static <T extends InterfaceC15354c<T>> Pool<T> m3011b(PoolableManager<T> poolableManager) {
        return new FinitePool(poolableManager);
    }

    /* renamed from: c */
    public static <T extends InterfaceC15354c<T>> Pool<T> m3010c(Pool<T> pool) {
        return new SynchronizedPool(pool);
    }

    /* renamed from: d */
    public static <T extends InterfaceC15354c<T>> Pool<T> m3009d(Pool<T> pool, Object obj) {
        return new SynchronizedPool(pool, obj);
    }
}
