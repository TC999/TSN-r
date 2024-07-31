package io.netty.util.collection;

import io.netty.util.collection.ShortObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ShortCollections {
    private static final ShortObjectMap<Object> EMPTY_MAP = new EmptyMap();

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class EmptyMap implements ShortObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // java.util.Map
        public void clear() {
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public boolean containsKey(short s) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public Iterable<ShortObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public Set<Map.Entry<Short, Object>> entrySet() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return null;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public Object get(short s) {
            return null;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Map
        public Set<Short> keySet() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ?> map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            return null;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public Object remove(short s) {
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

        @Override // io.netty.util.collection.ShortObjectMap
        public Object put(short s, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public Object put(Short sh, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class UnmodifiableMap<V> implements ShortObjectMap<V> {
        private Iterable<ShortObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Short, V>> entrySet;
        private Set<Short> keySet;
        private final ShortObjectMap<V> map;
        private Collection<V> values;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public class EntryImpl implements ShortObjectMap.PrimitiveEntry<V> {
            private final ShortObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(ShortObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.ShortObjectMap.PrimitiveEntry
            public short key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.ShortObjectMap.PrimitiveEntry
            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.ShortObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        private class IteratorImpl implements Iterator<ShortObjectMap.PrimitiveEntry<V>> {
            final Iterator<ShortObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<ShortObjectMap.PrimitiveEntry<V>> it) {
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
            public ShortObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }
        }

        UnmodifiableMap(ShortObjectMap<V> shortObjectMap) {
            this.map = shortObjectMap;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public boolean containsKey(short s) {
            return this.map.containsKey(s);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public Iterable<ShortObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<ShortObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ShortCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<ShortObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Short, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public V get(short s) {
            return this.map.get(s);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public Set<Short> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Short sh, Object obj) {
            return put2(sh, (Short) obj);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends V> map) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public V remove(short s) {
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

        @Override // io.netty.util.collection.ShortObjectMap
        public V put(short s, V v) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        /* renamed from: put  reason: avoid collision after fix types in other method */
        public V put2(Short sh, V v) {
            throw new UnsupportedOperationException("put");
        }
    }

    private ShortCollections() {
    }

    public static <V> ShortObjectMap<V> emptyMap() {
        return (ShortObjectMap<V>) EMPTY_MAP;
    }

    public static <V> ShortObjectMap<V> unmodifiableMap(ShortObjectMap<V> shortObjectMap) {
        return new UnmodifiableMap(shortObjectMap);
    }
}
