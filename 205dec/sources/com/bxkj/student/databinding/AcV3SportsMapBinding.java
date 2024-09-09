package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity;
import com.google.android.material.tabs.TabLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV3SportsMapBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clGps;
    @NonNull
    public final AppCompatImageButton ibBack;
    @NonNull
    public final ConstraintLayout ibSet;
    @NonNull
    public final AppCompatImageView ivGps;
    @NonNull
    public final LinearLayout llBottom;
    @Bindable
    protected V3SportsMapActivity mBackEvent;
    @Bindable
    protected String mIsClock;
    @NonNull
    public final MapView mMapView;
    @Bindable
    protected String mNotice;
    @Bindable
    protected int mSportType;
    @Bindable
    protected String mTitle;
    @NonNull
    public final TabLayout tab;
    @NonNull
    public final ConstraintLayout titleLayout;
    @NonNull
    public final MarqueeTextView tvDescription;
    @NonNull
    public final TextView tvDistance;
    @NonNull
    public final TextView tvGps;
    @NonNull
    public final TextView tvPeisu;
    @NonNull
    public final TextView tvStep;
    @NonNull
    public final TextView tvTime;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV3SportsMapBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clGps, AppCompatImageButton ibBack, ConstraintLayout ibSet, AppCompatImageView ivGps, LinearLayout llBottom, MapView mMapView, TabLayout tab, ConstraintLayout titleLayout, MarqueeTextView tvDescription, TextView tvDistance, TextView tvGps, TextView tvPeisu, TextView tvStep, TextView tvTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.clGps = clGps;
        this.ibBack = ibBack;
        this.ibSet = ibSet;
        this.ivGps = ivGps;
        this.llBottom = llBottom;
        this.mMapView = mMapView;
        this.tab = tab;
        this.titleLayout = titleLayout;
        this.tvDescription = tvDescription;
        this.tvDistance = tvDistance;
        this.tvGps = tvGps;
        this.tvPeisu = tvPeisu;
        this.tvStep = tvStep;
        this.tvTime = tvTime;
    }

    public static AcV3SportsMapBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3SportsMapBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3SportsMapActivity getBackEvent() {
        return this.mBackEvent;
    }

    @Nullable
    public String getIsClock() {
        return this.mIsClock;
    }

    @Nullable
    public String getNotice() {
        return this.mNotice;
    }

    public int getSportType() {
        return this.mSportType;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setBackEvent(@Nullable V3SportsMapActivity backEvent);

    public abstract void setIsClock(@Nullable String isClock);

    public abstract void setNotice(@Nullable String notice);

    public abstract void setSportType(int sportType);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static AcV3SportsMapBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3SportsMapBinding) ViewDataBinding.bind(component, view, 2131427518);
    }

    @NonNull
    @Deprecated
    public static AcV3SportsMapBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3SportsMapBinding) ViewDataBinding.inflateInternal(inflater, 2131427518, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3SportsMapBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3SportsMapBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3SportsMapBinding) ViewDataBinding.inflateInternal(inflater, 2131427518, null, false, component);
    }
}
