package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AcV3SportsStatisticsBinding extends ViewDataBinding {
    @Bindable
    protected OnBackPress mMActvity;
    @NonNull
    public final V3PubTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV3SportsStatisticsBinding(Object _bindingComponent, View _root, int _localFieldCount, V3PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.titleLayout = titleLayout;
    }

    public static AcV3SportsStatisticsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OnBackPress getMActvity() {
        return this.mMActvity;
    }

    public abstract void setMActvity(@Nullable OnBackPress mActvity);

    @Deprecated
    public static AcV3SportsStatisticsBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3SportsStatisticsBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_v3_sports_statistics);
    }

    @NonNull
    @Deprecated
    public static AcV3SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3SportsStatisticsBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v3_sports_statistics, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3SportsStatisticsBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v3_sports_statistics, null, false, component);
    }
}
