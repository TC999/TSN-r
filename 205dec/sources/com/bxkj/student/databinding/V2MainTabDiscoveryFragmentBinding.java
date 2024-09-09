package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2MainTabDiscoveryFragmentBinding extends ViewDataBinding {
    @NonNull
    public final SmartWebView smartWebView;
    @NonNull
    public final SmartRefreshLayout srl;
    @NonNull
    public final TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2MainTabDiscoveryFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, SmartWebView smartWebView, SmartRefreshLayout srl, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.smartWebView = smartWebView;
        this.srl = srl;
        this.tvTitle = tvTitle;
    }

    public static V2MainTabDiscoveryFragmentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MainTabDiscoveryFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2MainTabDiscoveryFragmentBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MainTabDiscoveryFragmentBinding) ViewDataBinding.bind(component, view, 2131428092);
    }

    @NonNull
    @Deprecated
    public static V2MainTabDiscoveryFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MainTabDiscoveryFragmentBinding) ViewDataBinding.inflateInternal(inflater, 2131428092, root, attachToRoot, component);
    }

    @NonNull
    public static V2MainTabDiscoveryFragmentBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MainTabDiscoveryFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MainTabDiscoveryFragmentBinding) ViewDataBinding.inflateInternal(inflater, 2131428092, null, false, component);
    }
}
