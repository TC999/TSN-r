package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    @Nullable
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    @Nullable
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int i4) {
        if (i4 == 8) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr = mTwiceBaseCache;
                if (objArr != null) {
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i4 == 4) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr2 = mBaseCache;
                if (objArr2 != null) {
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i4];
        this.mArray = new Object[i4 << 1];
    }

    private static int binarySearchHashes(int[] iArr, int i4, int i5) {
        try {
            return ContainerHelpers.binarySearch(iArr, i4, i5);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i5 = (i4 << 1) - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i6 = (i4 << 1) - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public void clear() {
        int i4 = this.mSize;
        if (i4 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i4);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i4) {
        int i5 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i4) {
            Object[] objArr = this.mArray;
            allocArrays(i4);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i5);
                System.arraycopy(objArr, 0, this.mArray, 0, i5 << 1);
            }
            freeArrays(iArr, objArr, i5);
        }
        if (this.mSize != i5) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.mSize; i4++) {
                try {
                    K keyAt = keyAt(i4);
                    V valueAt = valueAt(i4);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.mSize; i5++) {
                try {
                    K keyAt2 = keyAt(i5);
                    V valueAt2 = valueAt(i5);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v3) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? (V) this.mArray[(indexOfKey << 1) + 1] : v3;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i4 = this.mSize;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            Object obj = objArr[i5];
            i7 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i6];
            i6++;
            i5 += 2;
        }
        return i7;
    }

    int indexOf(Object obj, int i4) {
        int i5 = this.mSize;
        if (i5 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i5, i4);
        if (binarySearchHashes >= 0 && !obj.equals(this.mArray[binarySearchHashes << 1])) {
            int i6 = binarySearchHashes + 1;
            while (i6 < i5 && this.mHashes[i6] == i4) {
                if (obj.equals(this.mArray[i6 << 1])) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = binarySearchHashes - 1; i7 >= 0 && this.mHashes[i7] == i4; i7--) {
                if (obj.equals(this.mArray[i7 << 1])) {
                    return i7;
                }
            }
            return i6 ^ (-1);
        }
        return binarySearchHashes;
    }

    public int indexOfKey(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    int indexOfNull() {
        int i4 = this.mSize;
        if (i4 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i4, 0);
        if (binarySearchHashes >= 0 && this.mArray[binarySearchHashes << 1] != null) {
            int i5 = binarySearchHashes + 1;
            while (i5 < i4 && this.mHashes[i5] == 0) {
                if (this.mArray[i5 << 1] == null) {
                    return i5;
                }
                i5++;
            }
            for (int i6 = binarySearchHashes - 1; i6 >= 0 && this.mHashes[i6] == 0; i6--) {
                if (this.mArray[i6 << 1] == null) {
                    return i6;
                }
            }
            return i5 ^ (-1);
        }
        return binarySearchHashes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfValue(Object obj) {
        int i4 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i5 = 1; i5 < i4; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i4; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public K keyAt(int i4) {
        return (K) this.mArray[i4 << 1];
    }

    @Nullable
    public V put(K k4, V v3) {
        int i4;
        int indexOf;
        int i5 = this.mSize;
        if (k4 == null) {
            indexOf = indexOfNull();
            i4 = 0;
        } else {
            int hashCode = k4.hashCode();
            i4 = hashCode;
            indexOf = indexOf(k4, hashCode);
        }
        if (indexOf >= 0) {
            int i6 = (indexOf << 1) + 1;
            Object[] objArr = this.mArray;
            V v4 = (V) objArr[i6];
            objArr[i6] = v3;
            return v4;
        }
        int i7 = indexOf ^ (-1);
        int[] iArr = this.mHashes;
        if (i5 >= iArr.length) {
            int i8 = 4;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i8 = 8;
            }
            Object[] objArr2 = this.mArray;
            allocArrays(i8);
            if (i5 == this.mSize) {
                int[] iArr2 = this.mHashes;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
                }
                freeArrays(iArr, objArr2, i5);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr3 = this.mHashes;
            int i9 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i9, i5 - i7);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, i7 << 1, objArr3, i9 << 1, (this.mSize - i7) << 1);
        }
        int i10 = this.mSize;
        if (i5 == i10) {
            int[] iArr4 = this.mHashes;
            if (i7 < iArr4.length) {
                iArr4[i7] = i4;
                Object[] objArr4 = this.mArray;
                int i11 = i7 << 1;
                objArr4[i11] = k4;
                objArr4[i11 + 1] = v3;
                this.mSize = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i4 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i4);
        if (this.mSize != 0) {
            for (int i5 = 0; i5 < i4; i5++) {
                put(simpleArrayMap.keyAt(i5), simpleArrayMap.valueAt(i5));
            }
        } else if (i4 > 0) {
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i4);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i4 << 1);
            this.mSize = i4;
        }
    }

    @Nullable
    public V putIfAbsent(K k4, V v3) {
        V v4 = get(k4);
        return v4 == null ? put(k4, v3) : v4;
    }

    @Nullable
    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i4) {
        Object[] objArr = this.mArray;
        int i5 = i4 << 1;
        V v3 = (V) objArr[i5 + 1];
        int i6 = this.mSize;
        int i7 = 0;
        if (i6 <= 1) {
            freeArrays(this.mHashes, objArr, i6);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int i8 = i6 - 1;
            int[] iArr = this.mHashes;
            if (iArr.length > 8 && i6 < iArr.length / 3) {
                allocArrays(i6 > 8 ? i6 + (i6 >> 1) : 8);
                if (i6 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i4 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i4);
                    System.arraycopy(objArr, 0, this.mArray, 0, i5);
                }
                if (i4 < i8) {
                    int i9 = i4 + 1;
                    int i10 = i8 - i4;
                    System.arraycopy(iArr, i9, this.mHashes, i4, i10);
                    System.arraycopy(objArr, i9 << 1, this.mArray, i5, i10 << 1);
                }
            } else {
                if (i4 < i8) {
                    int i11 = i4 + 1;
                    int i12 = i8 - i4;
                    System.arraycopy(iArr, i11, iArr, i4, i12);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i11 << 1, objArr2, i5, i12 << 1);
                }
                Object[] objArr3 = this.mArray;
                int i13 = i8 << 1;
                objArr3[i13] = null;
                objArr3[i13 + 1] = null;
            }
            i7 = i8;
        }
        if (i6 == this.mSize) {
            this.mSize = i7;
            return v3;
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K k4, V v3) {
        int indexOfKey = indexOfKey(k4);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v3);
        }
        return null;
    }

    public V setValueAt(int i4, V v3) {
        int i5 = (i4 << 1) + 1;
        Object[] objArr = this.mArray;
        V v4 = (V) objArr[i5];
        objArr[i5] = v3;
        return v4;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.mSize; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i4);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i4);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V valueAt(int i4) {
        return (V) this.mArray[(i4 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            V valueAt = valueAt(indexOfKey);
            if (obj2 == valueAt || (obj2 != null && obj2.equals(valueAt))) {
                removeAt(indexOfKey);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean replace(K k4, V v3, V v4) {
        int indexOfKey = indexOfKey(k4);
        if (indexOfKey >= 0) {
            V valueAt = valueAt(indexOfKey);
            if (valueAt == v3 || (v3 != null && v3.equals(valueAt))) {
                setValueAt(indexOfKey, v4);
                return true;
            }
            return false;
        }
        return false;
    }

    public SimpleArrayMap(int i4) {
        if (i4 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i4);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }
}
