package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class FmV3RecordListTotalBinding extends ViewDataBinding {
    @NonNull
    public final AAChartView AAChartView;
    @NonNull
    public final MaterialCardView cardChat;
    @NonNull
    public final MaterialCardView cardPace;
    @NonNull
    public final View line;
    @NonNull
    public final View line0;
    @NonNull
    public final View line00;
    @NonNull
    public final View line2;
    @NonNull
    public final LinearLayout ll0;
    @NonNull
    public final LinearLayout ll00;
    @NonNull
    public final LinearLayout ll1;
    @NonNull
    public final LinearLayout ll2;
    @NonNull
    public final TabLayout tbType;
    @NonNull
    public final TextView tvAvgCount;
    @NonNull
    public final TextView tvAvgCountHint;
    @NonNull
    public final TextView tvAvgCountUnit;
    @NonNull
    public final TextView tvAvgDistance;
    @NonNull
    public final TextView tvAvgDistanceHint;
    @NonNull
    public final TextView tvAvgDistanceUnit;
    @NonNull
    public final TextView tvAvgTime;
    @NonNull
    public final TextView tvAvgTimeHint;
    @NonNull
    public final TextView tvAvgTimeUnit;
    @NonNull
    public final TextView tvCount;
    @NonNull
    public final TextView tvCountHint;
    @NonNull
    public final TextView tvCountUnit;
    @NonNull
    public final TextView tvDay;
    @NonNull
    public final TextView tvDayHint;
    @NonNull
    public final TextView tvDayUnit;
    @NonNull
    public final TextView tvDistance;
    @NonNull
    public final TextView tvDistanceHint;
    @NonNull
    public final TextView tvDistanceUnit;
    @NonNull
    public final TextView tvHeart;
    @NonNull
    public final TextView tvHeartHint;
    @NonNull
    public final TextView tvHeartUnit;
    @NonNull
    public final TextView tvPace;
    @NonNull
    public final TextView tvPaceHint;
    @NonNull
    public final TextView tvPaceUnit;
    @NonNull
    public final TextView tvStep;
    @NonNull
    public final TextView tvStepDistance;
    @NonNull
    public final TextView tvStepDistanceHint;
    @NonNull
    public final TextView tvStepDistanceUnit;
    @NonNull
    public final TextView tvStepHint;
    @NonNull
    public final TextView tvStepUnit;
    @NonNull
    public final TextView tvTime;
    @NonNull
    public final TextView tvTimeHint;
    @NonNull
    public final TextView tvTimeUnit;

    /* JADX INFO: Access modifiers changed from: protected */
    public FmV3RecordListTotalBinding(Object _bindingComponent, View _root, int _localFieldCount, AAChartView AAChartView, MaterialCardView cardChat, MaterialCardView cardPace, View line, View line0, View line00, View line2, LinearLayout ll0, LinearLayout ll00, LinearLayout ll1, LinearLayout ll2, TabLayout tbType, TextView tvAvgCount, TextView tvAvgCountHint, TextView tvAvgCountUnit, TextView tvAvgDistance, TextView tvAvgDistanceHint, TextView tvAvgDistanceUnit, TextView tvAvgTime, TextView tvAvgTimeHint, TextView tvAvgTimeUnit, TextView tvCount, TextView tvCountHint, TextView tvCountUnit, TextView tvDay, TextView tvDayHint, TextView tvDayUnit, TextView tvDistance, TextView tvDistanceHint, TextView tvDistanceUnit, TextView tvHeart, TextView tvHeartHint, TextView tvHeartUnit, TextView tvPace, TextView tvPaceHint, TextView tvPaceUnit, TextView tvStep, TextView tvStepDistance, TextView tvStepDistanceHint, TextView tvStepDistanceUnit, TextView tvStepHint, TextView tvStepUnit, TextView tvTime, TextView tvTimeHint, TextView tvTimeUnit) {
        super(_bindingComponent, _root, _localFieldCount);
        this.AAChartView = AAChartView;
        this.cardChat = cardChat;
        this.cardPace = cardPace;
        this.line = line;
        this.line0 = line0;
        this.line00 = line00;
        this.line2 = line2;
        this.ll0 = ll0;
        this.ll00 = ll00;
        this.ll1 = ll1;
        this.ll2 = ll2;
        this.tbType = tbType;
        this.tvAvgCount = tvAvgCount;
        this.tvAvgCountHint = tvAvgCountHint;
        this.tvAvgCountUnit = tvAvgCountUnit;
        this.tvAvgDistance = tvAvgDistance;
        this.tvAvgDistanceHint = tvAvgDistanceHint;
        this.tvAvgDistanceUnit = tvAvgDistanceUnit;
        this.tvAvgTime = tvAvgTime;
        this.tvAvgTimeHint = tvAvgTimeHint;
        this.tvAvgTimeUnit = tvAvgTimeUnit;
        this.tvCount = tvCount;
        this.tvCountHint = tvCountHint;
        this.tvCountUnit = tvCountUnit;
        this.tvDay = tvDay;
        this.tvDayHint = tvDayHint;
        this.tvDayUnit = tvDayUnit;
        this.tvDistance = tvDistance;
        this.tvDistanceHint = tvDistanceHint;
        this.tvDistanceUnit = tvDistanceUnit;
        this.tvHeart = tvHeart;
        this.tvHeartHint = tvHeartHint;
        this.tvHeartUnit = tvHeartUnit;
        this.tvPace = tvPace;
        this.tvPaceHint = tvPaceHint;
        this.tvPaceUnit = tvPaceUnit;
        this.tvStep = tvStep;
        this.tvStepDistance = tvStepDistance;
        this.tvStepDistanceHint = tvStepDistanceHint;
        this.tvStepDistanceUnit = tvStepDistanceUnit;
        this.tvStepHint = tvStepHint;
        this.tvStepUnit = tvStepUnit;
        this.tvTime = tvTime;
        this.tvTimeHint = tvTimeHint;
        this.tvTimeUnit = tvTimeUnit;
    }

    public static FmV3RecordListTotalBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FmV3RecordListTotalBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FmV3RecordListTotalBinding bind(@NonNull View view, @Nullable Object component) {
        return (FmV3RecordListTotalBinding) ViewDataBinding.bind(component, view, 2131427648);
    }

    @NonNull
    @Deprecated
    public static FmV3RecordListTotalBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FmV3RecordListTotalBinding) ViewDataBinding.inflateInternal(inflater, 2131427648, root, attachToRoot, component);
    }

    @NonNull
    public static FmV3RecordListTotalBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FmV3RecordListTotalBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FmV3RecordListTotalBinding) ViewDataBinding.inflateInternal(inflater, 2131427648, null, false, component);
    }
}
