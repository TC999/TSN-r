package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.BarChart;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class FmV2SportsStepBinding extends ViewDataBinding {
    @NonNull
    public final BarChart chart;

    /* JADX INFO: Access modifiers changed from: protected */
    public FmV2SportsStepBinding(Object _bindingComponent, View _root, int _localFieldCount, BarChart chart) {
        super(_bindingComponent, _root, _localFieldCount);
        this.chart = chart;
    }

    public static FmV2SportsStepBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FmV2SportsStepBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FmV2SportsStepBinding bind(@NonNull View view, @Nullable Object component) {
        return (FmV2SportsStepBinding) ViewDataBinding.bind(component, view, 2131427646);
    }

    @NonNull
    @Deprecated
    public static FmV2SportsStepBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FmV2SportsStepBinding) ViewDataBinding.inflateInternal(inflater, 2131427646, root, attachToRoot, component);
    }

    @NonNull
    public static FmV2SportsStepBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FmV2SportsStepBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FmV2SportsStepBinding) ViewDataBinding.inflateInternal(inflater, 2131427646, null, false, component);
    }
}
