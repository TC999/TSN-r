package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {
    @NonNull
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i4, int i5, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i4, i5, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i4, int i5) {
        this.mAdapter.notifyItemRangeInserted(i4, i5);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i4, int i5) {
        this.mAdapter.notifyItemMoved(i4, i5);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i4, int i5) {
        this.mAdapter.notifyItemRangeRemoved(i4, i5);
    }
}
