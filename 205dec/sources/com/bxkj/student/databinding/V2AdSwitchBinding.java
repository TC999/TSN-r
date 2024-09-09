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
import com.bxkj.student.common.view.ToggleButton;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2AdSwitchBinding extends ViewDataBinding {
    @NonNull
    public final V2PubTitleBinding includeTitle;
    @Bindable
    protected a mBackEvent;
    @NonNull
    public final ToggleButton tagAd;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2AdSwitchBinding(Object _bindingComponent, View _root, int _localFieldCount, V2PubTitleBinding includeTitle, ToggleButton tagAd) {
        super(_bindingComponent, _root, _localFieldCount);
        this.includeTitle = includeTitle;
        this.tagAd = tagAd;
    }

    public static V2AdSwitchBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2AdSwitchBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public a getBackEvent() {
        return this.mBackEvent;
    }

    public abstract void setBackEvent(@Nullable a backEvent);

    @Deprecated
    public static V2AdSwitchBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2AdSwitchBinding) ViewDataBinding.bind(component, view, 2131428084);
    }

    @NonNull
    @Deprecated
    public static V2AdSwitchBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2AdSwitchBinding) ViewDataBinding.inflateInternal(inflater, 2131428084, root, attachToRoot, component);
    }

    @NonNull
    public static V2AdSwitchBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2AdSwitchBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2AdSwitchBinding) ViewDataBinding.inflateInternal(inflater, 2131428084, null, false, component);
    }
}
