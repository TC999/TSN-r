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
import com.bxkj.student.C4215R;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.google.android.material.card.MaterialCardView;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
        sparseIntArray.put(C4215R.C4219id.card_pace, 1);
        sparseIntArray.put(C4215R.C4219id.tv_pace_hint, 2);
        sparseIntArray.put(C4215R.C4219id.card_pace_line, 3);
        sparseIntArray.put(C4215R.C4219id.tv_avg_pace_hint, 4);
        sparseIntArray.put(C4215R.C4219id.tv_best_pace_hint, 5);
        sparseIntArray.put(C4215R.C4219id.tv_avg_pace, 6);
        sparseIntArray.put(C4215R.C4219id.tv_best_pace, 7);
        sparseIntArray.put(C4215R.C4219id.tv_y_name, 8);
        sparseIntArray.put(C4215R.C4219id.AAChartView, 9);
        sparseIntArray.put(C4215R.C4219id.tv_x_name, 10);
        sparseIntArray.put(C4215R.C4219id.card_step, 11);
        sparseIntArray.put(C4215R.C4219id.tv_step_hint, 12);
        sparseIntArray.put(C4215R.C4219id.card_step_line, 13);
        sparseIntArray.put(C4215R.C4219id.tv_avg_step_hint, 14);
        sparseIntArray.put(C4215R.C4219id.tv_best_step_hint, 15);
        sparseIntArray.put(C4215R.C4219id.tv_avg_step, 16);
        sparseIntArray.put(C4215R.C4219id.tv_best_step, 17);
        sparseIntArray.put(C4215R.C4219id.tv_y_step_name, 18);
        sparseIntArray.put(C4215R.C4219id.AAChartView_step, 19);
        sparseIntArray.put(C4215R.C4219id.tv_x_step_name, 20);
        sparseIntArray.put(C4215R.C4219id.card_pace2, 21);
        sparseIntArray.put(C4215R.C4219id.tv_pace2_hint, 22);
        sparseIntArray.put(C4215R.C4219id.card_pace2_line, 23);
        sparseIntArray.put(C4215R.C4219id.tv_avg_pace2_hint, 24);
        sparseIntArray.put(C4215R.C4219id.tv_best_pace2_hint, 25);
        sparseIntArray.put(C4215R.C4219id.tv_avg_pace2, 26);
        sparseIntArray.put(C4215R.C4219id.tv_best_pace2, 27);
        sparseIntArray.put(C4215R.C4219id.rv_pace2, 28);
        sparseIntArray.put(C4215R.C4219id.tv_last_km_pace, 29);
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
