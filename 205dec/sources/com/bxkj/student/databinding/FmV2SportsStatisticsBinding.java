package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.v2.common.view.CustomBarChart;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class FmV2SportsStatisticsBinding extends ViewDataBinding {
    @NonNull
    public final CustomBarChart barChart;

    /* JADX INFO: Access modifiers changed from: protected */
    public FmV2SportsStatisticsBinding(Object _bindingComponent, View _root, int _localFieldCount, CustomBarChart barChart) {
        super(_bindingComponent, _root, _localFieldCount);
        this.barChart = barChart;
    }

    public static FmV2SportsStatisticsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FmV2SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FmV2SportsStatisticsBinding bind(@NonNull View view, @Nullable Object component) {
        return (FmV2SportsStatisticsBinding) ViewDataBinding.bind(component, view, 2131427645);
    }

    @NonNull
    @Deprecated
    public static FmV2SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FmV2SportsStatisticsBinding) ViewDataBinding.inflateInternal(inflater, 2131427645, root, attachToRoot, component);
    }

    @NonNull
    public static FmV2SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FmV2SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FmV2SportsStatisticsBinding) ViewDataBinding.inflateInternal(inflater, 2131427645, null, false, component);
    }
}
