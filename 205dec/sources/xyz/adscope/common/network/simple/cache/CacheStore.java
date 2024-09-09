package xyz.adscope.common.network.simple.cache;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface CacheStore {
    public static final CacheStore DEFAULT = new CacheStore() { // from class: xyz.adscope.common.network.simple.cache.CacheStore.1
        @Override // xyz.adscope.common.network.simple.cache.CacheStore
        public boolean clear() {
            return true;
        }

        @Override // xyz.adscope.common.network.simple.cache.CacheStore
        public Cache get(String str) {
            return null;
        }

        @Override // xyz.adscope.common.network.simple.cache.CacheStore
        public boolean remove(String str) {
            return true;
        }

        @Override // xyz.adscope.common.network.simple.cache.CacheStore
        public boolean replace(String str, Cache cache) {
            return true;
        }
    };

    boolean clear();

    Cache get(String str);

    boolean remove(String str);

    boolean replace(String str, Cache cache);
}
