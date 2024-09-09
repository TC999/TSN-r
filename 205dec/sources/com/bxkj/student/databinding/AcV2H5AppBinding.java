package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.common.view.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV2H5AppBinding extends ViewDataBinding {
    @Bindable
    protected a mMActivity;
    @Bindable
    protected String mTitle;
    @NonNull
    public final SmartWebView smartWebView;
    @NonNull
    public final V2PubTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV2H5AppBinding(Object _bindingComponent, View _root, int _localFieldCount, SmartWebView smartWebView, V2PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.smartWebView = smartWebView;
        this.titleLayout = titleLayout;
    }

    public static AcV2H5AppBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2H5AppBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public a getMActivity() {
        return this.mMActivity;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setMActivity(@Nullable a mActivity);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static AcV2H5AppBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2H5AppBinding) ViewDataBinding.bind(component, view, 2131427506);
    }

    @NonNull
    @Deprecated
    public static AcV2H5AppBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2H5AppBinding) ViewDataBinding.inflateInternal(inflater, 2131427506, root, attachToRoot, component);
    }

    @NonNull
    public static AcV2H5AppBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2H5AppBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2H5AppBinding) ViewDataBinding.inflateInternal(inflater, 2131427506, null, false, component);
    }
}
