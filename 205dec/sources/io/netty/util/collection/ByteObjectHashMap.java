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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ByteObjectHashMap<V> implements ByteObjectMap<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
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
            boolean z3 = false;
            while (it.hasNext()) {
                if (!collection.contains(Byte.valueOf(it.next().key()))) {
                    z3 = true;
                    it.remove();
                }
            }
            return z3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ByteObjectHashMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class MapEntry implements Map.Entry<Byte, V> {
        private final int entryIndex;

        MapEntry(int i4) {
            this.entryIndex = i4;
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
        public V setValue(V v3) {
            verifyExists();
            V v4 = (V) ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
            ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(v3);
            return v4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public Byte getKey() {
            verifyExists();
            return Byte.valueOf(ByteObjectHashMap.this.keys[this.entryIndex]);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
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
                int i4 = this.nextIndex + 1;
                this.nextIndex = i4;
                if (i4 == ByteObjectHashMap.this.values.length) {
                    return;
                }
            } while (ByteObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex != ByteObjectHashMap.this.values.length;
        }

        @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
        public byte key() {
            return ByteObjectHashMap.this.keys[this.entryIndex];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i4 = this.prevIndex;
            if (i4 != -1) {
                if (ByteObjectHashMap.this.removeAt(i4)) {
                    this.nextIndex = this.prevIndex;
                }
                this.prevIndex = -1;
                return;
            }
            throw new IllegalStateException("next must be called before each remove.");
        }

        @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
        public void setValue(V v3) {
            ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(v3);
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

    private int calcMaxSize(int i4) {
        return Math.min(i4 - 1, (int) (i4 * this.loadFactor));
    }

    private void growSize() {
        int i4 = this.size + 1;
        this.size = i4;
        if (i4 > this.maxSize) {
            byte[] bArr = this.keys;
            if (bArr.length != Integer.MAX_VALUE) {
                rehash(bArr.length << 1);
                return;
            }
            throw new IllegalStateException("Max capacity reached at size=" + this.size);
        }
    }

    private static int hashCode(byte b4) {
        return b4;
    }

    private int hashIndex(byte b4) {
        return hashCode(b4) & this.mask;
    }

    private int indexOf(byte b4) {
        int hashIndex = hashIndex(b4);
        int i4 = hashIndex;
        while (this.values[i4] != null) {
            if (b4 == this.keys[i4]) {
                return i4;
            }
            i4 = probeNext(i4);
            if (i4 == hashIndex) {
                return -1;
            }
        }
        return -1;
    }

    private byte objectToKey(Object obj) {
        return ((Byte) obj).byteValue();
    }

    private int probeNext(int i4) {
        return (i4 + 1) & this.mask;
    }

    private void rehash(int i4) {
        V[] vArr;
        byte[] bArr = this.keys;
        V[] vArr2 = this.values;
        this.keys = new byte[i4];
        this.values = (V[]) new Object[i4];
        this.maxSize = calcMaxSize(i4);
        this.mask = i4 - 1;
        for (int i5 = 0; i5 < vArr2.length; i5++) {
            V v3 = vArr2[i5];
            if (v3 != null) {
                byte b4 = bArr[i5];
                int hashIndex = hashIndex(b4);
                while (true) {
                    vArr = this.values;
                    if (vArr[hashIndex] == null) {
                        break;
                    }
                    hashIndex = probeNext(hashIndex);
                }
                this.keys[hashIndex] = b4;
                vArr[hashIndex] = v3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeAt(int i4) {
        this.size--;
        this.keys[i4] = 0;
        this.values[i4] = null;
        int probeNext = probeNext(i4);
        V v3 = this.values[probeNext];
        int i5 = i4;
        while (v3 != null) {
            byte b4 = this.keys[probeNext];
            int hashIndex = hashIndex(b4);
            if ((probeNext < hashIndex && (hashIndex <= i5 || i5 <= probeNext)) || (hashIndex <= i5 && i5 <= probeNext)) {
                byte[] bArr = this.keys;
                bArr[i5] = b4;
                V[] vArr = this.values;
                vArr[i5] = v3;
                bArr[probeNext] = 0;
                vArr[probeNext] = null;
                i5 = probeNext;
            }
            V[] vArr2 = this.values;
            probeNext = probeNext(probeNext);
            v3 = vArr2[probeNext];
        }
        return i5 != i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toExternal(T t3) {
        if (t3 == NULL_VALUE) {
            return null;
        }
        return t3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toInternal(T t3) {
        return t3 == null ? (T) NULL_VALUE : t3;
    }

    @Override // java.util.Map
    public void clear() {
        Arrays.fill(this.keys, (byte) 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    @Override // io.netty.util.collection.ByteObjectMap
    public boolean containsKey(byte b4) {
        return indexOf(b4) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        V[] vArr;
        Object internal = toInternal(obj);
        for (V v3 : this.values) {
            if (v3 != null && v3.equals(internal)) {
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
        int i4 = 0;
        while (true) {
            V[] vArr = this.values;
            if (i4 >= vArr.length) {
                return true;
            }
            V v3 = vArr[i4];
            if (v3 != null) {
                Object obj2 = byteObjectMap.get(this.keys[i4]);
                if (v3 == NULL_VALUE) {
                    if (obj2 != null) {
                        return false;
                    }
                } else if (!v3.equals(obj2)) {
                    return false;
                }
            }
            i4++;
        }
    }

    @Override // io.netty.util.collection.ByteObjectMap
    public V get(byte b4) {
        int indexOf = indexOf(b4);
        if (indexOf == -1) {
            return null;
        }
        return (V) toExternal(this.values[indexOf]);
    }

    @Override // java.util.Map
    public int hashCode() {
        int i4 = this.size;
        for (byte b4 : this.keys) {
            i4 ^= hashCode(b4);
        }
        return i4;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.Map
    public Set<Byte> keySet() {
        return this.keySet;
    }

    protected String keyToString(byte b4) {
        return Byte.toString(b4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Byte b4, Object obj) {
        return put2(b4, (Byte) obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Byte, ? extends V> map) {
        if (map instanceof ByteObjectHashMap) {
            ByteObjectHashMap byteObjectHashMap = (ByteObjectHashMap) map;
            int i4 = 0;
            while (true) {
                V[] vArr = byteObjectHashMap.values;
                if (i4 >= vArr.length) {
                    return;
                }
                V v3 = vArr[i4];
                if (v3 != null) {
                    put(byteObjectHashMap.keys[i4], (byte) v3);
                }
                i4++;
            }
        } else {
            for (Map.Entry<? extends Byte, ? extends V> entry : map.entrySet()) {
                put2(entry.getKey(), (Byte) entry.getValue());
            }
        }
    }

    @Override // io.netty.util.collection.ByteObjectMap
    public V remove(byte b4) {
        int indexOf = indexOf(b4);
        if (indexOf == -1) {
            return null;
        }
        V v3 = this.values[indexOf];
        removeAt(indexOf);
        return (V) toExternal(v3);
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
        boolean z3 = true;
        int i4 = 0;
        while (true) {
            V[] vArr = this.values;
            if (i4 < vArr.length) {
                V v3 = vArr[i4];
                if (v3 != null) {
                    if (!z3) {
                        sb.append(", ");
                    }
                    sb.append(keyToString(this.keys[i4]));
                    sb.append('=');
                    sb.append(v3 == this ? "(this Map)" : toExternal(v3));
                    z3 = false;
                }
                i4++;
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
                        this.iter.remove();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return ByteObjectHashMap.this.size;
            }
        };
    }

    public ByteObjectHashMap(int i4) {
        this(i4, 0.5f);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return containsKey(objectToKey(obj));
    }

    @Override // io.netty.util.collection.ByteObjectMap
    public V put(byte b4, V v3) {
        int hashIndex = hashIndex(b4);
        int i4 = hashIndex;
        do {
            Object[] objArr = this.values;
            if (objArr[i4] == null) {
                this.keys[i4] = b4;
                objArr[i4] = toInternal(v3);
                growSize();
                return null;
            } else if (this.keys[i4] == b4) {
                Object obj = objArr[i4];
                objArr[i4] = toInternal(v3);
                return (V) toExternal(obj);
            } else {
                i4 = probeNext(i4);
            }
        } while (i4 != hashIndex);
        throw new IllegalStateException("Unable to insert");
    }

    public ByteObjectHashMap(int i4, float f4) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<ByteObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ByteObjectHashMap.1
            @Override // java.lang.Iterable
            public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (f4 > 0.0f && f4 <= 1.0f) {
            this.loadFactor = f4;
            int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i4);
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
    public V put2(Byte b4, V v3) {
        return put(objectToKey(b4), (byte) v3);
    }
}
