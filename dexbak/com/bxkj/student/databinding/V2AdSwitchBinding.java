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
import com.bxkj.student.common.view.ToggleButton;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V2AdSwitchBinding extends ViewDataBinding {
    @NonNull
    public final V2PubTitleBinding includeTitle;
    @Bindable
    protected OnBackPress mBackEvent;
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
    public OnBackPress getBackEvent() {
        return this.mBackEvent;
    }

    public abstract void setBackEvent(@Nullable OnBackPress backEvent);

    @Deprecated
    public static V2AdSwitchBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2AdSwitchBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v2_ad_switch);
    }

    @NonNull
    @Deprecated
    public static V2AdSwitchBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2AdSwitchBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_ad_switch, root, attachToRoot, component);
    }

    @NonNull
    public static V2AdSwitchBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2AdSwitchBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2AdSwitchBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_ad_switch, null, false, component);
    }
}
