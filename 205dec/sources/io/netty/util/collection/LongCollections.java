package io.netty.util.collection;

import io.netty.util.collection.LongObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class LongCollections {
    private static final LongObjectMap<Object> EMPTY_MAP = new EmptyMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class EmptyMap implements LongObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // java.util.Map
        public void clear() {
        }

        @Override // io.netty.util.collection.LongObjectMap
        public boolean containsKey(long j4) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Iterable<LongObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public Set<Map.Entry<Long, Object>> entrySet() {
            return Collections.emptySet();
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Object get(long j4) {
            return null;
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Map
        public Set<Long> keySet() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ?> map) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Object remove(long j4) {
            return null;
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public int size() {
            return 0;
        }

        @Override // java.util.Map
        public Collection<Object> values() {
            return Collections.emptyList();
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Object put(long j4, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public Object put(Long l4, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class UnmodifiableMap<V> implements LongObjectMap<V> {
        private Iterable<LongObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Long, V>> entrySet;
        private Set<Long> keySet;
        private final LongObjectMap<V> map;
        private Collection<V> values;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class EntryImpl implements LongObjectMap.PrimitiveEntry<V> {
            private final LongObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(LongObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public long key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public void setValue(V v3) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        private class IteratorImpl implements Iterator<LongObjectMap.PrimitiveEntry<V>> {
            final Iterator<LongObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<LongObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            @Override // java.util.Iterator
            public LongObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }
        }

        UnmodifiableMap(LongObjectMap<V> longObjectMap) {
            this.map = longObjectMap;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        @Override // io.netty.util.collection.LongObjectMap
        public boolean containsKey(long j4) {
            return this.map.containsKey(j4);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Iterable<LongObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<LongObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.LongCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<LongObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Long, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public V get(long j4) {
            return this.map.get(j4);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public Set<Long> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Long l4, Object obj) {
            return put2(l4, (Long) obj);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends V> map) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // io.netty.util.collection.LongObjectMap
        public V remove(long j4) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            if (this.values == null) {
                this.values = Collections.unmodifiableCollection(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.map.get(obj);
        }

        @Override // io.netty.util.collection.LongObjectMap
        public V put(long j4, V v3) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        /* renamed from: put  reason: avoid collision after fix types in other method */
        public V put2(Long l4, V v3) {
            throw new UnsupportedOperationException("put");
        }
    }

    private LongCollections() {
    }

    public static <V> LongObjectMap<V> emptyMap() {
        return (LongObjectMap<V>) EMPTY_MAP;
    }

    public static <V> LongObjectMap<V> unmodifiableMap(LongObjectMap<V> longObjectMap) {
        return new UnmodifiableMap(longObjectMap);
    }
}
