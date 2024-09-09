package com.bxkj.base.v2.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EmptyRecyclerView.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001dB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0014J\u0006\u0010\t\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u000f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/bxkj/base/v2/common/view/EmptyRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/f1;", "b", "onAttachedToWindow", "a", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "removeAndRecycleExistingViews", "swapAdapter", "setAdapter", "Landroid/view/View;", "emptyView", "setEmptyView", "Landroid/view/View;", "", "I", "resourceId", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "c", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "observer", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class EmptyRecyclerView extends RecyclerView {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private View f18667a;

    /* renamed from: b  reason: collision with root package name */
    private int f18668b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView.AdapterDataObserver f18669c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyRecyclerView(@Nullable Context context) {
        super(context);
        f0.m(context);
        this.f18668b = -1;
        this.f18669c = new RecyclerView.AdapterDataObserver() { // from class: com.bxkj.base.v2.common.view.EmptyRecyclerView$observer$1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i4, int i5) {
                super.onItemRangeChanged(i4, i5);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i4, int i5) {
                super.onItemRangeInserted(i4, i5);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i4, int i5, int i6) {
                super.onItemRangeMoved(i4, i5, i6);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i4, int i5) {
                super.onItemRangeRemoved(i4, i5);
                EmptyRecyclerView.this.a();
            }
        };
    }

    private final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmptyRecyclerView);
        f0.o(obtainStyledAttributes, "context.obtainStyledAttr\u2026leable.EmptyRecyclerView)");
        this.f18668b = obtainStyledAttributes.getResourceId(R.styleable.EmptyRecyclerView_emptyId, -1);
    }

    public final void a() {
        RecyclerView.Adapter adapter;
        View view = this.f18667a;
        if (view == null || (adapter = getAdapter()) == null) {
            return;
        }
        view.setVisibility(adapter.getItemCount() > 0 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View findViewById;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent != null) {
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup instanceof SmartRefreshLayout) {
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) viewGroup;
                    if (smartRefreshLayout.getParent() instanceof ViewGroup) {
                        ViewParent parent2 = smartRefreshLayout.getParent();
                        if (parent2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                        }
                        viewGroup = (ViewGroup) parent2;
                    }
                }
                int i4 = this.f18668b;
                if (i4 == -1) {
                    findViewById = LayoutInflater.from(getContext()).inflate(R.layout.v2_pub_empty, viewGroup, false);
                    viewGroup.addView(findViewById);
                } else {
                    findViewById = viewGroup.findViewById(i4);
                }
                this.f18667a = findViewById;
            }
        }
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f18669c);
        }
        super.setAdapter(adapter);
        if (adapter == null) {
            return;
        }
        adapter.registerAdapterDataObserver(this.f18669c);
    }

    public final void setEmptyView(@Nullable View view) {
        this.f18667a = view;
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(@Nullable RecyclerView.Adapter<?> adapter, boolean z3) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f18669c);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f18669c);
        }
        super.swapAdapter(adapter, z3);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        f0.m(context);
        this.f18668b = -1;
        this.f18669c = new RecyclerView.AdapterDataObserver() { // from class: com.bxkj.base.v2.common.view.EmptyRecyclerView$observer$1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i4, int i5) {
                super.onItemRangeChanged(i4, i5);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i4, int i5) {
                super.onItemRangeInserted(i4, i5);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i4, int i5, int i6) {
                super.onItemRangeMoved(i4, i5, i6);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i4, int i5) {
                super.onItemRangeRemoved(i4, i5);
                EmptyRecyclerView.this.a();
            }
        };
        b(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        f0.m(context);
        this.f18668b = -1;
        this.f18669c = new RecyclerView.AdapterDataObserver() { // from class: com.bxkj.base.v2.common.view.EmptyRecyclerView$observer$1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i42, int i5) {
                super.onItemRangeChanged(i42, i5);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i42, int i5) {
                super.onItemRangeInserted(i42, i5);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i42, int i5, int i6) {
                super.onItemRangeMoved(i42, i5, i6);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i42, int i5) {
                super.onItemRangeRemoved(i42, i5);
                EmptyRecyclerView.this.a();
            }
        };
        b(context, attributeSet);
    }
}
