package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V3ItemForValidRecordListTraceBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivSportsDistance;
    @NonNull
    public final ImageView ivSportsStep;
    @NonNull
    public final ImageView ivSportsTime;
    @NonNull
    public final ImageView ivSportsType;
    @Bindable
    protected int mSportType;
    @NonNull
    public final TextView tvDistance;
    @NonNull
    public final TextView tvDistanceUnit;
    @NonNull
    public final TextView tvDuration;
    @NonNull
    public final TextView tvSportsTypeName;
    @NonNull
    public final TextView tvStep;
    @NonNull
    public final TextView tvStepUnit;
    @NonNull
    public final TextView tvTime;
    @NonNull
    public final View vCenter;
    @NonNull
    public final View vLeft;
    @NonNull
    public final View vRight;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3ItemForValidRecordListTraceBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivSportsDistance, ImageView ivSportsStep, ImageView ivSportsTime, ImageView ivSportsType, TextView tvDistance, TextView tvDistanceUnit, TextView tvDuration, TextView tvSportsTypeName, TextView tvStep, TextView tvStepUnit, TextView tvTime, View vCenter, View vLeft, View vRight) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivSportsDistance = ivSportsDistance;
        this.ivSportsStep = ivSportsStep;
        this.ivSportsTime = ivSportsTime;
        this.ivSportsType = ivSportsType;
        this.tvDistance = tvDistance;
        this.tvDistanceUnit = tvDistanceUnit;
        this.tvDuration = tvDuration;
        this.tvSportsTypeName = tvSportsTypeName;
        this.tvStep = tvStep;
        this.tvStepUnit = tvStepUnit;
        this.tvTime = tvTime;
        this.vCenter = vCenter;
        this.vLeft = vLeft;
        this.vRight = vRight;
    }

    public static V3ItemForValidRecordListTraceBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3ItemForValidRecordListTraceBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public int getSportType() {
        return this.mSportType;
    }

    public abstract void setSportType(int sportType);

    @Deprecated
    public static V3ItemForValidRecordListTraceBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3ItemForValidRecordListTraceBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v3_item_for_valid_record_list_trace);
    }

    @NonNull
    @Deprecated
    public static V3ItemForValidRecordListTraceBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3ItemForValidRecordListTraceBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_item_for_valid_record_list_trace, root, attachToRoot, component);
    }

    @NonNull
    public static V3ItemForValidRecordListTraceBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3ItemForValidRecordListTraceBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3ItemForValidRecordListTraceBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_item_for_valid_record_list_trace, null, false, component);
    }
}
