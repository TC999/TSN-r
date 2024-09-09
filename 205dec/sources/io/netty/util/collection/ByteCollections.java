package io.netty.util.collection;

import io.netty.util.collection.ByteObjectMap;
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
public final class ByteCollections {
    private static final ByteObjectMap<Object> EMPTY_MAP = new EmptyMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class EmptyMap implements ByteObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // java.util.Map
        public void clear() {
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public boolean containsKey(byte b4) {
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

        @Override // io.netty.util.collection.ByteObjectMap
        public Iterable<ByteObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public Set<Map.Entry<Byte, Object>> entrySet() {
            return Collections.emptySet();
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public Object get(byte b4) {
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
        public Set<Byte> keySet() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ?> map) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public Object remove(byte b4) {
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

        @Override // io.netty.util.collection.ByteObjectMap
        public Object put(byte b4, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public Object put(Byte b4, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class UnmodifiableMap<V> implements ByteObjectMap<V> {
        private Iterable<ByteObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Byte, V>> entrySet;
        private Set<Byte> keySet;
        private final ByteObjectMap<V> map;
        private Collection<V> values;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class EntryImpl implements ByteObjectMap.PrimitiveEntry<V> {
            private final ByteObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(ByteObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public byte key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public void setValue(V v3) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        private class IteratorImpl implements Iterator<ByteObjectMap.PrimitiveEntry<V>> {
            final Iterator<ByteObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<ByteObjectMap.PrimitiveEntry<V>> it) {
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
            public ByteObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }
        }

        UnmodifiableMap(ByteObjectMap<V> byteObjectMap) {
            this.map = byteObjectMap;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public boolean containsKey(byte b4) {
            return this.map.containsKey(b4);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public Iterable<ByteObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<ByteObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ByteCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Byte, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public V get(byte b4) {
            return this.map.get(b4);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public Set<Byte> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Byte b4, Object obj) {
            return put2(b4, (Byte) obj);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends V> map) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public V remove(byte b4) {
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

        @Override // io.netty.util.collection.ByteObjectMap
        public V put(byte b4, V v3) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        /* renamed from: put  reason: avoid collision after fix types in other method */
        public V put2(Byte b4, V v3) {
            throw new UnsupportedOperationException("put");
        }
    }

    private ByteCollections() {
    }

    public static <V> ByteObjectMap<V> emptyMap() {
        return (ByteObjectMap<V>) EMPTY_MAP;
    }

    public static <V> ByteObjectMap<V> unmodifiableMap(ByteObjectMap<V> byteObjectMap) {
        return new UnmodifiableMap(byteObjectMap);
    }
}
