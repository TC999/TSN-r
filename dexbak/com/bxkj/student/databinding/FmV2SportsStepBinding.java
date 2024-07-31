package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;
import com.github.mikephil.charting.charts.BarChart;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
        return (FmV2SportsStepBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.fm_v2_sports_step);
    }

    @NonNull
    @Deprecated
    public static FmV2SportsStepBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FmV2SportsStepBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.fm_v2_sports_step, root, attachToRoot, component);
    }

    @NonNull
    public static FmV2SportsStepBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FmV2SportsStepBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FmV2SportsStepBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.fm_v2_sports_step, null, false, component);
    }
}
