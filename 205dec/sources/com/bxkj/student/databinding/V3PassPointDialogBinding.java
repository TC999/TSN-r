package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.student.v2.ui.sports.v3.V3PassPointDialog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V3PassPointDialogBinding extends ViewDataBinding {
    @Bindable
    protected V3PassPointDialog mDialog;
    @NonNull
    public final CardView rlThreetwoone;
    @NonNull
    public final RecyclerView rv;
    @NonNull
    public final TextView tvTitleHint;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3PassPointDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView rlThreetwoone, RecyclerView rv, TextView tvTitleHint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rlThreetwoone = rlThreetwoone;
        this.rv = rv;
        this.tvTitleHint = tvTitleHint;
    }

    public static V3PassPointDialogBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3PassPointDialog getDialog() {
        return this.mDialog;
    }

    public abstract void setDialog(@Nullable V3PassPointDialog dialog);

    @Deprecated
    public static V3PassPointDialogBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3PassPointDialogBinding) ViewDataBinding.bind(component, view, 2131428114);
    }

    @NonNull
    @Deprecated
    public static V3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3PassPointDialogBinding) ViewDataBinding.inflateInternal(inflater, 2131428114, root, attachToRoot, component);
    }

    @NonNull
    public static V3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3PassPointDialogBinding) ViewDataBinding.inflateInternal(inflater, 2131428114, null, false, component);
    }
}
