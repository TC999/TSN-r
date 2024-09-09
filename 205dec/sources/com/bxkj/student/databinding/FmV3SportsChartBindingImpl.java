package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.google.android.material.card.MaterialCardView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class FmV3SportsChartBindingImpl extends FmV3SportsChartBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131231067, 1);
        sparseIntArray.put(2131233064, 2);
        sparseIntArray.put(2131231070, 3);
        sparseIntArray.put(2131232865, 4);
        sparseIntArray.put(2131232876, 5);
        sparseIntArray.put(2131232862, 6);
        sparseIntArray.put(2131232873, 7);
        sparseIntArray.put(2131233238, 8);
        sparseIntArray.put(2131230720, 9);
        sparseIntArray.put(2131233235, 10);
        sparseIntArray.put(2131231074, 11);
        sparseIntArray.put(2131233178, 12);
        sparseIntArray.put(2131231075, 13);
        sparseIntArray.put(2131232869, 14);
        sparseIntArray.put(2131232878, 15);
        sparseIntArray.put(2131232868, 16);
        sparseIntArray.put(2131232877, 17);
        sparseIntArray.put(2131233239, 18);
        sparseIntArray.put(2131230721, 19);
        sparseIntArray.put(2131233236, 20);
        sparseIntArray.put(2131231068, 21);
        sparseIntArray.put(2131233063, 22);
        sparseIntArray.put(2131231069, 23);
        sparseIntArray.put(2131232864, 24);
        sparseIntArray.put(2131232875, 25);
        sparseIntArray.put(2131232863, 26);
        sparseIntArray.put(2131232874, 27);
        sparseIntArray.put(2131232552, 28);
        sparseIntArray.put(2131233010, 29);
    }

    public FmV3SportsChartBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
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

    private FmV3SportsChartBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AAChartView) bindings[9], (AAChartView) bindings[19], (MaterialCardView) bindings[1], (MaterialCardView) bindings[21], (MaterialCardView) bindings[23], (MaterialCardView) bindings[3], (MaterialCardView) bindings[11], (MaterialCardView) bindings[13], (RecyclerView) bindings[28], (TextView) bindings[6], (TextView) bindings[26], (TextView) bindings[24], (TextView) bindings[4], (TextView) bindings[16], (TextView) bindings[14], (TextView) bindings[7], (TextView) bindings[27], (TextView) bindings[25], (TextView) bindings[5], (TextView) bindings[17], (TextView) bindings[15], (TextView) bindings[29], (TextView) bindings[22], (TextView) bindings[2], (TextView) bindings[12], (TextView) bindings[10], (TextView) bindings[20], (TextView) bindings[8], (TextView) bindings[18]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
