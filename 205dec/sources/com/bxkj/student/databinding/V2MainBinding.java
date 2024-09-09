package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2MainBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout flContent;
    @NonNull
    public final BottomNavigationView navView;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2MainBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flContent, BottomNavigationView navView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.flContent = flContent;
        this.navView = navView;
    }

    public static V2MainBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2MainBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MainBinding) ViewDataBinding.bind(component, view, 2131428090);
    }

    @NonNull
    @Deprecated
    public static V2MainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MainBinding) ViewDataBinding.inflateInternal(inflater, 2131428090, root, attachToRoot, component);
    }

    @NonNull
    public static V2MainBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MainBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MainBinding) ViewDataBinding.inflateInternal(inflater, 2131428090, null, false, component);
    }
}
