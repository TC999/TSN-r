package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class ItemForV3PassPointDialogBinding extends ViewDataBinding {
    @NonNull
    public final ShapeableImageView ivPoint;
    @NonNull
    public final TextView tvPoint;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemForV3PassPointDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, ShapeableImageView ivPoint, TextView tvPoint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivPoint = ivPoint;
        this.tvPoint = tvPoint;
    }

    public static ItemForV3PassPointDialogBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemForV3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemForV3PassPointDialogBinding bind(@NonNull View view, @Nullable Object component) {
        return (ItemForV3PassPointDialogBinding) ViewDataBinding.bind(component, view, 2131427774);
    }

    @NonNull
    @Deprecated
    public static ItemForV3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ItemForV3PassPointDialogBinding) ViewDataBinding.inflateInternal(inflater, 2131427774, root, attachToRoot, component);
    }

    @NonNull
    public static ItemForV3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemForV3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ItemForV3PassPointDialogBinding) ViewDataBinding.inflateInternal(inflater, 2131427774, null, false, component);
    }
}
