package io.netty.util.collection;

import io.netty.util.collection.ByteObjectMap;
import io.netty.util.internal.MathUtil;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ByteObjectHashMap<V> implements ByteObjectMap<V> {
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE = new Object();
    private final Iterable<ByteObjectMap.PrimitiveEntry<V>> entries;
    private final Set<Map.Entry<Byte, V>> entrySet;
    private final Set<Byte> keySet;
    private byte[] keys;
    private final float loadFactor;
    private int mask;
    private int maxSize;
    private int size;
    private V[] values;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class EntrySet extends AbstractSet<Map.Entry<Byte, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Byte, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ByteObjectHashMap.this.size();
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class KeySet extends AbstractSet<Byte> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ByteObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ByteObjectHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Byte> iterator() {
            return new Iterator<Byte>() { // from class: io.netty.util.collection.ByteObjectHashMap.KeySet.1
                private final Iterator<Map.Entry<Byte, V>> iter;

                {
                    this.iter = ByteObjectHashMap.this.entrySet.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.iter.remove();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Byte next() {
                    return this.iter.next().getKey();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return ByteObjectHashMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Iterator<ByteObjectMap.PrimitiveEntry<V>> it = ByteObjectHashMap.this.entries().iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Byte.valueOf(it.next().key()))) {
                    z = true;
                    it.remove();
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ByteObjectHashMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class MapEntry implements Map.Entry<Byte, V> {
        private final int entryIndex;

        MapEntry(int i) {
            this.entryIndex = i;
        }

        private void verifyExists() {
            if (ByteObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            verifyExists();
            return (V) ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            verifyExists();
            V v2 = (V) ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
            ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(v);
            return v2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public Byte getKey() {
            verifyExists();
            return Byte.valueOf(ByteObjectHashMap.this.keys[this.entryIndex]);
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class MapIterator implements Iterator<Map.Entry<Byte, V>> {
        private final ByteObjectHashMap<V>.PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<Byte, V> next() {
            if (hasNext()) {
                this.iter.next();
                return new MapEntry(((PrimitiveIterator) this.iter).entryIndex);
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class PrimitiveIterator implements Iterator<ByteObjectMap.PrimitiveEntry<V>>, ByteObjectMap.PrimitiveEntry<V> {
        private int entryIndex;
        private int nextIndex;
        private int prevIndex;

        private PrimitiveIterator() {
            this.prevIndex = -1;
            this.nextIndex = -1;
            this.entryIndex = -1;
        }

        private void scanNext() {
            do {
                int i = this.nextIndex + 1;
                this.nextIndex = i;
                if (i == ByteObjectHashMap.this.values.length) {
                    return;
                }
            } while (ByteObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex < ByteObjectHashMap.this.keys.length;
        }

        @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
        public byte key() {
            return ByteObjectHashMap.this.keys[this.entryIndex];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.prevIndex;
            if (i >= 0) {
                if (ByteObjectHashMap.this.removeAt(i)) {
                    this.nextIndex = this.prevIndex;
                }
                this.prevIndex = -1;
                return;
            }
            throw new IllegalStateException("next must be called before each remove.");
        }

        @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
        public void setValue(V v) {
            ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(v);
        }

        @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
        public V value() {
            return (V) ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Iterator
        public ByteObjectMap.PrimitiveEntry<V> next() {
            if (hasNext()) {
                this.prevIndex = this.nextIndex;
                scanNext();
                this.entryIndex = this.prevIndex;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    public ByteObjectHashMap() {
        this(8, 0.5f);
    }

    private int calcMaxSize(int i) {
        return Math.min(i - 1, (int) (i * this.loadFactor));
    }

    private void growSize() {
        int i = this.size + 1;
        this.size = i;
        if (i > this.maxSize) {
            byte[] bArr = this.keys;
            if (bArr.length != Integer.MAX_VALUE) {
                rehash(bArr.length << 1);
                return;
            }
            throw new IllegalStateException("Max capacity reached at size=" + this.size);
        }
    }

    private static int hashCode(byte b) {
        return b;
    }

    private int hashIndex(byte b) {
        return hashCode(b) & this.mask;
    }

    private int indexOf(byte b) {
        int hashIndex = hashIndex(b);
        int i = hashIndex;
        while (this.values[i] != null) {
            if (b == this.keys[i]) {
                return i;
            }
            i = probeNext(i);
            if (i == hashIndex) {
                return -1;
            }
        }
        return -1;
    }

    private byte objectToKey(Object obj) {
        return ((Byte) obj).byteValue();
    }

    private int probeNext(int i) {
        return (i + 1) & this.mask;
    }

    private void rehash(int i) {
        V[] vArr;
        byte[] bArr = this.keys;
        V[] vArr2 = this.values;
        this.keys = new byte[i];
        this.values = (V[]) new Object[i];
        this.maxSize = calcMaxSize(i);
        this.mask = i - 1;
        for (int i2 = 0; i2 < vArr2.length; i2++) {
            V v = vArr2[i2];
            if (v != null) {
                byte b = bArr[i2];
                int hashIndex = hashIndex(b);
                while (true) {
                    vArr = this.values;
                    if (vArr[hashIndex] == null) {
                        break;
                    }
                    hashIndex = probeNext(hashIndex);
                }
                this.keys[hashIndex] = b;
                vArr[hashIndex] = v;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeAt(int i) {
        this.size--;
        this.keys[i] = 0;
        this.values[i] = null;
        int probeNext = probeNext(i);
        boolean z = false;
        while (this.values[probeNext] != null) {
            int hashIndex = hashIndex(this.keys[probeNext]);
            if ((probeNext < hashIndex && (hashIndex <= i || i <= probeNext)) || (hashIndex <= i && i <= probeNext)) {
                byte[] bArr = this.keys;
                bArr[i] = bArr[probeNext];
                V[] vArr = this.values;
                vArr[i] = vArr[probeNext];
                bArr[probeNext] = 0;
                vArr[probeNext] = null;
                i = probeNext;
                z = true;
            }
            probeNext = probeNext(probeNext);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toExternal(T t) {
        if (t == NULL_VALUE) {
            return null;
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toInternal(T t) {
        return t == null ? (T) NULL_VALUE : t;
    }

    @Override // java.util.Map
    public void clear() {
        Arrays.fill(this.keys, (byte) 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    @Override // io.netty.util.collection.ByteObjectMap
    public boolean containsKey(byte b) {
        return indexOf(b) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        V[] vArr;
        Object internal = toInternal(obj);
        for (V v : this.values) {
            if (v != null && v.equals(internal)) {
                return true;
            }
        }
        return false;
    }

    @Override // io.netty.util.collection.ByteObjectMap
    public Iterable<ByteObjectMap.PrimitiveEntry<V>> entries() {
        return this.entries;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Byte, V>> entrySet() {
        return this.entrySet;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ByteObjectMap)) {
            return false;
        }
        ByteObjectMap byteObjectMap = (ByteObjectMap) obj;
        if (this.size != byteObjectMap.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            V[] vArr = this.values;
            if (i >= vArr.length) {
                return true;
            }
            V v = vArr[i];
            if (v != null) {
                Object obj2 = byteObjectMap.get(this.keys[i]);
                if (v == NULL_VALUE) {
                    if (obj2 != null) {
                        return false;
                    }
                } else if (!v.equals(obj2)) {
                    return false;
                }
            }
            i++;
        }
    }

    @Override // io.netty.util.collection.ByteObjectMap
    public V get(byte b) {
        int indexOf = indexOf(b);
        if (indexOf == -1) {
            return null;
        }
        return (V) toExternal(this.values[indexOf]);
    }

    @Override // java.util.Map
    public int hashCode() {
        int i = this.size;
        for (byte b : this.keys) {
            i ^= hashCode(b);
        }
        return i;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.Map
    public Set<Byte> keySet() {
        return this.keySet;
    }

    protected String keyToString(byte b) {
        return Byte.toString(b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Byte b, Object obj) {
        return put2(b, (Byte) obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Byte, ? extends V> map) {
        if (map instanceof ByteObjectHashMap) {
            ByteObjectHashMap byteObjectHashMap = (ByteObjectHashMap) map;
            int i = 0;
            while (true) {
                V[] vArr = byteObjectHashMap.values;
                if (i >= vArr.length) {
                    return;
                }
                V v = vArr[i];
                if (v != null) {
                    put(byteObjectHashMap.keys[i], (byte) v);
                }
                i++;
            }
        } else {
            for (Map.Entry<? extends Byte, ? extends V> entry : map.entrySet()) {
                put2(entry.getKey(), (Byte) entry.getValue());
            }
        }
    }

    @Override // io.netty.util.collection.ByteObjectMap
    public V remove(byte b) {
        int indexOf = indexOf(b);
        if (indexOf == -1) {
            return null;
        }
        V v = this.values[indexOf];
        removeAt(indexOf);
        return (V) toExternal(v);
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 4);
        sb.append('{');
        boolean z = true;
        int i = 0;
        while (true) {
            V[] vArr = this.values;
            if (i < vArr.length) {
                V v = vArr[i];
                if (v != null) {
                    if (!z) {
                        sb.append(", ");
                    }
                    sb.append(keyToString(this.keys[i]));
                    sb.append('=');
                    sb.append(v == this ? "(this Map)" : toExternal(v));
                    z = false;
                }
                i++;
            } else {
                sb.append('}');
                return sb.toString();
            }
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new AbstractCollection<V>() { // from class: io.netty.util.collection.ByteObjectHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<V> iterator() {
                return new Iterator<V>() { // from class: io.netty.util.collection.ByteObjectHashMap.2.1
                    final ByteObjectHashMap<V>.PrimitiveIterator iter;

                    {
                        this.iter = new PrimitiveIterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.iter.next().value();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return ByteObjectHashMap.this.size;
            }
        };
    }

    public ByteObjectHashMap(int i) {
        this(i, 0.5f);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return containsKey(objectToKey(obj));
    }

    @Override // io.netty.util.collection.ByteObjectMap
    public V put(byte b, V v) {
        int hashIndex = hashIndex(b);
        int i = hashIndex;
        do {
            Object[] objArr = this.values;
            if (objArr[i] == null) {
                this.keys[i] = b;
                objArr[i] = toInternal(v);
                growSize();
                return null;
            } else if (this.keys[i] == b) {
                Object obj = objArr[i];
                objArr[i] = toInternal(v);
                return (V) toExternal(obj);
            } else {
                i = probeNext(i);
            }
        } while (i != hashIndex);
        throw new IllegalStateException("Unable to insert");
    }

    public ByteObjectHashMap(int i, float f) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<ByteObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ByteObjectHashMap.1
            @Override // java.lang.Iterable
            public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (f > 0.0f && f <= 1.0f) {
            this.loadFactor = f;
            int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i);
            this.mask = safeFindNextPositivePowerOfTwo - 1;
            this.keys = new byte[safeFindNextPositivePowerOfTwo];
            this.values = (V[]) new Object[safeFindNextPositivePowerOfTwo];
            this.maxSize = calcMaxSize(safeFindNextPositivePowerOfTwo);
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return get(objectToKey(obj));
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return remove(objectToKey(obj));
    }

    /* renamed from: put  reason: avoid collision after fix types in other method */
    public V put2(Byte b, V v) {
        return put(objectToKey(b), (byte) v);
    }
}
