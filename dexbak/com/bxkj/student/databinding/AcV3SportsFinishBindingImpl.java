package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.common.view.CircleProgressView;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsFinishDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AcV3SportsFinishBindingImpl extends AcV3SportsFinishBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
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
        sparseIntArray.put(C4215R.C4219id.tv_title_hint, 16);
        sparseIntArray.put(C4215R.C4219id.v_time, 17);
        sparseIntArray.put(C4215R.C4219id.tv_time_target, 18);
        sparseIntArray.put(C4215R.C4219id.tv_time_hint, 19);
        sparseIntArray.put(2131233198, 20);
        sparseIntArray.put(C4215R.C4219id.tv_time_status, 21);
        sparseIntArray.put(C4215R.C4219id.cp_time, 22);
        sparseIntArray.put(C4215R.C4219id.card_pass_point, 23);
        sparseIntArray.put(C4215R.C4219id.tv_pass_point_target, 24);
        sparseIntArray.put(C4215R.C4219id.tv_pass_point, 25);
        sparseIntArray.put(C4215R.C4219id.tv_pass, 26);
        sparseIntArray.put(C4215R.C4219id.tv_no_pass_point, 27);
        sparseIntArray.put(2131230989, 28);
    }

    public AcV3SportsFinishBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3SportsFinishDialog v3SportsFinishDialog = this.mDialog;
            if (v3SportsFinishDialog != null) {
                v3SportsFinishDialog.m38560c0();
            }
        } else if (sourceId != 2) {
        } else {
            V3SportsFinishDialog v3SportsFinishDialog2 = this.mDialog;
            if (v3SportsFinishDialog2 != null) {
                v3SportsFinishDialog2.m38575N();
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
        String str = this.mTipsText;
        long j2 = j & 9;
        int i2 = 0;
        if (j2 != 0) {
            boolean z = i == 5;
            if (j2 != 0) {
                j |= z ? 32L : 16L;
            }
            if (z) {
                i2 = 8;
            }
        }
        long j3 = 12 & j;
        if ((8 & j) != 0) {
            this.btBack.setOnClickListener(this.mCallback23);
            this.cardNoPass.setOnClickListener(this.mCallback22);
        }
        if ((j & 9) != 0) {
            this.cpDistance.setVisibility(i2);
            this.cpStep.setVisibility(i2);
            this.tvDistance.setVisibility(i2);
            this.tvDistanceHint.setVisibility(i2);
            this.tvDistanceStatus.setVisibility(i2);
            this.tvDistanceTag.setVisibility(i2);
            this.tvStep.setVisibility(i2);
            this.tvStepHint.setVisibility(i2);
            this.tvStepStatus.setVisibility(i2);
            this.tvStepTarget.setVisibility(i2);
            this.vDistance.setVisibility(i2);
            this.vStep.setVisibility(i2);
        }
        if (j3 != 0) {
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
        this.mCallback23 = new View$OnClickListenerC4297a(this, 2);
        this.mCallback22 = new View$OnClickListenerC4297a(this, 1);
        invalidateAll();
    }
}
