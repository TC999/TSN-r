package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V3ItemForValidRecordListBinding extends ViewDataBinding {
    @NonNull
    public final MaterialCardView card1;
    @NonNull
    public final ImageView ivArrow;
    @NonNull
    public final RecyclerView rvTrace;
    @NonNull
    public final TextView tvCountDistance;
    @NonNull
    public final TextView tvCountNumber;
    @NonNull
    public final TextView tvCountTime;
    @NonNull
    public final TextView tvDate;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3ItemForValidRecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialCardView card1, ImageView ivArrow, RecyclerView rvTrace, TextView tvCountDistance, TextView tvCountNumber, TextView tvCountTime, TextView tvDate) {
        super(_bindingComponent, _root, _localFieldCount);
        this.card1 = card1;
        this.ivArrow = ivArrow;
        this.rvTrace = rvTrace;
        this.tvCountDistance = tvCountDistance;
        this.tvCountNumber = tvCountNumber;
        this.tvCountTime = tvCountTime;
        this.tvDate = tvDate;
    }

    public static V3ItemForValidRecordListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3ItemForValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V3ItemForValidRecordListBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3ItemForValidRecordListBinding) ViewDataBinding.bind(component, view, 2131428110);
    }

    @NonNull
    @Deprecated
    public static V3ItemForValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3ItemForValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, 2131428110, root, attachToRoot, component);
    }

    @NonNull
    public static V3ItemForValidRecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3ItemForValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3ItemForValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, 2131428110, null, false, component);
    }
}