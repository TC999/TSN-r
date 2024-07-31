package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class EmptyRecyclerView extends RecyclerView {

    /* renamed from: a */
    View f1738a;

    /* renamed from: b */
    final RecyclerView.AdapterDataObserver f1739b;

    /* renamed from: cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1124a extends RecyclerView.AdapterDataObserver {
        C1124a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            EmptyRecyclerView.this.m57832a();
        }
    }

    public EmptyRecyclerView(Context context) {
        super(context);
        this.f1739b = new C1124a();
    }

    /* renamed from: a */
    void m57832a() {
        View view = this.f1738a;
        if (view != null) {
            view.setVisibility(getAdapter().getItemCount() > 0 ? 8 : 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f1739b);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f1739b);
        }
    }

    public void setEmptyView(View view) {
        this.f1738a = view;
        m57832a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f1739b);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f1739b);
        }
        super.swapAdapter(adapter, z);
        m57832a();
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1739b = new C1124a();
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1739b = new C1124a();
    }
}
