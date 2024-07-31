package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.view.LongPressButton;
import com.bxkj.student.p094v2.common.view.StepArcView;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsActivity;
import com.google.android.material.tabs.TabLayout;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AcV3SportsBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clGps;
    @NonNull
    public final AppCompatImageButton ibBack;
    @NonNull
    public final ConstraintLayout ibSet;
    @NonNull
    public final AppCompatImageView ivGps;
    @NonNull
    public final AppCompatImageView ivLock;
    @NonNull
    public final LongPressButton ivStop;
    @NonNull
    public final AppCompatImageView ivToMap;
    @NonNull
    public final LongPressButton ivUnlock;
    @NonNull
    public final ConstraintLayout llTitle;
    @Bindable
    protected V3SportsActivity mBackEvent;
    @Bindable
    protected int mSportType;
    @NonNull

    /* renamed from: ns */
    public final NestedScrollView f16280ns;
    @NonNull
    public final StepArcView saDistance;
    @NonNull
    public final StepArcView saStep;
    @NonNull
    public final StepArcView saTime;
    @NonNull
    public final TabLayout tab;
    @NonNull
    public final TextView tvAvgSpeed;
    @NonNull
    public final TextView tvAvgSpeedHint;
    @NonNull
    public final TextView tvGps;
    @NonNull
    public final TextView tvPaceSpeed;
    @NonNull
    public final TextView tvPaceSpeedHint;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV3SportsBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clGps, AppCompatImageButton ibBack, ConstraintLayout ibSet, AppCompatImageView ivGps, AppCompatImageView ivLock, LongPressButton ivStop, AppCompatImageView ivToMap, LongPressButton ivUnlock, ConstraintLayout llTitle, NestedScrollView ns, StepArcView saDistance, StepArcView saStep, StepArcView saTime, TabLayout tab, TextView tvAvgSpeed, TextView tvAvgSpeedHint, TextView tvGps, TextView tvPaceSpeed, TextView tvPaceSpeedHint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.clGps = clGps;
        this.ibBack = ibBack;
        this.ibSet = ibSet;
        this.ivGps = ivGps;
        this.ivLock = ivLock;
        this.ivStop = ivStop;
        this.ivToMap = ivToMap;
        this.ivUnlock = ivUnlock;
        this.llTitle = llTitle;
        this.f16280ns = ns;
        this.saDistance = saDistance;
        this.saStep = saStep;
        this.saTime = saTime;
        this.tab = tab;
        this.tvAvgSpeed = tvAvgSpeed;
        this.tvAvgSpeedHint = tvAvgSpeedHint;
        this.tvGps = tvGps;
        this.tvPaceSpeed = tvPaceSpeed;
        this.tvPaceSpeedHint = tvPaceSpeedHint;
    }

    public static AcV3SportsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3SportsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3SportsActivity getBackEvent() {
        return this.mBackEvent;
    }

    public int getSportType() {
        return this.mSportType;
    }

    public abstract void setBackEvent(@Nullable V3SportsActivity backEvent);

    public abstract void setSportType(int sportType);

    @Deprecated
    public static AcV3SportsBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3SportsBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_v3_sports);
    }

    @NonNull
    @Deprecated
    public static AcV3SportsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3SportsBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v3_sports, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3SportsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3SportsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3SportsBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v3_sports, null, false, component);
    }
}
