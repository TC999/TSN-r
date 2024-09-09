package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.common.view.CycleViewPager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2MainTabHomeFragmentBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardAd;
    @NonNull
    public final CycleViewPager cpAd;
    @NonNull
    public final RecyclerView rvMenu;
    @NonNull
    public final SmartWebView smartWebView;
    @NonNull
    public final TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2MainTabHomeFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardAd, CycleViewPager cpAd, RecyclerView rvMenu, SmartWebView smartWebView, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardAd = cardAd;
        this.cpAd = cpAd;
        this.rvMenu = rvMenu;
        this.smartWebView = smartWebView;
        this.tvTitle = tvTitle;
    }

    public static V2MainTabHomeFragmentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MainTabHomeFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2MainTabHomeFragmentBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MainTabHomeFragmentBinding) ViewDataBinding.bind(component, view, 2131428093);
    }

    @NonNull
    @Deprecated
    public static V2MainTabHomeFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MainTabHomeFragmentBinding) ViewDataBinding.inflateInternal(inflater, 2131428093, root, attachToRoot, component);
    }

    @NonNull
    public static V2MainTabHomeFragmentBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MainTabHomeFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MainTabHomeFragmentBinding) ViewDataBinding.inflateInternal(inflater, 2131428093, null, false, component);
    }
}
