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
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V3ItemForValidRecordListTraceBindingImpl extends V3ItemForValidRecordListTraceBinding {
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
        sparseIntArray.put(C4215R.C4219id.iv_sports_type, 10);
        sparseIntArray.put(C4215R.C4219id.tv_sports_type_name, 11);
        sparseIntArray.put(2131233198, 12);
        sparseIntArray.put(C4215R.C4219id.iv_sports_time, 13);
        sparseIntArray.put(C4215R.C4219id.tv_duration, 14);
    }

    public V3ItemForValidRecordListTraceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int i = this.mSportType;
        long j2 = j & 3;
        int i2 = 0;
        if (j2 != 0) {
            boolean z = i == 5;
            if (j2 != 0) {
                j |= z ? 8L : 4L;
            }
            if (z) {
                i2 = 8;
            }
        }
        if ((j & 3) != 0) {
            this.ivSportsDistance.setVisibility(i2);
            this.ivSportsStep.setVisibility(i2);
            this.tvDistance.setVisibility(i2);
            this.tvDistanceUnit.setVisibility(i2);
            this.tvStep.setVisibility(i2);
            this.tvStepUnit.setVisibility(i2);
            this.vCenter.setVisibility(i2);
            this.vLeft.setVisibility(i2);
            this.vRight.setVisibility(i2);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.V3ItemForValidRecordListTraceBinding
    public void setSportType(int SportType) {
        this.mSportType = SportType;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (25 == variableId) {
            setSportType(((Integer) variable).intValue());
            return true;
        }
        return false;
    }

    private V3ItemForValidRecordListTraceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[4], (ImageView) bindings[7], (ImageView) bindings[13], (ImageView) bindings[10], (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[14], (TextView) bindings[11], (TextView) bindings[8], (TextView) bindings[9], (TextView) bindings[12], (View) bindings[2], (View) bindings[1], (View) bindings[3]);
        this.mDirtyFlags = -1L;
        this.ivSportsDistance.setTag(null);
        this.ivSportsStep.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvDistance.setTag(null);
        this.tvDistanceUnit.setTag(null);
        this.tvStep.setTag(null);
        this.tvStepUnit.setTag(null);
        this.vCenter.setTag(null);
        this.vLeft.setTag(null);
        this.vRight.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
