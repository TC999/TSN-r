package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class DirectedAcyclicGraph<T> {
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    private void dfs(T t3, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t3)) {
            return;
        }
        if (!hashSet.contains(t3)) {
            hashSet.add(t3);
            ArrayList<T> arrayList2 = this.mGraph.get(t3);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    dfs(arrayList2.get(i4), arrayList, hashSet);
                }
            }
            hashSet.remove(t3);
            arrayList.add(t3);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> acquire = this.mListPool.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t3, @NonNull T t4) {
        if (this.mGraph.containsKey(t3) && this.mGraph.containsKey(t4)) {
            ArrayList<T> arrayList = this.mGraph.get(t3);
            if (arrayList == null) {
                arrayList = getEmptyList();
                this.mGraph.put(t3, arrayList);
            }
            arrayList.add(t4);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void addNode(@NonNull T t3) {
        if (this.mGraph.containsKey(t3)) {
            return;
        }
        this.mGraph.put(t3, null);
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i4 = 0; i4 < size; i4++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i4);
            if (valueAt != null) {
                poolList(valueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t3) {
        return this.mGraph.containsKey(t3);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t3) {
        return this.mGraph.get(t3);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t3) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < size; i4++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i4);
            if (valueAt != null && valueAt.contains(t3)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i4));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i4 = 0; i4 < size; i4++) {
            dfs(this.mGraph.keyAt(i4), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t3) {
        int size = this.mGraph.size();
        for (int i4 = 0; i4 < size; i4++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i4);
            if (valueAt != null && valueAt.contains(t3)) {
                return true;
            }
        }
        return false;
    }

    int size() {
        return this.mGraph.size();
    }
}
