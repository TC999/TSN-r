package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areContentsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areItemsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t22, T2 t23) {
            return this.mWrappedCallback.compare(t22, t23);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return this.mWrappedCallback.getChangePayload(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i4, int i5) {
            this.mBatchingListUpdateCallback.onChanged(i4, i5, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i4, int i5) {
            this.mBatchingListUpdateCallback.onInserted(i4, i5);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i4, int i5) {
            this.mBatchingListUpdateCallback.onMoved(i4, i5);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i4, int i5) {
            this.mBatchingListUpdateCallback.onRemoved(i4, i5);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i4, int i5, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i4, i5, obj);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t22, T2 t23);

        public abstract boolean areItemsTheSame(T2 t22, T2 t23);

        @Override // java.util.Comparator
        public abstract int compare(T2 t22, T2 t23);

        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return null;
        }

        public abstract void onChanged(int i4, int i5);

        public void onChanged(int i4, int i5, Object obj) {
            onChanged(i4, i5);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int sortAndDedup = sortAndDedup(tArr);
        if (this.mSize == 0) {
            this.mData = tArr;
            this.mSize = sortAndDedup;
            this.mCallback.onInserted(0, sortAndDedup);
            return;
        }
        merge(tArr, sortAndDedup);
    }

    private void addToData(int i4, T t3) {
        int i5 = this.mSize;
        if (i4 <= i5) {
            T[] tArr = this.mData;
            if (i5 == tArr.length) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
                System.arraycopy(this.mData, 0, tArr2, 0, i4);
                tArr2[i4] = t3;
                System.arraycopy(this.mData, i4, tArr2, i4 + 1, this.mSize - i4);
                this.mData = tArr2;
            } else {
                System.arraycopy(tArr, i4, tArr, i4 + 1, i5 - i4);
                this.mData[i4] = t3;
            }
            this.mSize++;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + i4 + " because size is " + this.mSize);
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t3, T[] tArr, int i4, int i5, int i6) {
        while (i4 < i5) {
            int i7 = (i4 + i5) / 2;
            T t4 = tArr[i7];
            int compare = this.mCallback.compare(t4, t3);
            if (compare < 0) {
                i4 = i7 + 1;
            } else if (compare == 0) {
                if (this.mCallback.areItemsTheSame(t4, t3)) {
                    return i7;
                }
                int linearEqualitySearch = linearEqualitySearch(t3, i7, i4, i5);
                return (i6 == 1 && linearEqualitySearch == -1) ? i7 : linearEqualitySearch;
            } else {
                i5 = i7;
            }
        }
        if (i6 == 1) {
            return i4;
        }
        return -1;
    }

    private int findSameItem(T t3, T[] tArr, int i4, int i5) {
        while (i4 < i5) {
            if (this.mCallback.areItemsTheSame(tArr[i4], t3)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t3, int i4, int i5, int i6) {
        T t4;
        for (int i7 = i4 - 1; i7 >= i5; i7--) {
            T t5 = this.mData[i7];
            if (this.mCallback.compare(t5, t3) != 0) {
                break;
            } else if (this.mCallback.areItemsTheSame(t5, t3)) {
                return i7;
            }
        }
        do {
            i4++;
            if (i4 >= i6) {
                return -1;
            }
            t4 = this.mData[i4];
            if (this.mCallback.compare(t4, t3) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t4, t3));
        return i4;
    }

    private void merge(T[] tArr, int i4) {
        boolean z3 = !(this.mCallback instanceof BatchedCallback);
        if (z3) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i5 = 0;
        this.mOldDataStart = 0;
        int i6 = this.mSize;
        this.mOldDataSize = i6;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i6 + i4 + 10));
        this.mNewDataStart = 0;
        while (true) {
            int i7 = this.mOldDataStart;
            int i8 = this.mOldDataSize;
            if (i7 >= i8 && i5 >= i4) {
                break;
            } else if (i7 == i8) {
                int i9 = i4 - i5;
                System.arraycopy(tArr, i5, this.mData, this.mNewDataStart, i9);
                int i10 = this.mNewDataStart + i9;
                this.mNewDataStart = i10;
                this.mSize += i9;
                this.mCallback.onInserted(i10 - i9, i9);
                break;
            } else if (i5 == i4) {
                int i11 = i8 - i7;
                System.arraycopy(this.mOldData, i7, this.mData, this.mNewDataStart, i11);
                this.mNewDataStart += i11;
                break;
            } else {
                T t3 = this.mOldData[i7];
                T t4 = tArr[i5];
                int compare = this.mCallback.compare(t3, t4);
                if (compare > 0) {
                    T[] tArr2 = this.mData;
                    int i12 = this.mNewDataStart;
                    int i13 = i12 + 1;
                    this.mNewDataStart = i13;
                    tArr2[i12] = t4;
                    this.mSize++;
                    i5++;
                    this.mCallback.onInserted(i13 - 1, 1);
                } else if (compare == 0 && this.mCallback.areItemsTheSame(t3, t4)) {
                    T[] tArr3 = this.mData;
                    int i14 = this.mNewDataStart;
                    this.mNewDataStart = i14 + 1;
                    tArr3[i14] = t4;
                    i5++;
                    this.mOldDataStart++;
                    if (!this.mCallback.areContentsTheSame(t3, t4)) {
                        Callback callback = this.mCallback;
                        callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t3, t4));
                    }
                } else {
                    T[] tArr4 = this.mData;
                    int i15 = this.mNewDataStart;
                    this.mNewDataStart = i15 + 1;
                    tArr4[i15] = t3;
                    this.mOldDataStart++;
                }
            }
        }
        this.mOldData = null;
        if (z3) {
            endBatchedUpdates();
        }
    }

    private void removeItemAtIndex(int i4, boolean z3) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i4 + 1, tArr, i4, (this.mSize - i4) - 1);
        int i5 = this.mSize - 1;
        this.mSize = i5;
        this.mData[i5] = null;
        if (z3) {
            this.mCallback.onRemoved(i4, 1);
        }
    }

    private void replaceAllInsert(T t3) {
        T[] tArr = this.mData;
        int i4 = this.mNewDataStart;
        tArr[i4] = t3;
        int i5 = i4 + 1;
        this.mNewDataStart = i5;
        this.mSize++;
        this.mCallback.onInserted(i5 - 1, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z3 = !(this.mCallback instanceof BatchedCallback);
        if (z3) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int sortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, sortAndDedup));
        while (true) {
            int i4 = this.mNewDataStart;
            if (i4 >= sortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i5 = this.mOldDataStart;
            int i6 = this.mOldDataSize;
            if (i5 >= i6) {
                int i7 = sortAndDedup - i4;
                System.arraycopy(tArr, i4, this.mData, i4, i7);
                this.mNewDataStart += i7;
                this.mSize += i7;
                this.mCallback.onInserted(i4, i7);
                break;
            } else if (i4 >= sortAndDedup) {
                int i8 = i6 - i5;
                this.mSize -= i8;
                this.mCallback.onRemoved(i4, i8);
                break;
            } else {
                T t3 = this.mOldData[i5];
                T t4 = tArr[i4];
                int compare = this.mCallback.compare(t3, t4);
                if (compare < 0) {
                    replaceAllRemove();
                } else if (compare > 0) {
                    replaceAllInsert(t4);
                } else if (!this.mCallback.areItemsTheSame(t3, t4)) {
                    replaceAllRemove();
                    replaceAllInsert(t4);
                } else {
                    T[] tArr2 = this.mData;
                    int i9 = this.mNewDataStart;
                    tArr2[i9] = t4;
                    this.mOldDataStart++;
                    this.mNewDataStart = i9 + 1;
                    if (!this.mCallback.areContentsTheSame(t3, t4)) {
                        Callback callback = this.mCallback;
                        callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t3, t4));
                    }
                }
            }
        }
        this.mOldData = null;
        if (z3) {
            endBatchedUpdates();
        }
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i4 = 1;
        int i5 = 0;
        for (int i6 = 1; i6 < tArr.length; i6++) {
            T t3 = tArr[i6];
            if (this.mCallback.compare(tArr[i5], t3) == 0) {
                int findSameItem = findSameItem(t3, tArr, i5, i4);
                if (findSameItem != -1) {
                    tArr[findSameItem] = t3;
                } else {
                    if (i4 != i6) {
                        tArr[i4] = t3;
                    }
                    i4++;
                }
            } else {
                if (i4 != i6) {
                    tArr[i4] = t3;
                }
                i5 = i4;
                i4++;
            }
        }
        return i4;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t3) {
        throwIfInMutationOperation();
        return add(t3, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z3) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z3) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i4 = this.mSize;
        if (i4 == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i4, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i4);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i4) throws IndexOutOfBoundsException {
        int i5;
        if (i4 < this.mSize && i4 >= 0) {
            T[] tArr = this.mOldData;
            if (tArr != null && i4 >= (i5 = this.mNewDataStart)) {
                return tArr[(i4 - i5) + this.mOldDataStart];
            }
            return this.mData[i4];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i4 + " but size is " + this.mSize);
    }

    public int indexOf(T t3) {
        if (this.mOldData != null) {
            int findIndexOf = findIndexOf(t3, this.mData, 0, this.mNewDataStart, 4);
            if (findIndexOf != -1) {
                return findIndexOf;
            }
            int findIndexOf2 = findIndexOf(t3, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            if (findIndexOf2 != -1) {
                return (findIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
            }
            return -1;
        }
        return findIndexOf(t3, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int i4) {
        throwIfInMutationOperation();
        T t3 = get(i4);
        removeItemAtIndex(i4, false);
        int add = add(t3, false);
        if (i4 != add) {
            this.mCallback.onMoved(i4, add);
        }
    }

    public boolean remove(T t3) {
        throwIfInMutationOperation();
        return remove(t3, true);
    }

    public T removeItemAt(int i4) {
        throwIfInMutationOperation();
        T t3 = get(i4);
        removeItemAtIndex(i4, true);
        return t3;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z3) {
        throwIfInMutationOperation();
        if (z3) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i4, T t3) {
        throwIfInMutationOperation();
        T t4 = get(i4);
        boolean z3 = t4 == t3 || !this.mCallback.areContentsTheSame(t4, t3);
        if (t4 != t3 && this.mCallback.compare(t4, t3) == 0) {
            this.mData[i4] = t3;
            if (z3) {
                Callback callback = this.mCallback;
                callback.onChanged(i4, 1, callback.getChangePayload(t4, t3));
                return;
            }
            return;
        }
        if (z3) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i4, 1, callback2.getChangePayload(t4, t3));
        }
        removeItemAtIndex(i4, false);
        int add = add(t3, false);
        if (i4 != add) {
            this.mCallback.onMoved(i4, add);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i4) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i4));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t3, boolean z3) {
        int findIndexOf = findIndexOf(t3, this.mData, 0, this.mSize, 1);
        if (findIndexOf == -1) {
            findIndexOf = 0;
        } else if (findIndexOf < this.mSize) {
            T t4 = this.mData[findIndexOf];
            if (this.mCallback.areItemsTheSame(t4, t3)) {
                if (this.mCallback.areContentsTheSame(t4, t3)) {
                    this.mData[findIndexOf] = t3;
                    return findIndexOf;
                }
                this.mData[findIndexOf] = t3;
                Callback callback = this.mCallback;
                callback.onChanged(findIndexOf, 1, callback.getChangePayload(t4, t3));
                return findIndexOf;
            }
        }
        addToData(findIndexOf, t3);
        if (z3) {
            this.mCallback.onInserted(findIndexOf, 1);
        }
        return findIndexOf;
    }

    private boolean remove(T t3, boolean z3) {
        int findIndexOf = findIndexOf(t3, this.mData, 0, this.mSize, 2);
        if (findIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(findIndexOf, z3);
        return true;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }
}
