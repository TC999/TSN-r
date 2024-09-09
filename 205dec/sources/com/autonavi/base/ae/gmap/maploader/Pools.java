package com.autonavi.base.ae.gmap.maploader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class Pools {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface Pool<T> {
        T acquire();

        void destory();

        boolean release(T t3);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i4) {
            if (i4 > 0) {
                this.mPool = new Object[i4];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T t3) {
            for (int i4 = 0; i4 < this.mPoolSize; i4++) {
                if (this.mPool[i4] == t3) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            int i4 = this.mPoolSize;
            if (i4 > 0) {
                int i5 = i4 - 1;
                Object[] objArr = this.mPool;
                T t3 = (T) objArr[i5];
                objArr[i5] = null;
                this.mPoolSize = i4 - 1;
                return t3;
            }
            return null;
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public void destory() {
            int i4 = 0;
            while (true) {
                Object[] objArr = this.mPool;
                if (i4 >= objArr.length) {
                    return;
                }
                objArr[i4] = null;
                i4++;
            }
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public boolean release(T t3) {
            if (!isInPool(t3)) {
                int i4 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i4 < objArr.length) {
                    objArr[i4] = t3;
                    this.mPoolSize = i4 + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i4) {
            super(i4);
            this.mLock = new Object();
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.SimplePool, com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            T t3;
            synchronized (this.mLock) {
                t3 = (T) super.acquire();
            }
            return t3;
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.SimplePool, com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public boolean release(T t3) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t3);
            }
            return release;
        }
    }

    private Pools() {
    }
}
