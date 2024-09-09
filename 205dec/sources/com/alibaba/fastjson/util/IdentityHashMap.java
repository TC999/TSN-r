package com.alibaba.fastjson.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class IdentityHashMap<K, V> {
    private final Entry<K, V>[] buckets;
    private final int indexMask;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    protected static final class Entry<K, V> {
        public final int hashCode;
        public final K key;
        public final Entry<K, V> next;
        public V value;

        public Entry(K k4, V v3, int i4, Entry<K, V> entry) {
            this.key = k4;
            this.value = v3;
            this.next = entry;
            this.hashCode = i4;
        }
    }

    public IdentityHashMap() {
        this(1024);
    }

    public Class findClass(String str) {
        Entry<K, V>[] entryArr;
        for (Entry<K, V> entry : this.buckets) {
            if (entry != null) {
                for (Entry<K, V> entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    K k4 = entry.key;
                    if (k4 instanceof Class) {
                        Class cls = (Class) k4;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    public final V get(K k4) {
        for (Entry<K, V> entry = this.buckets[System.identityHashCode(k4) & this.indexMask]; entry != null; entry = entry.next) {
            if (k4 == entry.key) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean put(K k4, V v3) {
        int identityHashCode = System.identityHashCode(k4);
        int i4 = this.indexMask & identityHashCode;
        for (Entry<K, V> entry = this.buckets[i4]; entry != null; entry = entry.next) {
            if (k4 == entry.key) {
                entry.value = v3;
                return true;
            }
        }
        this.buckets[i4] = new Entry<>(k4, v3, identityHashCode, this.buckets[i4]);
        return false;
    }

    public IdentityHashMap(int i4) {
        this.indexMask = i4 - 1;
        this.buckets = new Entry[i4];
    }
}
