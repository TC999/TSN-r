package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.v2.common.view.CircleProgressView;
import com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV3SportsFinishBinding extends ViewDataBinding {
    @NonNull
    public final MaterialButton btBack;
    @NonNull
    public final MaterialButton btOk;
    @NonNull
    public final MaterialCardView cardNoPass;
    @NonNull
    public final MaterialCardView cardPassPoint;
    @NonNull
    public final CircleProgressView cpDistance;
    @NonNull
    public final CircleProgressView cpStep;
    @NonNull
    public final CircleProgressView cpTime;
    @Bindable
    protected V3SportsFinishDialog mDialog;
    @Bindable
    protected int mSportType;
    @Bindable
    protected String mTipsText;
    @NonNull
    public final MaterialCardView rlThreetwoone;
    @NonNull
    public final TextView tvDistance;
    @NonNull
    public final TextView tvDistanceHint;
    @NonNull
    public final TextView tvDistanceStatus;
    @NonNull
    public final TextView tvDistanceTag;
    @NonNull
    public final TextView tvNoPassPoint;
    @NonNull
    public final TextView tvPass;
    @NonNull
    public final TextView tvPassPoint;
    @NonNull
    public final TextView tvPassPointTarget;
    @NonNull
    public final TextView tvStep;
    @NonNull
    public final TextView tvStepHint;
    @NonNull
    public final TextView tvStepStatus;
    @NonNull
    public final TextView tvStepTarget;
    @NonNull
    public final TextView tvTime;
    @NonNull
    public final TextView tvTimeHint;
    @NonNull
    public final TextView tvTimeStatus;
    @NonNull
    public final TextView tvTimeTarget;
    @NonNull
    public final TextView tvTitleHint;
    @NonNull
    public final View vDistance;
    @NonNull
    public final View vStep;
    @NonNull
    public final View vTime;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV3SportsFinishBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btBack, MaterialButton btOk, MaterialCardView cardNoPass, MaterialCardView cardPassPoint, CircleProgressView cpDistance, CircleProgressView cpStep, CircleProgressView cpTime, MaterialCardView rlThreetwoone, TextView tvDistance, TextView tvDistanceHint, TextView tvDistanceStatus, TextView tvDistanceTag, TextView tvNoPassPoint, TextView tvPass, TextView tvPassPoint, TextView tvPassPointTarget, TextView tvStep, TextView tvStepHint, TextView tvStepStatus, TextView tvStepTarget, TextView tvTime, TextView tvTimeHint, TextView tvTimeStatus, TextView tvTimeTarget, TextView tvTitleHint, View vDistance, View vStep, View vTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btBack = btBack;
        this.btOk = btOk;
        this.cardNoPass = cardNoPass;
        this.cardPassPoint = cardPassPoint;
        this.cpDistance = cpDistance;
        this.cpStep = cpStep;
        this.cpTime = cpTime;
        this.rlThreetwoone = rlThreetwoone;
        this.tvDistance = tvDistance;
        this.tvDistanceHint = tvDistanceHint;
        this.tvDistanceStatus = tvDistanceStatus;
        this.tvDistanceTag = tvDistanceTag;
        this.tvNoPassPoint = tvNoPassPoint;
        this.tvPass = tvPass;
        this.tvPassPoint = tvPassPoint;
        this.tvPassPointTarget = tvPassPointTarget;
        this.tvStep = tvStep;
        this.tvStepHint = tvStepHint;
        this.tvStepStatus = tvStepStatus;
        this.tvStepTarget = tvStepTarget;
        this.tvTime = tvTime;
        this.tvTimeHint = tvTimeHint;
        this.tvTimeStatus = tvTimeStatus;
        this.tvTimeTarget = tvTimeTarget;
        this.tvTitleHint = tvTitleHint;
        this.vDistance = vDistance;
        this.vStep = vStep;
        this.vTime = vTime;
    }

    public static AcV3SportsFinishBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3SportsFinishBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3SportsFinishDialog getDialog() {
        return this.mDialog;
    }

    public int getSportType() {
        return this.mSportType;
    }

    @Nullable
    public String getTipsText() {
        return this.mTipsText;
    }

    public abstract void setDialog(@Nullable V3SportsFinishDialog dialog);

    public abstract void setSportType(int sportType);

    public abstract void setTipsText(@Nullable String tipsText);

    @Deprecated
    public static AcV3SportsFinishBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3SportsFinishBinding) ViewDataBinding.bind(component, view, 2131427516);
    }

    @NonNull
    @Deprecated
    public static AcV3SportsFinishBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3SportsFinishBinding) ViewDataBinding.inflateInternal(inflater, 2131427516, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3SportsFinishBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3SportsFinishBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3SportsFinishBinding) ViewDataBinding.inflateInternal(inflater, 2131427516, null, false, component);
    }
}
