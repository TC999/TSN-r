package com.alibaba.fastjson.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int KEY = 16777619;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int M_MASK = -2023358765;
    static final int SEED = -2128831035;
    private static final long serialVersionUID = 362498820763181265L;
    private transient Set<Map.Entry<K, V>> entrySet;
    volatile transient Set<K> keySet;
    final float loadFactor;
    volatile transient int modCount;
    final int random;
    transient int size;
    transient Entry<K, V>[] table;
    int threshold;
    volatile transient Collection<V> values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        Entry<K, V> next;
        V value;

        Entry(int i4, K k4, V v3, Entry<K, V> entry) {
            this.value = v3;
            this.next = entry;
            this.key = k4;
            this.hash = i4;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K key = getKey();
                Object key2 = entry.getKey();
                if (key == key2 || (key != null && key.equals(key2))) {
                    V value = getValue();
                    Object value2 = entry.getValue();
                    if (value == value2) {
                        return true;
                    }
                    if (value != null && value.equals(value2)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k4 = this.key;
            int hashCode = k4 == null ? 0 : k4.hashCode();
            V v3 = this.value;
            return hashCode ^ (v3 != null ? v3.hashCode() : 0);
        }

        void recordAccess(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }

        void recordRemoval(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v3) {
            V v4 = this.value;
            this.value = v3;
            return v4;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class EntryIterator extends AntiCollisionHashMap<K, V>.HashIterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Entry<K, V> entry2 = AntiCollisionHashMap.this.getEntry(entry.getKey());
                return entry2 != null && entry2.equals(entry);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AntiCollisionHashMap.this.newEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeMapping(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public abstract class HashIterator<E> implements Iterator<E> {
        Entry<K, V> current;
        int expectedModCount;
        int index;
        Entry<K, V> next;

        HashIterator() {
            Entry<K, V> entry;
            this.expectedModCount = AntiCollisionHashMap.this.modCount;
            if (AntiCollisionHashMap.this.size > 0) {
                Entry<K, V>[] entryArr = AntiCollisionHashMap.this.table;
                do {
                    int i4 = this.index;
                    if (i4 >= entryArr.length) {
                        return;
                    }
                    this.index = i4 + 1;
                    entry = entryArr[i4];
                    this.next = entry;
                } while (entry == null);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != null;
        }

        final Entry<K, V> nextEntry() {
            Entry<K, V> entry;
            if (AntiCollisionHashMap.this.modCount == this.expectedModCount) {
                Entry<K, V> entry2 = this.next;
                if (entry2 != null) {
                    Entry<K, V> entry3 = entry2.next;
                    this.next = entry3;
                    if (entry3 == null) {
                        Entry<K, V>[] entryArr = AntiCollisionHashMap.this.table;
                        do {
                            int i4 = this.index;
                            if (i4 >= entryArr.length) {
                                break;
                            }
                            this.index = i4 + 1;
                            entry = entryArr[i4];
                            this.next = entry;
                        } while (entry == null);
                    }
                    this.current = entry2;
                    return entry2;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current != null) {
                if (AntiCollisionHashMap.this.modCount == this.expectedModCount) {
                    K k4 = this.current.key;
                    this.current = null;
                    AntiCollisionHashMap.this.removeEntryForKey(k4);
                    this.expectedModCount = AntiCollisionHashMap.this.modCount;
                    return;
                }
                throw new ConcurrentModificationException();
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class KeyIterator extends AntiCollisionHashMap<K, V>.HashIterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private final class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return AntiCollisionHashMap.this.newKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeEntryForKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class ValueIterator extends AntiCollisionHashMap<K, V>.HashIterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().value;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private final class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return AntiCollisionHashMap.this.newValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    public AntiCollisionHashMap(int i4, float f4) {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        if (i4 >= 0) {
            i4 = i4 > 1073741824 ? 1073741824 : i4;
            if (f4 > 0.0f && !Float.isNaN(f4)) {
                int i5 = 1;
                while (i5 < i4) {
                    i5 <<= 1;
                }
                this.loadFactor = f4;
                this.threshold = (int) (i5 * f4);
                this.table = new Entry[i5];
                init();
                return;
            }
            throw new IllegalArgumentException("Illegal load factor: " + f4);
        }
        throw new IllegalArgumentException("Illegal initial capacity: " + i4);
    }

    private boolean containsNullValue() {
        Entry<K, V>[] entryArr;
        for (Entry<K, V> entry : this.table) {
            for (; entry != null; entry = entry.next) {
                if (entry.value == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<Map.Entry<K, V>> entrySet0() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    private V getForNullKey() {
        for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                return entry.value;
            }
        }
        return null;
    }

    static int hash(int i4) {
        int i5 = i4 * i4;
        int i6 = i5 ^ ((i5 >>> 20) ^ (i5 >>> 12));
        return (i6 >>> 4) ^ ((i6 >>> 7) ^ i6);
    }

    private int hashString(String str) {
        int i4 = this.random * (-2128831035);
        for (int i5 = 0; i5 < str.length(); i5++) {
            i4 = (i4 * 16777619) ^ str.charAt(i5);
        }
        return ((i4 >> 1) ^ i4) & (-2023358765);
    }

    static int indexFor(int i4, int i5) {
        return i4 & (i5 - 1);
    }

    private void putAllForCreate(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putForCreate(entry.getKey(), entry.getValue());
        }
    }

    private void putForCreate(K k4, V v3) {
        int hash;
        K k5;
        if (k4 == null) {
            hash = 0;
        } else if (k4 instanceof String) {
            hash = hash(hashString((String) k4));
        } else {
            hash = hash(k4.hashCode());
        }
        int indexFor = indexFor(hash, this.table.length);
        for (Entry<K, V> entry = this.table[indexFor]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k5 = entry.key) == k4 || (k4 != null && k4.equals(k5)))) {
                entry.value = v3;
                return;
            }
        }
        createEntry(hash, k4, v3, indexFor);
    }

    private V putForNullKey(V v3) {
        for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                V v4 = entry.value;
                entry.value = v3;
                entry.recordAccess(this);
                return v4;
            }
        }
        this.modCount++;
        addEntry(0, null, v3, 0);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.table = new Entry[objectInputStream.readInt()];
        init();
        int readInt = objectInputStream.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            putForCreate(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Iterator<Map.Entry<K, V>> it = this.size > 0 ? entrySet0().iterator() : null;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.size);
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objectOutputStream.writeObject(next.getKey());
                objectOutputStream.writeObject(next.getValue());
            }
        }
    }

    void addEntry(int i4, K k4, V v3, int i5) {
        Entry<K, V>[] entryArr = this.table;
        entryArr[i5] = new Entry<>(i4, k4, v3, entryArr[i5]);
        int i6 = this.size;
        this.size = i6 + 1;
        if (i6 >= this.threshold) {
            resize(this.table.length * 2);
        }
    }

    int capacity() {
        return this.table.length;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Entry<K, V>[] entryArr = this.table;
        for (int i4 = 0; i4 < entryArr.length; i4++) {
            entryArr[i4] = null;
        }
        this.size = 0;
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        AntiCollisionHashMap antiCollisionHashMap;
        try {
            antiCollisionHashMap = (AntiCollisionHashMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            antiCollisionHashMap = null;
        }
        antiCollisionHashMap.table = new Entry[this.table.length];
        antiCollisionHashMap.entrySet = null;
        antiCollisionHashMap.modCount = 0;
        antiCollisionHashMap.size = 0;
        antiCollisionHashMap.init();
        antiCollisionHashMap.putAllForCreate(this);
        return antiCollisionHashMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return getEntry(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Entry<K, V>[] entryArr;
        if (obj == null) {
            return containsNullValue();
        }
        for (Entry<K, V> entry : this.table) {
            for (; entry != null; entry = entry.next) {
                if (obj.equals(entry.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    void createEntry(int i4, K k4, V v3, int i5) {
        Entry<K, V>[] entryArr = this.table;
        entryArr[i5] = new Entry<>(i4, k4, v3, entryArr[i5]);
        this.size++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet0();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int hash;
        K k4;
        if (obj == null) {
            return getForNullKey();
        }
        if (obj instanceof String) {
            hash = hash(hashString((String) obj));
        } else {
            hash = hash(obj.hashCode());
        }
        Entry<K, V>[] entryArr = this.table;
        for (Entry<K, V> entry = entryArr[indexFor(hash, entryArr.length)]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k4 = entry.key) == obj || obj.equals(k4))) {
                return entry.value;
            }
        }
        return null;
    }

    final Entry<K, V> getEntry(Object obj) {
        int hash;
        K k4;
        if (obj == null) {
            hash = 0;
        } else if (obj instanceof String) {
            hash = hash(hashString((String) obj));
        } else {
            hash = hash(obj.hashCode());
        }
        Entry<K, V>[] entryArr = this.table;
        for (Entry<K, V> entry = entryArr[indexFor(hash, entryArr.length)]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k4 = entry.key) == obj || (obj != null && obj.equals(k4)))) {
                return entry;
            }
        }
        return null;
    }

    void init() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    float loadFactor() {
        return this.loadFactor;
    }

    Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new EntryIterator();
    }

    Iterator<K> newKeyIterator() {
        return new KeyIterator();
    }

    Iterator<V> newValueIterator() {
        return new ValueIterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k4, V v3) {
        int hash;
        K k5;
        if (k4 == null) {
            return putForNullKey(v3);
        }
        if (k4 instanceof String) {
            hash = hash(hashString((String) k4));
        } else {
            hash = hash(k4.hashCode());
        }
        int indexFor = indexFor(hash, this.table.length);
        for (Entry<K, V> entry = this.table[indexFor]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k5 = entry.key) == k4 || k4.equals(k5))) {
                V v4 = entry.value;
                entry.value = v3;
                entry.recordAccess(this);
                return v4;
            }
        }
        this.modCount++;
        addEntry(hash, k4, v3, indexFor);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        if (size > this.threshold) {
            int i4 = (int) ((size / this.loadFactor) + 1.0f);
            if (i4 > 1073741824) {
                i4 = 1073741824;
            }
            int length = this.table.length;
            while (length < i4) {
                length <<= 1;
            }
            if (length > this.table.length) {
                resize(length);
            }
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Entry<K, V> removeEntryForKey = removeEntryForKey(obj);
        if (removeEntryForKey == null) {
            return null;
        }
        return removeEntryForKey.value;
    }

    final Entry<K, V> removeEntryForKey(Object obj) {
        int hash;
        K k4;
        if (obj == null) {
            hash = 0;
        } else if (obj instanceof String) {
            hash = hash(hashString((String) obj));
        } else {
            hash = hash(obj.hashCode());
        }
        int indexFor = indexFor(hash, this.table.length);
        Entry<K, V> entry = this.table[indexFor];
        Entry<K, V> entry2 = entry;
        while (entry != null) {
            Entry<K, V> entry3 = entry.next;
            if (entry.hash == hash && ((k4 = entry.key) == obj || (obj != null && obj.equals(k4)))) {
                this.modCount++;
                this.size--;
                if (entry2 == entry) {
                    this.table[indexFor] = entry3;
                } else {
                    entry2.next = entry3;
                }
                entry.recordRemoval(this);
                return entry;
            }
            entry2 = entry;
            entry = entry3;
        }
        return entry;
    }

    final Entry<K, V> removeMapping(Object obj) {
        int hash;
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            if (key == null) {
                hash = 0;
            } else if (key instanceof String) {
                hash = hash(hashString((String) key));
            } else {
                hash = hash(key.hashCode());
            }
            int indexFor = indexFor(hash, this.table.length);
            Entry<K, V> entry2 = this.table[indexFor];
            Entry<K, V> entry3 = entry2;
            while (entry2 != null) {
                Entry<K, V> entry4 = entry2.next;
                if (entry2.hash == hash && entry2.equals(entry)) {
                    this.modCount++;
                    this.size--;
                    if (entry3 == entry2) {
                        this.table[indexFor] = entry4;
                    } else {
                        entry3.next = entry4;
                    }
                    entry2.recordRemoval(this);
                    return entry2;
                }
                entry3 = entry2;
                entry2 = entry4;
            }
            return entry2;
        }
        return null;
    }

    void resize(int i4) {
        if (this.table.length == 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        Entry<K, V>[] entryArr = new Entry[i4];
        transfer(entryArr);
        this.table = entryArr;
        this.threshold = (int) (i4 * this.loadFactor);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    void transfer(Entry[] entryArr) {
        Entry<K, V>[] entryArr2 = this.table;
        int length = entryArr.length;
        for (int i4 = 0; i4 < entryArr2.length; i4++) {
            Entry<K, V> entry = entryArr2[i4];
            if (entry != null) {
                entryArr2[i4] = null;
                while (true) {
                    Entry<K, V> entry2 = entry.next;
                    int indexFor = indexFor(entry.hash, length);
                    entry.next = entryArr[indexFor];
                    entryArr[indexFor] = entry;
                    if (entry2 == null) {
                        break;
                    }
                    entry = entry2;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    public AntiCollisionHashMap(int i4) {
        this(i4, 0.75f);
    }

    public AntiCollisionHashMap() {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        this.loadFactor = 0.75f;
        this.threshold = 12;
        this.table = new Entry[16];
        init();
    }

    public AntiCollisionHashMap(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (map.size() / 0.75f)) + 1, 16), 0.75f);
        putAllForCreate(map);
    }
}
