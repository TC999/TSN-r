package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.google.android.material.card.MaterialCardView;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V3FmDataBinding extends ViewDataBinding {
    @NonNull
    public final Button btAppeal;
    @NonNull
    public final MaterialCardView card1;
    @NonNull
    public final MaterialCardView cardTotalTagrt;
    @NonNull
    public final ImageView ivDbcs;
    @NonNull
    public final ImageView ivDblc;
    @NonNull
    public final ImageView ivLjsc;
    @NonNull
    public final ImageView ivPbts;
    @NonNull
    public final ImageView ivYxlc;
    @NonNull
    public final ImageView ivYxxs;
    @Bindable
    protected V3RecordDetailActivity mMActivity;
    @Bindable
    protected Map<String, Object> mMap;
    @NonNull
    public final ProgressBar pbCount;
    @NonNull
    public final ProgressBar pbDistance;
    @NonNull
    public final TextView tv1;
    @NonNull
    public final TextView tv2;
    @NonNull
    public final TextView tvDbcs;
    @NonNull
    public final TextView tvDbcsHint;
    @NonNull
    public final TextView tvDbcsUnit;
    @NonNull
    public final TextView tvDblc;
    @NonNull
    public final TextView tvDblcHint;
    @NonNull
    public final TextView tvDblcUnit;
    @NonNull
    public final TextView tvLjsc;
    @NonNull
    public final TextView tvLjscUnit;
    @NonNull
    public final TextView tvLsscHint;
    @NonNull
    public final TextView tvPbts;
    @NonNull
    public final TextView tvPbtsHint;
    @NonNull
    public final TextView tvPbtsUnit;
    @NonNull
    public final TextView tvYxcs;
    @NonNull
    public final TextView tvYxcsHint;
    @NonNull
    public final TextView tvYxcsUnit;
    @NonNull
    public final TextView tvYxlc;
    @NonNull
    public final TextView tvYxlcHint;
    @NonNull
    public final TextView tvYxlcUnit;
    @NonNull
    public final TextView tvZdbsj;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3FmDataBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btAppeal, MaterialCardView card1, MaterialCardView cardTotalTagrt, ImageView ivDbcs, ImageView ivDblc, ImageView ivLjsc, ImageView ivPbts, ImageView ivYxlc, ImageView ivYxxs, ProgressBar pbCount, ProgressBar pbDistance, TextView tv1, TextView tv2, TextView tvDbcs, TextView tvDbcsHint, TextView tvDbcsUnit, TextView tvDblc, TextView tvDblcHint, TextView tvDblcUnit, TextView tvLjsc, TextView tvLjscUnit, TextView tvLsscHint, TextView tvPbts, TextView tvPbtsHint, TextView tvPbtsUnit, TextView tvYxcs, TextView tvYxcsHint, TextView tvYxcsUnit, TextView tvYxlc, TextView tvYxlcHint, TextView tvYxlcUnit, TextView tvZdbsj) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btAppeal = btAppeal;
        this.card1 = card1;
        this.cardTotalTagrt = cardTotalTagrt;
        this.ivDbcs = ivDbcs;
        this.ivDblc = ivDblc;
        this.ivLjsc = ivLjsc;
        this.ivPbts = ivPbts;
        this.ivYxlc = ivYxlc;
        this.ivYxxs = ivYxxs;
        this.pbCount = pbCount;
        this.pbDistance = pbDistance;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tvDbcs = tvDbcs;
        this.tvDbcsHint = tvDbcsHint;
        this.tvDbcsUnit = tvDbcsUnit;
        this.tvDblc = tvDblc;
        this.tvDblcHint = tvDblcHint;
        this.tvDblcUnit = tvDblcUnit;
        this.tvLjsc = tvLjsc;
        this.tvLjscUnit = tvLjscUnit;
        this.tvLsscHint = tvLsscHint;
        this.tvPbts = tvPbts;
        this.tvPbtsHint = tvPbtsHint;
        this.tvPbtsUnit = tvPbtsUnit;
        this.tvYxcs = tvYxcs;
        this.tvYxcsHint = tvYxcsHint;
        this.tvYxcsUnit = tvYxcsUnit;
        this.tvYxlc = tvYxlc;
        this.tvYxlcHint = tvYxlcHint;
        this.tvYxlcUnit = tvYxlcUnit;
        this.tvZdbsj = tvZdbsj;
    }

    public static V3FmDataBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3FmDataBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3RecordDetailActivity getMActivity() {
        return this.mMActivity;
    }

    @Nullable
    public Map<String, Object> getMap() {
        return this.mMap;
    }

    public abstract void setMActivity(@Nullable V3RecordDetailActivity mActivity);

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V3FmDataBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3FmDataBinding) ViewDataBinding.bind(component, view, 2131428106);
    }

    @NonNull
    @Deprecated
    public static V3FmDataBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3FmDataBinding) ViewDataBinding.inflateInternal(inflater, 2131428106, root, attachToRoot, component);
    }

    @NonNull
    public static V3FmDataBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3FmDataBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3FmDataBinding) ViewDataBinding.inflateInternal(inflater, 2131428106, null, false, component);
    }
}
