package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.view.LongPressButton;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.common.view.StepArcView;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsActivity;
import com.google.android.material.tabs.TabLayout;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AcV3SportsBindingImpl extends AcV3SportsBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback1;
    @Nullable
    private final View.OnClickListener mCallback2;
    @Nullable
    private final View.OnClickListener mCallback3;
    @Nullable
    private final View.OnClickListener mCallback4;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232230, 11);
        sparseIntArray.put(C4215R.C4219id.tab, 12);
        sparseIntArray.put(C4215R.C4219id.cl_gps, 13);
        sparseIntArray.put(C4215R.C4219id.tv_gps, 14);
        sparseIntArray.put(C4215R.C4219id.iv_gps, 15);
        sparseIntArray.put(C4215R.C4219id.sa_time, 16);
        sparseIntArray.put(C4215R.C4219id.iv_unlock, 17);
        sparseIntArray.put(C4215R.C4219id.iv_stop, 18);
    }

    public AcV3SportsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3SportsActivity v3SportsActivity = this.mBackEvent;
            if (v3SportsActivity != null) {
                v3SportsActivity.onBackPressed();
            }
        } else if (sourceId == 2) {
            V3SportsActivity v3SportsActivity2 = this.mBackEvent;
            if (v3SportsActivity2 != null) {
                v3SportsActivity2.m38581U();
            }
        } else if (sourceId == 3) {
            V3SportsActivity v3SportsActivity3 = this.mBackEvent;
            if (v3SportsActivity3 != null) {
                v3SportsActivity3.m38586P();
            }
        } else if (sourceId != 4) {
        } else {
            V3SportsActivity v3SportsActivity4 = this.mBackEvent;
            if (v3SportsActivity4 != null) {
                v3SportsActivity4.m38582T();
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int i = this.mSportType;
        long j2 = j & 5;
        int i2 = 0;
        if (j2 != 0) {
            boolean z = i == 5;
            if (j2 != 0) {
                j |= z ? 16L : 8L;
            }
            if (z) {
                i2 = 8;
            }
        }
        if ((4 & j) != 0) {
            this.ibBack.setOnClickListener(this.mCallback1);
            this.ibSet.setOnClickListener(this.mCallback2);
            this.ivLock.setOnClickListener(this.mCallback3);
            this.ivToMap.setOnClickListener(this.mCallback4);
        }
        if ((j & 5) != 0) {
            this.saDistance.setVisibility(i2);
            this.saStep.setVisibility(i2);
            this.tvAvgSpeed.setVisibility(i2);
            this.tvAvgSpeedHint.setVisibility(i2);
            this.tvPaceSpeed.setVisibility(i2);
            this.tvPaceSpeedHint.setVisibility(i2);
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
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.AcV3SportsBinding
    public void setBackEvent(@Nullable V3SportsActivity BackEvent) {
        this.mBackEvent = BackEvent;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsBinding
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
        } else if (3 != variableId) {
            return false;
        } else {
            setBackEvent((V3SportsActivity) variable);
        }
        return true;
    }

    private AcV3SportsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[13], (AppCompatImageButton) bindings[1], (ConstraintLayout) bindings[2], (AppCompatImageView) bindings[15], (AppCompatImageView) bindings[9], (LongPressButton) bindings[18], (AppCompatImageView) bindings[10], (LongPressButton) bindings[17], (ConstraintLayout) bindings[11], (NestedScrollView) bindings[0], (StepArcView) bindings[3], (StepArcView) bindings[4], (StepArcView) bindings[16], (TabLayout) bindings[12], (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[14], (TextView) bindings[7], (TextView) bindings[8]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.ibSet.setTag(null);
        this.ivLock.setTag(null);
        this.ivToMap.setTag(null);
        this.f16280ns.setTag(null);
        this.saDistance.setTag(null);
        this.saStep.setTag(null);
        this.tvAvgSpeed.setTag(null);
        this.tvAvgSpeedHint.setTag(null);
        this.tvPaceSpeed.setTag(null);
        this.tvPaceSpeedHint.setTag(null);
        setRootTag(root);
        this.mCallback4 = new View$OnClickListenerC4297a(this, 4);
        this.mCallback2 = new View$OnClickListenerC4297a(this, 2);
        this.mCallback3 = new View$OnClickListenerC4297a(this, 3);
        this.mCallback1 = new View$OnClickListenerC4297a(this, 1);
        invalidateAll();
    }
}
