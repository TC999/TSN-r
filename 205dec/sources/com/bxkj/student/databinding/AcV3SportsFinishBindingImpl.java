package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.common.view.CircleProgressView;
import com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcV3SportsFinishBindingImpl extends AcV3SportsFinishBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback22;
    @Nullable
    private final View.OnClickListener mCallback23;
    private long mDirtyFlags;
    @NonNull
    private final TextView mboundView14;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131233205, 16);
        sparseIntArray.put(2131233283, 17);
        sparseIntArray.put(2131233202, 18);
        sparseIntArray.put(2131233200, 19);
        sparseIntArray.put(2131233198, 20);
        sparseIntArray.put(2131233201, 21);
        sparseIntArray.put(2131231153, 22);
        sparseIntArray.put(2131231071, 23);
        sparseIntArray.put(2131233071, 24);
        sparseIntArray.put(2131233070, 25);
        sparseIntArray.put(2131233069, 26);
        sparseIntArray.put(2131233046, 27);
        sparseIntArray.put(2131230989, 28);
    }

    public AcV3SportsFinishBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3SportsFinishDialog v3SportsFinishDialog = this.mDialog;
            if (v3SportsFinishDialog != null) {
                v3SportsFinishDialog.c0();
            }
        } else if (sourceId != 2) {
        } else {
            V3SportsFinishDialog v3SportsFinishDialog2 = this.mDialog;
            if (v3SportsFinishDialog2 != null) {
                v3SportsFinishDialog2.N();
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
        String str = this.mTipsText;
        long j5 = j4 & 9;
        int i5 = 0;
        if (j5 != 0) {
            boolean z3 = i4 == 5;
            if (j5 != 0) {
                j4 |= z3 ? 32L : 16L;
            }
            if (z3) {
                i5 = 8;
            }
        }
        long j6 = 12 & j4;
        if ((8 & j4) != 0) {
            this.btBack.setOnClickListener(this.mCallback23);
            this.cardNoPass.setOnClickListener(this.mCallback22);
        }
        if ((j4 & 9) != 0) {
            this.cpDistance.setVisibility(i5);
            this.cpStep.setVisibility(i5);
            this.tvDistance.setVisibility(i5);
            this.tvDistanceHint.setVisibility(i5);
            this.tvDistanceStatus.setVisibility(i5);
            this.tvDistanceTag.setVisibility(i5);
            this.tvStep.setVisibility(i5);
            this.tvStepHint.setVisibility(i5);
            this.tvStepStatus.setVisibility(i5);
            this.tvStepTarget.setVisibility(i5);
            this.vDistance.setVisibility(i5);
            this.vStep.setVisibility(i5);
        }
        if (j6 != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, str);
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
            this.mDirtyFlags = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.AcV3SportsFinishBinding
    public void setDialog(@Nullable V3SportsFinishDialog Dialog) {
        this.mDialog = Dialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsFinishBinding
    public void setSportType(int SportType) {
        this.mSportType = SportType;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsFinishBinding
    public void setTipsText(@Nullable String TipsText) {
        this.mTipsText = TipsText;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (25 == variableId) {
            setSportType(((Integer) variable).intValue());
        } else if (8 == variableId) {
            setDialog((V3SportsFinishDialog) variable);
        } else if (27 != variableId) {
            return false;
        } else {
            setTipsText((String) variable);
        }
        return true;
    }

    private AcV3SportsFinishBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialButton) bindings[15], (MaterialButton) bindings[28], (MaterialCardView) bindings[13], (MaterialCardView) bindings[23], (CircleProgressView) bindings[11], (CircleProgressView) bindings[12], (CircleProgressView) bindings[22], (MaterialCardView) bindings[0], (TextView) bindings[4], (TextView) bindings[3], (TextView) bindings[5], (TextView) bindings[2], (TextView) bindings[27], (TextView) bindings[26], (TextView) bindings[25], (TextView) bindings[24], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[10], (TextView) bindings[7], (TextView) bindings[20], (TextView) bindings[19], (TextView) bindings[21], (TextView) bindings[18], (TextView) bindings[16], (View) bindings[1], (View) bindings[6], (View) bindings[17]);
        this.mDirtyFlags = -1L;
        this.btBack.setTag(null);
        this.cardNoPass.setTag(null);
        this.cpDistance.setTag(null);
        this.cpStep.setTag(null);
        TextView textView = (TextView) bindings[14];
        this.mboundView14 = textView;
        textView.setTag(null);
        this.rlThreetwoone.setTag(null);
        this.tvDistance.setTag(null);
        this.tvDistanceHint.setTag(null);
        this.tvDistanceStatus.setTag(null);
        this.tvDistanceTag.setTag(null);
        this.tvStep.setTag(null);
        this.tvStepHint.setTag(null);
        this.tvStepStatus.setTag(null);
        this.tvStepTarget.setTag(null);
        this.vDistance.setTag(null);
        this.vStep.setTag(null);
        setRootTag(root);
        this.mCallback23 = new a(this, 2);
        this.mCallback22 = new a(this, 1);
        invalidateAll();
    }
}
