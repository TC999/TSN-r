package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class EmptyRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    View f1724a;

    /* renamed from: b  reason: collision with root package name */
    final RecyclerView.AdapterDataObserver f1725b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            EmptyRecyclerView.this.a();
        }
    }

    public EmptyRecyclerView(Context context) {
        super(context);
        this.f1725b = new a();
    }

    void a() {
        View view = this.f1724a;
        if (view != null) {
            view.setVisibility(getAdapter().getItemCount() > 0 ? 8 : 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f1725b);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f1725b);
        }
    }

    public void setEmptyView(View view) {
        this.f1724a = view;
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z3) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f1725b);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f1725b);
        }
        super.swapAdapter(adapter, z3);
        a();
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1725b = new a();
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1725b = new a();
    }
}
