package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV3SportsStatisticsBinding extends ViewDataBinding {
    @Bindable
    protected a mMActvity;
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
    public a getMActvity() {
        return this.mMActvity;
    }

    public abstract void setMActvity(@Nullable a mActvity);

    @Deprecated
    public static AcV3SportsStatisticsBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3SportsStatisticsBinding) ViewDataBinding.bind(component, view, 2131427519);
    }

    @NonNull
    @Deprecated
    public static AcV3SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3SportsStatisticsBinding) ViewDataBinding.inflateInternal(inflater, 2131427519, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3SportsStatisticsBinding) ViewDataBinding.inflateInternal(inflater, 2131427519, null, false, component);
    }
}
