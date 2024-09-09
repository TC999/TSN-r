package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.google.android.material.card.MaterialCardView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class FmV3SportsChartBinding extends ViewDataBinding {
    @NonNull
    public final AAChartView AAChartView;
    @NonNull
    public final AAChartView AAChartViewStep;
    @NonNull
    public final MaterialCardView cardPace;
    @NonNull
    public final MaterialCardView cardPace2;
    @NonNull
    public final MaterialCardView cardPace2Line;
    @NonNull
    public final MaterialCardView cardPaceLine;
    @NonNull
    public final MaterialCardView cardStep;
    @NonNull
    public final MaterialCardView cardStepLine;
    @NonNull
    public final RecyclerView rvPace2;
    @NonNull
    public final TextView tvAvgPace;
    @NonNull
    public final TextView tvAvgPace2;
    @NonNull
    public final TextView tvAvgPace2Hint;
    @NonNull
    public final TextView tvAvgPaceHint;
    @NonNull
    public final TextView tvAvgStep;
    @NonNull
    public final TextView tvAvgStepHint;
    @NonNull
    public final TextView tvBestPace;
    @NonNull
    public final TextView tvBestPace2;
    @NonNull
    public final TextView tvBestPace2Hint;
    @NonNull
    public final TextView tvBestPaceHint;
    @NonNull
    public final TextView tvBestStep;
    @NonNull
    public final TextView tvBestStepHint;
    @NonNull
    public final TextView tvLastKmPace;
    @NonNull
    public final TextView tvPace2Hint;
    @NonNull
    public final TextView tvPaceHint;
    @NonNull
    public final TextView tvStepHint;
    @NonNull
    public final TextView tvXName;
    @NonNull
    public final TextView tvXStepName;
    @NonNull
    public final TextView tvYName;
    @NonNull
    public final TextView tvYStepName;

    /* JADX INFO: Access modifiers changed from: protected */
    public FmV3SportsChartBinding(Object _bindingComponent, View _root, int _localFieldCount, AAChartView AAChartView, AAChartView AAChartViewStep, MaterialCardView cardPace, MaterialCardView cardPace2, MaterialCardView cardPace2Line, MaterialCardView cardPaceLine, MaterialCardView cardStep, MaterialCardView cardStepLine, RecyclerView rvPace2, TextView tvAvgPace, TextView tvAvgPace2, TextView tvAvgPace2Hint, TextView tvAvgPaceHint, TextView tvAvgStep, TextView tvAvgStepHint, TextView tvBestPace, TextView tvBestPace2, TextView tvBestPace2Hint, TextView tvBestPaceHint, TextView tvBestStep, TextView tvBestStepHint, TextView tvLastKmPace, TextView tvPace2Hint, TextView tvPaceHint, TextView tvStepHint, TextView tvXName, TextView tvXStepName, TextView tvYName, TextView tvYStepName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.AAChartView = AAChartView;
        this.AAChartViewStep = AAChartViewStep;
        this.cardPace = cardPace;
        this.cardPace2 = cardPace2;
        this.cardPace2Line = cardPace2Line;
        this.cardPaceLine = cardPaceLine;
        this.cardStep = cardStep;
        this.cardStepLine = cardStepLine;
        this.rvPace2 = rvPace2;
        this.tvAvgPace = tvAvgPace;
        this.tvAvgPace2 = tvAvgPace2;
        this.tvAvgPace2Hint = tvAvgPace2Hint;
        this.tvAvgPaceHint = tvAvgPaceHint;
        this.tvAvgStep = tvAvgStep;
        this.tvAvgStepHint = tvAvgStepHint;
        this.tvBestPace = tvBestPace;
        this.tvBestPace2 = tvBestPace2;
        this.tvBestPace2Hint = tvBestPace2Hint;
        this.tvBestPaceHint = tvBestPaceHint;
        this.tvBestStep = tvBestStep;
        this.tvBestStepHint = tvBestStepHint;
        this.tvLastKmPace = tvLastKmPace;
        this.tvPace2Hint = tvPace2Hint;
        this.tvPaceHint = tvPaceHint;
        this.tvStepHint = tvStepHint;
        this.tvXName = tvXName;
        this.tvXStepName = tvXStepName;
        this.tvYName = tvYName;
        this.tvYStepName = tvYStepName;
    }

    public static FmV3SportsChartBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FmV3SportsChartBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FmV3SportsChartBinding bind(@NonNull View view, @Nullable Object component) {
        return (FmV3SportsChartBinding) ViewDataBinding.bind(component, view, 2131427649);
    }

    @NonNull
    @Deprecated
    public static FmV3SportsChartBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FmV3SportsChartBinding) ViewDataBinding.inflateInternal(inflater, 2131427649, root, attachToRoot, component);
    }

    @NonNull
    public static FmV3SportsChartBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FmV3SportsChartBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FmV3SportsChartBinding) ViewDataBinding.inflateInternal(inflater, 2131427649, null, false, component);
    }
}
