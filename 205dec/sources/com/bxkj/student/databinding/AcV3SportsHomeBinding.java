package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.MapView;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.google.android.material.tabs.TabLayout;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV3SportsHomeBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clData;
    @NonNull
    public final ConstraintLayout clGps;
    @NonNull
    public final AppCompatImageButton ibBack;
    @NonNull
    public final ConstraintLayout ibSet;
    @NonNull
    public final ImageView ivDescription;
    @NonNull
    public final AppCompatImageView ivGps;
    @NonNull
    public final ImageView ivPermission;
    @NonNull
    public final ImageView ivStart;
    @NonNull
    public final ImageView ivTimeArrow;
    @NonNull
    public final ConstraintLayout llTitle;
    @Bindable
    protected V3SportsHomeActivity mBackEvent;
    @Bindable
    protected Map<String, Object> mRecordMap;
    @Bindable
    protected String mTitle;
    @NonNull
    public final MapView map;
    @NonNull
    public final TabLayout tab;
    @NonNull
    public final TextView tvCount;
    @NonNull
    public final TextView tvCountHint;
    @NonNull
    public final TextView tvDescription;
    @NonNull
    public final TextView tvDescriptionV3;
    @NonNull
    public final TextView tvDistance;
    @NonNull
    public final TextView tvGps;
    @NonNull
    public final TextView tvPermissionV3;
    @NonNull
    public final TextView tvTime;
    @NonNull
    public final TextView tvTimeUnit;
    @NonNull
    public final TextView tvWeather;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV3SportsHomeBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clData, ConstraintLayout clGps, AppCompatImageButton ibBack, ConstraintLayout ibSet, ImageView ivDescription, AppCompatImageView ivGps, ImageView ivPermission, ImageView ivStart, ImageView ivTimeArrow, ConstraintLayout llTitle, MapView map, TabLayout tab, TextView tvCount, TextView tvCountHint, TextView tvDescription, TextView tvDescriptionV3, TextView tvDistance, TextView tvGps, TextView tvPermissionV3, TextView tvTime, TextView tvTimeUnit, TextView tvWeather) {
        super(_bindingComponent, _root, _localFieldCount);
        this.clData = clData;
        this.clGps = clGps;
        this.ibBack = ibBack;
        this.ibSet = ibSet;
        this.ivDescription = ivDescription;
        this.ivGps = ivGps;
        this.ivPermission = ivPermission;
        this.ivStart = ivStart;
        this.ivTimeArrow = ivTimeArrow;
        this.llTitle = llTitle;
        this.map = map;
        this.tab = tab;
        this.tvCount = tvCount;
        this.tvCountHint = tvCountHint;
        this.tvDescription = tvDescription;
        this.tvDescriptionV3 = tvDescriptionV3;
        this.tvDistance = tvDistance;
        this.tvGps = tvGps;
        this.tvPermissionV3 = tvPermissionV3;
        this.tvTime = tvTime;
        this.tvTimeUnit = tvTimeUnit;
        this.tvWeather = tvWeather;
    }

    public static AcV3SportsHomeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3SportsHomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3SportsHomeActivity getBackEvent() {
        return this.mBackEvent;
    }

    @Nullable
    public Map<String, Object> getRecordMap() {
        return this.mRecordMap;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setBackEvent(@Nullable V3SportsHomeActivity backEvent);

    public abstract void setRecordMap(@Nullable Map<String, Object> recordMap);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static AcV3SportsHomeBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3SportsHomeBinding) ViewDataBinding.bind(component, view, 2131427517);
    }

    @NonNull
    @Deprecated
    public static AcV3SportsHomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3SportsHomeBinding) ViewDataBinding.inflateInternal(inflater, 2131427517, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3SportsHomeBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3SportsHomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3SportsHomeBinding) ViewDataBinding.inflateInternal(inflater, 2131427517, null, false, component);
    }
}
