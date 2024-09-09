package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2DialogQrCodeBinding extends ViewDataBinding {
    @NonNull
    public final ImageView iv;
    @NonNull
    public final FrameLayout root;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2DialogQrCodeBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView iv, FrameLayout root) {
        super(_bindingComponent, _root, _localFieldCount);
        this.iv = iv;
        this.root = root;
    }

    public static V2DialogQrCodeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2DialogQrCodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2DialogQrCodeBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2DialogQrCodeBinding) ViewDataBinding.bind(component, view, 2131428085);
    }

    @NonNull
    @Deprecated
    public static V2DialogQrCodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2DialogQrCodeBinding) ViewDataBinding.inflateInternal(inflater, 2131428085, root, attachToRoot, component);
    }

    @NonNull
    public static V2DialogQrCodeBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2DialogQrCodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2DialogQrCodeBinding) ViewDataBinding.inflateInternal(inflater, 2131428085, null, false, component);
    }
}
