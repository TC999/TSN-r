package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.student.C4215R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V3ItemForValidRecordListBindingImpl extends V3ItemForValidRecordListBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C4215R.C4219id.card1, 1);
        sparseIntArray.put(2131232926, 2);
        sparseIntArray.put(C4215R.C4219id.tv_count_distance, 3);
        sparseIntArray.put(C4215R.C4219id.tv_count_time, 4);
        sparseIntArray.put(C4215R.C4219id.tv_count_number, 5);
        sparseIntArray.put(2131231389, 6);
        sparseIntArray.put(C4215R.C4219id.rv_trace, 7);
    }

    public V3ItemForValidRecordListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        return true;
    }

    private V3ItemForValidRecordListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialCardView) bindings[1], (ImageView) bindings[6], (RecyclerView) bindings[7], (TextView) bindings[3], (TextView) bindings[5], (TextView) bindings[4], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}