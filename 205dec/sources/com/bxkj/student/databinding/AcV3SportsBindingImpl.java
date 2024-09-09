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
import com.bxkj.student.common.view.LongPressButton;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.common.view.StepArcView;
import com.bxkj.student.v2.ui.sports.v3.V3SportsActivity;
import com.google.android.material.tabs.TabLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcV3SportsBindingImpl extends AcV3SportsBinding implements a.InterfaceC0220a {
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
        sparseIntArray.put(2131232695, 12);
        sparseIntArray.put(2131231113, 13);
        sparseIntArray.put(2131232979, 14);
        sparseIntArray.put(2131231423, 15);
        sparseIntArray.put(2131232566, 16);
        sparseIntArray.put(2131231502, 17);
        sparseIntArray.put(2131231494, 18);
    }

    public AcV3SportsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3SportsActivity v3SportsActivity = this.mBackEvent;
            if (v3SportsActivity != null) {
                v3SportsActivity.onBackPressed();
            }
        } else if (sourceId == 2) {
            V3SportsActivity v3SportsActivity2 = this.mBackEvent;
            if (v3SportsActivity2 != null) {
                v3SportsActivity2.U();
            }
        } else if (sourceId == 3) {
            V3SportsActivity v3SportsActivity3 = this.mBackEvent;
            if (v3SportsActivity3 != null) {
                v3SportsActivity3.P();
            }
        } else if (sourceId != 4) {
        } else {
            V3SportsActivity v3SportsActivity4 = this.mBackEvent;
            if (v3SportsActivity4 != null) {
                v3SportsActivity4.T();
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int i4 = this.mSportType;
        long j5 = j4 & 5;
        int i5 = 0;
        if (j5 != 0) {
            boolean z3 = i4 == 5;
            if (j5 != 0) {
                j4 |= z3 ? 16L : 8L;
            }
            if (z3) {
                i5 = 8;
            }
        }
        if ((4 & j4) != 0) {
            this.ibBack.setOnClickListener(this.mCallback1);
            this.ibSet.setOnClickListener(this.mCallback2);
            this.ivLock.setOnClickListener(this.mCallback3);
            this.ivToMap.setOnClickListener(this.mCallback4);
        }
        if ((j4 & 5) != 0) {
            this.saDistance.setVisibility(i5);
            this.saStep.setVisibility(i5);
            this.tvAvgSpeed.setVisibility(i5);
            this.tvAvgSpeedHint.setVisibility(i5);
            this.tvPaceSpeed.setVisibility(i5);
            this.tvPaceSpeedHint.setVisibility(i5);
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
        this.ns.setTag(null);
        this.saDistance.setTag(null);
        this.saStep.setTag(null);
        this.tvAvgSpeed.setTag(null);
        this.tvAvgSpeedHint.setTag(null);
        this.tvPaceSpeed.setTag(null);
        this.tvPaceSpeedHint.setTag(null);
        setRootTag(root);
        this.mCallback4 = new a(this, 4);
        this.mCallback2 = new a(this, 2);
        this.mCallback3 = new a(this, 3);
        this.mCallback1 = new a(this, 1);
        invalidateAll();
    }
}
