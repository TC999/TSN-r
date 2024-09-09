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
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V3LayoutSportDetailDataCommonBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivDistance;
    @NonNull
    public final ImageView ivFastSpeed;
    @NonNull
    public final ImageView ivHeart;
    @NonNull
    public final ImageView ivHot;
    @NonNull
    public final ImageView ivPjpl;
    @NonNull
    public final ImageView ivPjsd;
    @NonNull
    public final ImageView ivSlowSpeed;
    @NonNull
    public final ImageView ivStep;
    @NonNull
    public final ImageView ivStepCount;
    @NonNull
    public final ImageView ivStepDistance;
    @NonNull
    public final ImageView ivTime;
    @NonNull
    public final ImageView ivZjps;
    @Bindable
    protected V3RecordDetailActivity mMActivity;
    @Bindable
    protected Map<String, Object> mMap;
    @NonNull
    public final TextView tvBfException;
    @NonNull
    public final TextView tvDistance;
    @NonNull
    public final TextView tvDistanceHint;
    @NonNull
    public final TextView tvDistanceUnit;
    @NonNull
    public final TextView tvFastSpeed;
    @NonNull
    public final TextView tvFastSpeedHint;
    @NonNull
    public final TextView tvFastSpeedUnit;
    @NonNull
    public final TextView tvHeart;
    @NonNull
    public final TextView tvHeartHint;
    @NonNull
    public final TextView tvHeartUnit;
    @NonNull
    public final TextView tvHot;
    @NonNull
    public final TextView tvHotHint;
    @NonNull
    public final TextView tvHotUnit;
    @NonNull
    public final TextView tvPjpl;
    @NonNull
    public final TextView tvPjplHint;
    @NonNull
    public final TextView tvPjplUnit;
    @NonNull
    public final TextView tvPjsd;
    @NonNull
    public final TextView tvPjsdHint;
    @NonNull
    public final TextView tvPjsdUnit;
    @NonNull
    public final TextView tvSlowSpeed;
    @NonNull
    public final TextView tvSlowSpeedHint;
    @NonNull
    public final TextView tvSlowSpeedUnit;
    @NonNull
    public final TextView tvStep;
    @NonNull
    public final TextView tvStepCount;
    @NonNull
    public final TextView tvStepCountHint;
    @NonNull
    public final TextView tvStepCountUnit;
    @NonNull
    public final TextView tvStepDistance;
    @NonNull
    public final TextView tvStepDistanceHint;
    @NonNull
    public final TextView tvStepDistanceUnit;
    @NonNull
    public final TextView tvStepException;
    @NonNull
    public final TextView tvStepHint;
    @NonNull
    public final TextView tvStepUnit;
    @NonNull
    public final TextView tvTime;
    @NonNull
    public final TextView tvTimeHint;
    @NonNull
    public final TextView tvZjps;
    @NonNull
    public final TextView tvZjpsHint;
    @NonNull
    public final TextView tvZjpsUnit;
    @NonNull
    public final View vLeft;
    @NonNull
    public final View vRight;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3LayoutSportDetailDataCommonBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivDistance, ImageView ivFastSpeed, ImageView ivHeart, ImageView ivHot, ImageView ivPjpl, ImageView ivPjsd, ImageView ivSlowSpeed, ImageView ivStep, ImageView ivStepCount, ImageView ivStepDistance, ImageView ivTime, ImageView ivZjps, TextView tvBfException, TextView tvDistance, TextView tvDistanceHint, TextView tvDistanceUnit, TextView tvFastSpeed, TextView tvFastSpeedHint, TextView tvFastSpeedUnit, TextView tvHeart, TextView tvHeartHint, TextView tvHeartUnit, TextView tvHot, TextView tvHotHint, TextView tvHotUnit, TextView tvPjpl, TextView tvPjplHint, TextView tvPjplUnit, TextView tvPjsd, TextView tvPjsdHint, TextView tvPjsdUnit, TextView tvSlowSpeed, TextView tvSlowSpeedHint, TextView tvSlowSpeedUnit, TextView tvStep, TextView tvStepCount, TextView tvStepCountHint, TextView tvStepCountUnit, TextView tvStepDistance, TextView tvStepDistanceHint, TextView tvStepDistanceUnit, TextView tvStepException, TextView tvStepHint, TextView tvStepUnit, TextView tvTime, TextView tvTimeHint, TextView tvZjps, TextView tvZjpsHint, TextView tvZjpsUnit, View vLeft, View vRight) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivDistance = ivDistance;
        this.ivFastSpeed = ivFastSpeed;
        this.ivHeart = ivHeart;
        this.ivHot = ivHot;
        this.ivPjpl = ivPjpl;
        this.ivPjsd = ivPjsd;
        this.ivSlowSpeed = ivSlowSpeed;
        this.ivStep = ivStep;
        this.ivStepCount = ivStepCount;
        this.ivStepDistance = ivStepDistance;
        this.ivTime = ivTime;
        this.ivZjps = ivZjps;
        this.tvBfException = tvBfException;
        this.tvDistance = tvDistance;
        this.tvDistanceHint = tvDistanceHint;
        this.tvDistanceUnit = tvDistanceUnit;
        this.tvFastSpeed = tvFastSpeed;
        this.tvFastSpeedHint = tvFastSpeedHint;
        this.tvFastSpeedUnit = tvFastSpeedUnit;
        this.tvHeart = tvHeart;
        this.tvHeartHint = tvHeartHint;
        this.tvHeartUnit = tvHeartUnit;
        this.tvHot = tvHot;
        this.tvHotHint = tvHotHint;
        this.tvHotUnit = tvHotUnit;
        this.tvPjpl = tvPjpl;
        this.tvPjplHint = tvPjplHint;
        this.tvPjplUnit = tvPjplUnit;
        this.tvPjsd = tvPjsd;
        this.tvPjsdHint = tvPjsdHint;
        this.tvPjsdUnit = tvPjsdUnit;
        this.tvSlowSpeed = tvSlowSpeed;
        this.tvSlowSpeedHint = tvSlowSpeedHint;
        this.tvSlowSpeedUnit = tvSlowSpeedUnit;
        this.tvStep = tvStep;
        this.tvStepCount = tvStepCount;
        this.tvStepCountHint = tvStepCountHint;
        this.tvStepCountUnit = tvStepCountUnit;
        this.tvStepDistance = tvStepDistance;
        this.tvStepDistanceHint = tvStepDistanceHint;
        this.tvStepDistanceUnit = tvStepDistanceUnit;
        this.tvStepException = tvStepException;
        this.tvStepHint = tvStepHint;
        this.tvStepUnit = tvStepUnit;
        this.tvTime = tvTime;
        this.tvTimeHint = tvTimeHint;
        this.tvZjps = tvZjps;
        this.tvZjpsHint = tvZjpsHint;
        this.tvZjpsUnit = tvZjpsUnit;
        this.vLeft = vLeft;
        this.vRight = vRight;
    }

    public static V3LayoutSportDetailDataCommonBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3LayoutSportDetailDataCommonBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
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
    public static V3LayoutSportDetailDataCommonBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3LayoutSportDetailDataCommonBinding) ViewDataBinding.bind(component, view, 2131428112);
    }

    @NonNull
    @Deprecated
    public static V3LayoutSportDetailDataCommonBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3LayoutSportDetailDataCommonBinding) ViewDataBinding.inflateInternal(inflater, 2131428112, root, attachToRoot, component);
    }

    @NonNull
    public static V3LayoutSportDetailDataCommonBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3LayoutSportDetailDataCommonBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3LayoutSportDetailDataCommonBinding) ViewDataBinding.inflateInternal(inflater, 2131428112, null, false, component);
    }
}
